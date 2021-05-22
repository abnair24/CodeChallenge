package com.abn.dsalgos.algo.slidingWindo;

/*
Given a string, find the length of the longest substring in it with no more than K distinct characters.

Input: String="araaci", K=2
Output: 4
Explanation: The longest substring with no more than '2' distinct characters is "araa".

Input: String="araaci", K=1
Output: 2
Explanation: The longest substring with no more than '1' distinct characters is "aa".

Input: String="cbbebi", K=3
Output: 5
Explanation: The longest substrings with no more than '3' distinct characters are "cbbeb" & "bbebi".

 */

import java.util.HashMap;

public class LongestSubstringWithKDistinctChar {

    public int longestSubstring(String str, int k) {
        int start = 0;
        int maxSize = 0;
        int size;

        int len = str.length();
        HashMap<Character, Integer> hm = new HashMap<>();
        for (int i =0; i< len; i++) {
            char ch = str.charAt(i);
            hm.put(ch, hm.getOrDefault(ch, 0) + 1);

            while(hm.size() > k) {
                size = i - start;
                maxSize = Math.max(size, maxSize);
                hm.put(str.charAt(start), hm.get(str.charAt(start))-1);
                if(hm.get(str.charAt(start))==0) {
                    hm.remove(str.charAt(start));
                }
                start++;
            }
        }
        return maxSize;
    }
}
