package com.abn.dsalgos.algo.heap;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/*
Given an integer array nums and an integer k, return the k most frequent elements.
You may return the answer in any order.

Input: nums = [1,1,1,2,2,3], k = 2
Output: [1,2]

 the idea of the question is to find out the K most frequent items and not "Which element is K times repeated".
 So when the test case is [1,2] and k being 2, you need to return 2 most frequent elements which is apparently 1,2


 */
public class TopKFrequentElement {

    public int[] solve(int[] array, int k) {

        Map<Integer, Integer> frequencyMap = new HashMap<>();

        for(int n : array) {
            frequencyMap.put(n, frequencyMap.getOrDefault(n, 0) + 1);
        }

        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> frequencyMap.get(a) -frequencyMap.get(b));

        for(int n : frequencyMap.keySet()) {

            pq.offer(n);

            if(pq.size() > k) {
                pq.poll();
            }
        }

        int[] result = new int[k];
        for(int i = k-1; i >= 0; i--) {
            result[i] = pq.poll();
        }

        return result;
    }

    public static void main(String[] args) {

        TopKFrequentElement topKFrequentElement = new TopKFrequentElement();
        System.out.println(Arrays.toString(topKFrequentElement.solve(new int[] {1,1,1,2,2,3}, 2)));
    }
}
