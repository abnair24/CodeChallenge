package com.abn.scalar.dsa.day9;

/*
Given an array of size N, print subarray sums starting from index 3.
 */

public class SubarraySumFromIndex {

    public int solve(int[] array, int index) {

        int currentSum = 0;
        int maxSum = Integer.MIN_VALUE;

        for(int i = index; i < array.length; i++) {

            currentSum = currentSum + array[i];
            maxSum = Math.max(currentSum, maxSum);
        }

        return maxSum;
    }

    public static void main(String[] args) {

        SubarraySumFromIndex subarraySumFromIndex = new SubarraySumFromIndex();
        System.out.println(subarraySumFromIndex.solve(new int[] {3, 8, 4, 7, 9, 4, 3, -1}, 3));

    }
}
