package com.abn.dsalgos.algo.BFS;

import java.util.LinkedList;
import java.util.Queue;

public class RottenOranges {

    int[][] DIRECTIONS = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    public int rotten(int[][] grid) {

        int rows = grid.length;
        int cols = grid[0].length;
        int freshOrangeCount = 0;
        int minutes = -1;

        Queue<int[]> queue = new LinkedList<>();

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == 2) {
                    queue.add(new int[] {i, j});
                } else if (grid[i][j] == 1) {
                    freshOrangeCount++;
                }
            }
        }

//        queue.add(new int[] {-1, -1});

        while (!queue.isEmpty()) {
            int size = queue.size();


            while(size > 0) {

                int[] visitNode = queue.remove();
//
//            if (visitNode[0] == -1) {
//                minutes++;
//                if (!queue.isEmpty()) {
//                    queue.add(new int[] {-1, -1});
//                }
//
//            } else {
                for (int[] dir : DIRECTIONS) {
                    int x = dir[0] + visitNode[0];
                    int y = dir[1] + visitNode[1];

                    if (x > -1 && y > -1 && x < rows && y < cols && grid[x][y] == 1) {
                        freshOrangeCount--;
                        grid[x][y] = 2;
                        queue.add(new int[] {x, y});
                    }
                }
                size --;
            }
            minutes ++;
        }

        if (freshOrangeCount > 0) {
            return -1;
        } else {
            return minutes;
        }
    }
}
