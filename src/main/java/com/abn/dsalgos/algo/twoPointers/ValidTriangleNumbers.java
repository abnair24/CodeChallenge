package com.abn.dsalgos.algo.twoPointers;

import java.util.Arrays;

/*
Given an integer array nums, return the number of triplets chosen from the array
that can make triangles if we take them as side lengths of a triangle.

Input: nums = [2,2,3,4]
Output: 3
Explanation: Valid combinations are:
2,3,4 (using the first 2)
2,3,4 (using the second 2)
2,2,3

Input: nums = [4,2,3,4]
Output: 4
 */
public class ValidTriangleNumbers {

//    int count;
//
//    public int permute(int[] array) {
//
//        LinkedList<Integer> track = new LinkedList<>();
//        Arrays.sort(array);
//
//        backtrack(array, track, 0);
//
//        return count;
//    }
//
//    private void backtrack(int[] array, LinkedList<Integer> track, int index) {
//
//        if (track.size() == 3) {
//
//            count ++;
//            return;
//        }
//
//        for (int i = index; i < array.length; ++i) {
//
//            if (track.size() == 2 && !isValidTriangle(array[i], track.get(0), track.get(1))) {
//                continue;
//            }
//
//            if(array[i] == 0) {
//                continue;
//            }
//
//            track.add(array[i]);
//            backtrack(array, track, i + 1);
//            track.removeLast();
//        }
//    }
//
//    private boolean isValidTriangle(int firstSide, int secondSide, int thirdSide) {
//
//        if(firstSide + secondSide > thirdSide && secondSide + thirdSide > firstSide && thirdSide + firstSide > secondSide) {
//            return true;
//        }
//        return false;
//    }

    public int triangleNumber(int[] nums) {
        Arrays.sort(nums);
        int count = 0;
        for(int k=nums.length-1; k>1; k--){
            int i=0, j=k-1;
            while(i<j){
                if(nums[i] + nums[j] > nums[k]){
                    count += j-i;
                    j--;
                }
                else i++;
            }
        }
        return count;
    }
    public static void main(String[] args) {

        System.out.println(new ValidTriangleNumbers().triangleNumber(new int[] {4, 6, 3, 7}));
        System.out.println(new ValidTriangleNumbers().triangleNumber(new int[] {10, 21, 22, 100, 101, 200, 300}));
        System.out.println(new ValidTriangleNumbers().triangleNumber(new int[] {2, 2, 3, 4}));
    }
}
