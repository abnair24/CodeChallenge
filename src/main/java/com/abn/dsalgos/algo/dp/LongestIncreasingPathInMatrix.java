package com.abn.dsalgos.algo.dp;

/*
Given an m x n integers matrix, return the length of the longest increasing path in matrix.
From each cell, you can either move in four directions: left, right, up, or down.
You may not move diagonally or move outside the boundary (i.e., wrap-around is not allowed).
 */
public class LongestIncreasingPathInMatrix {

    int[][] DIRECTIONS = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    public int longestIncreasingPath(int[][] matrix) {
        if (matrix.length == 0) {
            return 0;
        }
        int rows = matrix.length;
        int cols = matrix[0].length;
        int longestPathMax = 0;
        int[][] cache = new int[rows][cols];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                int longestPath = longestPathHelper(matrix, cache, rows, cols, i, j);
                longestPathMax = Math.max(longestPath, longestPathMax);
            }
        }
        return longestPathMax;
    }

    private int longestPathHelper(int[][] matrix, int[][] cache, int m, int n, int i, int j) {
        int max = 0;
        if (cache[i][j] != 0) {
            return cache[i][j];
        }

        for (int[] direction : DIRECTIONS) {
            int x = i + direction[0];
            int y = j + direction[1];
            if (x > -1 && y > -1 && x < m && y < n && matrix[i][j] < matrix[x][y]) {
                int longest = longestPathHelper(matrix, cache, m, n, x, y);
                max = Math.max(longest, max);
            }
        }
        cache[i][j] = max + 1;
        return cache[i][j];
    }
}
