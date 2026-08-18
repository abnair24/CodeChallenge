package com.abn.scaler.dsa.day73;

/*
Given an array A of positive elements, you have to flip the sign of some of its elements such that the resultant
sum of the elements of array should be minimum non-negative(as close to zero as possible).

Return the minimum number of elements whose sign needs to be flipped such that the resultant sum is minimum non-negative.
Input 1:

 A = [15, 10, 6]
 Output 1:

 1

Input 2:

 A = [14, 10, 4]
 Output 2:

 1

 Explanation 1:

 Here, we will flip the sign of 15 and the resultant sum will be 1.
Explanation 2:

 Here, we will flip the sign of 14 and the resultant sum will be 0.
 Note that flipping the sign of 10 and 4 also gives the resultant sum 0 but flippings there sign are not minimum.

 */
public class FlipArray {

    public int solve(final int[] A) {

        int n = A.length;
        int totalSum = 0;

        for (int num : A) {
            totalSum += num;
        }
        int target = totalSum / 2;

        int[][] dp = new int[n + 1][target + 1];

        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= target; j++) {
                dp[i][j] = Integer.MAX_VALUE;
            }
        }

        for (int i = 0; i <= n; i++) {
            dp[i][0] = 0;
        }
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j <= target; j++) {
                dp[i][j] = dp[i - 1][j];

                if (j >= A[i - 1] && dp[i - 1][j - A[i - 1]] != Integer.MAX_VALUE) {
                    dp[i][j] = Math.min(dp[i][j], dp[i - 1][j - A[i - 1]] + 1);
                }
            }
        }

        int bestSum = 0;
        for (int j = target; j >= 0; j--) {
            if (dp[n][j] != Integer.MAX_VALUE) {
                bestSum = j;
                break;
            }
        }

        return dp[n][bestSum];
    }

    public static void main(String[] args) {
        FlipArray flipArray = new FlipArray();
        int[] A1 = {15, 10, 6};
        System.out.println(flipArray.solve(A1)); // Output: 1

        int[] A2 = {14, 10, 4};
        System.out.println(flipArray.solve(A2)); // Output: 1
    }
}
