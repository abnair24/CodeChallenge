package com.abn.dsalgos.algo.subset;

import java.util.ArrayList;
import java.util.List;

/*
Given a set with distinct elements, find all of its distinct subsets.

Input: [1, 3]
Output: [], [1], [3], [1,3]

Input: [1, 5, 3]
Output: [], [1], [5], [3], [1,5], [1,3], [5,3], [1,5,3]
 */
public class Subsets {

    public List<List<Integer>> findSubset(int[] array) {
        List<List<Integer>> result = new ArrayList<>();
        result.add(new ArrayList<>());

        int i = 0;
        while (i < array.length) {
            int currentSubsetSize = result.size();

            for (int j = 0; j < currentSubsetSize; j++) {
                List<Integer> set = new ArrayList<>(result.get(j));
                set.add(array[i]);
                result.add(set);
            }
            i++;
        }

        return result;
    }

    public static void main(String[] args) {
        Subsets subsets = new Subsets();
        subsets.findSubset(new int[] {1, 5});
    }
}
