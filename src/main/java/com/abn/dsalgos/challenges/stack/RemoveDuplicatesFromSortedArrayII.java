package com.abn.dsalgos.challenges.stack;

import java.util.Stack;

/*
Given an integer array nums sorted in non-decreasing order,
remove some duplicates in-place such that each unique element appears at most twice.
The relative order of the elements should be kept the same.

Input: nums = [1,1,1,2,2,3]
Output: 5, nums = [1,1,2,2,3,_]

Input: nums = [0,0,1,1,1,1,2,3,3]
Output: 7, nums = [0,0,1,1,2,3,3,_,_]


 */
public class RemoveDuplicatesFromSortedArrayII {

    public int removeDuplicates(int[] nums) {

        Stack<Integer> stack = new Stack<>();
        stack.push(nums[0]);
        int k = 1;
        int i = 1;
        int count = 2;

        while (i < nums.length) {
            if (stack.peek() == nums[i]) {
                if (k < count) {
                    stack.push(nums[i]);
                    k++;
                }
            } else {
                k = 1;
                stack.push(nums[i]);
            }
            i++;
        }

        int size = stack.size();
        for (int j = size; j > 0; j--) {
            nums[j - 1] = stack.pop();
        }
        return size;
    }

    public static void main(String[] args) {
        RemoveDuplicatesFromSortedArrayII remove = new RemoveDuplicatesFromSortedArrayII();

        remove.removeDuplicates(new int[] {1, 1, 1, 1, 5});
    }
}
