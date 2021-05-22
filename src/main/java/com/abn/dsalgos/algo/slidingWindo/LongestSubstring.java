package com.abn.dsalgos.algo.slidingWindo;

/*
Print Longest substring without repeating characters
GEEKSFORGEEKSABCDH`
 */

import java.util.HashMap;
import java.util.Map;

public class LongestSubstring {
    public String longestSubstring(String str) {
        int start = 0;
        int maxLen = 0;
        int len;
        Map<Character, Integer> hm = new HashMap<>();
        int maxStartIndex = 0;

        for (int i = 0; i < str.length(); i++) {
            if (hm.containsKey(str.charAt(i))) {
                start = Math.max(start, hm.get(str.charAt(i)) + 1); //checking to see duplicated char lies within starting and current index
            }
            hm.put(str.charAt(i), i);
            len = i - start + 1;

            // if multiple substring has same maxLen, and return the firs substring enable below condition
//            if(maxLen <= len) {
//                maxStartIndex = start;
//            }

            maxLen = Math.max(maxLen, len);

            // if multiple substring has maxLen and return the last substring use if loop below
            if (maxLen <= len) {
                maxStartIndex = start;
            }

        }
        // return maxLen;  // if maxLen of substring only needs to be returned.
        return str.substring(maxStartIndex, maxStartIndex + maxLen);
    }
}
