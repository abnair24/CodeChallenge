package com.abn.dsalgos.algo.dp;

import java.util.HashMap;
import java.util.Map;

public class KnapSack {

    public int knapSackRecursion(int[] values, int[] weights, int capacity) {

        return knapSackRecursionHelper(values, weights, capacity, 0);
    }

    private int knapSackRecursionHelper(int[] values, int[] weights, int capacity, int currentIndex) {

        //base case
        if (capacity <= 0 || currentIndex >= values.length) {
            return 0;
        }

        int p1 = 0;
        if (weights[currentIndex] <= capacity) {
            p1 = values[currentIndex] + knapSackRecursionHelper(values, weights,
                    capacity - weights[currentIndex], currentIndex + 1);
        }

        int p2 = knapSackRecursionHelper(values, weights, capacity, currentIndex + 1);

        return Math.max(p1, p2);
    }

    public int knapSackMemoization(int[] values, int[] weights, int capacity) {
        Map<String, Integer> cache = new HashMap<>();

        return knapSackMemoizationHelper(cache, values, weights, capacity, 0);
    }

    private int knapSackMemoizationHelper(Map<String, Integer> cache, int[] values, int[] weights, int capacity, int currentIndex) {

        if (capacity <= 0 || currentIndex >= values.length) {
            return 0;
        }

        String key = currentIndex + "-" + capacity;
        if (cache.containsKey(key)) {
            return cache.get(key);
        }

        int p1 = 0;
        if (weights[currentIndex] <= capacity) {
            p1 = values[currentIndex] + knapSackMemoizationHelper(cache, values, weights, capacity - weights[currentIndex], currentIndex + 1);
        }

        int p2 = knapSackMemoizationHelper(cache, values, weights, capacity, currentIndex + 1);

        cache.put(key, Math.max(p1, p2));

        return cache.get(key);
    }
}
