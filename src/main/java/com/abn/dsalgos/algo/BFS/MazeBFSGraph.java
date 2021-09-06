package com.abn.dsalgos.algo.BFS;

import java.util.LinkedList;
import java.util.Queue;

/*
Given the m x n maze, the ball's start position and the destination,
where start = [startrow, startcol] and destination = [destinationrow, destinationcol],
return true if the ball can stop at the destination, otherwise return false.

You may assume that the borders of the maze are all walls (see examples).
 */
public class MazeBFSGraph {

    int[][] DIRECTIONS = {{0, 1}, {0, -1}, {-1, 0}, {1, 0}};

    public boolean isPath(int[][] maze, int[] start, int[] destination) {

        boolean[][] isVisited = new boolean[maze.length][maze[0].length];

        Queue<int[]> queue = new LinkedList<>();
        queue.add(start);
        isVisited[start[0]][start[1]] = true;

        while (!queue.isEmpty()) {

            int[] temp = queue.remove();
            if (temp[0] == destination[0] && temp[1] == destination[1]) {
                return true;
            }

            for (int[] dir : DIRECTIONS) {
                int x = dir[0] + temp[0];
                int y = dir[1] + temp[1];

                while (x > -1 && y > -1 && x < maze.length && y < maze[0].length && maze[x][y] == 0) {
                    x += dir[0];
                    y += dir[1];
                }

                if (!isVisited[x - dir[0]][y - dir[1]]) {
                    queue.add(new int[] {x - dir[0], y - dir[1]});
                    isVisited[x - dir[0]][y - dir[1]] = true;
                }

            }
        }
        return false;
    }

    public static void main(String[] args) {

        MazeBFSGraph mazeBFSGraph = new MazeBFSGraph();
        int[][] input = {{0, 0, 1, 0, 0}, {0, 0, 0, 0, 0}, {0, 0, 0, 1, 0}, {1, 1, 0, 1, 1}, {0, 0, 0, 0, 0}};
        int[] start = {0, 4};
        int[] destination = {4, 4};

        mazeBFSGraph.isPath(input, start, destination);
    }
}
