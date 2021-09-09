package com.abn.dsalgos.glc;

import java.util.HashMap;
import java.util.Map;

/*
A subsequence of a string is a new string that is formed from the original string by deleting some
(can be none) of the characters without disturbing the relative positions of the remaining characters.
(i.e., "ace" is a subsequence of "abcde" while "aec" is not).

Given two strings source and target, return the minimum number of subsequences of source such that
their concatenation equals target. If the task is impossible, return -1.

Input: source = "abc", target = "abcbc"
Output: 2
Explanation: The target "abcbc" can be formed by "abc" and "bc", which are subsequences of source "abc".

Input: source = "xyz", target = "xzyxz"
Output: 3
Explanation: The target string can be constructed as follows "xz" + "y" + "xz".

 */
public class ShortestWay {

    public int shortestWay(String source, String target) {

        Map<Character, Integer> map = new HashMap<>();

        for(int i = 0; i< source.length(); i++) {
            map.put(source.charAt(i), map.getOrDefault(source.charAt(i), 0) + 1);
        }

        for(int i = 0; i < target.length(); i ++) {
            if(!map.containsKey(target.charAt(i))) {
                return -1;
            }
        }

        int j = 0;
        int i = 0;
        int count = 0;

        while( i < target.length()) {
            while( i < target.length() && j < source.length()) {
                if(source.charAt(j) == target.charAt(i)) {
                    i ++;
                }
                j ++;
            }
            j= 0;
            count ++;
        }

        return count;
    }

    public static void main(String[] args) {

        ShortestWay shortestWay = new ShortestWay();
        System.out.println(shortestWay.shortestWay("xyz", "xzyxz"));
    }
}
