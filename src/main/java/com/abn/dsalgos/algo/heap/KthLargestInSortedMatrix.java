package com.abn.dsalgos.algo.heap;

import java.util.PriorityQueue;

/*
Find the kth largest element in a sorted matrix. The matrix is sorted in ascending order both row-wise and column-wise.
 */
public class KthLargestInSortedMatrix {

    public int kthLargest(int[][] nums, int k) {

        int len = nums.length;
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> b[0] - a[0]);

        for(int i = 0; i < len; i++) {
            pq.offer(new int[]{nums[i][len-1], i, len-1});
        }

        int result = 0;

        for(int i = 0; i < k; i++) {
            int[] current =  pq.poll();
            result = current[0];
            int row = current[1];
            int col = current[2];

            if(col - 1 >= 0) {
                pq.offer(new int[]{nums[row][col-1], row, col-1});
            }
        }
        return result;
    }

    public static void main(String[] args) {

        KthLargestInSortedMatrix problem6 = new KthLargestInSortedMatrix();
        int[][] nums = {
                {1, 5, 9},
                {10, 11, 13},
                {12, 13, 15}
        };

        int k = 1;
        System.out.println(problem6.kthLargest(nums, k));
    }
}
