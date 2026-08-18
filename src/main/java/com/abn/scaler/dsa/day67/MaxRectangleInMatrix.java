package com.abn.scaler.dsa.day67;

public class MaxRectangleInMatrix {

    public int solve(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return 0;
        }


        int rows = matrix.length;
        int cols = matrix[0].length;
        int maxArea = 0;

        // Step 1: Build DP table for widths
        int[][] dp = new int[rows][cols];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (matrix[i][j] == 0) {
                    dp[i][j] = 0;
                } else {
                    dp[i][j] = (j == 0) ? 1 : dp[i][j-1] + 1;
                }
            }
        }
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (matrix[i][j] == 1) {
                    int minWidth = Integer.MAX_VALUE;

                    // Try rectangles of different heights ending at (i,j)
                    for (int height = 1; i - height + 1 >= 0; height++) {
                        int currentRow = i - height + 1;

                        minWidth = Math.min(minWidth, dp[currentRow][j]);

                        if (minWidth == 0) {
                            break;
                        }

                        int currentArea = height * minWidth;
                        maxArea = Math.max(maxArea, currentArea);
                    }
                }
            }
        }

        return maxArea;
    }

    public static void main(String[] args) {
        MaxRectangleInMatrix maxRectangleInMatrix = new MaxRectangleInMatrix();
        int[][] matrix = {
                {1, 0, 1, 0, 0},
                {1, 0, 1, 1, 1},
                {1, 1, 1, 1, 1},
                {1, 0, 0, 1, 0}
        };
        System.out.println(maxRectangleInMatrix.solve(matrix));
    }
}
