package com.abn.dsalgos.algo.subset;

import java.util.ArrayList;
import java.util.List;

public class PermutationOfIntegers {

    List<List<Integer>> result = new ArrayList<>();

    public static void main(String[] args) {

        PermutationOfIntegers permutationOfIntegers = new PermutationOfIntegers();
        System.out.print(permutationOfIntegers.permutations(new int[] {1, 3, 4}));
    }

    public List<List<Integer>> permutations(int[] array) {
        permutationsHelper(array, 0, new ArrayList<>(), result);
        return result;
    }

    private void permutationsHelper(int[] array, int index, List<Integer> list, List<List<Integer>> result) {

        if (index == array.length) {
            result.add(list);
        } else {
            for (int i = 0; i <= list.size(); i++) {
                List<Integer> set = new ArrayList<>(list);
                set.add(i, array[index]);
                permutationsHelper(array, index + 1, set, result);
            }
        }
    }
}
