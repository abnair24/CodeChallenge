package com.abn.dsalgos.algo.dp;

public class CoinChangeUnboundedKnapsack {

    public int coinChange(int[] array, int target) {

        Integer[][] cache = new Integer[array.length + 1][target + 1];

        return coinChangeHelper(array, cache, target, 0);
    }

    private int coinChangeHelper(int[] array, Integer[][] cache, int target, int index) {

        if(target == 0) {
            return 1;
        }

        if(array.length == 0 || index >= array.length) {
            return 0;
        }

        if(cache[index][target] != null) {
            return cache[index][target];
        }

        int sum1 = 0;

        if(array[index] <= target) {
            sum1 = coinChangeHelper(array, cache,target - array[index], index);
        }

        int sum2 = coinChangeHelper(array, cache, target, index + 1);

        cache[index][target] = sum1 + sum2;

        return cache[index][target];
    }

    public static void main(String[] args) {
        CoinChangeUnboundedKnapsack coinChangeUnboundedKnapsack = new CoinChangeUnboundedKnapsack();
        System.out.println(coinChangeUnboundedKnapsack.coinChange(new int[]{1,2,3}, 5));

    }
}
