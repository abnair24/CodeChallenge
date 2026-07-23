package com.abn.dsalgos.leetcode30Day;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;

public class FrequencyStack {

    Map<Integer, Integer> freq = new HashMap<>();

    Map<Integer, Deque<Integer>> group = new HashMap<>();

    int maxFreq = 0;

    public void push(int val) {

        int f = freq.getOrDefault(val, 0) + 1;
        freq.put(val, f);

        maxFreq = Math.max(maxFreq, f);


        if (!group.containsKey(f)) {
            group.put(f, new ArrayDeque<>());
        }
        group.get(f).push(val);
    }

    public int pop() {
        int val = group.get(maxFreq).pop();

        int f = freq.get(val) - 1;
        freq.put(val, f);

        if (group.get(maxFreq).isEmpty()) {
            maxFreq--;
        }

        return val;
    }
}

