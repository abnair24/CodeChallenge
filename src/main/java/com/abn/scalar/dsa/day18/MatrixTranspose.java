package com.abn.scalar.dsa.day18;

/*

Hint: Upper triangle elements swap with lower triangle of main diagonal

1  2  3  4  5               1  6  11  16  21
6  7  8  9  10              2  7  12  17  22
11 12 13 14 15   =>         3  8  13  18  23
16 17 18 19 20              4  9  14  19  24
21 22 23 24 25              5  10 15  20  25

 */
public class MatrixTranspose {

    public int[][] solve1(int[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        int[][] result = new int[cols][rows];
        for(int i = 0; i < rows; i++) {
            for(int j = 0; j < cols; j++) {

                result[j][i]= matrix[i][j];
            }
        }
        return result;

    }
    public int[][] solve(int[][] matrix) {

        int rows = matrix.length;
        int cols = matrix[0].length;

        for(int i = 0; i < rows - 1; i++) {
            for(int j = i+1; j < cols; j++) {

                swap(i, j, matrix);
            }
        }

        return matrix;
    }

    private int[][] swap(int i, int j, int[][] matrix) {

        int temp = matrix[i][j];
        matrix[i][j] = matrix[j][i];
        matrix[j][i] = temp;
        return matrix;
    }

    public static void main(String[] args) {

        MatrixTranspose matrixTranspose = new MatrixTranspose();
//        matrixTranspose.solve(new int[][] {
//                {1, 2, 3, 4, 5},
//                {6, 7, 8, 9, 10},
//                {11, 12, 13, 14, 15},
//                {16, 17, 18, 19, 20},
//                {21, 22, 23, 24, 25}
//        });

        matrixTranspose.solve(new int[][] {
                {21, 62, 42, 5, 2, 18, 23},
                {62, 72, 44, 35, 65, 1, 57},
                {16, 85, 30, 12, 65, 16, 9 },
                {44, 35, 56, 35, 82, 91, 28 },
                {55, 14, 25, 55, 26, 42, 13 },
                {100, 1, 52, 74, 36, 11, 44 },
                {16, 89, 61, 50, 66, 72, 40 },
                {86, 15, 23, 50, 60, 97, 47 },
                {29, 73, 54, 80, 1, 35, 98 }
        });
    }
}