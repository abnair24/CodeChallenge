package com.abn.dsalgos.glc;

/*
Suppose an array of length n sorted in ascending order is rotated between 1 and n times.
For example, the array nums = [0,1,4,4,5,6,7] might become:

[4,5,6,7,0,1,4] if it was rotated 4 times.
[0,1,4,4,5,6,7] if it was rotated 7 times.

Input: nums = [1,3,5]
Output: 1

Input: nums = [2,2,2,0,1]
Output: 0
 */
public class MinimumInRotatedSortedArray {

    public int minimum(int[] array) {

        int start = 0;
        int end = array.length - 1;
        int mid;

        while (start < end) {
            mid = (start + end) / 2;
            if (array[mid] < array[end]) {
                end = mid;
            } else if (array[mid] > array[end]) {
                start = mid + 1;
            } else {
                end = end - 1;
            }
        }
        return array[start];
    }
}
