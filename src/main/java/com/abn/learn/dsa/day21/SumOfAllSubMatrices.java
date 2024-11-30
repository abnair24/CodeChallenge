package com.abn.learn.dsa.day21;
/*

Given a 2D Matrix A of dimensions N*N, we need to return the sum of all possible submatrices.
 */
public class SumOfAllSubMatrices {

    public int solve(int[][] matrix) {

        int ans = 0;
        int top_left = 0;
        int bottom_right = 0;
        int contribution = 0;

        for(int i = 0; i < matrix.length; i++) {
            for(int j = 0; j < matrix[0].length; j++) {
                top_left = (i + 1) * (j+1);
                bottom_right = (matrix.length - i) * (matrix[0].length - j);
                contribution = matrix[i][j] * top_left * bottom_right;
                ans = ans + contribution;
            }
        }
        return ans;
    }
}
