package com.abn.learn.dsa.day7;

import java.util.Arrays;

/*
Given an array of size N queries For every query return sum of all even indexed elements from L to R

Eg: {2, 3, 1, 6, 4, 5}
{{1, 3}, {2, 5}, {0, 4}, {3, 3}}

o/p:
9, 11, 9, 6
 */
public class SumOfOddIndexElementsInRange {

    public int[] solve(int[] array, int[][] range) {

        int[] prefix = new int[array.length];
        int[] result = new int[range.length];

        prefix[0]= 0;

        for(int i = 1; i < array.length; i++) {

            if(i % 2 != 0) {
                prefix[i] = prefix[i - 1] + array[i];
            } else {
                prefix[i] = prefix[i - 1];
            }
        }

        for(int i = 0; i < range.length; i++) {

            int left = range[i][0];
            int right = range[i][1];

            if(left == 0) {
               result[i] = prefix[right];
            } else {
                result[i] = prefix[right] - prefix[left - 1];
            }
        }

        return result;
    }

    public static void main(String[] args) {

        SumOfOddIndexElementsInRange sumOfOddIndexElementsInRange = new SumOfOddIndexElementsInRange();
        int[] res = sumOfOddIndexElementsInRange.solve(new int[] {2, 3, 1, 6, 4, 5}, new int[][] {{1, 3}, {2, 5}, {0, 4}, {3, 3}});

        Arrays.stream(res).forEach(System.out::println);
    }

}
