package com.abn.learn.dsa.day16;

/*
Given a 2D array NxM, print row wise sum
 */
public class MatrixRowSum {

    public void solve(int[][] matrix) {

        int rows = matrix.length;
        int cols = matrix[0].length;

        for(int i = 0; i < rows; i++) {

            int sum = 0;
            for(int j = 0; j < cols; j++) {
                sum += matrix[i][j];
            }

            System.out.println(sum);
        }
    }

    public static void main(String[] args) {

        MatrixRowSum matrixRowSum = new MatrixRowSum();
        int[][] matrix = new int[][] {
                {1, 0, 1, 0},
                {1, 2, 1, 2},
                {1, 3, 1, 3}
        };
        matrixRowSum.solve(matrix);
    }
}