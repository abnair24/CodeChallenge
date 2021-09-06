package com.abn.dsalgos.algo.backtrack;

import java.util.LinkedList;
import java.util.List;

/*
Given an array of distinct integers candidates and a target integer target, return a list of all unique

combinations of candidates where the chosen numbers sum to target. You may return the combinations in any order.

The same number may be chosen from candidates an unlimited number of times. Two combinations are unique if the frequency

of at least one of the chosen numbers is different.

It is guaranteed that the number of unique combinations that sum up to target is less than 150 combinations for the given input.

Input: candidates = [2,3,6,7], target = 7
Output: [[2,2,3],[7]]

As we are conidering combination, only one 2,2,3 is taken though different permutation produce same result

 */
public class CombinationSum {

    List<List<Integer>> result = new LinkedList<>();

    public List<List<Integer>> combinationSum(int[] candidates, int target) {

        LinkedList<Integer> track = new LinkedList<>();

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

        for (int i = start; i < candidates.length; ++i) {

            track.add(candidates[i]);
            backtrack(candidates, target - candidates[i], i, track);
            track.removeLast();
        }
    }

    public static void main(String[] args) {
        int[] input = {3, 4, 5};
        CombinationSum combinationSum = new CombinationSum();
        combinationSum.combinationSum(input, 8);
    }
}
