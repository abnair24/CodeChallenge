package com.abn.dsalgos.algo.twoPointers;


/*
Given an array of sorted numbers and a target sum, find a pair in the array whose
sum is equal to the given target.

Write a function to return the indices of the two numbers (i.e. the pair) such that
they add up to the given target.

Input: [1, 2, 3, 4, 6], target=6
Output: [1, 3]

Input: [2, 5, 9, 11], target=11
Output: [0, 2]
 */
public class PairWithTargetSum {

    public int[] search(int[] arr, int targetSum) {

        int startPtr = 0;
        int endPtr = arr.length - 1;
        int sum;

        for (int i = 0; i < arr.length; i++) {
            sum = arr[startPtr] + arr[endPtr];
            if (sum > targetSum) {
                endPtr--;
            } else if (sum < targetSum) {
                startPtr++;
            } else {
                return new int[] {startPtr, endPtr};
            }
        }
        return new int[] {-1, -1};
    }
}
