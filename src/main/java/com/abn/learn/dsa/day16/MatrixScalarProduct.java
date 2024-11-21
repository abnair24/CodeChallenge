package com.abn.learn.dsa.day16;

/*
You are given a matrix A and an integer B, you have to perform scalar multiplication of matrix A with an integer B.

A = [[1, 2, 3],
     [4, 5, 6],
     [7, 8, 9]]

     [[2, 4, 6],
     [8, 10, 12],
     [14, 16, 18]]
 */
public class MatrixScalarProduct {

    public int[][] solve(int[][] matrix, int num) {
        int rows = matrix.length;
        int cols = matrix[0].length;

        if(num == 1) {
            return matrix;
        }

        if(num == 0) {
            return new int[rows][cols];
        }

        for(int i = 0; i< rows; i++){
            for(int j = 0; j< cols; j++) {
                matrix[i][j] *= num;
            }
        }

        return matrix;

    }
}