package com.abn.dsalgos.algo.BFS;

import com.abn.dsalgos.utils.Pair;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

/*
Given an n x n binary matrix grid, return the length of the shortest clear path in the matrix.
If there is no clear path, return -1.

A clear path in a binary matrix is a path from the top-left cell (i.e., (0, 0)) to the bottom-right
cell (i.e., (n - 1, n - 1)) such that:

All the visited cells of the path are 0.
All the adjacent cells of the path are 8-directionally connected (i.e., they are different and
they share an edge or a corner).
The length of a clear path is the number of visited cells of this path.

Input: grid = [[0,1],[1,0]]
Output: 2

Input: grid = [[0,0,0],[1,1,0],[1,1,0]]
Output: 4

Input: grid = [[1,0,0],[1,1,0],[1,1,0]]
Output: -1
 */

public class ShortestPathBinaryMatrix {

    int[][] DIRECTIONS = {{-1, -1}, {-1, 0}, {-1, 1}, {0, -1}, {0, 1}, {1, -1}, {1, 0}, {1, 1}};

    public int shortestPathBinaryMatrix(int[][] grid) {

        if (grid[0][0] == 0) {
            return helper(grid);
        }
        return -1;
    }

    private int helper(int[][] grid) {

        Queue<Pair> queue = new LinkedList<>();
        Set<Pair> visited = new HashSet<>();
        Pair start = new Pair(0, 0);
        queue.add(start);
        visited.add(start);
        int level = 0;
        int rows = grid.length - 1;
        int cols = grid[0].length - 1;
        grid[0][0] = -1;

        Pair target = new Pair(rows, cols);

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {

                Pair current = queue.poll();
                if (current.row == target.row && current.col == target.col) {
                    return level;
                }
                for (Pair neighbour : getNeighbours(current, rows, cols, grid)) {

                    if (!visited.contains(neighbour)) {
                        queue.add(neighbour);
                        visited.add(neighbour);
                        grid[neighbour.row][neighbour.col] = -1;
                    }
                }
            }
            level++;
        }
        return -1;
    }

    private List<Pair> getNeighbours(Pair node, int m, int n, int[][] grid) {

        List<Pair> result = new ArrayList<>();

        for (int[] dir : DIRECTIONS) {
            int x = dir[0] + node.row;
            int y = dir[1] + node.col;
            Pair temp = new Pair(x, y);

            if (x > -1 && y > -1 && x <= m && y <= n && grid[x][y] == 0) {
                result.add(temp);
            }
        }

        return result;
    }

    public static void main(String[] args) {

        ShortestPathBinaryMatrix shortestPathBinaryMatrix = new ShortestPathBinaryMatrix();

        int[][] matrix = {{0, 1}, {1, 0}};
        System.out.println(shortestPathBinaryMatrix.shortestPathBinaryMatrix(matrix));
    }
}
