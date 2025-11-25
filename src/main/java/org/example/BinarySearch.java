package org.example;

import java.util.ArrayList;

public class BinarySearch
{
    public static int search(int[] arr, int target, int start, int end){

        int  mid = start + (end - start)/2;

        if( arr[mid] == target ){
            return mid;
        }

        if( target < arr[mid])  return search(arr, target, start, mid);

        if( target > arr[mid])  return search(arr, target, mid, end);

        return -1;
    }

    public static void main(String[] args) {
        ArrayList<Integer> arr = new ArrayList<>();
        arr.add(1);
        arr.add(3);
        arr.add(4);
        arr.add(6);
        arr.add(7);
        arr.add(9);
        System.out.println("Item at Index: " + search(arr.stream()
                                                         .mapToInt( i -> i)
                                                         .toArray(), 7, 0, arr.size()-1) );
    }
}
