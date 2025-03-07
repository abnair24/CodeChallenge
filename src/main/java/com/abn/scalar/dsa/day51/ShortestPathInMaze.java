package com.abn.scalar.dsa.day51;

import java.util.LinkedList;
import java.util.Queue;

/*
Given an MxN matrix where each element can either be 0 or 1. We need to find the length of shortest path between a given source cell to a destination cell.

A cell with value 0 denotes that it's a hurdle. The path can only be created out of the cells with values 1.
If NO path exists then print -1.

The matrix A is given as input of size M x N.
The coordinates of Source cell are given by B, C.
The coordinates of Destination cell are given by D, E.

 */
public class ShortestPathInMaze {

    private static final int[][] DIRECTIONS = {
            {0, 1},
            {1, 0},
            {0, -1},
            {-1, 0}
    };

    public int findShortestPath(int[][] A, int B, int C, int D, int E) {
        int rows = A.length;
        int cols = A[0].length;

        if(A[B][C] == 0 || A[D][E] == 0) {
            return -1;
        }

        if(B == D && C == E) {
            return 0;
        }

        Queue<int[]> queue = new LinkedList<>();
        boolean[][] visited = new boolean[rows][cols];
        int[][] distance = new int[rows][cols];

        queue.offer(new int[]{B, C});
        visited[B][C] = true;

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int x = current[0];
            int y = current[1];

            for(int[] dir : DIRECTIONS) {

                int x1 = x + dir[0];
                int y1 = y + dir[1];

                if(isValid(A, x1, y1) && !visited[x1][y1]) {

                    visited[x1][y1] = true;
                    distance[x1][y1] = distance[x][y] + 1;
                    queue.offer(new int[]{x1, y1});

                    if(x1 == D && y1 == E) {
                        return distance[x1][y1];
                    }
                }
            }
        }
        return -1;
    }

    private boolean isValid(int[][] A, int x, int y) {
        return x >= 0 && x < A.length && y >= 0 && y < A[0].length && A[x][y] == 1;
    }

    public static void main(String[] args) {

        ShortestPathInMaze shortestPathInMaze = new ShortestPathInMaze();
        int[][] A = {
                {1, 0, 1, 1, 1},
                {1, 0, 1, 0, 1},
                {1, 1, 1, 0, 1},
                {0, 0, 0, 0, 1},
                {1, 1, 1, 1, 1}
        };

        System.out.println(shortestPathInMaze.findShortestPath(A, 0, 0, 4, 4));
    }
}

