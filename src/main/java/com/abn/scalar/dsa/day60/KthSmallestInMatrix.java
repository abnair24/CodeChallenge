package com.abn.scalar.dsa.day60;

import java.util.PriorityQueue;

/*
Given a sorted matrix of integers A of size N x M and an integer B.

Each of the rows and columns of matrix A is sorted in ascending order, find the Bth smallest element in the matrix.

NOTE: Return The Bth smallest element in the sorted order, not the Bth distinct element.

A = [ [9, 11, 15],
       [10, 15, 17] ]
 B = 6

  A = [  [5, 9, 11],
        [9, 11, 13],
        [10, 12, 15],
        [13, 14, 16],
        [16, 20, 21] ]
 B = 12
 */
public class KthSmallestInMatrix {

    public int solve(int[][] A, int B) {

        int k = 0;
        PriorityQueue<Integer> max = new PriorityQueue<>((n1, n2) -> n2 - n1);
        for(int i = 0; i < A.length; i++) {
            for(int j = 0; j < A[0].length; j++){
                if(k < B) {
                    max.offer(A[i][j]);
                    k++;
                } else {
                    if(A[i][j] < max.peek()) {
                        max.poll();
                        max.offer(A[i][j]);
                    }
                }
            }
        }

        return max.peek();
    }

    public static void main(String[] args) {

        KthSmallestInMatrix kthSmallestInMatrix = new KthSmallestInMatrix();
        System.out.println(kthSmallestInMatrix.solve(new int[][]
                {{5, 9, 11},
                {9, 11, 13},
                {10, 12, 15},
                {13, 14, 16},
                {16, 20, 21}}, 12));
    }
}
