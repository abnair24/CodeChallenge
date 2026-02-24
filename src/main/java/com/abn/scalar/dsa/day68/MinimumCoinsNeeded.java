package com.abn.scalar.dsa.day68;

/*
Find minimum number of coins to make target amount

 */
public class MinimumCoinsNeeded {

    public int solve(int[] coins, int target) {

        int[][] dp = new int[coins.length + 1][target + 1];
        for(int i = 0; i <= coins.length; i++) {
            for(int j = 0; j <= target; j++) {
                dp[i][j] = Integer.MAX_VALUE;
            }
        }

        for(int i = 0; i <= coins.length; i++) {
            dp[i][0] = 0;
        }

        //unbounded knapsack as we can use same coin multiple times
        for(int i = 1; i <= coins.length; i++) {
            for(int j = 1; j <= target; j++) {

                dp[i][j] = dp[i-1][j];
                if(coins[i-1] <= j && dp[i][j - coins[i-1]] != Integer.MAX_VALUE) {
                    dp[i][j] = Math.min(dp[i][j], 1 + dp[i][j - coins[i-1]]);
                }
            }
        }

        return dp[coins.length][target] == Integer.MAX_VALUE ? -1 : dp[coins.length][target];
    }
}
