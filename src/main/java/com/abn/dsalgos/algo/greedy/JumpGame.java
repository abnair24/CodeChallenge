package com.abn.dsalgos.algo.greedy;

/*
Given an array of non-negative integers, you are initially positioned at the first index of the array.

Each element in the array represents your maximum jump length at that position.

Determine if you are able to reach the last index.


 Input: nums = [2,3,1,1,4]
Output: true
Explanation: Jump 1 step from index 0 to 1, then 3 steps to the last index.

Input: nums = [3,2,1,0,4]
Output: false
Explanation: You will always arrive at index 3 no matter what. Its maximum jump length is 0, which makes it impossible to reach the last index.
 */
public class JumpGame {

    public boolean solve(int[] array) {

        int targetIndex = array.length - 1;
        for(int i = array.length - 2; i>=0; i --) {

            if(targetIndex <= (i + array[i])) {

                targetIndex = i;
            }
        }
        if(targetIndex == 0) {
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        JumpGame jumpGame = new JumpGame();
        jumpGame.solve(new int[] {3, 2, 2, 0, 1, 4});
        jumpGame.solve(new int[] {3, 2, 1, 0, 4});
    }
}
