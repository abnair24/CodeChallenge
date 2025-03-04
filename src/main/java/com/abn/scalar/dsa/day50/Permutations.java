package com.abn.scalar.dsa.day50;

import java.util.ArrayList;
import java.util.LinkedList;

/*
Given an integer array A of size N denoting collection of numbers , return all possible permutations.

NOTE:

No two entries in the permutation sequence should be the same.
For the purpose of this problem, assume that all the numbers in the collection are unique.
Return the answer in any order

A = [1, 2, 3]

[ [1, 2, 3]
  [1, 3, 2]
  [2, 1, 3]
  [2, 3, 1]
  [3, 1, 2]
  [3, 2, 1] ]
 */
public class Permutations {

    ArrayList<ArrayList<Integer>> result = new ArrayList<>();

    public ArrayList<ArrayList<Integer>> permute(ArrayList<Integer> A) {

        LinkedList<Integer> track = new LinkedList<>();
        boolean[] used = new boolean[A.size()];
        backtrack(A, track, used);
        return result;
    }

    private void backtrack(ArrayList<Integer> A, LinkedList<Integer> track, boolean[] used) {

        if (track.size() == A.size()) {
            result.add(new ArrayList<>(track));
            return;
        }

        for (int i = 0; i < A.size(); i++) {
            if (used[i]) {
                continue;
            }
            track.add(A.get(i));
            used[i] = true;
            backtrack(A, track, used);
            track.removeLast();
            used[i] = false;
        }
    }
}
