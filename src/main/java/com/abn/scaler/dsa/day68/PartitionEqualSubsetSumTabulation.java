package com.abn.scaler.dsa.day68;

/*
 Can we partition array into two subsets with equal sum?

    Input: nums = [1,5,11,5]
 */
public class PartitionEqualSubsetSumTabulation {

    public boolean solve(int[] A) {
        int sum = 0;
        for(int num : A) {
            if(num < 0) {
                return false;
            }
            sum += num;
        }

        if(sum % 2 != 0 ) {
            return false;
        }
        int target = sum / 2;

        boolean[][] dp = new boolean[A.length + 1][target + 1];

        for (int i = 0; i <= A.length; i++) {
            dp[i][0] = true;
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
        PartitionEqualSubsetSumTabulation partitionEqualSubsetSum = new PartitionEqualSubsetSumTabulation();
        System.out.println(partitionEqualSubsetSum.solve(new int[] {1,5,11,5}));
    }
}
