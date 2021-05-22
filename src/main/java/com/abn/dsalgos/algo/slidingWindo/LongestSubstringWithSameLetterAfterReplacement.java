package com.abn.dsalgos.algo.slidingWindo;

import java.util.HashMap;
import java.util.Map;

public class LongestSubstringWithSameLetterAfterReplacement {

    public int findLength(String str, int k) {

        if(str.length() == 0 || str == null) {
            return 0;
        }

        int start = 0;
        int maxLen = Integer.MIN_VALUE;
        int len;
        int windowSize;
        int maxRepeatedCount = 0;

        Map<Character, Integer> hm =new HashMap<>();

        for(int i = 0; i< str.length(); i++) {
            hm.put(str.charAt(i), hm.getOrDefault(str.charAt(i), 0)+1);
            maxRepeatedCount = Math.max(hm.get(str.charAt(i)), maxRepeatedCount);
            windowSize = i - start + 1;

            if(windowSize - maxRepeatedCount > k) {
                hm.put(str.charAt(start), hm.get(str.charAt(start))- 1);
                start++;
            }
            len = i - start + 1;
            maxLen = Math.max(maxLen,len);

        }
        return maxLen;
    }
}
