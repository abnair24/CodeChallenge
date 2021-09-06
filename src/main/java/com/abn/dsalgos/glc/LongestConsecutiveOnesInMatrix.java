package com.abn.dsalgos.glc;

/*
Given an m x n binary matrix mat, return the length of the longest line of consecutive one in the matrix.

The line could be horizontal, vertical, diagonal, or anti-diagonal.

 Input: mat = [[0,1,1,0],[0,1,1,0],[0,0,0,1]]
Output: 3

Input: mat = [[1,1,1,1],[0,1,1,0],[0,0,0,1]]
Output: 4
 */
public class LongestConsecutiveOnesInMatrix {

    public int longestLine(int[][] mat) {
        int rows = mat.length;
        int cols = mat[0].length;

        if (mat.length == 0) {
            return 0;
        }

        int max = 0;

        // Eg : 4 x 5 matrix

        //horizontal
        // 0, 0 -> 0, 5
        // .... 4, 0 -> 4, 5

        for (int i = 0; i < rows; i++) {
            int count = 0;
            for (int j = 0; j < cols; j++) {
                if (mat[i][j] == 1) {
                    count++;
                    max = Math.max(max, count);
                } else {
                    count = 0;
                }
            }
        }

        //vertical
        // 0, 0 -> 4, 0
        // ... 0, 5 -> 4, 5
        for (int i = 0; i < cols; i++) {
            int count = 0;
            for (int j = 0; j < rows; j++) {
                if (mat[j][i] == 1) {
                    count++;
                    max = Math.max(max, count);
                } else {
                    count = 0;
                }
            }
        }

        //upper diagonal

        // 0, 5 - > 4, 1
        // ....
        for (int i = 0; i < cols || i < rows; i++) {
            int count = 0;
            for (int x = 0, y = i; x < rows && y < cols; x++, y++) {
                if (mat[x][y] == 1) {
                    count++;
                    max = Math.max(max, count);
                } else {
                    count = 0;
                }
            }
        }

        //lower diagonal
        for (int i = 0; i < cols || i < rows; i++) {
            int count = 0;
            for (int x = i, y = 0; x < rows && y < cols; x++, y++) {
                if (mat[x][y] == 1) {
                    count++;
                    max = Math.max(max, count);
                } else {
                    count = 0;
                }
            }
        }

        //upper antidiagonal
        for (int i = 0; i < cols || i < rows; i++) {
            int count = 0;
            for (int x = 0, y = cols - i - 1; x < rows && y >= 0; x++, y--) {
                if (mat[x][y] == 1) {
                    count++;
                    max = Math.max(max, count);
                } else {
                    count = 0;
                }
            }
        }

        //lower antidiagonal
        for (int i = 0; i < cols || i < rows; i++) {
            int count = 0;
            for (int x = i, y = cols - 1; x < rows && y >= 0; x++, y--) {
                if (mat[x][y] == 1) {
                    count++;
                    max = Math.max(max, count);
                } else {
                    count = 0;
                }
            }
        }
        return max;
    }
}
