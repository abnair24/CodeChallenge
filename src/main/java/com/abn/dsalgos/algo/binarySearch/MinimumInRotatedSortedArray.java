package com.abn.dsalgos.algo.binarySearch;

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

    public int search(int[] array) {
        int low = 0;
        int high = array.length - 1;

        if(array[0] < array[high]) {
            return array[0];
        }

        while(low <= high) {
            int mid = low + (high - low)/2;

            if(array[mid] < array[mid-1]) {
                return array[mid];
            }
            if(array[mid] > array[mid + 1]) {
                return array[mid + 1];
            }

            if(array[low]< array[mid]) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {

        MinimumInRotatedSortedArray minimumInRotatedSortedArray = new MinimumInRotatedSortedArray();
        System.out.println(minimumInRotatedSortedArray.search(new int[] {4, 5, 6, 7,8,9, 1, 2, 3}));
    }
}
