package com.abn.learn.dsa.day16;

/*
Given a 2D NxN matrix, print diagonal principal and anti diagonal
 */
public class MatrixDiagonal {

    public void solve(int[][] matrix) {

        int rows = matrix.length;

        for(int i = 0; i < rows; i++) {
            System.out.print(matrix[i][i] + " ");
        }

        System.out.println();
        int j = matrix.length - 1;
        for(int i = 0; i < matrix.length; i ++) {
            System.out.print(matrix[i][j]+ " ");
            j --;
        }

    }

    public static void main(String[] args) {
        MatrixDiagonal matrixDiagonal = new MatrixDiagonal();
        int[][] matrix = new int[][] {
                {1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12},
                {13, 14, 15, 16}
        };
        matrixDiagonal.solve(matrix);
    }
}