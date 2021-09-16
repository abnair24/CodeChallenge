package com.abn.dsalgos.algo.DFS;

/*
An image is represented by an m x n integer grid image where image[i][j] represents the pixel value of the image.

You are also given three integers sr, sc, and newColor. You should perform a flood fill on the
image starting from the pixel image[sr][sc].

Input: image = [[1,1,1],[1,1,0],[1,0,1]], sr = 1, sc = 1, newColor = 2
Output: [[2,2,2],[2,2,0],[2,0,1]]

Input: image = [[0,0,0],[0,0,0]], sr = 0, sc = 0, newColor = 2
Output: [[2,2,2],[2,2,2]]
 */

public class FloodFillDFS {

    int[][] DIRECTIONS = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    public int[][] floodFill(int[][] image, int sourceRow, int sourceCol, int color) {

        int currentColor = image[sourceRow][sourceCol];

        if (color != currentColor) {
            dfsHelper(image, sourceRow, sourceCol, image.length, image[0].length, currentColor, color);
        }

        return image;
    }

    private void dfsHelper(int[][] image, int r, int c, int m, int n, int currentColor, int color) {

        image[r][c] = color;

        for (int[] dir : DIRECTIONS) {
            int x = dir[0] + r;
            int y = dir[1] + c;

            if (x > -1 && y > -1 && x < m && y < n && image[x][y] == currentColor) {
                image[x][y] = color;
                dfsHelper(image, x, y, m, n, currentColor, color);
            }
        }
    }

    public static void main(String[] args) {
        FloodFillDFS floodFillDFS = new FloodFillDFS();

        int[][] image = {{0, 0, 0}, {0, 1, 1}};
        floodFillDFS.floodFill(image, 1, 1, 2);


        int[][] image1 = {{0, 0, 0}, {0, 1, 1}};


        floodFillDFS.floodFill(image1, 1, 1, 1);

        int[][] image2 = {{1, 1, 1}, {1, 1, 0}, {1, 0, 1}};
        int[][] result = floodFillDFS.floodFill(image2, 1, 1, 2);

        for (int i = 0; i < result.length; i++) {
            for (int j = 0; j < result[0].length; j++) {
                System.out.print(result[i][j] + " ");
            }
            System.out.println();
        }
    }
}
