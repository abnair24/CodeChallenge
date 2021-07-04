package com.abn.dsalgos.glc;

/*
Given an array of integers nums sorted in ascending order, find the starting and ending position of a given target value.

If target is not found in the array, return [-1, -1].

You must write an algorithm with O(log n) runtime complexity.

Input: nums = [5,7,7,8,8,10], target = 8
Output: [3,4]

Input: nums = [5,7,7,8,8,10], target = 6
Output: [-1,-1]

Input: nums = [], target = 0
Output: [-1,-1]
 */
public class PositionsOfElementInSortedArray {

    public int[] position(int[] array, int target) {
        int r1 = -1;
        int r2 = -1;
        int[] results = new int[2];

        if (array.length == 0) {
            results[0] = r1;
            results[1] = r2;
            return results;
        }

        int len = array.length;
        int start = 0;
        int end = len - 1;
        int mid;

        while (start <= end) {
            mid = (start + end) / 2;
            if (array[mid] == target) {
                r1 = mid;
                end = mid - 1;
            } else if (target < array[mid]) {
                end = mid - 1;
            } else if (target > array[mid]) {
                start = mid + 1;
            }
        }

        int start1 = 0;
        int end1 = len - 1;
        int mid1;

        while (start1 <= end1) {
            mid1 = (start1 + end1) / 2;
            if (array[mid1] == target) {
                start1 = mid1 + 1;
                r2 = mid1;
            } else if (target < array[mid1]) {
                end1 = mid1 - 1;
            } else if (target > array[mid1]) {
                start1 = mid1 + 1;
            }
        }

        results[0] = r1;
        results[1] = r2;

        return results;
    }
}
