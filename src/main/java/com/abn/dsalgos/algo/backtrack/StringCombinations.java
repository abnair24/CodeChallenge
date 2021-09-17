package com.abn.dsalgos.algo.backtrack;

import java.util.LinkedList;
import java.util.List;

public class StringCombinations {

    List<List<Character>> result = new LinkedList<>();

    public List<List<Character>> combine(String n, int k) {

        if (k <= 0 || n.length() <= 0) {
            return result;
        }

        LinkedList<Character> track = new LinkedList<>();
        for (int i = 1; i <= k; i++) {
            backtrack(n, i, 0, track);
        }

        return result;
    }

    private void backtrack(String n, int k, int start, LinkedList<Character> track) {

        if (k == track.size()) {
            result.add(new LinkedList<>(track));
            return;
        }

        for (int i = start; i < n.length(); ++i) {

            track.add(n.charAt(i));
            backtrack(n, k, i + 1, track);
            track.removeLast();
        }
    }

    public static void main(String[] args) {

        StringCombinations combinations = new StringCombinations();
        combinations.combine("ABC", 3);
    }
}
