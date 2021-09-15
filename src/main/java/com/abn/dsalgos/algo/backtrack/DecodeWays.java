package com.abn.dsalgos.algo.backtrack;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/*
A message containing letters from A-Z can be encoded into numbers using the following mapping:

'A' -> "1"
'B' -> "2"
...
'Z' -> "26"
To decode an encoded message, all the digits must be grouped then mapped back into letters using the reverse of the mapping above (there may be multiple ways). For example, "11106" can be mapped into:

"AAJF" with the grouping (1 1 10 6)
"KJF" with the grouping (11 10 6)
Note that the grouping (1 11 06) is invalid because "06" cannot be mapped into 'F' since "6" is different from "06".

Given a string s containing only digits, return the number of ways to decode it.

Input: s = "12"
Output: 2  "AB" or "L" .

Input: s = "226"
Output: 3
 */

//TODO : Implement memoization for backtracking to handle timeout scenarios
public class DecodeWays {

    List<String> LETTERS = IntStream.range(1, 27).mapToObj(Integer::toString).collect(Collectors.toList());
    LinkedList<String> result = new LinkedList<>();

    char[] alphabetArray = "ABCDEFGHIJKLMNOPQRSTUVWXYZ".toCharArray();
    Map<String, String> charMap = new HashMap<>();



    public int combination(String digits) {

        String[] cache = new String[LETTERS.size()];

        LinkedList<String> track = new LinkedList<>();

        for(int i = 0; i < alphabetArray.length; i ++) {
            charMap.put(String.valueOf(i + 1), String.valueOf(alphabetArray[i]));
        }

        backtrack(digits, track, 0, cache);

        return result.size();
    }

    private void backtrack(String digits, LinkedList<String> track, int index, String[] cache) {

        if(digits.length() == index) {
            result.add(getDecodedString(track));
            return;
        }

        if(cache[index] != null) {
            track.add(cache[index]);
            return;
        }

        String current = digits.substring(index);
        for(String alphabet : charMap.keySet()) {
            if(current.startsWith(alphabet)) {
                track.add(alphabet);
                backtrack(digits, track, index + alphabet.length(), cache);
                track.removeLast();
                //cache[index] = alphabet;
            }
        }
    }

    private String getDecodedString(LinkedList<String> track) {

        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < track.size(); i++) {
            sb.append(track.get(i));
        }
        return sb.toString();
    }

    public static void main(String[] args) {

        DecodeWays decode = new DecodeWays();
        decode.combination("123");
    }
}
