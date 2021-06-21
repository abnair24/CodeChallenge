package com.abn.dsalgos.algo.binarySearch;

/*
Given 2 sorted arrays, find the median.
 */
public class MedianOfSortedArrays {


    // Complexity : O(m+n)
    public double findMedianOfSorted(int[] array1, int[] array2) {

        if (array1.length == 0 && array2.length == 1) {
            return array2[0];
        } else if (array2.length == 0 && array1.length == 1) {
            return array1[0];
        }

        int[] result = mergeSortedArrays(array1, array2);

        int mid = result.length / 2;

        if (result.length % 2 == 0) {
            return (result[mid] + result[mid - 1]) / 2.0;
        } else {
            return result[mid];
        }
    }

    private int[] mergeSortedArrays(int[] a1, int[] a2) {

        int[] result = new int[a1.length + a2.length];

        int leftIndex = 0;
        int rightIndex = 0;
        int resultIndex = 0;

        while (leftIndex < a1.length && rightIndex < a2.length) {
            if (a1[leftIndex] < a2[rightIndex]) {
                result[resultIndex++] = a1[leftIndex++];
            } else {
                result[resultIndex++] = a2[rightIndex++];
            }
        }

        while (leftIndex < a1.length) {
            result[resultIndex++] = a1[leftIndex++];
        }

        while (rightIndex < a2.length) {
            result[resultIndex++] = a2[rightIndex++];
        }

        return result;
    }

    public double getMedian(int[] array1, int[] array2) {

        int size1 = array1.length;
        int size2 = array2.length;
        int end_index = size1;
        int start_index = 0, i = 0, j = 0, median = 0;

        while (start_index <= end_index) {
            i = (start_index + end_index) / 2;
            j = ((size1 + size2 + 1) / 2) - i;

            if (i < size1 && j > 0 && array2[j - 1] > array1[i])
                start_index = i + 1;

            else if (i > 0 && j < size2 && array2[j] < array1[i - 1])
                end_index = i - 1;

            else {
                if (i == 0)
                    median = array2[j - 1];

                else if (j == 0)
                    median = array1[i - 1];
                else
                    median = maximum(array1[i - 1],
                            array2[j - 1]);
                break;
            }
        }

        if ((size1 + size2) % 2 == 1)
            return (double) median;


        if (i == size1)
            return (median + array2[j]) / 2.0;


        if (j == size2)
            return (median + array1[i]) / 2.0;

        return (median + minimum(array1[i],
                array2[j])) / 2.0;
    }

    private int maximum(int a, int b) {
        return a > b ? a : b;
    }

    // Function to find minimum
    private int minimum(int a, int b) {
        return a < b ? a : b;
    }
}
