package com.abn.dsalgos.algo.twoPointers;


/*
Given an array of sorted numbers, remove all duplicates from it.
You should not use any extra space; after removing the duplicates in-place return
the length of the subarray that has no duplicate in it.
Input: [2, 3, 3, 3, 6, 9, 9]
Output: 4

Input: [2, 2, 2, 11]
Output: 2
Example 1:
 */
public class RemoveDuplicatesSortedArray {

    public int removeDuplicates(int[] array) {
        int startPtr = 0;
        int nextPtr = 0;
        int len = array.length;

        while (nextPtr < len) {
            if (array[startPtr] != array[nextPtr]) {
                startPtr++;
                array[startPtr] = array[nextPtr];
            }
            nextPtr++;
        }
        return startPtr + 1;
    }
}
