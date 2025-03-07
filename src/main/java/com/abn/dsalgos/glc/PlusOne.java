package com.abn.dsalgos.glc;

import java.util.Arrays;

/*
You are given a large integer represented as an integer array digits, where each digits[i]
is the ith digit of the integer. The digits are ordered from most significant to least significant in left-to-right order. The large integer does not contain any leading 0's.

Increment the large integer by one and return the resulting array of digits.

Input: digits = [1,2,3]
Output: [1,2,4]
Explanation: The array represents the integer 123.
Incrementing by one gives 123 + 1 = 124.
Thus, the result should be [1,2,4].

Input: digits = [9]
Output: [1,0]
Explanation: The array represents the integer 9.
Incrementing by one gives 9 + 1 = 10.
Thus, the result should be [1,0].

 */
public class PlusOne {

    public int[] plusOne(int[] digits) {
        int len = digits.length;

        for(int i = len - 1; i >= 0; i--){
            if(digits[i] == 9) {
                digits[i] = 0;
            } else {
                digits[i]++;

                return digits;
            }
        }
        digits = new int[len + 1];
        digits[0] = 1;
        return digits;
    }

    public static void main(String[] args) {
        PlusOne plus = new PlusOne();

        int[] input1 = {1, 2, 3};
        int[] input2= {9};
        int[] input3 = {1, 2, 9};

        System.out.println(Arrays.toString(plus.plusOne(input1)));
        System.out.println(Arrays.toString(plus.plusOne(input2)));
        System.out.println(Arrays.toString(plus.plusOne(input3)));

    }
}
