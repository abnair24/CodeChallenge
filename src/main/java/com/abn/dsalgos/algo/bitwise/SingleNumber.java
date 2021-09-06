package com.abn.dsalgos.algo.bitwise;

/*
Given a non-empty array of integers nums, every element appears twice except for one. Find that single one.

Input: nums = [2,2,1]
Output: 1

Input: nums = [1]
Output: 1
 */
public class SingleNumber {

    public int getSingleNumber(int[] nums) {

        if (nums.length == 0) {
            return nums[0];
        }

        int num = nums[0];

        for (int i = 1; i < nums.length; i++) {
            num = num ^ nums[i];
        }
        return num;
    }
}
