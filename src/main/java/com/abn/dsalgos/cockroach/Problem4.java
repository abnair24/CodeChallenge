package com.abn.dsalgos.cockroach;

import java.util.HashSet;
import java.util.PriorityQueue;

/*
Check If N and Its Double Exist
Given an array of integers, return true if there exist two indices i and j such that:

i != j
nums[i] == 2 * nums[j]

[10, 2, 5, 3]  →  true   (10 == 2 * 5)
[3, 1, 7, 11]  →  false
 */
public class Problem4 {

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
        Problem4 problem4 = new Problem4();
        int[] nums1 = {10, 2, 5, 3};
        System.out.println(problem4.isDoublePresent(nums1)); // true

        int[] nums2 = {3, 1, 7, 11};
        System.out.println(problem4.isDoublePresent(nums2)); // false
    }
}
