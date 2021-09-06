package com.abn.dsalgos.algo.DFS;


/*
Given an m x n 2D binary grid grid which represents a map of '1's (land) and '0's (water), return the number of islands.

An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically. You may assume all
four edges of the grid are all surrounded by water.

Input: grid = [
  ["1","1","1","1","0"],
  ["1","1","0","1","0"],
  ["1","1","0","0","0"],
  ["0","0","0","0","0"]
]
Output: 1

Input: grid = [
  ["1","1","0","0","0"],
  ["1","1","0","0","0"],
  ["0","0","1","0","0"],
  ["0","0","0","1","1"]
]
Output: 3
 */
public class IslandCount {

    int[][] DIRECTIONS = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    public int getIslandCount(int[][] matrix) {

        if (matrix.length == 0 || matrix == null) {
            return 0;
        }

        int rows = matrix.length;
        int cols = matrix[0].length;
        int count = 0;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (matrix[i][j] == 1) {
                    count++;
                    getIslandCountHelper(matrix, i, j, rows, cols);
                }
            }
        }
        return count;
    }

    private void getIslandCountHelper(int[][] matrix, int i, int j, int m, int n) {

        for (int[] dir : DIRECTIONS) {

            int x = dir[0] + i;
            int y = dir[1] + j;

            if (x > -1 && y > -1 && x < m && y < n && matrix[x][y] != 0) {
                matrix[x][y] = 0;
                getIslandCountHelper(matrix, x, y, m, n);
            }
        }
    }
}
