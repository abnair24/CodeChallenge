package com.abn.dsalgos.algo.dp;

/*
Given a non-empty array nums containing only positive integers, find if the array can be partitioned into
 two subsets such that the sum of elements in both subsets is equal.

Input: nums = [1,5,11,5]
Output: true

Input: nums = [1,2,3,5]
Output: false
 */

public class PartitionEqualSubsetSum {

    public boolean canPartition(int[] nums) {

        int sum = 0;

        for (int num : nums) {
            sum = sum + num;
        }

        if (sum % 2 != 0) {
            return false;
        }

        int subsetSum = sum / 2;
        Boolean[][] cache = new Boolean[nums.length + 1][subsetSum + 1];

        return isPartition(cache, nums, nums.length - 1, subsetSum);
    }

    private boolean isPartition(Boolean[][] cache, int[] nums, int index, int sum) {

        if (sum == 0) {
            return true;
        }

        if (index == 0 || sum < 0) {
            return false;
        }

        if (cache[index][sum] != null) {
            return cache[index][sum];
        }

        if (nums[index - 1] > sum) {
            return isPartition(cache, nums, index - 1, sum);
        }

        boolean result = isPartition(cache, nums, index - 1, sum - nums[index - 1]) ||
                isPartition(cache, nums, index - 1, sum);

        cache[index][sum] = result;

        return result;
    }
}
