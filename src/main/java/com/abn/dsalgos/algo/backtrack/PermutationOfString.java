package com.abn.dsalgos.algo.backtrack;

import java.util.LinkedList;
import java.util.List;

/*
Given a list of unique letters, find all of its distinct permutations.
 */
public class PermutationOfString {

    List<List<Character>> result = new LinkedList<>();

    public List<List<Character>> permute(char[] letters) {

        LinkedList<Character> track = new LinkedList<>();
        permuteHelper(letters, track);
        return result;
    }

    private void permuteHelper(char[] letters, LinkedList<Character> track) {

        if (track.size() == letters.length) {
            result.add(new LinkedList<>(track));
            return;
        }

        for (int i = 0; i < letters.length; i++) {

            if (track.contains(letters[i])) {
                continue;
            }

            track.add(letters[i]);
            permuteHelper(letters, track);
            track.removeLast();
        }
    }

    public static void main(String[] args) {

        PermutationOfString permutation = new PermutationOfString();

        permutation.permute(new char[] {'a', 'b', 'c'});
    }
}
