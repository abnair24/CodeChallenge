package com.abn.learn.dsa.day13;

import java.util.PriorityQueue;

/*
Find the Bth smallest element in given array A .
A = [2, 1, 4, 3, 2]
B = 3

o/p: 2
 */

public class KthSmallestInteger {

    public int kthsmallest(final int[] A, int B) {

        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((n1, n2)-> n2 - n1);

        for(int i = 0; i < B; i++) {
            maxHeap.add(A[i]);
        }

        for(int i = B; i < A.length; i++) {
            if(A[i] < maxHeap.peek()) {
                maxHeap.poll();
                maxHeap.add(A[i]);
            }
        }

        return maxHeap.peek();
    }
}
