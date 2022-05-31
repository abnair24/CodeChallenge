package com.abn.dsalgos.dailyCoding;

/*
Write a program that checks whether an integer is a palindrome.
For example, 121 is a palindrome, as well as 888. 678 is not a palindrome.
Do not convert the integer into a string.

DCP : #788
 */
public class IntegerPalindrome {

    public boolean isPalindrome(int number) {

        int result = 0;
        int num = number;

        while(number > 0) {
            int rem = number % 10;
            result =  result * 10 + rem;
            number = number /10;
        }

        return num == result ? true : false;
    }
}
