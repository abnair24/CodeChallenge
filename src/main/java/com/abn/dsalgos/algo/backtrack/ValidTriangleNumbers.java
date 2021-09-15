package com.abn.dsalgos.algo.backtrack;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/*
Given an integer array nums, return the number of triplets chosen from the array
that can make triangles if we take them as side lengths of a triangle.

Input: nums = [2,2,3,4]
Output: 3
Explanation: Valid combinations are:
2,3,4 (using the first 2)
2,3,4 (using the second 2)
2,2,3

Input: nums = [4,2,3,4]
Output: 4
 */
public class ValidTriangleNumbers {

    int count;

    public int permute(int[] array) {

        LinkedList<Integer> track = new LinkedList<>();
        Arrays.sort(array);

        backtrack(array, track, 0);

        return count;
    }

    private void backtrack(int[] array, LinkedList<Integer> track, int index) {

        if (track.size() == 3) {

            count ++;
            return;
        }

        for (int i = index; i < array.length; ++i) {

            if (track.size() == 2 && (array[i] >= (track.get(0) + track.get(1)) || track.get(0) >= (array[i] + track.get(1)) || track.get(1) >= (array[i] + track.get(0)))) {
                continue;
            }

            track.add(array[i]);
            backtrack(array, track, i + 1);
            track.removeLast();
        }
    }

    public static void main(String[] args) {

        System.out.println(new ValidTriangleNumbers().permute(new int[] {4, 6, 3, 7}));
        System.out.println(new ValidTriangleNumbers().permute(new int[] {10, 21, 22, 100, 101, 200, 300}));
        System.out.println(new ValidTriangleNumbers().permute(new int[] {2, 2, 3, 4}));
    }
}
