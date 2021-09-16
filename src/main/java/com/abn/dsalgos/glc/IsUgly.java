package com.abn.dsalgos.glc;

import org.testng.Assert;

/*
An ugly number is a positive integer whose prime factors are limited to 2, 3, and 5.

Given an integer n, return true if n is an ugly number.

Input: n = 6
Output: true
Explanation: 6 = 2 × 3

Input: n = 8
Output: true
Explanation: 8 = 2 × 2 × 2

Input: n = 14
Output: false
Explanation: 14 is not ugly since it includes the prime factor 7.

Input: n = 1
Output: true
 */
public class IsUgly {

    public boolean isUgly(int num) {

        while(num % 2 == 0) {
            num /= 2;
        }

        while(num % 3 == 0) {
            num /= 3;
        }

        while(num % 5 == 0) {
            num /= 5;
        }

        return num == 1;
    }

    public static void main(String[] args) {
        IsUgly ugly = new IsUgly();
        Assert.assertTrue(ugly.isUgly(4));
        Assert.assertTrue(ugly.isUgly(9));
        Assert.assertTrue(ugly.isUgly(12));
        Assert.assertFalse(ugly.isUgly(11));
        Assert.assertFalse(ugly.isUgly(14));
        Assert.assertFalse(ugly.isUgly(26));
        Assert.assertFalse(ugly.isUgly(13));
    }
}
