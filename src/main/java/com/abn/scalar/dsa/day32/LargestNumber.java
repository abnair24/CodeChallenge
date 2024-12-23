package com.abn.scalar.dsa.day32;

import java.util.Arrays;
import java.util.Comparator;

/*
Given a list of non-negative integers nums, arrange them such that they form the largest number and return it.
Since the result may be very large, so you need to return a string instead of an integer.

Example 1:
Input: nums = [10,2] Output: "210"

Example 2:
Input: nums = [3,30,34,5,9] Output: "9534330"\

input: 10,5 2 8,200
output: 85220010
 */
public class LargestNumber {

    public String solve(int[] array) {

        Integer[] a = new Integer[array.length];

        for(int i = 0; i < array.length; i++) {

            a[i] = array[i];
        }

        Arrays.sort(a, new Comparator<Integer>() {
            public int compare(Integer x, Integer y) {
                String xy = x + String.valueOf(y);
                String yx = y + String.valueOf(x);

                return xy.compareTo(yx) < 0 ? 1 : -1;

            }});

        StringBuilder sb = new StringBuilder();

        for(int n : a) {
            sb.append(n);
        }

        if(sb.charAt(0) == '0') {
            return "0";
        }

        return sb.toString();
    }

    public static void main(String[] args) {

        LargestNumber largestNumber = new LargestNumber();
        System.out.println(largestNumber.solve(new int[] {3,30,34,5,9}));
        System.out.println(largestNumber.solve(new int[] {10,5, 2, 8, 200}));
    }
}
