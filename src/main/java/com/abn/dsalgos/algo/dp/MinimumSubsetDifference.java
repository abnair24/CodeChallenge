package com.abn.dsalgos.algo.dp;

/*
Given a set of positive numbers, partition the set into two subsets with a minimum difference between their subset sums.

Input: {1, 2, 3, 9}
Output: 3
Explanation: {1, 2, 3} & {9}.

Input: {1, 2, 7, 1, 5}
Output: 0
Explanation: {1, 2, 5} & {7, 1}.

 */
public class MinimumSubsetDifference {

    public int minimumSubsetSumDiff(int[] array) {

        int sum = 0;

        for (int i = 0; i < array.length; i++) {
            sum = sum + array[i];
        }

        Integer[][] cache = new Integer[array.length + 1][sum + 1];

        return minimum(array, cache, 0, 0, 0);
    }

    private int minimum(int[] array, Integer[][] cache, int index, int sum1, int sum2) {

        if (index == array.length) {
            return Math.abs(sum1 - sum2);
        }

        if (cache[index][sum1] != null) {
            return cache[index][sum1];
        }

        int leftSum = minimum(array, cache, index + 1, sum1 + array[index], sum2);

        int rightSum = minimum(array, cache, index + 1, sum1, sum2 + array[index]);


        cache[index][sum1] = Math.min(leftSum, rightSum);

        return cache[index][sum1];
    }
}
