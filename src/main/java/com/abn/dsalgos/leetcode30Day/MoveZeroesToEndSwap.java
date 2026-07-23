package com.abn.dsalgos.leetcode30Day;

public class MoveZeroesToEndSwap {

     /*
    Given an array nums, write a function to move all 0's to the end of it.

    Input: [0,1,0,3,12]
    Output: [3,12,1,0,0]
     */

    public int[] pushZeroesToEnd(int[] arr) {

        int slow = 0;
        for(int fast = 0; fast < arr.length; fast ++) {
            if(arr[fast] != 0) {
                int temp = arr[slow];
                arr[slow] = arr[fast];
                arr[fast] = temp;
                slow ++;
            }
        }
        return arr;
    }
}
