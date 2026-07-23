package com.abn.sc.dsa.day67;

/*
given a mat[m][n] find total number of ways from 0,0 to m-1, n-1 java
 */
public class CountUniquePaths {

    public int solve(int m, int n) {
        int[][] dp = new int[m][n];

        for(int i = 0; i < m; i++) {
            dp[i][0] = 1;
        }

        for(int j = 0; j < n; j++) {
            dp[0][j] = 1;
        }

        for(int i = 1; i < m; i++) {
            for(int j = 1; j < n; j++) {
                dp[i][j] = dp[i-1][j] + dp[i][j-1];
            }
        }

        return dp[m-1][n-1];
    }

    public static void main(String[] args) {
        CountUniquePaths countUniquePaths = new CountUniquePaths();
        System.out.println(countUniquePaths.solve(2, 2));
        System.out.println(countUniquePaths.solve(3, 3));
        System.out.println(countUniquePaths.solve(5, 5));
    }
}
