package com.abn.dsalgos.algo.dp;

/*
Given an infinite supply of ‘n’ coin denominations and a total money amount,
we are asked to find the minimum number of coins needed to make up that amount.

Denominations: {1,2,3}
Total amount: 5
Output: 2

Denominations: {1,2,3}
Total amount: 11
Output: 4
 */
public class MinCoinChangeUnboundedKnapsack {

    public int minimumCoins(int[] array, int target) {

        Integer[][] cache = new Integer[array.length + 1][target + 1];

        return minimum(array, cache, target, 0);
    }

    private int minimum(int[] array, Integer[][] cache, int target, int index) {

        if(target == 0) {
            return 0;
        }

        if(index >= array.length || array.length == 0) {
            return Integer.MAX_VALUE;
        }

        if(cache[index][target] != null) {
            return cache[index][target];
        }

        int res = 0;
        int count = Integer.MAX_VALUE;

        if(array[index] <= target) {
            res = minimum(array, cache, target - array[index], index);

            if(res != Integer.MAX_VALUE) {
                count = res + 1;
            }
        }
        int count1  = minimum(array, cache, target, index + 1);

        return Math.min(count, count1);
    }


    public static void main(String[] args) {
        MinCoinChangeUnboundedKnapsack minCoinChangeUnboundedKnapsack = new MinCoinChangeUnboundedKnapsack();
        System.out.println(minCoinChangeUnboundedKnapsack.minimumCoins(new int[]{1, 6}, 6));
    }
}
