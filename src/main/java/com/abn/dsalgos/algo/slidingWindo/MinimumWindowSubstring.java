package com.abn.dsalgos.algo.slidingWindo;

import java.util.HashMap;

/*
Given two strings s and t, return the minimum window in s which will
contain all the characters in t. If there is no such window in s that
covers all characters in t, return the empty string "".

Note that If there is such a window, it is guaranteed that there will
always be only one unique minimum window in s.

Input: s = "ADOBECODEBANC", t = "ABC"
Output: "BANC"

Input: s = "a", t = "a"
Output: "a"
 */
public class MinimumWindowSubstring {

    public String minimumWindow(String str, String pattern) {

        HashMap<Character, Integer> patternMap = new HashMap<>();

        int start = 0;
        int count = 0;
        int patternLen = pattern.length();
        int minCount =Integer.MAX_VALUE;
        int minStartIndex = 0;

        for(int i = 0; i < patternLen; i++) {
            char ch = pattern.charAt(i);
            patternMap.put(ch, patternMap.getOrDefault(ch, 0) + 1);
        }

        for(int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if (patternMap.containsKey(ch)) {
                patternMap.put(ch, patternMap.get(ch) - 1);

                if (patternMap.get(ch) >= 0) {
                    count++;
                }
            }

            while (count == patternLen) {
                if(minCount > i-start +1) {
                    minCount = i-start+1;
                    minStartIndex = start;
                }

                char startChar = str.charAt(start);
                if (patternMap.containsKey(startChar)) {
                    if (patternMap.get(startChar) == 0) {
                        count--;
                    }
                    patternMap.put(startChar, patternMap.get(startChar) + 1);
                }
                start++;
            }
        }
        return minCount> str.length()? "" : str.substring(minStartIndex, minStartIndex+minCount);
    }
}
