package com.abn.sc.dsa.day68;

/*
You are trying to send signals to aliens using a linear array of A laser lights.
You don't know much about how the aliens are going to percieve the signals, but what you know is
that if two consecutive lights are on then the aliens might take it as a sign of danger and destroy the earth.

Find and return the total number of ways in which you can send a signal without compromising the safety
of the earth. Return the ans % 109 + 7.

Input 1:
 A = 2
Output 1:
 3

Input 2:
 A = 3
Output 2:
 5
 */
public class WaysToSendSignal {

    public int solve(int A) {

        /*
        No of ways to arrange the first i lights where j indicates light OFF/ ON.

        1. If current light is OFF, previous light can be either ON or OFF.
        2. If current light is ON, previous light must be OFF.

        dp[0][0] = 1 : number of ways to arrange 0 lights where the last light is OFF,
        When we have 0 lights, there's exactly 1 way to arrange them: the empty arrangement []

        Sample tabulation table for A = 3

        i   dp[i][0]   dp[i][1]  Total
        0     1          0        1
        1     1          1        2
        2     2          1        3
        3     3          2        5
         */
        int MOD = 1000000007;

        int[][] dp = new int[A + 1][2];

        dp[0][0] = 1;
        dp[1][0] = 0;

        for(int  i = 1; i <= A; i++) {
            dp[i][0] = (dp[i-1][0] + dp[i-1][1]) % MOD;
            dp[i][1] = dp[i-1][0] % MOD;
        }

        return (int) (dp[A][0] + dp[A][1]) % MOD;
    }

    public static void main(String[] args) {
        WaysToSendSignal waysToSendSignal = new WaysToSendSignal();
        System.out.println(waysToSendSignal.solve(2));
        System.out.println(waysToSendSignal.solve(3));
        System.out.println(waysToSendSignal.solve(4));
        System.out.println(waysToSendSignal.solve(5));
    }
}
