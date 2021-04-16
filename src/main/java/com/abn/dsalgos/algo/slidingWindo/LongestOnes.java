package com.abn.dsalgos.algo.slidingWindo;

import java.util.HashMap;
import java.util.Map;

public class LongestOnes {

    public int getLongestOnes(int[] arr, int k) {
        int start = 0;
        int maxLen = Integer.MIN_VALUE;
        int len = 0;
        int windowSize = 0;
        int maxOnes = 0;

        Map<Integer, Integer> hm = new HashMap<>();

        for (int i = 0; i < arr.length; i++) {
            hm.put(arr[i], hm.getOrDefault(arr[i], 0) + 1);
            windowSize = i - start + 1;
            maxOnes = hm.getOrDefault(1, 0);

            if (windowSize - maxOnes > k) {
                hm.put(arr[start], hm.get(arr[start]) - 1);
                start++;
            }
            len = i - start + 1;
            maxLen = Math.max(maxLen, len);

        }
        return maxLen;
    }
}
