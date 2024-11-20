package com.abn.learn.dsa.day16;

/*
Give a N * N square matrix A, return an array of its anti-diagonals. Look at the example for more details.

Return a 2D integer array of size (2 * N-1) * N, representing the anti-diagonals of input array A.
The vacant spaces in the grid should be assigned to 0

Input :
1 2 3
4 5 6
7 8 9

o/p:

1 0 0
2 4 0
3 5 7
6 8 0
9 0 0

input:

1 2
3 4

o/p:
1 0
2 3
4 0
 */

import com.beust.ah.A;

import java.util.Arrays;

/*
todo

 */
public class AntiDiagonal {

    public int[][] diagonal(int[][] matrix) {
        int n = matrix.length;
        int rows = 2 * n - 1;
        int[][] result = new int[rows][n];

        for(int[] row: result) {
            Arrays.fill(row, 0);
        }

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                result[i+j][i] = matrix[i][j];
            }
        }
        return result;
    }

    public static void main(String[] args) {

        AntiDiagonal antiDiagonal = new AntiDiagonal();
        antiDiagonal.diagonal(new int[][] {{1, 2}, {3, 4}});
    }
}