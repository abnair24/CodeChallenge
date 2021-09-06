package com.abn.dsalgos.sortAlgos;

import java.util.Arrays;

public class MergeSortRecursion {

    public int[] mergeSort(int[] input) {

        if (input.length <= 1) {
            return input;
        }
        int middle = input.length / 2;
        int len = input.length;

        int[] left = mergeSort(Arrays.copyOfRange(input, 0, middle));
        int[] right = mergeSort(Arrays.copyOfRange(input, middle, len));

        return merge(left, right);
    }

    private int[] merge(int[] left, int[] right) {

        int[] result = new int[left.length + right.length];

        int leftIndex = 0;
        int rightIndex = 0;
        int resultIndex = 0;

        while (leftIndex < left.length && rightIndex < right.length) {
            if (left[leftIndex] < right[rightIndex]) {
                result[resultIndex++] = left[leftIndex++];
            } else {
                result[resultIndex++] = right[rightIndex++];
            }
        }

        while (leftIndex < left.length) {
            result[resultIndex++] = left[leftIndex++];
        }
        while (rightIndex < right.length) {
            result[resultIndex++] = right[rightIndex++];
        }

        return result;
    }


    public static void main(String[] args) {

        MergeSortRecursion mergeSortRecursion = new MergeSortRecursion();
        mergeSortRecursion.mergeSort(new int[] {5, 7, 2, 6, 8, 4, 3});
    }
}
