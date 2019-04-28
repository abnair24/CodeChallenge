package com.abn.dsalgos.challenges.heap;

import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class KthSmallestInArray {

    public int findKthSmallest(List<Integer> array, int k) {

        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
        pq.addAll(array.subList(0,k));

        for(int i = k; i<array.size();i++) {
            if(array.get(i) < pq.peek()) {
                pq.poll();
                pq.add(array.get(i));
            }
        }

        return pq.peek();
    }
}
