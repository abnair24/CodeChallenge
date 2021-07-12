package com.abn.dsalgos.challenges.graph;

/*
In a gold mine grid of size m x n, each cell in this mine has an integer representing the amount
of gold in that cell, 0 if it is empty.

Return the maximum amount of gold you can collect under the conditions:

Every time you are located in a cell you will collect all the gold in that cell.
From your position, you can walk one step to the left, right, up, or down.
You can't visit the same cell more than once.
Never visit a cell with 0 gold.
You can start and stop collecting gold from any position in the grid that has some gold.

Input: grid = [[0,6,0],[5,8,7],[0,9,0]]
Output: 24
Path : 9 -> 8 -> 7.
 */
public class PairWithMaxGold {

    int[][] DIRECTIONS = {{1, 0}, {-1, 0}, {0, -1}, {0, 1}};

    public int getMaximumGold(int[][] matrix) {

        if (matrix == null || matrix.length == 0) {
            return 0;
        }

        int rows = matrix.length;
        int cols = matrix[0].length;
        int maxPath = 0;
        boolean[][] isVisited = new boolean[rows][cols];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (matrix[i][j] > 0) {

                    int goldSum = getMaximumGoldHelper(matrix, isVisited, rows, cols, i, j);
                    maxPath = Math.max(maxPath, goldSum);
                }
            }
        }

        return maxPath;
    }

    private int getMaximumGoldHelper(int[][] matrix, boolean[][] isVisited, int m, int n, int i, int j) {
        int max = 0;
        isVisited[i][j] = true;

        for (int[] direction : DIRECTIONS) {

            int x = direction[0] + i;
            int y = direction[1] + j;

            if (x > -1 && y > -1 && x < m && y < n && matrix[x][y] > 0 && !isVisited[x][y]) {

                int sum = getMaximumGoldHelper(matrix, isVisited, m, n, x, y);
                max = Math.max(sum, max);
            }
        }
        isVisited[i][j] = false;

        return max + matrix[i][j];
    }
}
