package com.abn.dsalgos.algo.backtrack;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/*
Given a string s and a dictionary of strings wordDict, add spaces in s to construct a sentence where each
 word is a valid dictionary word. Return all such possible sentences in any order.

Note that the same word in the dictionary may be reused multiple times in the segmentation.

Input: s = "catsanddog", wordDict = ["cat","cats","and","sand","dog"]
Output: ["cats and dog","cat sand dog"]

Input: s = "pineapplepenapple", wordDict = ["apple","pen","applepen","pine","pineapple"]
Output: ["pine apple pen apple","pineapple pen apple","pine applepen apple"]

Input: s = "catsandog", wordDict = ["cats","dog","sand","and","cat"]
Output: []
 */
public class WordBreakII {

    List<String> result = new LinkedList<>();
    public List<String> wordBreak(String s, List<String> words) {

        LinkedList<String> track = new LinkedList<>();
        backtrack(s, track, words, 0);
        return result;
    }

    private void backtrack(String s, LinkedList<String> track, List<String> words, int index) {

        if(index == s.length()) {
            result.add(getSentence(track));
            return;
        }

        String currentWord = s.substring(index);
        for(String word : words) {
            if(currentWord.contains(word)) {

                track.add(word);
                backtrack(s, track, words, index + word.length());
                track.removeLast();
            }
        }
    }

    private String getSentence(List<String> track) {

        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < track.size(); i++) {
            sb.append(track.get(i) + " ");
        }
        return sb.toString().trim();
    }

    public static void main(String[] args) {

        WordBreakII wordBreakII = new WordBreakII();
        List<String> array = new ArrayList<>();
        array.add("cat");
        array.add("cats");
        array.add("and");
        array.add("dog");
        array.add("sand");

        wordBreakII.wordBreak("catsanddog", array);
    }
}
