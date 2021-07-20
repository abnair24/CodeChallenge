package com.abn.dsalgos.algo.dp;

/*
You are a professional robber planning to rob houses along a street.
 Each house has a certain amount of money stashed, the only constraint
  stopping you from robbing each of them is that adjacent houses have security systems
  connected and it will automatically contact the police if two adjacent houses were broken into on the same night.

Given an integer array nums representing the amount of money of each house,
return the maximum amount of money you can rob tonight without alerting the police.

Input: nums = [1,2,3,1]
Output: 4
Total amount you can rob = 1 + 3 = 4.

Input: nums = [2,7,9,3,1]
Output: 12
Total amount you can rob = 2 + 9 + 1 = 12.
 */
public class HouseRobber {

    public int robMax(int[] array) {

        int[] cache = new int[array.length];
        return robMaxHelper(array, cache, 0);
    }

    private int robMaxHelper(int[] array, int[] cache, int index) {


        if(index >= array.length) {
            return 0;
        }

        if(cache[index] != 0) {
            return cache[index];
        }

        // At any given index, if robber robs current index, then he can rob from index + 2 house / higher,
        // If not rob current then move to index + 1;
        int max1 = array[index] + robMaxHelper(array, cache, index + 2);

        int max2 = robMaxHelper(array, cache, index + 1);

        cache[index] = Math.max(max1, max2);

        return cache[index];
    }
}
