package com.abn.scalar.dsa.day66;

import java.util.Arrays;

/*
Given an integer A. Return minimum count of numbers, sum of whose squares is equal to A.

Input 1:

 A = 6
Input 2:

 A = 5


Example Output

Output 1:

 3
Output 2:

 2
 */
public class MinimumNumberOfSquares {



//    private static int[] cache;
//    public int countMinSquares(int A) {
//        cache = new int[A+ 1];
//        Arrays.fill(cache, -1);
//
//        return solve(A);
//    }
//
//    private int solve(int N) {
//
//        if(N == 1 || N == 0) {
//            return cache[N] = N;
//        }
//        if(cache[N] != -1) {
//            return cache[N];
//        }
//
//        int min = Integer.MAX_VALUE;
//        for(int i = 1; i <= N/i; i++) {
//            int result = solve(N - i*i);
//            min = Math.min(min, result);
//        }
//
//        return cache[N] = min + 1;
//    }

    public int countMinSquares(int A) {
        if (A <= 0) return 0;

        // Check if it's a perfect square
        int sqrt = (int) Math.sqrt(A);
        if (sqrt * sqrt == A) return 1;

        // We still need to use tabulation but can optimize space
        // Key insight: We only need values that are A - perfect squares
        int[] dp = new int[A + 1];

        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0; // Base case: 0 can be formed with
        dp[1] = 1; // Base case: 1 is a perfect square

        for (int i = 2; i <= A; i++) {
            // Only compute if i could be part of the solution
            // This is still O(A) but with early termination possibilities

            for (int j = 1; j * j <= i; j++) {
                dp[i] = Math.min(dp[i], dp[i - j * j] + 1);

                // Early termination: if we found that i needs only 1 square, no need to check further
                if (dp[i] == 1) break;
            }
        }

        return dp[A];
    }

    public static void main(String[] args) {
        MinimumNumberOfSquares minimumNumberOfSquares = new MinimumNumberOfSquares();
        System.out.println(minimumNumberOfSquares.countMinSquares(3));
        System.out.println(minimumNumberOfSquares.countMinSquares(6));
//        System.out.println(minimumNumberOfSquares.countMinSquares(5));
//        System.out.println(minimumNumberOfSquares.countMinSquares(12));
//        System.out.println(minimumNumberOfSquares.countMinSquares(13));
    }
}
