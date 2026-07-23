package com.abn.sc.dsa.day67;

/*
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
public class HouseRobberTabulation {

    public int solve(int[] array) {

        int[] dp = new int[array.length];
        dp[0] = array[0];
        dp[1] = Math.max(array[0], array[1]);

        for(int i = 2; i < array.length; i++) {
            dp[i] = Math.max(array[i] + dp[i-2], dp[i-1]);
        }
        return dp[array.length - 1];
    }

    public static void main(String[] args) {
        HouseRobberTabulation houseRobberTabulation = new HouseRobberTabulation();
        System.out.println(houseRobberTabulation.solve(new int[] {1,2,3,1}));
        System.out.println(houseRobberTabulation.solve(new int[] {2,7,9,3,1}));
    }
}
