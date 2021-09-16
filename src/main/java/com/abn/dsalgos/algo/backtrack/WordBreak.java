package com.abn.dsalgos.algo.backtrack;

import java.util.ArrayList;
import java.util.List;

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

    boolean status = false;

    public boolean combinations(String s, List<String> words) {

        Boolean[] cache = new Boolean[s.length() - 1];
        status = backtrack(s, words, 0, cache);
        return status;
    }

    private boolean backtrack(String s, List<String> words, int index, Boolean[] cache) {

        if (index == s.length()) {
            return true;
        }

        if (cache[index] != null) {
            return cache[index];
        }

        String currentWord = s.substring(index);

        for (String word : words) {
            if (currentWord.startsWith(word)) {
                if (backtrack(s, words, index + word.length(), cache)) {
                    cache[index] = true;
                    return cache[index];
                }
            }
        }
        cache[index] = false;
        return cache[index];
    }

    public static void main(String[] args) {

        WordBreak wordBreak = new WordBreak();
        List<String> ll = new ArrayList<>();
        ll.add("cats");
        ll.add("dog");
        ll.add("sand");
        ll.add("and");
        ll.add("cat");
        wordBreak.combinations("catsandog", ll);

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
        wordBreak.combinations(input, ll1);
    }
}
