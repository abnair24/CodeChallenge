package com.abn.dsalgos.algo.dp;

import java.util.HashMap;
import java.util.Map;

/*
Given a message to decode. Letters are encoded to digits by their position in the alphabet:
A -> 1
B -> 2
C -> 3
...
Y -> 25
Z -> 26

Input: "18"

Output: 2
Explanation: "18" can be decoded as "AH" or "R"
 */

public class DecodeStringWays {

    public int decode(String str) {
        int len = str.length();
        Map<Integer, Integer> cache = new HashMap<>();

        return decodeHelper(str, 0, cache);
    }

    private int decodeHelper(String s, int index, Map<Integer, Integer> cache) {

        if (cache.containsKey(index)) {
            return cache.get(index);
        }

        if (index == s.length()) {
            return 1;
        }

        if (s.charAt(index) == '0') {
            return 0;
        }

        if (index == s.length() - 1) {
            return 1;
        }

        int count = decodeHelper(s, index + 1, cache);

        if (Integer.parseInt(s.substring(index, index + 2)) <= 26) {
            count += decodeHelper(s, index + 2, cache);
        }

        cache.put(index, count);
        return cache.get(index);
    }

    public static void main(String[] args) {
        DecodeStringWays decodeStringWays = new DecodeStringWays();
        System.out.println(decodeStringWays.decode("1234"));
    }
}
