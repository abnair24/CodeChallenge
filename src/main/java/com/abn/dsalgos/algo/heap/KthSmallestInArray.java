package com.abn.dsalgos.algo.heap;

import java.util.List;
import java.util.PriorityQueue;

public class KthSmallestInArray {

    public int findKthSmallest(List<Integer> array, int k) {

        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((n1, n2) -> n2 - n1);

        for (int i = 0; i < k; i++) {
            maxHeap.add(array.get(i));
        }

        for (int i = k; i < array.size(); i++) {
            if (array.get(i) < maxHeap.peek()) {
                maxHeap.poll();
                maxHeap.add(array.get(i));
            }
        }

        return maxHeap.peek();
    }
}
