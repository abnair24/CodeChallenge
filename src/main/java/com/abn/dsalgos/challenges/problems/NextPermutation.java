package com.abn.dsalgos.challenges.problems;

import java.util.Arrays;

/*
    https://leetcode.com/problems/next-permutation/editorial/

    A permutation of an array of integers is an arrangement of its members into a sequence or linear order.

For example, for arr = [1,2,3],
the following are all the permutations of arr: [1,2,3], [1,3,2], [2, 1, 3], [2, 3, 1], [3,1,2], [3,2,1].
The next permutation of an array of integers is the next lexicographically greater permutation of its integer.
More formally, if all the permutations of the array are sorted in one container according to their lexicographical order,
then the next permutation of that array is the permutation that follows it in the sorted container.
If such arrangement is not possible, the array must be rearranged as the lowest possible order (i.e., sorted in ascending order).

For example, the next permutation of arr = [1,2,3] is [1,3,2].
Similarly, the next permutation of arr = [2,3,1] is [3,1,2].
While the next permutation of arr = [3,2,1] is [1,2,3] because [3,2,1] does not have a lexicographical larger rearrangement.
Given an array of integers nums, find the next permutation of nums.

The replacement must be in place and use only constant extra memory.
 */
public class NextPermutation {

    public void nextPermutation(int[] nums) {

        int index = nums.length - 2;

        while (index >= 0 && nums[index] >= nums[index + 1]) {

            index--;
        }

        int dipIndex = index;

        if (index >= 0) {

            index = nums.length - 1;

            while (nums[index] <= nums[dipIndex]) {

                index--;
            }

            int swapIndex = index;

            swap(nums, swapIndex, dipIndex);
        }

        // reversing out of the if condition to satisfy the case: [3, 2, 1] ==> [1, 2, 3]
        reverse(nums, dipIndex + 1);
        System.out.println(Arrays.toString(nums));

    }

    private void swap(int[] nums, int i, int j) {

        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    private void reverse(int[] nums, int startIndex) {

        int endIndex = nums.length - 1;

        while (startIndex < endIndex) {

            int temp = nums[startIndex];
            nums[startIndex] = nums[endIndex];
            nums[endIndex] = temp;

            startIndex++;
            endIndex--;
        }
    }

    public static void main(String[] args) {
        NextPermutation nextPermutation = new NextPermutation();
        nextPermutation.nextPermutation(new int[] {5, 6, 1});
        nextPermutation.nextPermutation(new int[] {6, 2, 8, 1, 4, 3, 2, 1});

    }
}