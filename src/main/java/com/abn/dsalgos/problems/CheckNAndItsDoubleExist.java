package com.abn.dsalgos.problems;

import java.util.HashSet;

/*
Check If N and Its Double Exist
Given an array of integers, return true if there exist two indices i and j such that:

i != j
nums[i] == 2 * nums[j]

[10, 2, 5, 3]  →  true   (10 == 2 * 5)
[3, 1, 7, 11]  →  false
 */
public class CheckNAndItsDoubleExist {

    public boolean isDoublePresent(int[] nums) {

        HashSet<Integer> set = new HashSet<>();

        for(int n : nums) {
            if(n%2 == 0 && set.contains(n/2)) {
                return true;
            } else if(set.contains(n * 2)) {
                return true;
            } else {
                set.add(n);
            }
        }
        return false;
    }

    public static void main(String[] args) {
        CheckNAndItsDoubleExist problem4 = new CheckNAndItsDoubleExist();
        int[] nums1 = {10, 2, 5, 3};
        System.out.println(problem4.isDoublePresent(nums1)); // true

        int[] nums2 = {3, 1, 7, 11};
        System.out.println(problem4.isDoublePresent(nums2)); // false
    }
}
