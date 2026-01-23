package org.example.java8;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Stream;

public class DefaultFunctionalInterfaces {

    static int a = 232;

    public static void main (String[] args) {
     int a = 232;
    Predicate< String> test = x-> x.length()<10;
    Predicate<String> isFirstLetterA = y -> y.charAt(0) == 'A';
    List<String> list = Arrays.asList("Ajay", "Bob", "grishmasoor", "Ajanta", "Ajanta Ellora");
    List<String> stream = list.stream().filter(test.and(isFirstLetterA)).toList();
        System.out.println(stream);
    }

}
