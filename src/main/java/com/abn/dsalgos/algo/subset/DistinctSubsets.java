package com.abn.dsalgos.algo.subset;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
Given a set of numbers that might contain duplicates, find all of its distinct subsets.

Input: [1, 3, 3]
Output: [], [1], [3], [1,3], [3,3], [1,3,3]

 */
public class DistinctSubsets {

    public static void main(String[] args) {

        DistinctSubsets distinctSubsets = new DistinctSubsets();
        distinctSubsets.distinct(new int[] {3, 1, 3});
    }

    public List<List<Integer>> distinct(int[] array) {

        Arrays.sort(array);
        List<List<Integer>> result = new ArrayList<>();

        result.add(new ArrayList<>());

        int i = 0;
        int start = 0;
        int end = 0;

        while (i < array.length) {
            start = 0;

            if (i > 0 && array[i] == array[i - 1]) {
                start = end + 1;
            }

            end = result.size() - 1;
            for (int j = start; j <= end; j++) {

                List<Integer> set = new ArrayList<>(result.get(j));
                set.add(array[i]);
                result.add(set);
            }
            i++;
        }

        return result;
    }
}
