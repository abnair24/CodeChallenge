package com.abn.scaler.dsa.day68;

/*
/ How many subsets have sum equal to target?
 */
public class CountOfSubsetsWithGivenSum {

    public int solve(int[] A, int target) {
        int[][] dp = new int[A.length + 1][target + 1];

        for(int i = 0; i <= A.length; i++) {
            dp[i][0] = 1;
        }

        for (int i = 1; i <= A.length; i++) {
            for (int j = 1; j <= target; j++) {
                dp[i][j] = dp[i-1][j];
                if(A[i-1] <= j) {
                    dp[i][j] += dp[i-1][j - A[i-1]];
                }
            }
        }
        return dp[A.length][target];
    }

    public static void main(String[] args) {
        CountOfSubsetsWithGivenSum countOfSubsetsWithGivenSum = new CountOfSubsetsWithGivenSum();
        System.out.println(countOfSubsetsWithGivenSum.solve(new int[] {1,2,3,3}, 6));
    }
}
