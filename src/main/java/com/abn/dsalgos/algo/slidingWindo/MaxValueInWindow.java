package com.abn.dsalgos.algo.slidingWindo;

/*
You are given an array of integers nums, there is a sliding window of size k which is moving from
the very left of the array to the very right. You can only see the k numbers
in the window. Each time the sliding window moves right by one position.
 */

public class MaxValueInWindow {

    public int maxSlidingWindow(int[] arr, int k) {

        int windowStart = 0;
        int maxSum = Integer.MIN_VALUE;
        int sum = 0;

        for(int windowEnd = 0; windowEnd < arr.length; windowEnd ++) {

            sum += arr[windowEnd];

            if(windowEnd >= k - 1) {
                maxSum = Math.max(maxSum, sum);
                sum = sum - arr[windowStart];
                windowStart ++;
            }
        }
        return maxSum;
    }
}
