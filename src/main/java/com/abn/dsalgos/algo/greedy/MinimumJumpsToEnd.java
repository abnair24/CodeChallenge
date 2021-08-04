package com.abn.dsalgos.algo.greedy;

/*
Given an array of non-negative integers nums, you are initially positioned at the first index of the array.

Each element in the array represents your maximum jump length at that position.

Your goal is to reach the last index in the minimum number of jumps.

You can assume that you can always reach the last index.

Input: nums = [2,3,1,1,4]
Output: 2

https://leetcode.com/problems/jump-game-ii/
 */
public class MinimumJumpsToEnd {

    public int minJumps(int[] array) {

        if(array[0] == 0 || array.length == 1) {
            return 0;
        }

        int windowStartIndex = 0;
        int count = 1;
        int indexToStart = 0;

        while(windowStartIndex < array.length - 1 && (windowStartIndex + array[windowStartIndex] < array.length-1)) {

            int size = windowStartIndex + array[windowStartIndex];
            int maxIndex = 0;
            for(int j = 1; j <= size; j++) {
                int temp = j + array[j];

                if(temp > maxIndex) {
                    maxIndex = temp;
                    indexToStart = j;
                }
            }
            windowStartIndex = indexToStart;
            count ++;
        }
        return count;
    }
}
