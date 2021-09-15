package com.abn.dsalgos.glc;

import org.testng.Assert;

/*
https://leetcode.com/problems/string-to-integer-atoi/

Input: s = "42"
Output: 42

Input: s = "   -42"
Output: -42

Input: s = "4193 with words"
Output: 4193

Input: s = "words and 987"
Output: 0

Input: s = "-91283472332"
Output: -2147483648

*/

public class StringToInteger {

    int maxValue = Integer.MAX_VALUE;
    int minValue = Integer.MIN_VALUE;

    public int myAtoi(String s1) {

        String s = s1.trim();
        StringBuilder str = new StringBuilder();

        if (s.length() == 0) {
            return 0;
        }

        char firstNonSpaceChar = s.charAt(0);
        int multiplier = 1;
        int startPointer = 0;

        // Handle any char other than digits in the beginning after whitespace trim.
        if (Character.isLetter(firstNonSpaceChar) || firstNonSpaceChar == '.') {
            return 0;
        }

        //Handle positive number and negative signs
        if (firstNonSpaceChar == '+') {
            multiplier = 1;
            startPointer = 1;
        } else if (firstNonSpaceChar == '-') {
            multiplier = -1;
            startPointer = 1;
        }

        // Handle single length string with '+' / '-' only.
        if (s.length() == 1 && startPointer == 1) {
            return 0;
        }

        while (s.charAt(startPointer) == '0') {
            startPointer++;
            if (startPointer == s.length()) {
                return 0;
            }
        }

        for (int i = startPointer; i < s.length(); i++) {
            char currChar = s.charAt(i);
            if (!Character.isDigit(currChar)) {
                break;
            }
            str.append(currChar);
        }

        return convertToInt(str, multiplier);
    }

    private int convertToInt(StringBuilder intAsString, int multiplier) {
        if (multiplier == 1) {

            if (isMoreThanLimit(intAsString, maxValue)) {
                return maxValue;
            }
            return safeConvert(intAsString);

        } else {

            if (isMoreThanLimit(intAsString, minValue)) {
                return minValue;
            }
            return -1 * safeConvert(intAsString);
        }
    }

    private int safeConvert(StringBuilder intAsString) {
        int result = 0;

        for (int i = 0; i < intAsString.length(); i++) {
            result = result * 10 + intAsString.charAt(i) - '0';
        }
        return result;
    }

    //Check whether string is more than integer limit or not if string has same length of digits as limit
    //Testcase : 16
    private boolean isMoreThanLimit(StringBuilder intAsString, int limit) {
        String limitAsString = "" + limit;

        if (limitAsString.charAt(0) == '-') {
            limitAsString = limitAsString.substring(1);
        }

        if (intAsString.length() == limitAsString.length()) {

            for (int i = 0; i < intAsString.length(); i++) {
                int currDigitInString = intAsString.charAt(i) - '0';

                int currDigitInLimit = limitAsString.charAt(i) - '0';

                if (currDigitInString < currDigitInLimit) {
                    return false;
                }
                if (currDigitInString > currDigitInLimit) {
                    return true;
                }
            }
            return true;
        }

        return intAsString.length() > limitAsString.length();
    }

    public static void main(String[] args) {
        Assert.assertEquals(new StringToInteger().myAtoi("435"), 435);
        Assert.assertEquals(new StringToInteger().myAtoi("word and 943"), 0);
        Assert.assertEquals(new StringToInteger().myAtoi("-91283472332"), -2147483648);
        Assert.assertEquals(new StringToInteger().myAtoi("3.45"), 3);
        Assert.assertEquals(new StringToInteger().myAtoi("-109394"), -109394);
        Assert.assertEquals(new StringToInteger().myAtoi("-9223372036854775809"), -2147483648);
        Assert.assertEquals(new StringToInteger().myAtoi("9223372036854775808"), 2147483647);
        Assert.assertEquals(new StringToInteger().myAtoi("           45"), 45);
        Assert.assertEquals(new StringToInteger().myAtoi("18446744073709551617"), 2147483647);
        Assert.assertEquals(new StringToInteger().myAtoi("  0000000000012345678"), 12345678);
        Assert.assertEquals(new StringToInteger().myAtoi("+"), 0);
        Assert.assertEquals(new StringToInteger().myAtoi("-"), 0);
        Assert.assertEquals(new StringToInteger().myAtoi("    000   "), 0);
        Assert.assertEquals(new StringToInteger().myAtoi("    00011   "), 11);
        Assert.assertEquals(new StringToInteger().myAtoi("1095502006p8"), 1095502006);
        Assert.assertEquals(new StringToInteger().myAtoi("2147483800"), 2147483647);
        Assert.assertEquals(new StringToInteger().myAtoi("          "), 0);
    }
}
