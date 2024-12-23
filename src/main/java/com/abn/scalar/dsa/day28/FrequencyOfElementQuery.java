package com.abn.scalar.dsa.day28;

import java.util.HashMap;
import java.util.Map;

/*
Given an array A that represents the participants of various contests, where each integer corresponds to a specific learner,
and an array B containing the learners for whom you want to check participation frequency, your task is to find the
frequency of each learner from array B in the array A and return a list containing all these frequencies

Input 1:
A = [1, 2, 1, 1]
B = [1, 2]

Input 2:
A = [2, 5, 9, 2, 8]
B = [3, 2]

Output 1:
[3, 1]
Output 2:
[0, 2]

 */
public class FrequencyOfElementQuery {

    public int[] solve(int[] A, int[] B) {

        int[] array = new int[B.length];
        Map<Integer, Integer> map = new HashMap<>();
        for(int a : A) {
            map.put(a, map.getOrDefault(a, 0) + 1);
        }

        int index = 0;
        for(int b : B) {
            if(map.containsKey(b)){
                array[index] = map.get(b);
            } else {
                array[index] = 0;
            }

            index++;
        }

        return array;
    }
}
