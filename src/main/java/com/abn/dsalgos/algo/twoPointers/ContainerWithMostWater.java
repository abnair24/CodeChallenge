package com.abn.dsalgos.algo.twoPointers;

/*
Given n non-negative integers a1, a2, ..., an , where each represents a point at coordinate (i, ai).
n vertical lines are drawn such that the two endpoints of the line i is at (i, ai) and (i, 0). Find two lines, which,
 together with the x-axis forms a container, such that the container contains the most water.

Input: height = [1,8,6,2,5,4,8,3,7]
Output: 49

Input: height = [4,3,2,1,4]
Output: 16
Notice that you may not slant the container.

https://leetcode.com/problems/container-with-most-water/
 */

public class ContainerWithMostWater {

    public int maximum(int[] height) {

        int max = Integer.MIN_VALUE;
        int rightIndex = height.length - 1;
        int leftIndex = 0;
        int len = 0;
        int area = 0;

        while (leftIndex < rightIndex) {

            len = rightIndex - leftIndex;
            area = len * Math.min(height[leftIndex], height[rightIndex]);

            max = Math.max(area, max);

            if (height[leftIndex] <= height[rightIndex]) {
                leftIndex++;
            } else {
                rightIndex--;
            }
        }
        return max;
    }
}
