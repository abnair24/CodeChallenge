package com.abn.dsalgos.algo.backtrack;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/*
Given a collection of numbers, nums, that might contain duplicates, return all possible unique permutations in any order.

Input: nums = [1,1,2]
Output:
[[1,1,2],
 [1,2,1],
 [2,1,1]]
 */
public class PermutationII {

    List<List<Integer>> result = new LinkedList<>();

    public List<List<Integer>> permute(int[] array) {

        LinkedList<Integer> track = new LinkedList<>();
        Map<Integer, Integer> countMap = new HashMap<>();

        for (int i = 0; i < array.length; i++) {
            countMap.put(array[i], countMap.getOrDefault(array[i], 0) + 1);
        }

        backtrack(array, track, countMap);
        return result;
    }

    private void backtrack(int[] arr, LinkedList<Integer> track, Map<Integer, Integer> countMap) {

        if (track.size() == arr.length) {
            result.add(new LinkedList<>(track));
            return;
        }

        for (Map.Entry<Integer, Integer> entry : countMap.entrySet()) {
            int num = entry.getKey();
            int count = entry.getValue();

            if (count == 0) {
                continue;
            }

            track.add(num);
            countMap.put(num, count - 1);
            backtrack(arr, track, countMap);
            track.removeLast();
            countMap.put(num, count);
        }
    }

    public static void main(String[] args) {
        int[] input = {1, 1, 2};
        PermutationII permutationII = new PermutationII();
        permutationII.permute(input);
    }
}
