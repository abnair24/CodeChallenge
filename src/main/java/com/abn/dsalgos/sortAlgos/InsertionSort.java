package com.abn.dsalgos.sortAlgos;

/*
Insertion sort works by comparing current element with all the previous element and swap if curr < previous
 */

public class InsertionSort {

    public int[] insertionSort(int[] array) {

        int len = array.length;
        for (int i = 1; i < len; i++) {
            int k = i;
            while (k > 0) {
                if (array[k] < array[k - 1]) {
                    int temp = array[k];
                    array[k] = array[k - 1];
                    array[k - 1] = temp;
                }
                k--;
            }
        }

        return array;
    }
}
