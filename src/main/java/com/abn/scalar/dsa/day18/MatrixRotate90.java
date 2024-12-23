package com.abn.scalar.dsa.day18;

/*
You are given a n x n 2D matrix A representing an image.

Rotate the image by 90 degrees (clockwise).

You need to do this in place.

 1  2  3  4  5             21 16 11 6 1
 6  7  8  9  10            22 17 12 7 2
 11 12 13 14 15            23 18 13 8 3
 16 17 18 19 20      =>    24 19 14 9 4
 21 22 23 24 25            25 20 15 10 5


First find transpose and then reverse each row
 */

public class MatrixRotate90 {

    public void solve(int[][] array) {

        // transpose

        array = transpose(array);

        //reverse each row

        for(int i =0; i< array.length; i++) {
            int start = 0;
            int end = array.length - 1;

            while(start < end) {
                int temp = array[i][start];
                array[i][start] = array[i][end];
                array[i][end] = temp;
                start ++;
                end --;
            }
        }
    }

    private int[][] transpose(int[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;

        for (int i = 0; i < rows - 1; i++) {
            for (int j = i + 1; j < cols; j++) {
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
}