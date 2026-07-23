package com.abn.sc.dsa.day67;

/*
Given a 2 x N grid of integers, A, your task is to choose numbers from the grid such that sum of these numbers is maximized.
However, you cannot choose two numbers that are adjacent horizontally, vertically, or diagonally.

Return the maximum possible sum.

Note: You are allowed to choose more than 2 numbers from the grid.
 */
public class MaxSumWithoutAdjElements {

    public int solve(int[][] grid) {

        // Intialize dp array with 3 rows and N columns
        // for every [i][j], the max obtained till [j-1] for each row is calculated and stored
        // for dp[2][j], max to the left if no value of jth column is taken is stored

        /*
        eg: dp[2][0] => stores max value when no value is taken from 0th column
            dp[2][1] => stores max value when 1st column is not taken.
               0    1   2   3   4   5
            =============================
         0  ||  1 | 2 | 4 | 3 | 8 | 6
         1  ||  5 | 4 | 7 | 2 | 5 | 4

           Take column 1, if grid[0][1] is taken, then max obtained = 2 + removing all adjacent and then find max. so 2+ 0
           if grid[1][1] is taken, then max obtained = 4 + removing all adjacent and then find max. so 4 + 0

           dp[2][1] = ignore col 1, then it can have values from dp[0][0] or dp[1][0] or dp[2][0] max.

           General pattern:

            dp[0][j] = "max sum ending with top cell selected in column j"
            dp[1][j] = "max sum ending with bottom cell selected in column j"
            dp[2][j] = "max sum ending with no cell selected in column j"

         */

        int cols = grid[0].length;
        int[][] dp = new int[3][cols];

        dp[0][0] = grid[0][0];
        dp[1][0] = grid[1][0];
        dp[2][0] = 0;

        for(int i = 1; i < cols; i++) {

            dp[0][i] = dp[2][i-1] + grid[0][i];
            dp[1][i] = dp[2][i-1] + grid[1][i];
            dp[2][i] = Math.max(dp[0][i-1], Math.max(dp[1][i-1] , dp[2][i-1]));
        }

        return Math.max(dp[0][cols - 1], Math.max(dp[1][cols - 1], dp[2][cols - 1]));
    }

    public static void main(String[] args) {
        MaxSumWithoutAdjElements maxSumWithoutAdjElements = new MaxSumWithoutAdjElements();
        System.out.println(maxSumWithoutAdjElements.solve(new int[][] {{1,2,4,3,8,6}, {5,4,7,2,5,4}}));
    }
}
