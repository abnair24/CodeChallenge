package com.abn.dsalgos.algo.backtrack;

import java.util.LinkedList;
import java.util.List;

/*
Input two numbers n, k, and the algorithm outputs all combinations of k numbers in [1..n].

For example, input n = 4, k = 2, the output is as follows, the order does not matter,

but it cannot contain duplicates (according to the definition of the combination,[1,2]and[2,1]are also duplicates):

[ [1,2], [1,3], [1,4], [2,3], [2,4], [3,4] ]
 */
public class Combinations {

    List<List<Integer>> result = new LinkedList<>();

    public List<List<Integer>> combine(int n, int k) {

        if (k <= 0 || n <= 0) {
            return result;
        }

        LinkedList<Integer> track = new LinkedList<>();
        for (int i = 1; i <= k; i++) {
            backtrack(n, i, 1, track);
        }

        return result;
    }

    private void backtrack(int n, int k, int start, LinkedList<Integer> track) {

        if (k == track.size()) {
            result.add(new LinkedList<>(track));
            return;
        }

        for (int i = start; i <= n; ++i) {

            // pruning cases of unwanted combinations.
            // Here checking if current index "i" and first item in track index is greater than or equal to k
            if (k > 1 && track.size() >= 1 && (i - track.get(0) >= k)) {
                continue;
            }

            track.add(i);
            backtrack(n, k, i + 1, track);
            track.removeLast();
        }
    }

    public static void main(String[] args) {

        Combinations combinations = new Combinations();
        combinations.combine(4, 4);
    }
}
