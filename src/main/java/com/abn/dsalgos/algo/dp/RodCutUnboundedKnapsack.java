package com.abn.dsalgos.algo.dp;

/*
Given a rod of length ‘n’, we are asked to cut the rod and sell the pieces in a way that will maximize the profit.
We are also given the price of every piece of length ‘i’ where ‘1 <= i <= n’.

Lengths: [1, 2, 3, 4, 5]
Prices: [2, 6, 7, 10, 13]
Rod Length: 5
 */

public class RodCutUnboundedKnapsack {

    public int rodCut(int[] rodLength, int[] price, int targetLength) {
        Integer[][] cache = new Integer[rodLength.length][targetLength + 1];

        return rodCutHelper(rodLength, price, cache, targetLength, 0);
    }

    private int rodCutHelper(int[] rodLength, int[] price, Integer[][] cache, int targetLength, int index) {

        if(targetLength <= 0 || price.length != rodLength.length || index >= price.length) {
            return 0;
        }

        int l1 = 0;

        if(cache[index][targetLength] != null) {
            return cache[index][targetLength];
        }

        if(rodLength[index] <= targetLength) {
            l1 = price[index] + rodCutHelper(rodLength, price, cache, targetLength - rodLength[index], index);
        }

        int l2 = rodCutHelper(rodLength, price, cache, targetLength, index + 1);

        cache[index][targetLength] = Math.max(l1, l2);
        return cache[index][targetLength];
    }

    public static void main(String[] args) {
        RodCutUnboundedKnapsack rodCutUnboundedKnapsack = new RodCutUnboundedKnapsack();
        System.out.println(rodCutUnboundedKnapsack.rodCut(new int[]{1,3,4,5}, new int[]{2, 6, 7, 10, 13}, 5));
    }

}
