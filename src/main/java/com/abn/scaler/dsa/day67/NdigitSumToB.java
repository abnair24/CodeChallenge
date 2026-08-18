package com.abn.scaler.dsa.day67;

/*
How many A digit numbers exist such that the sum of digits is equal to B.

A = 2, B = 4

40, 31, 22, 13

 */
public class NdigitSumToB {

    public int solve(int A, int B) {
        int[][] dp = new int[A + 1][B + 1];
        dp[0][0] = 1;
        System.out.println("Initial: dp[0][0] = 1\n");

        for (int digits = 1; digits <= A; digits++) {
            for (int sum = 0; sum <= B; sum++) {
                // First digit: 1-9, others: 0-9
                int start = (digits == 1) ? 1 : 0;

                System.out.println("\nCalculating dp[" + digits + "][" + sum + "]:");

                for (int d = start; d <= 9 && d <= sum; d++) {
                    int prevValue = dp[digits][sum];
                    int addValue = dp[digits-1][sum-d];

                    System.out.println("  Using digit " + d + ": dp[" + digits + "][" + sum + "] = "
                            + prevValue + " + dp[" + (digits-1) + "][" + (sum-d) + "] (which is "
                            + addValue + ") = " + (prevValue + addValue));

                    dp[digits][sum] += dp[digits-1][sum-d];
                }

                System.out.println("  Final: dp[" + digits + "][" + sum + "] = " + dp[digits][sum]);
            }
        }

        return dp[A][B];
    }

    public static void main(String[] args) {
        NdigitSumToB ndigitSumToB = new NdigitSumToB();
       // System.out.println(ndigitSumToB.solve(2, 4)); // Output: 4
        System.out.println(ndigitSumToB.solve(3, 4)); // Output: 28
//        System.out.println(ndigitSumToB.solve(1, 0)); // Output: 0
//        System.out.println(ndigitSumToB.solve(2, 0)); // Output: 1
//        System.out.println(ndigitSumToB.solve(3, 27)); // Output: 1
    }
}
