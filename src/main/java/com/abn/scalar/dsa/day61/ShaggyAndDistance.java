package com.abn.scalar.dsa.day61;

import java.util.HashMap;
import java.util.Map;

/*
Shaggy has an array A consisting of N elements. We call a pair of distinct indices in that array a special if elements at those indices in the array are equal.

Shaggy wants you to find a special pair such that the distance between that pair is minimum. Distance between two indices is defined as |i-j|. If there is no special pair in the array, then return -1. solve with java.

 */
public class ShaggyAndDistance {

    public int solve(int[] A) {
        Map<Integer, Integer> map = new HashMap<>();
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < A.length; i++) {
            if (!map.containsKey(A[i])) {
                map.put(A[i], i);
            } else {
                int prevIndex = map.get(A[i]);
                int distance = Math.abs(i - prevIndex);
                if(distance < 2) {
                    return 1;
                }
                min = Math.min(distance, min);
                map.put(A[i], i);
            }
        }

        return min == Integer.MAX_VALUE ? -1 : min;
    }

    public static void main(String[] args) {

        ShaggyAndDistance shaggyAndDistance = new ShaggyAndDistance();
        System.out.println(shaggyAndDistance.solve(new int[] {7, 1, 3, 4, 1, 7}));
        System.out.println(shaggyAndDistance.solve(new int[] {1, 2, 3, 4, 5}));
        System.out.println(shaggyAndDistance.solve(new int[] {1, 1}));
    }
}
