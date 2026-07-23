package com.abn.dsalgos.algo.heap;

import java.util.List;
import java.util.PriorityQueue;

public class KthLargestInArray {

    public int findLargest(List<Integer> array, int k) {

        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        for(int num: array) {
            minHeap.add(num);
            if(minHeap.size() > k) {
                minHeap.poll();
            }
        }

        return minHeap.peek();
    }
}
