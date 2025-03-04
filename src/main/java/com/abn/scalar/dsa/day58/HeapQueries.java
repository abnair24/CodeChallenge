package com.abn.scalar.dsa.day58;

import java.util.ArrayList;
import java.util.PriorityQueue;

/*
You have an empty min heap. You are given an array A consisting of N queries.
Let P denote A[i][0] and Q denote A[i][1]. There are two types of queries:

P = 1, Q = -1 : Pop the minimum element from the heap.
P = 2, 1 <= Q <= 109 : Insert Q into the heap.

Return an integer array containing the answer for all the extract min operation.
If the size of heap is 0, then extract min should return -1.

A = [[1, -1], [2, 2], [2, 1], [1, -1]]
[-1, 1]
 */
public class HeapQueries {

    public int[] solve(int[][] A) {

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int queries = A.length;
        ArrayList<Integer> list = new ArrayList<>();
        for(int i = 0; i < queries; i ++) {

            if(A[i][0] == 1) {
                if(pq.size() != 0) {
                    list.add(pq.poll());
                } else {
                    list.add(-1);
                }
            } else if(A[i][0] == 2) {
                pq.add(A[i][1]);
            }
        }
        return list.stream().mapToInt(i -> i).toArray();
    }
}
