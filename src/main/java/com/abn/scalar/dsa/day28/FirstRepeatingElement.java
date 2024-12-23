package com.abn.scalar.dsa.day28;

/*
Given an integer array A of size N, find the first repeating element in it.
We need to find the element that occurs more than once and whose index of the first occurrence is the smallest.

If there is no repeating element, return -1.

A = [10, 5, 3, 4, 3, 5, 6]

5

 */

import java.util.HashMap;
import java.util.Map;

public class FirstRepeatingElement {

    public int solve(int[] A) {

        Map<Integer,Integer> map = new HashMap<>();
        for(int i = 0; i < A.length; i++) {
            if(!map.containsKey(A[i])) {
                map.put(A[i], i);
            } else {
                map.put(A[i], -1);
            }
        }

        for(int i = 0; i < A.length; i++) {
            if(map.get(A[i]) == -1) {
                return A[i];
            }
        }
        return -1;
    }

    public static void main(String[] args) {

        FirstRepeatingElement firstRepeatingElement = new FirstRepeatingElement();
        firstRepeatingElement.solve(new int[]{10, 5, 3, 4, 3, 5, 6});
    }
}
