package com.abn.dsalgos.challenges.problems;

public class MatrixDiagonal {

    public void diagonalPrint(int[][] arr) {

        int size = arr.length;

        for (int k = 0; k < size; k++) {
            System.out.println(arr[k][0]);

            for (int i = k - 1, j = 1; i >= 0 && j <= k; i--, j++) {
                System.out.println(arr[i][j]);
            }
        }
        for (int k = 1; k < size; k++) {
            System.out.println(arr[size - 1][k]);

            for (int i = size - 2, j = k + 1; i >= 0 && j < size; i--, j++) {
                System.out.println(arr[i][j]);

            }
        }
    }

    public static void main(String[] args) {
        int[][] array = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};

        MatrixDiagonal matrixDiagonal = new MatrixDiagonal();
        matrixDiagonal.diagonalPrint(array);
    }
}
