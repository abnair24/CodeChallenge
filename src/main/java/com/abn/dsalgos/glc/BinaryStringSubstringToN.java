package com.abn.dsalgos.glc;

/*
Given a binary string s and a positive integer n, return true if the binary representation of all
the integers in the range [1, n] are substrings of s, or false otherwise.

A substring is a contiguous sequence of characters within a string.

Input: s = "0110", n = 3
Output: true
Input: s = "0110", n = 4
Output: false

 */
public class BinaryStringSubstringToN {

    public boolean queryString(String s, int n) {

        boolean status = false;
        for(int i = 1; i <= n; i ++) {
            String b = String.valueOf(decToBin(i));
            if(!s.contains(b)) {
                return false;
            }
        }
        return true;
    }

    private int decToBin(int number) {

        if (number <= 1) {
            return number;
        } else {

            return number % 2 + 10 * decToBin(number / 2);
        }
    }

    public static void main(String[] args) {

        System.out.println(new BinaryStringSubstringToN().queryString("110101011011000011011111000000", 15));
    }


}
