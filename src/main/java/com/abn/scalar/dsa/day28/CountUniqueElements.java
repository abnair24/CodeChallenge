package com.abn.scalar.dsa.day28;

import java.util.HashMap;
import java.util.Map;

/*
You are given an array A of N integers. Return the count of elements with frequncy 1 in the given array.

 */
public class CountUniqueElements {

    public int solve(int[] A) {
        int count = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for(int n : A) {
            map.put(n, map.getOrDefault(n, 0)+ 1);
        }

        for(Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if(entry.getValue() == 1) {
                count++;
            }
        }

        return count;
    }

    public static void main(String[] args) {

        CountUniqueElements countUniqueElements = new CountUniqueElements();
        System.out.println(countUniqueElements.solve(new int[] {3, 4, 3, 6, 6}));
    }
}
