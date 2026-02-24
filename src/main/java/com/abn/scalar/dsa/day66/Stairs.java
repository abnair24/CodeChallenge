package com.abn.scalar.dsa.day66;

public class Stairs {

    public int climbStairs(int A) {
        int mod = 1000000007;
        int[] dp = new int[A + 1];
        dp[0] = 1;
        dp[1] = 1;

        for (int i = 2; i <= A; i++) {
            int result = dp[i - 1] + dp[i - 2];
            dp[i] = result % mod;
        }

        return dp[A] % mod;
    }

    public static void main(String[] args) {

        Stairs stairs = new Stairs();
        System.out.println(stairs.climbStairs(4));
    }
}


