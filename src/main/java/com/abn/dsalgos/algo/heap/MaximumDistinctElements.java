package com.abn.dsalgos.algo.heap;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class MaximumDistinctElements {

    public int distinctElements(int[] array, int k) {

        Map<Integer, Integer> map = new HashMap<>();
        int distinct = 0;
        for(int i = 0; i < array.length; i ++) {
            map.put(array[i], map.getOrDefault(array[i], 0) + 1);
        }

        PriorityQueue<Map.Entry<Integer, Integer>> minHeap = new PriorityQueue<>((n1, n2) -> n1.getValue() - n2.getValue());

        for(Map.Entry<Integer, Integer> entry : map.entrySet()) {

            if(entry.getValue() > 1) {
                minHeap.add(entry);
            } else {
                distinct ++;
            }
        }

        for(int i = 0; i < k; i ++) {
            Map.Entry<Integer, Integer> entry = minHeap.poll();
            k-= (entry.getValue() - 1);

            if(k >= 0) {
                distinct ++;
            }
        }
        return distinct;
    }
}
