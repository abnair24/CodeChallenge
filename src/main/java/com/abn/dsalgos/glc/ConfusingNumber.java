package com.abn.dsalgos.glc;

import org.testng.Assert;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

/*
A confusing number is a number that when rotated 180 degrees becomes a different number with each digit valid.

We can rotate digits of a number by 180 degrees to form new digits.

When 0, 1, 6, 8, and 9 are rotated 180 degrees, they become 0, 1, 9, 8, and 6 respectively.
When 2, 3, 4, 5, and 7 are rotated 180 degrees, they become invalid.
Note that after rotating a number, we can ignore leading zeros.

For example, after rotating 8000, we have 0008 which is considered as just 8.
Given an integer n, return true if it is a confusing number, or false otherwise.

Input: n = 6
Output: true
Explanation: We get 9 after rotating 6, 9 is a valid number, and 9 != 6.

Input: n = 89
Output: true
Explanation: We get 68 after rotating 89, 86 is a valid number and 86 != 89.

Input: n = 25
Output: false
Explanation: We get an invalid number after rotating 25.
 */
public class ConfusingNumber {

    Map<Integer, Integer> map = new HashMap<>();

    public boolean isConfusing(int n) {

        map.put(0, 0);
        map.put(1, 1);
        map.put(6, 9);
        map.put(8, 8);
        map.put(9, 6);

        return isValid(n);
    }

    private boolean isValid(int num) {
        int r = 0;
        int result = 0;
        int number = num;
        LinkedList<Integer> list = new LinkedList<>();

        // Extract digits
        while (num > 0) {

            r = num % 10;
            if (map.containsKey(r)) {
                list.add(map.get(r));
            } else {
                return false;
            }
            num /= 10;
        }

        // Form rotated number
        for (int i = 0; i < list.size(); i++) {
            result = result * 10 + list.get(i);
        }

        return result != number ? true : false;
    }

    public static void main(String[] args) {

        ConfusingNumber confusingNumber = new ConfusingNumber();
        Assert.assertFalse(confusingNumber.isConfusing(56));
        Assert.assertTrue(confusingNumber.isConfusing(86));
        Assert.assertTrue(confusingNumber.isConfusing(186));
    }
}
