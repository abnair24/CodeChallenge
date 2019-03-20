package com.abn.dsalgos.challenges.heap;

import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class KthLargestInArray {

    public int findLargest(List<Integer> array, int k) {

        PriorityQueue<Integer> pq = new PriorityQueue<>(array.subList(0,k));


        for(int i=k;i<array.size();i++) {
            if(array.get(i) >pq.peek()) {
                pq.poll();
                pq.add(array.get(i));
            }
        }

        return pq.peek();
    }

}
