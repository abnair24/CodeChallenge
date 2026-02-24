package com.abn.scalar.dsa.day67;

public class NdigitSumToBOptimized {

    public int solveExactRange(int A, int B) {
        if (A <= 0 || B < 0) return 0;
        if (B > 9 * A) return 0;

        // For A=3, B=4, we know:
        // dp[3][x] only needs dp[3][4]
        // dp[2][x] needs sums that can reach 4 with one more digit
        // dp[1][x] needs sums that can reach dp[2][needed_sums]

        int[][] dp = new int[A + 1][B + 1];
        dp[0][0] = 1;

        int maxDigitSum = Math.min(B, 9);
        for(int j = 1; j <= maxDigitSum; j++) {
            dp[1][j] = 1;
        }

        for(int i = 1; i <= A; i++) {
            dp[i][0] = 0; // Only one way to make sum 0 with i digits (all zeros)
        }

        for (int digits = 2; digits <= A; digits++) {
            if (digits == A) {
                // Last level: only compute dp[A][B]
                computeSingleCell(dp, A, B);

            } else {
                // Compute range that can contribute to final answer
                int remainingDigits = A - digits;
                int minSum = Math.max(0, B - remainingDigits * 9);
                System.out.println("minsum:" + minSum);

                // maxSum at any digit position is 9. So if 3 digits are there, max sum can be formed is 9 + 9 + 9 = 27
                int maxSum = Math.min(B, digits * 9);

                if (digits == 1) {
                    minSum = Math.max(minSum, 1);
                }

                for (int sum = minSum; sum <= maxSum; sum++) {
                    computeSingleCell(dp, digits, sum);
                }
            }
        }
        return dp[A][B];
    }

    private void computeSingleCell(int[][] dp, int digits, int sum) {
        int start = (digits == 1) ? 1 : 0;
        int temp = 0;
        for (int d = start; d <= 9 && d <= sum; d++) {

            if (dp[digits-1][sum-d] > 0) {

                temp += dp[digits-1][sum-d];
                temp = temp % 1000000007;
                System.out.println("dp[" + digits + "][" + sum + "] =  + (adding dp[" + (digits-1) + "][" + (sum-d) + "] which is " + dp[digits-1][sum-d] + ")");
            }
          dp[digits][sum] = temp;
        }
    }

    public static void main(String[] args) {
        NdigitSumToBOptimized ndigitSumToBOptimized = new NdigitSumToBOptimized();
        //System.out.println(ndigitSumToBOptimized.solveExactRange(2, 4)); // Output: 4
        System.out.println(ndigitSumToBOptimized.solveExactRange(75, 22)); // Output: 28
//        System.out.println(ndigitSumToBOptimized.solveExactRange(1, 0)); // Output: 0
//        System.out.println(ndigitSumToBOptimized.solveExactRange(2, 0)); // Output: 1
//        System.out.println(ndigitSumToBOptimized.solveExactRange(3, 27)); // Output: 1
    }
}
