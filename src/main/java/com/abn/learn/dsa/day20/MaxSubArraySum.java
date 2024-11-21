package com.abn.learn.dsa.day20;

/*
Given an integer away A find the maximum
subarray sum out of all the subarray

[-4, -3, -6, -9, -2]
o/p: -2

[4, 5, 2, 1, 6]
o/p: 18

[-2, 3, 4, -1, 9, -10, 7]
o/p: 15

Total subarrays for array of size N : N(N+1) / 2
 */
public class MaxSubArraySum {

    //Kadane's algorithm.

    public int maxSum(int[] array) {
        int ans = Integer.MIN_VALUE;
        int currentSum = 0;

        for (int i = 0; i < array.length; i++) {

            currentSum = currentSum + array[i];
            ans = Math.max(currentSum, ans);

            if(currentSum < 0) {
                currentSum = 0;
            }
        }

        return ans;
    }
}
