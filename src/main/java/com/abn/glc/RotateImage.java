package com.abn.glc;

/*
You are given an n x n 2D matrix representing an image, rotate the image by 90 degrees (clockwise)

1  2  3                 7   8   9
4  5  6          =>     4   5   6
7  8  9                 1   2   3
 */
public class RotateImage {

    public void rotate(int[][] matrix) {

        transpose(matrix);
        mirror(matrix);
    }

    private void transpose(int[][] matrix) {

        int len = matrix.length;

        for(int i = 0; i < len; i++) {
            for(int j = i; i < len; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
    }

    private void mirror(int[][] matrix) {

        int len = matrix.length;

        for(int i = 0; i < len; i++) {
            for(int j = 0; j < len/2; j ++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[i][len - j - 1];
                matrix[i][len - j - 1] = temp;
            }
        }
    }
}
