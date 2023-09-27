package com.abn.dsalgos.challenges.problems;

import java.util.ArrayList;
import java.util.List;

/*
Given an integer array and rotate array, return a list of indices such that, after each rotation, position of max value in the array

A = [1, 2, 6, 4, 3, 5]
R = [1, 2, 5, 4]

O = [1, 0, 3, 4]

Explanation : R = 1 => [2, 6, 4, 3, 5, 1]. max_index = 1
              R = 2 => [6, 4, 3, 5, 1, 2]. max_index = 0
              R = 5 => [5, 1, 2, 6, 4, 3]. max_index = 3
              R = 4 => [3, 5, 1, 2, 6, 4]. max_index = 4
 */
public class RotateArrayAndMaxIndex {


    public List<Integer> maxRotatedArrayIndexList(List<Integer> array, List<Integer> rotateList) {

        int length = array.size();
        int max = Integer.MIN_VALUE;
        int maxIndex = -1;
        for(int i = 0; i < length; i ++) {

            if(array.get(i) > max) {
                max = array.get(i);
                maxIndex = i;
            }
        }

        List<Integer> output = new ArrayList<>();
        for(int i = 0; i < rotateList.size(); i++) {

            int actualRotate = rotateList.get(i) % length;

            int maxRotateIndex = maxIndex - actualRotate;

            if(maxRotateIndex < 0) {
                maxRotateIndex = length + maxRotateIndex;
            }
            output.add(maxRotateIndex);
        }

        return output;
    }

    public static void main(String[] args) {

        RotateArrayAndMaxIndex rotateArrayAndMaxIndex = new RotateArrayAndMaxIndex();

        List<Integer> input = new ArrayList<>();
        input.add(1);
        input.add(2);

        input.add(6);

        input.add(4);

        input.add(3);
        input.add(5);

        List<Integer> rotate = new ArrayList<>();
        rotate.add(1);
        rotate.add(2);
        rotate.add(5);
        rotate.add(4);

        rotateArrayAndMaxIndex.maxRotatedArrayIndexList(input, rotate);
    }
}
