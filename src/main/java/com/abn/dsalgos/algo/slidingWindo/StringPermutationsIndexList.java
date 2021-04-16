package com.abn.dsalgos.algo.slidingWindo;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
Given a string s and a non-empty string p, find all the start indices of p's anagrams in s.

Strings consists of lowercase English letters only and the length of both strings s and p
will not be larger than 20,100.

The order of output does not matter.

s: "cbaebabacd" p: "abc"
Output:
[0, 6]

Input:
s: "abab" p: "ab"

Output:
[0, 1, 2]

 */
public class StringPermutationsIndexList {

    public List<Integer> findStringAnagrams(String str, String pattern) {

        List<Integer> resultIndices = new ArrayList<Integer>();
        Map<Character, Integer> patternMap = new HashMap<>();

        int start = 0;
        int count = 0;
        int len = 0;
        int patternLen = pattern.length();

        for(int i = 0; i < patternLen; i++) {
            char ch = pattern.charAt(i);
            patternMap.put(ch, patternMap.getOrDefault(ch, 0) + 1);
        }

        for(int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if (patternMap.containsKey(ch)) {
                patternMap.put(ch, patternMap.get(ch) - 1);

                if (patternMap.get(ch) == 0) {
                    count++;
                }
            }

            if (count == patternMap.size()) {
                resultIndices.add(start);
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
        return resultIndices;
    }
}
