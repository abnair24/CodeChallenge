package com.abn.dsalgos.glc;

import org.testng.Assert;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/*
Given an array of integers arr, write a function that returns true if and only if the number of occurrences
of each value in the array is unique.

Input: arr = [1,2,2,1,1,3]
Output: true

Input: arr = [1,2]
Output: false

Input: arr = [-3,0,1,-3,1,1,1,-3,10,0]
Output: true
 */
public class UniqueOccurances {

    public boolean uniqueOccurrences(int[] arr) {

        Map<Integer, Integer> map = new HashMap<>();
        Set<Integer> set = new HashSet<>();

        for (int i = 0; i < arr.length; i++) {
            map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
        }

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {

            if (set.contains(entry.getValue())) {
                return false;
            } else {
                set.add(entry.getValue());
            }
        }
        return true;
    }

    public static void main(String[] args) {

        int[] array = new int[]{1,2};
        Assert.assertFalse(new UniqueOccurances().uniqueOccurrences(array));
    }
}
