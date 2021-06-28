package com.abn.dsalgos.algo.dp;

public class MinimumStepsToOne {

    public int calcSteps(int num) {
        int[] cache = new int[num + 1];

        return minSteps(cache, num);
    }

    private int minSteps(int[] cache, int n) {

        if (n == 1) {
            return 0;
        }

        if (cache[n] != -1) {
            return cache[n];
        }

        int r = 1 + minSteps(cache, n - 1);

        if (n % 2 == 0) {
            r = Math.min(r, 1 + minSteps(cache, n / 2));
        }

        if (n % 3 == 0) {
            r = Math.min(r, 1 + minSteps(cache, n / 3));
        }

        cache[n] = r;

        return r;
    }
}
