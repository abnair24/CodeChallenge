package com.abn.dsalgos.glc;

import java.util.ArrayList;
import java.util.List;

/*
You are given an inclusive range [lower, upper] and a sorted unique integer array nums, where all elements are in the inclusive range.

A number x is considered missing if x is in the range [lower, upper] and x is not in nums.

Return the smallest sorted list of ranges that cover every missing number exactly. That is, no element of nums is in any of the ranges,
and each missing number is in one of the ranges.

Each range [a,b] in the list should be output as:

"a->b" if a != b
"a" if a == b

Input: nums = [0,1,3,50,75], lower = 0, upper = 99
Output: ["2","4->49","51->74","76->99"]

Input: nums = [], lower = 1, upper = 1
Output: ["1"]

Input: nums = [], lower = -3, upper = -1
Output: ["-3->-1"]

Input: nums = [-1], lower = -1, upper = -1
Output: []

Input: nums = [-1], lower = -2, upper = -1
Output: ["-2"]
 */
public class MissingRanges {

    public static void main(String[] args) {
        MissingRanges missingRanges = new MissingRanges();
        System.out.println(missingRanges.findMissingRanges(new int[] {-1}, -2, -1));
    }

    public List<Integer> findMissingRanges(int[] nums, int lower, int upper) {

        int leftIndex = 1;
        int rightIndex = leftIndex + 1;

        List<Integer> result = new ArrayList<>();

        return result;
    }
}
