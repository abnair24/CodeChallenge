package com.abn.dsalgos.algo.heap;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/*
Given a string, sort it based on the decreasing frequency of its characters.
Input: "Programming"
Output: "rrggmmPiano"
 */
public class FrequencySort {

    public String freqSort(String s) {

        Map<Character, Integer> map = new HashMap<>();

        for(int i = 0; i < s.length(); i++) {
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);
        }

        PriorityQueue<Map.Entry<Character, Integer>> maxHeap = new PriorityQueue<>((n1, n2) -> n2.getValue() - n1.getValue());

        maxHeap.addAll(map.entrySet());

        StringBuilder sb = new StringBuilder();

        while(!maxHeap.isEmpty()) {
            Map.Entry<Character, Integer> entry = maxHeap.poll();
            for(int i = 0; i < entry.getValue(); i++) {
                sb.append(entry.getKey());
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        FrequencySort frequencySort = new FrequencySort();
        System.out.println(frequencySort.freqSort("Programming"));
        System.out.println(frequencySort.freqSort("Mirror"));
    }
}
