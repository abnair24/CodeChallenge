package com.abn.dsalgos.challenges.graph;

public class MaxIslandArea {

    int[][] DIRS = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    public int maxAreaOfIsland(int[][] matrix) {

        int rows = matrix.length;
        int cols = matrix[0].length;
        int maxArea = 0;
        boolean[][] isVisited = new boolean[rows][cols];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (matrix[i][j] == 1 && !isVisited[i][j]) {
                    int area = maxAreaOfIslandHelper(matrix, i, j, rows, cols, isVisited);
                    maxArea = Math.max(area, maxArea);
                }
            }
        }
        return maxArea;
    }

    private int maxAreaOfIslandHelper(int[][] matrix, int i, int j, int m, int n, boolean[][] isVisited) {

        int count = 0;
        isVisited[i][j] = true;

        for (int[] dir : DIRS) {
            int x = dir[0] + i;
            int y = dir[1] + j;

            if (x > -1 && y > -1 && x < m && y < n && matrix[x][y] != 0 && !isVisited[x][y]) {
                count += maxAreaOfIslandHelper(matrix, x, y, m, n, isVisited);
            }
        }
        return count + 1;
    }
}
