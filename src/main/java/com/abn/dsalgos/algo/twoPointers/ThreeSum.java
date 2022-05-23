package com.abn.dsalgos.algo.twoPointers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
Given an integer array nums, return all the triplets [nums[i], nums[j], nums[k]] such that i != j, i != k, and j != k,

and nums[i] + nums[j] + nums[k] == 0.

Notice that the solution set must not contain duplicate triplets.

Input: nums = [-1,0,1,2,-1,-4]
Output: [[-1,-1,2],[-1,0,1]]
 */
public class ThreeSum {

    public List<List<Integer>> threeSum(int[] nums) {

        Arrays.sort(nums);

        List<List<Integer>> result = new ArrayList<>();

        for(int i = 0; i< nums.length && nums[i] <= 0; i++) {
            if(i == 0 || nums[i]!= nums[i-1]) {

                getSum(nums, i, result);
            }
        }
        return result;
    }

    private void getSum(int[] nums, int i, List<List<Integer>> result) {

        int left = i +1;
        int right = nums.length - 1;

        while(left < right) {
            int sum = nums[i] + nums[left] + nums[right];

            if(sum == 0) {
                result.add(Arrays.asList(nums[i], nums[left++], nums[right--]));
                while(left < right && nums[left] == nums[left -1]) {
                    ++left;
                }
            } else if( sum < 0) {
                ++ left;
            } else {
                -- right;
            }
        }
    }

    public static void main(String[] args) {

        ThreeSum threeSum = new ThreeSum();
        threeSum.threeSum(new int[] {-1, 0, 1, 2, -1, -4});
    }
}
