package com.abn.dsalgos.algo.cyclicSort;

/*
Given an array of integers nums containing n + 1 integers where each integer is in the range [1, n] inclusive.

There is only one repeated number in nums, return this repeated number.

You must solve the problem without modifying the array nums and uses only constant extra space.

Input: nums = [1,3,4,2,2]
Output: 2

Input: nums = [1,1]
Output: 1

nums = [2, 5, 9, 6, 9, 3, 8, 9, 7, 1]
ouput = 9
 */
public class FindDuplicateNumber {

    public int duplicate(int[] array) {

        int slow = array[0];
        int fast = array[0];

        do {
            slow = array[slow];
            fast = array[array[fast]];
        } while (slow != fast);

        slow = array[0];

        while (slow != fast) {
            slow = array[slow];
            fast = array[fast];
        }

        return fast;
    }
}
