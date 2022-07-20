package com.abn.dsalgos.algo.subset;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/*
Given a set with distinct elements, find all of its distinct subsets.

Input: [1, 3]
Output: [], [1], [3], [1,3]

Input: [1, 5, 3]
Output: [], [1], [5], [3], [1,5], [1,3], [5,3], [1,5,3]

Note: can be done using backtracking combination also.
 */
public class Subsets {

    public static void main(String[] args) {
        Subsets subsets = new Subsets();
        subsets.findSubset(new int[] {1, 5});
        subsets.findSubset(new int[] {1, 5, 3});
    }

    List<List<Integer>> result = new LinkedList<>();

    public List<List<Integer>> findSubset(int[] array) {

        LinkedList<Integer> track = new LinkedList<>();
        backtrack(array, track, 0);
        return result;
    }

    private void backtrack(int[] array, LinkedList<Integer> track, int start) {

        result.add(new LinkedList<>(track));

        for(int i = start; i < array.length; i++) {

            track.add(array[i]);
            backtrack(array, track, start + 1);
            track.removeLast();
        }
    }
}
