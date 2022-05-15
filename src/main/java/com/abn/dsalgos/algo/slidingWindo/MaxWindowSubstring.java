package com.abn.dsalgos.algo.slidingWindo;

import java.util.HashMap;
import java.util.Map;

public class MaxWindowSubstring {

    public String maxWindow(String str, String pattern) {

        int start = 0;
        int maxSize = Integer.MIN_VALUE;
        int size = 0;
        int count = 0;
        int maxStartIndex = 0;

        if(str.length() < pattern.length()) {
            return str;
        }
        Map<Character, Integer> patternMap = new HashMap<>();

        for(int i = 0; i < pattern.length(); i ++) {

            patternMap.put(pattern.charAt(i), patternMap.getOrDefault(pattern.charAt(i), 0) + 1);
        }

        for(int i =0 ; i < str.length(); i ++) {
            char ch = str.charAt(i);
            if(patternMap.containsKey(ch)) {
                patternMap.put(ch, patternMap.get(ch) - 1);

                if(patternMap.get(ch) >= 0) {
                    count ++;
                }
            }

            while(count == pattern.length()) {
                size = i - start + 1;
                if(maxSize < size) {
                    maxSize = Math.max(maxSize, size);
                    maxStartIndex = start;
                }

                char startChar = str.charAt(start);
                if(patternMap.containsKey(startChar)) {

                    if(patternMap.get(startChar) == 0) {
                        count --;
                    }
                    patternMap.put(startChar, patternMap.get(startChar) + 1);
                }
                start ++;
            }
        }
        return str.substring(maxStartIndex, maxStartIndex + maxSize);
    }
 }
