package com.abn.dsalgos.algo.cyclicSort;

import java.util.ArrayList;
import java.util.List;

/*
given an unsorted array containing ‘n’ numbers taken from the range 1 to ‘n’.
The array has some numbers appearing twice, find all these duplicate numbers without using any extra space.

Input: [3, 4, 4, 5, 5]
Output: [4, 5]
 */
public class FindAllDuplicateNumbers {

    public List<Integer> findAllDuplicate(int[] array) {

        int i = 0;
        List<Integer> result = new ArrayList<>();

        while (i < array.length) {

            if (array[i] != array[array[i] - 1]) {
                int j = array[i] - 1;
                int temp = array[i];
                array[i] = array[j];
                array[j] = temp;
            } else {
                i++;
            }
        }

        for (int k = 0; k < array.length; k++) {
            if (array[k] != k + 1) {
                result.add(array[k]);
            }
        }
        return result;
    }


    public static void main(String[] args) {

        FindAllDuplicateNumbers findAllDuplicateNumbers = new FindAllDuplicateNumbers();
        List<Integer> list = findAllDuplicateNumbers.findAllDuplicate(new int[] {3, 4, 4, 5, 5});

        for (int i = 0; i < list.size(); i++) {
            System.out.print(list.get(i) + " ");
        }
    }
}
