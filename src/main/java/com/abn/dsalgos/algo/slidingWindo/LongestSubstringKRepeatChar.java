package com.abn.dsalgos.algo.slidingWindo;

import java.util.HashMap;
import java.util.Map;

/*
Given a string s and an integer k, return the length of the longest substring of s such that the frequency of
each character in this substring is greater than or equal to k.

Input: s = "aaabb", k = 3
Output: 3
Explanation: The longest substring is "aaa", as 'a' is repeated 3 times.

Input: s = "ababbc", k = 2
Output: 5
Explanation: The longest substring is "ababb", as 'a' is repeated 2 times and 'b' is repeated 3 times

 */

//todo

public class LongestSubstringKRepeatChar {

    public int longestSubstring(String s, int k) {
        int n = s.length();

        if(n == 0 || n < k) {
            return 0;
        }

        if(k <= 1) {
            return n;
        }

        Map<Character, Integer> counts = new HashMap();

        for(char c: s.toCharArray()) {
            counts.put(c, counts.getOrDefault(c, 0) + 1);
        }

        int l = 0;

        while(l < n && counts.get(s.charAt(l)) >= k) {
            l++;
        }

        if(l >= n-1) {
            return l;
        }

        int ls1 = longestSubstring(s.substring(0, l), k);

        while(l < n && counts.get(s.charAt(l)) < k) {
            l++;
        }

        int ls2 = (l < n) ? longestSubstring(s.substring(l), k) : 0;

        return Math.max(ls1, ls2);
    }

    public static void main(String[] args) {

        LongestSubstringKRepeatChar longestSubstringKRepeatChar = new LongestSubstringKRepeatChar();
        longestSubstringKRepeatChar.longestSubstring("aaabbaacccdddd", 3);
        longestSubstringKRepeatChar.longestSubstring("ababbc", 2);
        longestSubstringKRepeatChar.longestSubstring("aaabcbbcc", 3);
    }
}
