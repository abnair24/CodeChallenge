package com.abn.dsalgos.challenges.problems;


import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/*
Array = [-1,1,2,3,-5]
Meandering array = [3,-5,2,-1,1]
                  [first_largest, first_smallest, second_largest,second_smallest, ....]
 */
public class MeanderingArray {

    public static List<Integer> meanderingArray(List<Integer> input) {
        int[] array = input.stream().mapToInt(i -> i).toArray();
        Arrays.sort(array);

        int size = array.length;
        int[] temp = new int[size];

        int index = 0;

        for (int i = 0, j = size - 1; i <= size / 2 || j > size / 2; i++, j--) {
            if (index < size) {
                temp[index] = array[j];
                index++;
            }

            if (index < size) {
                temp[index] = array[i];
                index++;
            }
        }
        return Arrays.stream(array).boxed().collect(Collectors.toList());
    }
}
