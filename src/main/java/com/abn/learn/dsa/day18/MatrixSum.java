package com.abn.learn.dsa.day18;

public class MatrixSum {

    public int[][] solve(int[][] A, int[][] B) {

        int rows = A.length;
        int cols = A[0].length;
        int[][] result = new int[rows][cols];

        for(int i = 0; i < rows; i++) {
            for(int j =0; j < cols; j++){
                result[i][j]= A[i][j] + B[i][j];
            }
        }
        return result;
    }

    public static void main(String[] args) {
        MatrixSum matrixSum = new MatrixSum();

        int[][] A = {{6}, {2}, {3}, {10}, {1}, {3}};
        int[][] B = {{6}, {7}, {3}, {8}, {1}, {2}};

        matrixSum.solve(A, B);
    }
}