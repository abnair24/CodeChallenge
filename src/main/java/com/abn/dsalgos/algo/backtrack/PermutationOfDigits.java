package com.abn.dsalgos.algo.backtrack;

import java.util.LinkedList;
import java.util.List;

/*
Given an array nums of distinct integers, return all the possible permutations. You can return the answer in any order.

Input: nums = [1,2,3]
Output: [[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]

 */
public class PermutationOfDigits {

    List<List<Integer>> result = new LinkedList<>();

    public List<List<Integer>> permutation(int[] array) {

        LinkedList<Integer> track = new LinkedList<>();
        backtrack(array, track);
        return result;
    }

    private void backtrack(int[] arr, LinkedList<Integer> track) {

        if (track.size() == arr.length) {
            result.add(new LinkedList<>(track));
            return;
        }

        for (int i = 0; i < arr.length; i++) {
            if (track.contains(arr[i])) {
                continue;
            }
            track.add(arr[i]);
            backtrack(arr, track);
            track.removeLast();
        }
    }

    public static void main(String[] args) {

        int[] input = {1, 2, 3, 4};
        PermutationOfDigits permutationOfDigits = new PermutationOfDigits();
        permutationOfDigits.permutation(input);
    }
}
