package com.abn.learn.dsa.day28;

import java.util.HashSet;
import java.util.Set;

/*
Given an array A of N integers, return the number of unique elements in the array.

A = [3, 4, 3, 6, 6]
Input 2:
A = [3, 3, 3, 9, 0, 1, 0]

Output 1:
3
Output 2:
4

 */
public class CountDistinctElements {

    public int solve(int[] A) {

        Set<Integer> set = new HashSet<>();

        for(int a: A) {
            if(!set.contains(a)) {
                set.add(a);
            }
        }

        return set.size();
    }
}
