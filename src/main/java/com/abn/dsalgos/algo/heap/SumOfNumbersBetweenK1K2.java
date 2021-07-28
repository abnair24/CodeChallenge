package com.abn.dsalgos.algo.heap;

import java.util.PriorityQueue;

/*
Given an array, find the sum of all numbers between the K1’th and K2’th smallest elements of that array.
Input: [1, 3, 12, 5, 15, 11], and K1=3, K2=6
Output: 23

 */

public class SumOfNumbersBetweenK1K2 {

    public int sum(int[] array, int k1, int k2) {

        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((n1, n2) -> n1 - n2);
        int total = 0;

        for(int i = 0; i < array.length; i ++) {

            if (i < k2 - 1) {
                maxHeap.add(array[i]);
            } else if (array[i] < maxHeap.peek()) {
                maxHeap.poll();
                maxHeap.add(array[i]);
            }
        }

        for(int i = 0; i < k2 - k1 - 1; i++) {
            total += maxHeap.poll();
        }
        return total;
    }
}
