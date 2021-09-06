package com.abn.dsalgos.algo.dp;

/*
Given the weights and profits of ‘N’ items, we are asked to put these items in a knapsack that has a capacity ‘C’.
The goal is to get the maximum profit from the items in the knapsack.
The only difference between the 0/1 Knapsack problem and this problem is that we are allowed to use an
unlimited quantity of an item.

Items: { Apple, Orange, Melon }
Weights: { 1, 2, 3 }
Profits: { 15, 20, 50 }
Knapsack capacity: 5

2 Apples + 1 Melon (total weight 5) => 80 profit
 */
public class UnboundedKnapsack {

    public int unbounded(int[] weights, int[] profit, int totalCapacity) {

        Integer[][] cache = new Integer[weights.length][totalCapacity + 1];
        return unboundedHelper(weights, profit, cache, totalCapacity, 0);
    }

    private int unboundedHelper(int[] weights, int[] profit, Integer[][] cache, int totalCapacity, int index) {

        System.out.println(index + ": " + totalCapacity);
        if (totalCapacity <= 0 || profit.length != weights.length || index >= profit.length) {
            return 0;
        }

        int p1 = 0;

        if (cache[index][totalCapacity] != null) {
            return cache[index][totalCapacity];
        }
        if (weights[index] <= totalCapacity) {
            p1 = profit[index] + unboundedHelper(weights, profit, cache, totalCapacity - weights[index], index);
        }

        int p2 = unboundedHelper(weights, profit, cache, totalCapacity, index + 1);

        cache[index][totalCapacity] = Math.max(p1, p2);

        return cache[index][totalCapacity];
    }

    public static void main(String[] args) {
        UnboundedKnapsack unboundedKnapsack = new UnboundedKnapsack();
        System.out.println(unboundedKnapsack.unbounded(new int[] {1, 2, 3}, new int[] {15, 20, 50}, 5));
    }
}
