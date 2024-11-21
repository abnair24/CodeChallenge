package com.abn.learn.dsa.day16;

/*
Given 2D integer array, make all the elements in a row or column 0, if A[i][j]=0.
 Specifically make entire ith row and jth col 0

[1,2,3,4]
[5,6,7,0]
[9,2,0,4]

o/p:
[1,2,0,0]
[0,0,0,0]
[0,0,0,0]
 */

public class MatrixRowColZeros {


    public void solve(int[][] matrix) {

        int row = matrix.length;
        int col = matrix[0].length;

        for(int i = 0; i < row; i++) {
            int flag = 0;
            for(int j = 0; j < col; j++) {
                if(matrix[i][j] == 0) {
                    flag = 1;
                    break;
                }
            }

            if(flag == 1) {
                for(int j = 0; j < col; j++) {
                    matrix[i][j] = (-1) * matrix[i][j];
                }
            }
        }

        for(int j = 0; j < col; j ++) {
            int flag = 0;
            for(int i = 0; i < row; i ++) {
                if(matrix[i][j] == 0) {
                    flag = 1;
                    break;
                }
            }
            if(flag == 1) {
                for(int i = 0; i < row; i++) {
                    if(matrix[i][j] >= 0) {
                        matrix[i][j] = (-1) * matrix[i][j];
                    }
                }
            }
        }

        for(int i = 0; i < row; i++) {
            for(int j = 0; j < col; j++) {
                if(matrix[i][j] < 1) {
                    matrix[i][j] = 0;
                }

                System.out.print(matrix[i][j]+ " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {


        MatrixRowColZeros matrixRowColZeros = new MatrixRowColZeros();

        int[][] matrix = new int[][] {
                {1, 2, 0, 4},
                {5, 6, 7, 8},
                {0, 10, 11, 12}
        };

        int[][] matrix1 = new int[][] {{1, 2, 3, 4}, {5, 6, 7, 0}, {9, 2, 0, 4}};

        matrixRowColZeros.solve(matrix);
        matrixRowColZeros.solve(matrix1);
    }
}