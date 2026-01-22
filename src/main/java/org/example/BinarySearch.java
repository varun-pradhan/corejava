package org.example;

import java.util.ArrayList;

public class BinarySearch
{
    /**
     * Performs a binary search on a sorted array to find the index of a target value.
     * This method uses recursion.
     *
     * @param arr    The sorted array to search.
     * @param target The value to search for.
     * @param start  The starting index of the search space.
     * @param end    The ending index of the search space.
     * @return The index of the target if found, otherwise -1.
     */
    public static int search(int[] arr, int target, int start, int end) {
        // Base Case 1: If the search space is invalid, the target is not in the array.
        // This is the most important condition to prevent infinite recursion.
        if (start > end) {
            return -1;
        }

        // Calculate the middle index.
        // This is a safe way to calculate the mid to avoid potential integer overflow.
        int mid = start + (end - start) / 2;

        // Base Case 2: If the element at the middle is our target, we've found it.
        if (arr[mid] == target) {
            return mid;
        }

        // Recursive Step: Decide which half of the array to search next.
        if (target < arr[mid]) {
            // If the target is smaller, search the left half.
            // We exclude 'mid' itself by using 'mid - 1'.
            return search(arr, target, start, mid - 1);
        } else {
            // If the target is larger, search the right half.
            // We exclude 'mid' itself by using 'mid + 1'.
            return search(arr, target, mid + 1, end);
        }
    }

    public static void main(String[] args) {
        int[] arr = {1, 3, 4, 6, 7, 9};
        int target = 7;
        int result = search(arr, target, 0, arr.length - 1);

        if (result != -1) {
            System.out.println("Item " + target + " found at Index: " + result);
        } else {
            System.out.println("Item " + target + " not found in the array.");
        }

        target = 5;
        result = search(arr, target, 0, arr.length - 1);
        if (result != -1) {
            System.out.println("Item " + target + " found at Index: " + result);
        } else {
            System.out.println("Item " + target + " not found in the array.");
        }
    }
}
