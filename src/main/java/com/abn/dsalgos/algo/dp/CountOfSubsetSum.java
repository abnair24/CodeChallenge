package com.abn.dsalgos.algo.dp;

/*
Given a set of positive numbers, find the total number of subsets whose sum is equal to a given number ‘S’.
 */
public class CountOfSubsetSum {

    public int subsetSumCount(int[] array, int target) {

        int sum = 0;
        for (int i = 0; i < array.length; i++) {
            sum = sum + array[i];
        }

        Integer[][] cache = new Integer[array.length][sum + 1];

        return countHelper(array, cache, 0, sum, 0, target);
    }

    private int countHelper(int[] array, Integer[][] cache, int sum1, int sum, int index, int target) {
        if (sum == 0) {
            return 0;
        }

        if (sum1 == target) {
            return 1;
        }

        if (cache[index][sum1] != null) {
            return cache[index][sum1];
        }
        int count = 0;

        if (sum1 > target) {
            return countHelper(array, cache, sum1, sum - array[index], index + 1, target);
        }

        count = countHelper(array, cache, sum1 + array[index], sum - array[index], index + 1, target) +
                countHelper(array, cache, sum1, sum - array[index], index + 1, target);

        cache[index][sum1] = count;
        return cache[index][sum1];
    }
}
