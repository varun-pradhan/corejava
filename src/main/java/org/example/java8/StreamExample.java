package org.example.java8;

import org.w3c.dom.ls.LSOutput;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamExample {
    public static void main(String[] args) {
        //generrated a list of 100 integers
        Stream<Integer> stream = Stream.generate(() -> (int) (Math.random() * 100)).limit(100);
        // filter out non-even integer with filter(predicate)
        List<Integer> list = stream.filter(n -> n % 2 == 0).collect(Collectors.toList());
        System.out.println(list + "\n  of length : " + list.size());
        // map( ) the list to transform - divide the elements into half (n/2)
        System.out.println(list.stream().map(n -> n / 2).collect(Collectors.toList()));
        // remove repeating elements using distinct( )
        System.out.println("Distinct elements are: \n" + list.stream().distinct().collect(Collectors.toList()));

        //sorting the element in descending order using sorted() and comparator[ (a,b)->b-a ]
        System.out.println("After sorting elements are: \n" + list.stream().sorted(Comparator.comparingInt(a -> a)).distinct().collect(Collectors.toList()));

        //All above operations can be done in a single stream pipeline
        List<Integer> modifiedList = list.stream().filter(n -> n % 2 == 0)
                .map(n -> n / 2)
                .distinct()
                .sorted()
                .limit(30)
//                .peek(System.out::println)    used to print elements while between the operation
                .collect(Collectors.toList());
        System.out.println("ascending ordered list : "+modifiedList);

//        List<Integer>  finalList;
        int x =2;
        long maxElement = Stream.iterate(0,n->n+1)
//                .peek(System.out::println)
                .skip(1)
                .limit(10)
                .peek(System.out::println)
                .sorted(Comparator.reverseOrder())
//                .peek(System.out::println)
                .skip(x)
                .count();

        System.out.println("maxElement: "+ maxElement);


    }
}


class SteamCreation{
    //Creating Stream
    //convert Collections list to a stream
    List< String> list = Arrays.asList("apple", "Banana", "Cherry");
    Stream<String> mystream = list.stream();

    // convert primitive array to a stream
    String[] array = {"apple", "Banana", "Cherry" };
    Stream<String> stream2 = Arrays.stream(array);

    //Create stream of primitive integers
    Stream<Integer> stream3 = Stream.of(1,2,3,4);

    //Create an infinite stream then limit it to required end
    Stream<Integer> stream4 = Stream.iterate(0, n -> n+2).limit(10);

    //Stream of 20 string element with same-value "item"
    Stream<String> stream5 = Stream.generate(() -> "item").limit(20);

    Stream<Integer> stream6 = Stream.generate(()-> (int) (Math.random() * 100)).limit(100);

}
