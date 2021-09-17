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
        boolean[] used = new boolean[array.length];
        backtrack(array, track, used);
        return result;
    }

    private void backtrack(int[] arr, LinkedList<Integer> track, boolean[] used) {

        if (track.size() == arr.length) {
            result.add(new LinkedList<>(track));
            return;
        }

        for (int i = 0; i < arr.length; i++) {
            if (used[i]) {
                continue;
            }
            track.add(arr[i]);
            used[i] = true;
            backtrack(arr, track, used);
            track.removeLast();
            used[i] = false;
        }
    }

    public static void main(String[] args) {

        int[] input = {1, 1};
        PermutationOfDigits permutationOfDigits = new PermutationOfDigits();
        System.out.println(permutationOfDigits.permutation(input));
    }
}
