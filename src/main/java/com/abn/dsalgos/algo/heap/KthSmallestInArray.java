package com.abn.dsalgos.algo.heap;

import java.util.List;
import java.util.PriorityQueue;

public class KthSmallestInArray {

    public int findKthSmallest(List<Integer> array, int k) {

        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((n1, n2) -> Integer.compare(n2, n1));

        for(int num: array) {
            maxHeap.add(num);
            if(maxHeap.size() > k) {
                maxHeap.poll();
            }
        }

        return maxHeap.peek();
    }
}
