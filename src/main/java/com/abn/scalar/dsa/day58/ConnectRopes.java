package com.abn.scalar.dsa.day58;

import java.util.PriorityQueue;

/*
You are given an array A of integers that represent the lengths of ropes.
You need to connect these ropes into one rope. The cost of joining two ropes equals the sum of their lengths.

Find and return the minimum cost to connect these ropes into one rope.
A = [1, 2, 3, 4, 5]
o/p: 33

A = [5, 17, 100, 11]
182
 */
public class ConnectRopes {

    public int solve(int[] A) {

        int len = A.length;

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int i = 0; i < len; i++) {
            pq.offer(A[i]);
        }

        int total = 0;

        while(pq.size() > 1) {
            int firstMin = pq.poll();
            int secondMin = pq.poll();

            total = total + firstMin + secondMin;
            pq.offer(firstMin + secondMin);
        }
        return total;
    }

    public static void main(String[] args) {
        ConnectRopes connectRopes = new ConnectRopes();
        System.out.println(connectRopes.solve(new int[] {5, 17, 100, 11}));
    }
}
