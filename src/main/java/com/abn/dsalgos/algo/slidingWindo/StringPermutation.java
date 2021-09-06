package com.abn.dsalgos.algo.slidingWindo;

import java.util.HashMap;

/*
Given a string and a pattern, find out if the string contains any permutation of the pattern.
 */

public class StringPermutation {

    public boolean isStringPermutation(String str, String pattern) {

        HashMap<Character, Integer> patternMap = new HashMap<>();

        int start = 0;
        int count = 0;
        int len;
        int patternLen = pattern.length();

        for (int i = 0; i < patternLen; i++) {
            char ch = pattern.charAt(i);
            patternMap.put(ch, patternMap.getOrDefault(ch, 0) + 1);
        }

        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if (patternMap.containsKey(ch)) {
                patternMap.put(ch, patternMap.get(ch) - 1);

                if (patternMap.get(ch) == 0) {
                    count++;
                }
            }

            if (count == patternMap.size()) {
                return true;
            }

            len = i - start + 1;
            if (len >= pattern.length()) {
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
        return false;
    }
}
