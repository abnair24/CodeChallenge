package com.abn.dsalgos.challenges.string;

/*
given an integer array nums where the largest integer is unique.

Determine whether the largest element in the array is at least twice as much as every other number
 in the array. If it is, return the index of the largest element, or return -1 otherwise.

 Input: nums = [3,6,1,0]
Output: 1

Input: nums = [1,2,3,4]
Output: -1
 */
public class LargestNumbersTwiceAsOthers {

    public int largest(int[] array) {

        int maxIndex = -1;
        int max = Integer.MIN_VALUE;
        boolean status = true;

        for (int i = 0; i < array.length; i++) {
            if (array[i] > max) {
                max = array[i];
                maxIndex = i;
            }
        }

        for (int i = 0; i < array.length; i++) {
            if (i != maxIndex && array[i] * 2 > max) {
                status = false;
                break;
            }
        }

        return status == true ? maxIndex : -1;
    }

    public static void main(String[] args) {
        LargestNumbersTwiceAsOthers largestNumbersTwiceAsOthers = new LargestNumbersTwiceAsOthers();
        System.out.println(largestNumbersTwiceAsOthers.largest(new int[] {3, 4, 6, 11, 5}));
    }
}
