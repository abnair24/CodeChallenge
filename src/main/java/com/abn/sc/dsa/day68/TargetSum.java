package com.abn.sc.dsa.day68;

/*
you are given a set of non negative integers and target sum. The task is to determin whether there exists  a subset
 of  the given set whose sum is equal to target sum.
 [3,34,12,4,5,2] target = 9
 */
public class TargetSum {

    public boolean solve(int[] A, int target) {

        boolean[][] dp = new boolean[A.length + 1][target + 1];

        for(int i = 0; i <= A.length; i++) {
            dp[i][0] = true;
        }

        for(int j = 0; j <= target; j++){
            dp[0][j] = false;
        }

        for(int i = 1; i <= A.length; i++) {
            for(int j = 1; j <= target; j++) {
                dp[i][j] = dp[i-1][j];
                if(A[i-1] <= j) {
                    dp[i][j] = dp[i-1][j] || dp[i-1][j - A[i-1]];
                }
            }
        }
        return dp[A.length][target];
    }

    public static void main(String[] args) {

        TargetSum targetSum = new TargetSum();
        System.out.println(targetSum.solve(new int[] {3,34,12,4,5,2}, 9));
    }
}
