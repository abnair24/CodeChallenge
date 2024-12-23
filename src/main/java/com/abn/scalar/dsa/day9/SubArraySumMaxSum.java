package com.abn.scalar.dsa.day9;

/*
Given an array, find the sum of all possible subarray and print the max
 */
public class SubArraySumMaxSum {

    public int solve(int[] array) {
        int maxSum = Integer.MIN_VALUE;

        for(int i = 0; i < array.length; i++) {
            int currentSum = 0;
            for(int j = i; j < array.length; j++) {
                currentSum += array[j];
                maxSum = Math.max(currentSum, maxSum);
            }
        }

        return maxSum;
    }

    public static void main(String[] args) {
        SubArraySumMaxSum subArraySumMaxSum = new SubArraySumMaxSum();
        System.out.println(subArraySumMaxSum.solve(new int[] {1, 2, 3, -2, 5, -1}));
    }

}
