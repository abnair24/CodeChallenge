package com.abn.scalar.dsa.day66;

/*
Given an integer array A of size N. Find the contiguous subarray within the given array (containing at least one number) which has the largest product.

Return an integer corresponding to the maximum product possible.

NOTE: Answer will fit in 32-bit integer value.

Solution : DP tabulation (O(N) time and O(N) space)
Kadane's : O(N) time and O(1) space
 */
public class MaxProductSubarray {

    public int solve(int[] A) {

        if (A == null || A.length == 0) {
            return 0;
        }

        int n = A.length;

        // dp[i][0] stores maximum product ending at index i
        // dp[i][1] stores minimum product ending at index i
        int[][] dp = new int[n][2];

        // Initialize with first element
        dp[0][0] = A[0]; // max
        dp[0][1] = A[0]; // min
        int result = A[0];

        // Fill the dp table
        for (int i = 1; i < n; i++) {
            // If current element is positive
            if (A[i] >= 0) {
                dp[i][0] = Math.max(A[i], dp[i - 1][0] * A[i]);
                dp[i][1] = Math.min(A[i], dp[i - 1][1] * A[i]);
            }
            // If current element is negative
            else {
                dp[i][0] = Math.max(A[i], dp[i - 1][1] * A[i]);
                dp[i][1] = Math.min(A[i], dp[i - 1][0] * A[i]);
            }

            // Update global maximum
            result = Math.max(result, dp[i][0]);
        }

        return result;
    }

    public static void main(String[] args) {
        MaxProductSubarray maxProductSubarray = new MaxProductSubarray();
        System.out.println(maxProductSubarray.solve(new int[]{6, -3, -10, 0, 2}));
        System.out.println(maxProductSubarray.solve(new int[]{-1, -3, -10, 0, 60}));
        System.out.println(maxProductSubarray.solve(new int[]{-2, -3, 0, -2, -40}));
    }
}
