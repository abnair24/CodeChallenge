package com.abn.design.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/*
Calculate P95/P90/P50 latency from a list
P95 = 95% of requests completed within this time.
If you have 100 requests sorted by latency — P95 is the value at index 95. The slowest 5% are above it.

Approach
1. Sort the list
2. Calculate index = (percentile / 100) × size
3. Return value at that index

Index formula
P50 → index = (50/100) × n = n/2
P90 → index = (90/100) × n = 0.9 × n
P95 → index = (95/100) × n = 0.95 × n

Always use Math.ceil or cast carefully — index must be valid
 */
public class LatencyCalculator {

    public double percentile(List<Integer> latencies, int percentile) {
        if (latencies == null || latencies.isEmpty()) return 0;

        List<Integer> sorted = new ArrayList<>(latencies);
        Collections.sort(sorted);

        System.out.println(sorted);
        // index calculation
        int index = (int) Math.ceil((percentile / 100.0) * sorted.size()) - 1;
        index = Math.max(0, Math.min(index, sorted.size() - 1)); // bounds check

        return sorted.get(index);
    }

    public static void main(String[] args) {
        List<Integer> latencies = Arrays.asList(
                120, 450, 800, 95, 310, 670, 230, 540, 190, 720, 400, 260, 150, 600, 330, 480, 210, 550, 290, 380);

        LatencyCalculator latencyCalculator = new LatencyCalculator();
        System.out.println("P50: " + latencyCalculator.percentile(latencies, 50));
        System.out.println("P90: " + latencyCalculator.percentile(latencies, 90));
        System.out.println("P95: " + latencyCalculator.percentile(latencies, 95));
        System.out.println("P99: " + latencyCalculator.percentile(latencies, 99));
    }
}
