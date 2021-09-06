package com.abn.dsalgos.challenges.string;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/*
Given an array of strings, group anagrams together.

Input: ["eat", "tea", "tan", "ate", "nat", "bat"],
Output:
[
  ["ate","eat","tea"],
  ["nat","tan"],
  ["bat"]
]
 */
public class AnagramGrouping {

    public List<List<String>> group(String[] anagrams) {

        Map<String, List<String>> result = new LinkedHashMap<>();
        int[] count = new int[26];

        for (String str : anagrams) {

            Arrays.fill(count, 0);

            for (char c : str.toCharArray()) {
                count[c - 'a']++;
            }

            StringBuilder sb = new StringBuilder();

            for (int i = 0; i < 26; i++) {
                sb.append('#');
                sb.append(count[i]);
            }

            if (!result.containsKey(sb.toString())) {
                result.put(sb.toString(), new ArrayList<>());
            }
            result.get(sb.toString()).add(str);
        }

        return new ArrayList(result.values());
    }
}
