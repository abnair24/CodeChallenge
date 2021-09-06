package com.abn.dsalgos.algo.BFS;

import com.abn.dsalgos.utils.Pair;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

/*
An image is represented by an m x n integer grid image where image[i][j] represents the pixel value of the image.

You are also given three integers sr, sc, and newColor. You should perform a flood fill on the
image starting from the pixel image[sr][sc].

Input: image = [[1,1,1],[1,1,0],[1,0,1]], sr = 1, sc = 1, newColor = 2
Output: [[2,2,2],[2,2,0],[2,0,1]]

Input: image = [[0,0,0],[0,0,0]], sr = 0, sc = 0, newColor = 2
Output: [[2,2,2],[2,2,2]]
 */
public class FloodFillBFS {

    int[][] DIRECTIONS = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    Set<Pair> visited = new HashSet<>();

    public int[][] floodFillColor(int[][] image, int sourceRow, int sourceCol, int color) {

        int rowMax = image.length;
        int colMax = image[0].length;
        int currentColor = image[sourceRow][sourceCol];

        Queue<Pair> queue = new LinkedList<>();

        Pair start = new Pair(sourceRow, sourceCol);
        queue.add(start);
        visited.add(start);
        image[sourceRow][sourceCol] = color;

        while (!queue.isEmpty()) {
            Pair node = queue.poll();

            for (Pair neighbour : getNeighbours(node, rowMax, colMax, image, currentColor)) {
                if (!visited.contains(neighbour)) {
                    queue.add(neighbour);
                    visited.add(neighbour);
                    image[neighbour.row][neighbour.col] = color;
                }
            }
        }
        return image;
    }

    private List<Pair> getNeighbours(Pair node, int m, int n, int[][] image, int currentColor) {

        List<Pair> neighbourList = new ArrayList<>();

        for (int[] dir : DIRECTIONS) {
            int x = dir[0] + node.row;
            int y = dir[1] + node.col;
            Pair temp = new Pair(x, y);

            if (x > -1 && y > -1 && x < m && y < n && image[x][y] == currentColor && !visited.contains(temp)) {
                neighbourList.add(temp);
            }
        }
        return neighbourList;
    }

    public static void main(String[] args) {

        int[][] image = {{0, 0, 0}, {0, 1, 1}};

        FloodFillBFS floodFillBFS = new FloodFillBFS();
        floodFillBFS.floodFillColor(image, 1, 1, 1);

        int[][] image1 = {{1, 1, 1}, {1, 1, 0}, {1, 0, 1}};
        int[][] result = floodFillBFS.floodFillColor(image1, 1, 1, 2);

        for (int i = 0; i < result.length; i++) {
            for (int j = 0; j < result[0].length; j++) {
                System.out.print(result[i][j] + " ");
            }
            System.out.println();
        }
    }
}

