package com.abn.dsalgos.algo.dp;

import java.util.HashMap;
import java.util.Map;

/*
A child is running up a staircase with n steps and can hop either 1 step, 2 steps, or 3 steps at a time.
Implement a function to count the number of possible ways that the child can run up the stairs.
*/
public class StaircaseProblem {

    Map<Integer, Integer> cache = new HashMap<>();

    public int uniqueWays(int n) {

        int count;
        if (n == 0) {
            return 1;
        }
        if (n < 0) {
            return 0;
        }

        if (cache.containsKey(n)) {
            return cache.get(n);
        } else {
            count = uniqueWays(n - 1) + uniqueWays(n - 2) + uniqueWays(n - 3);
            cache.put(n, count);
        }
        return cache.get(n);
    }
}
