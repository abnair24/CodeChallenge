package com.abn.dsalgos.algo.dp;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/*
Given a string s and a dictionary of strings wordDict, return true if s can be segmented into a
 space-separated sequence of one or more dictionary words.

Note that the same word in the dictionary may be reused multiple times in the segmentation.

Input: s = "leetcode", wordDict = ["leet","code"]
Output: true

Input: s = "applepenapple", wordDict = ["apple","pen"]
Output: true

Input: s = "catsandog", wordDict = ["cats","dog","sand","and","cat"]
Output: false
 */

public class WordBreak {

    public boolean wordBreak(String s, List<String> wordDict) {
        return wordBreakRecur(s, new HashSet<>(wordDict), 0);
    }

    private boolean wordBreakRecur(String s, Set<String> wordDict, int start) {
        if (start == s.length()) {
            return true;
        }
        for (int end = start + 1; end <= s.length(); end++) {
            if (wordDict.contains(s.substring(start, end)) && wordBreakRecur(s, wordDict, end)) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        WordBreak wordBreak = new WordBreak();
        List<String> ll = new ArrayList<>();
        ll.add("cats");
        ll.add("dog");
        ll.add("sand");
        ll.add("and");
        ll.add("cat");
        wordBreak.wordBreak("catsandog", ll);

        String input = "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaab";
        List<String> ll1 = new ArrayList<>();
        ll1.add("a");
        ll1.add("aa");
        ll1.add("aaa");
        ll1.add("aaaa");
        ll1.add("aaaaa");
        ll1.add("aaaaaa");
        ll1.add("aaaaaaa");
        ll1.add("aaaaaaaa");
        ll1.add("aaaaaaaaa");
        ll1.add("aaaaaaaaaa");
        wordBreak.wordBreak(input, ll1);
    }
}
