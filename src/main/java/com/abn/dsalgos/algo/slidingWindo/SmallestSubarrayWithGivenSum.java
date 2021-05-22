package com.abn.dsalgos.algo.slidingWindo;


/*
Given an array of positive numbers and a positive number "S," find the length of the
smallest contiguous subarray whose sum is greater than or equal to "S".
Return 0 if no such subarray exists.
 */
public class SmallestSubarrayWithGivenSum {

    public int findMinSubArray(int s, int[] arr) {

        int minSize = Integer.MAX_VALUE;
        int start = 0;
        int size;
        int subArraySum = 0;
        for (int i = 0; i < arr.length; i++) {
            subArraySum += arr[i];

            while (subArraySum >= s) {
                size = i - start + 1;
                minSize = Math.min(minSize, size);
                subArraySum -= arr[start];
                start++;
            }
        }
        return minSize;
    }
}
