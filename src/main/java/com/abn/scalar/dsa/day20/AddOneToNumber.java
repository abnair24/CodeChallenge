package com.abn.scalar.dsa.day20;


import java.util.Arrays;

/*
Given a non-negative number represented as an array of digits, add 1 to the number ( increment the number represented by the digits ).

The digits are stored such that the most significant digit is at the head of the list.

NOTE: Certain things are intentionally left unclear in this question which you should practice asking the interviewer.
For example: for this problem, the following are some good questions to ask :

Q: Can the input have 0's before the most significant digit. Or, in other words, is 0 1 2 3 a valid input?
A: For the purpose of this question, YES
Q: Can the output have 0's before the most significant digit? Or, in other words, is 0 1 2 4 a valid output?
A: For the purpose of this question, NO. Even if the input has zeroes before the most significant digit.

input  {9}
o/p: {1, 0}

input: {9, 9, 9}
o/p: {1, 0, 0, 0}

input: {1, 2. 3}
o/p: {1, 2, 4}

input: {1, 2, 9}
o/p: {1, 3, 0}

input: {0, 1, 2}
o/p: {1, 3}

 */

public class AddOneToNumber {

    public int[] plusOne(int[] digits) {

        int len = digits.length;
        int size = 0;
        int k = 0;

        while(digits[k] == 0 && digits.length > 1) {
            size = digits.length - k - 1;
            k++;
        }

        for(int i = len - 1; i >= 0; i--){
            if(digits[i] == 9) {
                digits[i] = 0;
            } else {
                digits[i]++;
                if(digits[0] == 0 && digits.length > 1) {
                    int index = 0;
                    int[] result = new int[size];
                    for(int j = k; j < digits.length; j++) {
                        result[index] = digits[j];
                        index++;
                    }
                    return result;
                }
                return digits;
            }
        }
        digits = new int[len + 1];
        digits[0] = 1;
        return digits;
    }

    public static void main(String[] args) {

        AddOneToNumber addOneToNumber = new AddOneToNumber();
        System.out.println(Arrays.toString(addOneToNumber.plusOne(new int[] { 0, 9 })));
        System.out.println(Arrays.toString(addOneToNumber.plusOne(new int[] {0, 3, 7, 6, 4, 0, 5, 5, 5})));
    }
}
