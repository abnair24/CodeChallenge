package com.abn.scalar.dsa.day16;

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

import java.util.Arrays;

public class AntiDiagonal {

    public int[][] diagonal(int[][] matrix) {

        int n = matrix.length;
        int rows = matrix.length == matrix[0].length ? 2 * n - 1 : 2 * n;
        int[][] result = new int[rows][n];

        int row = 0;
        for(int col = 0; col < matrix[0].length; col ++) {

            int sr = row;
            int sc = col;

            while(sr < matrix.length && sc >= 0) {
                result[sr+sc][sr] = matrix[sr][sc];
                sr++;
                sc--;
            }

        }

        int col = matrix[0].length - 1;
        for(row = 1; row < matrix.length; row++) {

            int sr = row;
            int sc = col;
            int j = 0;

            while(sr < matrix.length && sc >= 0) {
                result[sr + sc][j] = matrix[sr][sc];
                sr ++;
                sc --;
                j++;
            }

        }

        return result;
    }

    public static void main(String[] args) {

        AntiDiagonal antiDiagonal = new AntiDiagonal();
        System.out.println(Arrays.deepToString(antiDiagonal.diagonal(new int[][] {{1, 2}, {3, 4}})).replace("],", "]\n"));
        System.out.println(Arrays.deepToString(antiDiagonal.diagonal(new int[][] {
                {1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12}
        })).replace("],","]\n"));
    }
}