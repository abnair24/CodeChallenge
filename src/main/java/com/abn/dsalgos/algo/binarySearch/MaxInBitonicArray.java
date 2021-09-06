package com.abn.dsalgos.algo.binarySearch;

/*
A bitonic array is an array that is first increasing and then decreasing. Given an array of numbers which is
 first increasing and then decreasing, find the maximum value in the array.

 Input: a[] = {2, 4, 6, 8, 10, 3, 1}
Output: 10

Input: a[] = {10, 20, 30, 40, 50}
Output: 50

Input: a[] = {100, 80, 60, 40, 20, 0}
Output: 100
 */
public class MaxInBitonicArray {

    public int maximum(int[] array) {

        int start = 0;
        int end = array.length - 1;

        while (start <= end) {

            int mid = start + (end - start) / 2;

            if ((mid == 0 || array[mid] > array[mid - 1]) && (mid == array.length - 1 || array[mid] > array[mid + 1])) {
                return array[mid];
            } else if (array[mid] < array[mid - 1]) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }

        return -1;
    }
}
