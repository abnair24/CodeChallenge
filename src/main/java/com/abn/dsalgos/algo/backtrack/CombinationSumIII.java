package com.abn.dsalgos.algo.backtrack;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/*
Given a collection of candidate numbers (candidates) and a target number (target),
find all unique combinations in candidates where the candidate numbers sum to target.

Each number in candidates may only be used once in the combination.
Note: The solution set must not contain duplicate combinations.

Input: candidates = [10,1,2,7,6,1,5], target = 8
Output:
[
[1,1,6],
[1,2,5],
[1,7],
[2,6]
]

Input: candidates = [2,5,2,1,2], target = 5
Output:
[
[1,2,2],
[5]
]

 */
public class CombinationSumIII {

    List<List<Integer>> result = new LinkedList<>();

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {

        LinkedList<Integer> track = new LinkedList<>();
        Arrays.sort(candidates);

        backtrack(candidates, target, 0, track);
        return result;
    }

    private void backtrack(int[] candidates, int target, int start, LinkedList<Integer> track) {

        if (target == 0) {
            result.add(new LinkedList<>(track));
            return;
        }

        if (target < 0) {
            return;
        }

        for (int i = start; i < candidates.length; i++) {

            if (i > start && candidates[i] == candidates[i - 1]) {
                continue;
            }

            track.add(candidates[i]);
            backtrack(candidates, target - candidates[i], i + 1, track);
            track.removeLast();
        }
    }

    public static void main(String[] args) {

        CombinationSumIII combinationSumIII = new CombinationSumIII();
        int[] input = {10, 1, 2, 7, 6, 1, 5};
        combinationSumIII.combinationSum2(input, 8);
    }
}
