package com.abn.scalar.dsa.day30;

import java.util.HashMap;
import java.util.Map;

/*
Given an array A of N integers.
Find the length of the longest subarray in the array which sums to zero.

If there is no subarray which sums to zero then return 0.

Input 1:

A = [1, -2, 1, 2]
Input 2:

 A = [3, 2, -1]

Output 1:
3

Output 2:
0
 */
public class LongestSubarraySumZero {

    public int solve(int[] array) {

        int len = array.length;
        long sum = 0;
        int maxLen = 0;

        Map<Long, Integer> map = new HashMap<>();

        for(int i = 0; i < len; i++) {
            sum = sum + array[i];

            if(sum == 0) {
                maxLen = Math.max(maxLen, i+1);
            } else if(map.containsKey(sum)) {
                maxLen = Math.max(maxLen, i - map.get(sum));
            } else {
                map.put(sum, i);
            }
        }
        return maxLen;
    }

    public static void main(String[] args) {

        LongestSubarraySumZero longestSubarraySumZero = new LongestSubarraySumZero();
        System.out.println(longestSubarraySumZero.solve(new int[] {1, -2, 1, 2}));
    }
}
