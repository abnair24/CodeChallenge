package com.abn.dsalgos.algo.slidingWindo;

import java.util.HashMap;
import java.util.Map;

public class MaxOccurrencesOfSubstring {

    public static int countOfMax(String str, int maxLet, int minSize, int maxSize) {

        Map<Character, Integer> charMap = new HashMap<>();
        Map<String, Integer> strMap = new HashMap<>();
        int maxOccurrence = 0;
        if(str.isEmpty()) {
            return 0;
        }

        if(str.length() == 1) {
            return 0;
        }
        int startPtr = 0;
        int i = 0;
        int len = str.length();
//aabaabaababbbbabb
        while(i < len) {
            char ch = str.charAt(i);
            charMap.put(ch, charMap.getOrDefault(ch, 0) + 1);

            if( i >= minSize) {
                char chToRemove = str.charAt(startPtr);
                charMap.put(chToRemove, charMap.get(chToRemove)-1);
                if(charMap.get(chToRemove) == 0) {
                    charMap.remove(chToRemove);
                }
                startPtr ++;
            }

            if(i >= minSize - 1) {
                if(charMap.size() <= maxLet) {
                    String subStr = str.substring(startPtr, i + 1);
                    strMap.put(subStr, strMap.getOrDefault(subStr, 0) + 1);
                    maxOccurrence = Math.max(maxOccurrence, strMap.get(subStr));

                }
            }
            i++;
        }

        return maxOccurrence;
    }

    public static void main(String[] args) {

        String str = "aabaabaababbbbabb";
        int maxLet = 2;
        int minSize = 3;
        int maxSize = 4;

        System.out.println(countOfMax(str, maxLet, minSize, maxSize));
    }
}
