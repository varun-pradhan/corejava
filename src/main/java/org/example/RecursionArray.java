package org.example;

//import static org.example.BinarySearch.search;

import java.util.ArrayList;

public class RecursionArray {
    public static void main(String[] args) {
        int [] arr = {1,2,3 ,3,4,5};
        int [] d_arr = {1, 2, 4, 3, 5};
        int [] s_arr = {6};
/*
        System.out.println(isSorted(arr));
        System.out.println(isSorted(d_arr));
        System.out.println(isSorted(s_arr));
        System.out.println(Linear(arr, 5));
 */
        System.out.println(findAllOccurences(arr, 3, new ArrayList<>()));
    }

    private static ArrayList<Integer> findAllOccurences(int[] arr, int target, ArrayList<Integer> list) {
        return findAll(arr, target, arr.length-1 , list);
    }

    static ArrayList<Integer> findAll(int[] arr, int target, int index, ArrayList<Integer> list){
        if( index == -1)    return list;
        if( arr[index] == target) {
            list.add(index);
        }
            return findAll(arr, target, index - 1, list);

    }


    private static int Linear( int[] arr, int target) {
        // linear search using recursion
        RecursionArray r = new RecursionArray();
        return r.search(arr, target, 0);
    }
    private  int search(int[] arr, int target, int index){
        if( index == arr.length) return -1;

        if( arr[index]== target ){
            System.out.printf("Element found at index %d\n", index);
            return index;
        }
        return search(arr, target, index+1);
    }



    private static boolean isSorted(int[] arr) {
        //Check if input array is sorted
        return check(arr, 0);
    }
    private static boolean check( int[] arr, int i){
        int n = arr.length;
        if( i == n-1 ) return true;
        return (arr[i] <= arr[i+1]) && check(arr, i + 1);
    }


}
