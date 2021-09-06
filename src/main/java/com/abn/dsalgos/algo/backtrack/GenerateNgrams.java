package com.abn.dsalgos.algo.backtrack;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/*
Given a sentence string, extract words to form n-grams

"New york times square"

o/p:
unigram : "New", "york", "times", "square"
bigram : "New york", "york times", "times square"
trigram: "New york times", "york times square"
quadgram : "New york times square"
 */

public class GenerateNgrams {

    List<List<String>> result = new LinkedList<>();

    public List<List<String>> combine(String n, int k) {

        List<String> array = Arrays.asList(n.split(" "));

        LinkedList<String> track = new LinkedList<>();

        for (int i = 1; i <= k; i++) {
            backtrack(array, i, 0, track);
        }

        return result;
    }

    private void backtrack(List<String> n, int k, int start, LinkedList<String> track) {

        if (k == track.size()) {
            result.add(new LinkedList<>(track));
            return;
        }

        for (int i = start; i < n.size(); i++) {
            if (k > 1 && track.size() >= 1 && (i - n.indexOf(track.get(0))) >= k) {
                continue;
            }

            track.add(n.get(i));
            backtrack(n, k, i + 1, track);
            track.removeLast();
        }
    }

    public static void main(String[] args) {
        GenerateNgrams generateNgrams = new GenerateNgrams();
        generateNgrams.combine("new york times square central", 5);
    }
}

