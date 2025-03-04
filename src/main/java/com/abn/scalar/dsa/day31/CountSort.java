package com.abn.scalar.dsa.day31;

/*
Given an array A. Sort this array using Count Sort Algorithm and return the sorted array.
 */
//TO-DO
public class CountSort {

    public int[] solve(int[] array) {

        int max = findMax(array);
        int[] count = new int[max + 1];

        // Count occurrences of each element
        for (int i = 0; i < array.length; i++) {
            count[array[i]]++;
        }

        // Calculate cumulative counts
        for (int i = 1; i <= max; i++) {
            count[i] += count[i - 1];
        }

        // Build the sorted array
        int[] output = new int[array.length];
        for (int i = array.length - 1; i >= 0; i--) {
            output[count[array[i]] - 1] = array[i];
            count[array[i]]--;
        }

        // Copy sorted elements back to original array
        for (int i = 0; i < array.length; i++) {
            array[i] = output[i];
        }
        return array;
    }


    private int findMax(int[] array) {

        int max = Integer.MIN_VALUE;
        for (int i = 0; i < array.length; i++) {
            max = Math.max(max, array[i]);
        }
        return max;
    }


}
