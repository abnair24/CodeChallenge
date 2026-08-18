package com.abn.dsalgos.algo.heap;

import java.util.PriorityQueue;

//Find kth smallest in a sorted matrix

public class KthSmallestInSortedMatrix {

    public int kthSmallestInASortedMatrix(int[][] grid, int k) {

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0]-b[0]);
        int len = grid.length;
        for(int i = 0; i < len; i++) {
            pq.offer(new int[]{grid[i][0], i, 0});
        }
        int result = 0;
        for(int i = 0; i < k; i++) {
            int[] current = pq.poll();
            result = current[0];
            int row = current[1];
            int col = current[2];

            if(col + 1 < len) {
                pq.offer(new int[]{grid[row][col+1], row, col+1});
            }
        }

        return result;
    }

    public static void main(String[] args) {

        KthSmallestInSortedMatrix problem5 = new KthSmallestInSortedMatrix();
        int[][] grid = {
                {1, 5, 9},
                {10, 11, 13},
                {12, 13, 15}
        };

        int k = 8;
        System.out.println(problem5.kthSmallestInASortedMatrix(grid, k));
    }
}