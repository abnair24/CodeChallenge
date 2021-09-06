package com.abn.dsalgos.algo.slidingWindo;

import org.testng.Assert;

import java.util.HashMap;
import java.util.Map;

/*
Given an array of elements, return the length of the longest subarray where all its elements are distinct.

Input: arr[] = {1, 2, 3, 4, 5, 1, 2, 3}
Output: 5
 */

public class LongestUniqueSubArray {

    public int longestUnique(int[] array) {

        Map<Integer, Integer> hm = new HashMap<>();
        int max = 0;
        int len = 0;
        int start = 0;

        for (int i = 0; i < array.length; i++) {
            if (hm.containsKey(array[i])) {
                start = Math.max(start, hm.get(array[i]) + 1);
            }
            hm.put(array[i], i);
            len = i - start + 1;

            max = Math.max(max, len);
        }
        return max;
    }

    public static void main(String[] args) {
        int arr[] = {1, 2, 3, 4, 5, 1, 2, 3};

        LongestUniqueSubArray longestUniqueSubArray = new LongestUniqueSubArray();
        Assert.assertEquals(longestUniqueSubArray.longestUnique(arr), 5);
    }
}
