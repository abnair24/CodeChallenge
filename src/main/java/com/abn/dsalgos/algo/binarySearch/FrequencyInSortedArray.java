package com.abn.dsalgos.algo.binarySearch;

/*
Given a sorted array of integers, find the frequency of the occurrence of a given target value in the array.
If the value is not found in the array at all, return 0.
 */
public class FrequencyInSortedArray {

    public int frequency(int[] array, int key) {

        int start = 0;
        int end = array.length - 1;
        int mid;
        int result = -1;

        // Loop to find first occurance
        while (start <= end) {

            mid = (start + end) / 2;
            if (array[mid] == key) {

                result = mid;
                end = mid - 1;
            } else if (key > array[mid]) {
                start = mid + 1;
            } else if (key < array[mid]) {
                end = mid - 1;
            }
        }

        int start1 = 0;
        int end1 = array.length - 1;
        int result1 = -1;
        int mid1;

        // loop to find last occurance. then diff the indexes
        while (start1 <= end1) {

            mid1 = (start1 + end1) / 2;
            if (array[mid1] == key) {
                result1 = mid1;
                start1 = mid1 + 1;
            } else if (key > array[mid1]) {
                start1 = mid1 + 1;
            } else if (key < array[mid1]) {
                end1 = mid1 - 1;
            }
        }

        if (result == -1 || result1 == -1) {
            return result1 - result;
        }

        return result1 - result + 1;
    }
}
