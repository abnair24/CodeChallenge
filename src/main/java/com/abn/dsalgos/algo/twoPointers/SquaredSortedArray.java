package com.abn.dsalgos.algo.twoPointers;

/*

Given an integer array nums sorted in non-decreasing order, return an array of the squares
of each number sorted in non-decreasing order.

Input: nums = [-4,-1,0,3,10]
Output: [0,1,9,16,100]
Explanation: After squaring, the array becomes [16,1,0,9,100].
After sorting, it becomes [0,1,9,16,100].

Input: nums = [-7,-3,2,3,11]
Output: [4,9,9,49,121]

https://leetcode.com/problems/squares-of-a-sorted-array
 */
public class SquaredSortedArray {

    public int[] squares(int[] array) {
        int len = array.length;
        int[] sqArray = new int[len];
        int startPtr = 0;
        int endPtr = array.length - 1;

        for (int i = len - 1; i >= 0; i--) {
            int leftSquare = array[startPtr] * array[startPtr];
            int rightSquare = array[endPtr] * array[endPtr];

            if (Math.abs(array[startPtr]) > array[endPtr]) {
                sqArray[i] = leftSquare;
                startPtr++;
            } else {
                sqArray[i] = rightSquare;
                endPtr--;
            }
        }
        return sqArray;
    }
}
