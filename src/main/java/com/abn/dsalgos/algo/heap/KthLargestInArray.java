package com.abn.dsalgos.algo.heap;

import java.util.List;
import java.util.PriorityQueue;

public class KthLargestInArray {

    public int findLargest(List<Integer> array, int k) {

        PriorityQueue<Integer> minHeap = new PriorityQueue<>((n1, n2) -> n1 - n2);

        for (int i = 0; i < k; i++) {
            minHeap.add(array.get(i));
        }

        for (int i = k; i < array.size(); i++) {
            if (array.get(i) > minHeap.peek()) {
                minHeap.poll();
                minHeap.add(array.get(i));
            }
        }

        return minHeap.peek();
    }

}
