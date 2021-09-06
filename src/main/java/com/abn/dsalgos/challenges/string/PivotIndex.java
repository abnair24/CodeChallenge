package com.abn.dsalgos.challenges.string;

/*
Given an array of integers nums, calculate the pivot index of this array.

The pivot index is the index where the sum of all the numbers strictly to the left
of the index is equal to the sum of all the numbers strictly to the index's right.

Input: nums = [1,7,3,6,5,6]
Output: 3

Left sum = nums[0] + nums[1] + nums[2] = 1 + 7 + 3 = 11
Right sum = nums[4] + nums[5] = 5 + 6 = 11

Input: nums = [1,2,3]
Output: -1

 */
public class PivotIndex {

    public int pivotIndex(int[] array) {
        int sum = 0;
        for (int i = 0; i < array.length; i++) {
            sum += array[i];
        }

        int leftSum = 0;
        int index = -1;
        for (int i = 0; i < array.length; i++) {
            if ((sum - array[i]) != leftSum) {
                leftSum += array[i];
                sum = sum - array[i];
            } else if ((sum - array[i]) == leftSum) {
                index = i;
                break;
            }
        }
        return index;
    }

    public static void main(String[] args) {
        PivotIndex pivotIndex = new PivotIndex();
        System.out.println(pivotIndex.pivotIndex(new int[] {-1, -1, -1, -1, -1, 0}));
    }
}
