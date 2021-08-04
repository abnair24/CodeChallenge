package com.abn.dsalgos.algo.slidingWindo;

import java.util.HashMap;
import java.util.Map;

/*
Given an array of integers and an integer target, find a subarray that sums to target and returns
 the start and end indices of the subarray. It’s guaranteed to have a unique solution.

 Input: [1 -20 -3 30 5 4], 7

Output: 1 4
Explanation: -20 - 3 + 30 = 7. The indices for subarray [-20,-3,30] is 1 and 4 (right exclusive).

 */
public class SubArraySumPrefix {

    public int[] subarray(int[] array, int target) {

        int[] result = new int[2];
        int currentSum = 0;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 0);

        for(int i = 0; i < array.length; i++) {

            currentSum += array[i];
            int diff = currentSum - target;
            if(map.containsKey(diff)) {
                result[0] = map.get(diff);
                result[1] = i + 1;
                return result;
            }
            map.put(currentSum, i+1);
        }
        return result;
    }

    public static void main(String[] args) {
        SubArraySumPrefix subArraySumPrefix = new SubArraySumPrefix();
        subArraySumPrefix.subarray(new int[] {1 ,-20, -3, 30, 5, 4}, 7);
    }
}
