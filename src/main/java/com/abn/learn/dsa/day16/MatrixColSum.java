package com.abn.learn.dsa.day16;

/*
You are given a 2D integer matrix A, return a 1D integer array containing column-wise sums of original matrix.
[1,2,3,4]
[5,6,7,8]
[9,2,3,4]

{15,10,13,16}

 */

public class MatrixColSum {

    public void solve(int[][] matrix) {

        int rows = matrix.length;
        int cols = matrix[0].length;

        for(int i = 0; i < cols; i++) {

            int sum = 0;
            for(int j = 0; j < rows; j++) {
                sum += matrix[j][i];
            }

            System.out.println(sum);
        }
    }

    public static void main(String[] args) {

        MatrixColSum matrixColSum = new MatrixColSum();
        int[][] matrix = new int[][] {
                {1, 0, 1, 0},
                {1, 2, 1, 2},
                {1, 3, 1, 3}
        };
        matrixColSum.solve(matrix);
    }

}