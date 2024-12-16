package com.abn.learn.dsa.day30;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

/*
Given an array of N elements. Check if there exists a subarray with sum
equal to 0.

array = {2, 2, 1, -3, 4, 3, 1, -2, -3, 2}

o/p: true

Approach: create prefix sum subarray
{2, 4, 5, 2, 6, 9, 10, 8, 5, 7}

so sum(i, j) =  presum[j] - presum[i-1] = 0
=> presum[j] = presum[i-1]

Observation 1:  Repeating values in psum denotes subarray sum =0
Observation 2:  IF O is present in psum denotes subarray sum = 0

 */
public class SubarraySumToZero {

    public boolean isSubArraySumZero(int[] array) {

        int[] prefix = getPrefixArray(array);

        Set<Integer> set = new HashSet<>();

        for(int i = 0; i< prefix.length; i++) {
            if(set.contains(prefix[i]) || prefix[i] == 0) {
                return true;
            } else {
                set.add(prefix[i]);
            }
        }

        return false;

    }

    private int[] getPrefixArray(int[] array) {

        int[] prefixArray = new int[array.length];
        prefixArray[0] = array[0];

        for (int i = 1; i < array.length; i++) {
            int sum = prefixArray[i - 1] + array[i];
            prefixArray[i] = sum;
        }
        return prefixArray;
    }
}
