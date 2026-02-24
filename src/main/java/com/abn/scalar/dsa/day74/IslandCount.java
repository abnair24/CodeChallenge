package com.abn.scalar.dsa.day74;

public class IslandCount {

    //diagonal possible
    int[][] DIRECTIONS = {
            {-1, -1}, {-1, 0}, {-1, 1},  // top-left, top, top-right
            {0, -1}, {0, 1},   // left, right
            {1, -1}, {1, 0}, {1, 1}};

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
        // Base cases: out of bounds or water/visited cell
        if (i < 0 || i >= m || j < 0 || j >= n || matrix[i][j] == 0) {
            return;
        }
        matrix[i][j] = 0;
        for (int[] dir : DIRECTIONS) {

            int x = dir[0] + i;
            int y = dir[1] + j;

            getIslandCountHelper(matrix, x, y, m, n);
        }
    }

    public static void main(String[] args) {
        IslandCount islandCount = new IslandCount();
        int[][] inp = {
                {1, 1, 0, 0, 0},
                {1, 1, 0, 0, 0},
                {0, 0, 0, 0, 0},
                {0, 0, 0, 1, 1}};
        System.out.println(islandCount.getIslandCount(inp));
    }
}
