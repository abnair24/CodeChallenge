package com.abn.scalar.dsa.day47;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/*
Given three integers A, B, and C, where A represents n, B represents r,
and C represents m, find and return the value of nCr % m where nCr % m = (n!/((n-r)!*r!))% m.


x! means factorial of x i.e. x! = 1 * 2 * 3... * x.
 */

public class Ncr {

    public int solve(int A, int B, int C) {

        if(B > A) {
            return 0;
        }
        if(B == 0 || B == A) {
            return 1 % C;
        }
        B = Math.min(B, A-B);

        long[] dp = new long[B+1];
        dp[0] = 1;

        for(int i = 1; i<=A; i++) {
            for(int j = Math.min(i, B); j>0; j--) {
                dp[j] = (dp[j] + dp[j-1]) %C;
            }
        }
        return (int) dp[B];
    }

}
