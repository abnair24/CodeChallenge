package com.abn.scalar.dsa.day61;

import java.util.HashMap;
import java.util.Map;

public class MinimumWindowSubstring {

    public String minWindow(String A, String B) {

        Map<Character, Integer> targetMap = new HashMap<>();
        Map<Character, Integer> windowMap = new HashMap<>();

        for (char c : B.toCharArray()) {
            targetMap.put(c, targetMap.getOrDefault(c, 0) + 1);
        }

        int left = 0;
        int right = 0;
        int formed = 0;
        int requiredSize = targetMap.size();
        int minCount = Integer.MAX_VALUE;
        int minStartIndex = 0;

        //ADOBECODEBANC
        while (right < A.length()) {
            char charA = A.charAt(right);
            if (targetMap.containsKey(charA)) {
                windowMap.put(charA, windowMap.getOrDefault(charA, 0) + 1);

                if (windowMap.get(charA).intValue() == targetMap.get(charA).intValue()) {
                    formed++;
                }
            }

            while (formed == requiredSize && left <= right) {

                if (minCount > (right - left + 1)) {
                    minCount = right - left + 1;
                    minStartIndex = left;
                }

                char startChar = A.charAt(left);
                if (targetMap.containsKey(startChar)) {
                    windowMap.put(startChar, windowMap.get(startChar) - 1);

                    if (windowMap.get(startChar) < targetMap.get(startChar)) {
                        formed--;
                    }
                }
                left++;
            }
            right++;
        }
        return minCount == Integer.MAX_VALUE ? "-1" : A.substring(minStartIndex, minStartIndex + minCount);
    }

    public static void main(String[] args) {

        MinimumWindowSubstring minimumWindowSubstring = new MinimumWindowSubstring();
        System.out.println(minimumWindowSubstring.minWindow("ADOBECODEBANC", "ABC"));
        System.out.println(minimumWindowSubstring.minWindow("a", "a"));
        System.out.println(minimumWindowSubstring.minWindow("a", "aa"));
    }
}
