package com.abn.learn.dsa.day32;

import java.util.Arrays;

/*
Implemet Quicksort

Pick: Select an element.
Divide: Split the problem set, move smaller parts to the left of
the pivot and larger items to the right.
Repeat and combine: Repeat the steps on smaller subarrays and
combine the arrays that have previously been sorted.

A = [4, 1, 8, 9, 3, 8, 1, 9, 4]
 */

public class QuickSort {

    public void solve(int[] array) {

        int start = 0;
        int end = array.length - 1;

        qsort(array, start, end);
        System.out.println(Arrays.toString(array));
    }

    private int[] qsort(int[] array, int left, int right) {

        if(left < right) {
            int pivotIndex = partition(array, 0, right);
            qsort(array, left, pivotIndex - 1);
            qsort(array, pivotIndex + 1, right);
        }
        return array;
    }

    private int partition(int[] array, int leftPtr, int rightPtr) {

        int pivot = array[leftPtr];
        int pivotIndex = array[pivot];
        leftPtr++;

        while(leftPtr <= rightPtr) {

            if(array[leftPtr] <= pivot) {
                leftPtr ++;
            } else if(array[rightPtr] > pivot) {
                rightPtr --;
            } else {
                swap(array, leftPtr, rightPtr);
            }
        }

        swap(array, rightPtr, pivotIndex);
        return rightPtr;
    }

    private int[] swap(int[] array, int left, int right) {

        int temp = array[left];
        array[left] = array[right];
        array[right] = temp;

        return array;
    }

    public static void main(String[] args) {
        QuickSort quickSort = new QuickSort();
        quickSort.solve(new int[] {4, 1, 8, 9, 3, 8, 1, 9, 4});
    }
}
