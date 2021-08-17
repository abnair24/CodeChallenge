package com.abn.dsalgos.algo.slidingWindo;

import java.util.HashMap;
import java.util.Map;

/*
Given a binary array nums and an integer k, return the maximum number of consecutive 1's
in the array if you can flip at most k 0's.

Input: nums = [1,1,1,0,0,0,1,1,1,1,0], k = 2
Output: 6
Explanation: [1,1,1,0,0,1,1,1,1,1,1]

Input: nums = [0,0,1,1,0,0,1,1,1,0,1,1,0,0,0,1,1,1,1], k = 3
Output: 10
Explanation: [0,0,1,1,1,1,1,1,1,1,1,1,0,0,0,1,1,1,1]

https://leetcode.com/problems/max-consecutive-ones-iii/
 */

public class LongestOnes {

    public int getLongestOnes(int[] array, int k) {
        int len = array.length;
        int max = Integer.MIN_VALUE;
        int start = 0;

        int count = 0;
        int window = 0;

        for(int i = 0; i < len; i++) {

            if(array[i] == 0) {
                count ++;
            }

            while(count > k) {
                int temp = array[start];
                start ++;
                if(temp == 0) {
                    count --;
                }
            }
            window = i - start + 1;

            max = Math.max(max, window);
        }
        return max;
    }
}
