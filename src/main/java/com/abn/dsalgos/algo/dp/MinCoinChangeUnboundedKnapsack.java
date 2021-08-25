package com.abn.dsalgos.algo.dp;

import org.testng.Assert;

/*
Given an infinite supply of ‘n’ coin denominations and a total money amount,
we are asked to find the minimum number of coins needed to make up that amount.

Denominations: {1,2,3}
Total amount: 5
Output: 2

Denominations: {1,2,3}
Total amount: 11
Output: 4

322 : https://leetcode.com/problems/coin-change/ 322
 */
public class MinCoinChangeUnboundedKnapsack {

    public int minimumCoins(int[] array, int target) {

        Integer[][] cache = new Integer[array.length + 1][target + 1];

        int result = minimum(array, cache, target, 0);

        return result == Integer.MAX_VALUE ? -1 : result;
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
            res = minimum(array, cache,target - array[index], index);

            if(res != Integer.MAX_VALUE) {
                count = res + 1;
            }
        }
        int count1  = minimum(array, cache, target, index + 1);
        cache[index][target] = Math.min(count, count1);

        return cache[index][target];
    }


    public static void main(String[] args) {
        MinCoinChangeUnboundedKnapsack minCoinChangeUnboundedKnapsack = new MinCoinChangeUnboundedKnapsack();
        Assert.assertEquals(minCoinChangeUnboundedKnapsack.minimumCoins(new int[]{2}, 3), -1);
        Assert.assertEquals(minCoinChangeUnboundedKnapsack.minimumCoins(new int[]{1, 2}, 5), 3);
        Assert.assertEquals(minCoinChangeUnboundedKnapsack.minimumCoins(new int[]{1, 2, 5}, 11), 3);
    }
}
