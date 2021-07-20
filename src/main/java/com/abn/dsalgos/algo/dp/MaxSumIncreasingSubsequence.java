package com.abn.dsalgos.algo.dp;

import org.testng.Assert;

/*
Given a number sequence, find the increasing subsequence with the highest sum. Write a method that returns the highest sum.
Input: {4,1,2,6,10,1,12}
Output: 32
Explanation: The increaseing sequence is {4,6,10,12}.

Input: {-4,10,3,7,15}
Output: 25
 */
public class MaxSumIncreasingSubsequence {

    public int maxSum(int[] array) {

        int[][] cache = new int[array.length][array.length + 1];
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length; j++) {
                cache[i][j] = -1;
            }
        }

        return maxSumHelper(array, 0, -1, cache);
    }

    private int maxSumHelper(int[] array, int index, int previous, int[][] cache) {

        if (index >= array.length) {
            return 0;
        }

        if (cache[index][previous + 1] != -1) {
            return cache[index][previous + 1];
        }
        int s1 = 0;

        if (previous == -1 || array[index] > array[previous]) {
            s1 = array[index] + maxSumHelper(array, index + 1, index, cache);
        }

        int s2 = maxSumHelper(array, index + 1, previous, cache);

        cache[index][previous + 1] = Math.max(s1, s2);

        return cache[index][previous + 1];
    }

    public static void main(String[] args) {

        MaxSumIncreasingSubsequence maxSumIncreasingSubsequence = new MaxSumIncreasingSubsequence();
        Assert.assertEquals(maxSumIncreasingSubsequence.maxSum(new int[] {-4, 10, 3, 7, 15}), 25);
        Assert.assertEquals(maxSumIncreasingSubsequence.maxSum(new int[] {4, 1, 2, 6, 10, 1, 12}), 32);
    }
}
