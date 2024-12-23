package com.abn.scalar.dsa.day32;

/*
Given an integer array, consider first element as pivot, rearrange
the elements such that for all i:
if A[i] < p then it should be present on left side if A[i] > p then it
should be present on right side

Note: All elements are distinct
 */

import java.util.Arrays;

public class PartitionArray {

    public int[] solve(int[] array) {

        int len = array.length;

        int pivotIndex = 0;
        int leftPtr = 1;
        int rightPtr = len - 1;

        while(leftPtr <= rightPtr) {

            if(array[leftPtr] <= array[pivotIndex]) {
                leftPtr ++;
            } else if(array[rightPtr] > array[pivotIndex]) {
                rightPtr --;
            } else {
                swap(array, leftPtr, rightPtr);
            }
        }

        swap(array, rightPtr, pivotIndex);

        return array;
    }

    private int[] swap(int[] array, int left, int right) {

        int temp = array[left];
        array[left] = array[right];
        array[right] = temp;

        return array;
    }

    public static void main(String[] args) {

        PartitionArray partitionArray = new PartitionArray();

        System.out.println(Arrays.toString(partitionArray.solve(new int[]{54, 26, 20, 17, 77, 31, 44, 55, 93})));
    }
}
