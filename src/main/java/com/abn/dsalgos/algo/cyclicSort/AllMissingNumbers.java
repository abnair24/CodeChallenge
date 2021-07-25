package com.abn.dsalgos.algo.cyclicSort;

import java.util.ArrayList;
import java.util.List;

/*
given an unsorted array containing numbers taken from the range 1 to ‘n’.
The array can have duplicates, which means some numbers will be missing. Find all those missing numbers.

Input: [2, 3, 1, 8, 2, 3, 5, 1]
Output: 4, 6, 7
 */
public class AllMissingNumbers {

    public List<Integer> missingNumbers(int[] array) {
        List<Integer> list = new ArrayList<>();
        int i = 0;
        while (i < array.length) {
            if (array[i] != array[array[i] - 1]) {
                swap(array, i, array[i] - 1);
            } else {
                i++;
            }
        }

        for (int k = 0; k < array.length; k++) {
            if (array[k] != k + 1) {
                list.add(k + 1);
            }
        }

        return list;
    }

    private void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        AllMissingNumbers allMissingNumbers = new AllMissingNumbers();
        List<Integer> result = allMissingNumbers.missingNumbers(new int[] {2, 3, 1, 8, 2, 3, 5, 1});

        for (int i = 0; i < result.size(); i++) {
            System.out.print(result.get(i) + " ");
        }
    }
}
