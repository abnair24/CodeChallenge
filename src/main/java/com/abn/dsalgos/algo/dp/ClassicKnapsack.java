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
public class ClassicKnapsack {

    public int minimumSubsetSumDiff(int[] weights, int[] profits, int targetWeight) {


        return minimum(weights, profits, targetWeight, 0, 0, 0);
    }

    private int minimum(int[] weights, int[] profits, int targetWeight, int index, int currentWeight, int profit) {


        if (index == weights.length) {
            if (currentWeight <= targetWeight) {
                return profit;
            }
            return 0;
        }


        int leftSum = minimum(weights, profits, targetWeight, index + 1, currentWeight + weights[index], profit + profits[index]);

        int rightSum = minimum(weights, profits, targetWeight, index + 1, currentWeight, profit);


        return Math.max(leftSum, rightSum);
    }

    public static void main(String[] args) {
        ClassicKnapsack classicKnapsack = new ClassicKnapsack();
        System.out.println(classicKnapsack.minimumSubsetSumDiff(new int[] {2, 3, 1, 4}, new int[] {4, 5, 3, 7}, 5));

    }
}
