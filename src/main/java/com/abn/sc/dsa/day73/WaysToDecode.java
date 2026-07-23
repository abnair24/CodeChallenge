package com.abn.sc.dsa.day73;

/*
A message containing letters from A-Z is being encoded to numbers using the following mapping:

'A' -> 1
'B' -> 2
...
'Z' -> 26
Given an encoded message denoted by string A containing digits, determine the total
number of ways to decode it modulo 109 + 7.



Problem Constraints

1 <= length(A) <= 105



Input Format

The first and the only argument is a string A.



Output Format

Return an integer, representing the number of ways to decode the string modulo 109 + 7.

Example Input

Input 1:
 A = "12"

Output 1:
 2

Input 2:
 A = "8"
Output 2:
 1

 Explanation 1:

 Given encoded message "12", it could be decoded as "AB" (1, 2) or "L" (12).
 The number of ways decoding "12" is 2.
Explanation 2:

 Given encoded message "8", it could be decoded as only "H" (8).
 The number of ways decoding "8" is 1.

 */
public class WaysToDecode {

    private static final int MOD = 1000000007;

    public int numDecodings(String A) {

        int n = A.length();

        if (A == null || n == 0 || A.charAt(0) == '0') {
            return 0;
        }

        if(n == 1) {
            return 1;
        }

        int[][] dp = new int[n + 1][2];

        dp[0][0] = 1;
        dp[0][1] = 0;

        dp[1][0] = 1;
        dp[1][1] = 0;

        for(int i = 2; i <= n; i ++) {
            char current = A.charAt(i - 1);
            char prev = A.charAt(i - 2);
            if(current >= '1' && current <= '9') {
                dp[i][0] = (dp[i-1][0] + dp[i-1][1]) % MOD;
            }

            int twoDigit = (prev - '0') * 10 + (current - '0');
            if(twoDigit >= 10 && twoDigit <= 26) {
                dp[i][1] = (dp[i-2][0] + dp[i-2][1]) % MOD;
            }
        }

        return (int) (dp[n][0]+ dp[n][1]) % MOD;
    }

    public static void main(String[] args) {
        WaysToDecode waysToDecode = new WaysToDecode();
        System.out.println(waysToDecode.numDecodings("12"));
    }
}
