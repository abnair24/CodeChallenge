package com.abn.dsalgos.glc;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

/*
An integer x is a good if after rotating each digit individually by 180 degrees,
we get a valid number that is different from x. Each digit must be rotated - we cannot choose to leave it alone.

A number is valid if each digit remains a digit after rotation. For example:

0, 1, and 8 rotate to themselves,
2 and 5 rotate to each other (in this case they are rotated in a different direction, in other words, 2 or 5 gets mirrored),
6 and 9 rotate to each other, and
the rest of the numbers do not rotate to any other number and become invalid.
Given an integer n, return the number of good integers in the range [1, n].

Input: n = 10
Output: 4
Explanation: There are four good numbers in the range [1, 10] : 2, 5, 6, 9.
 */
public class RotatedDigits {

    Map<Integer, Integer> map = new HashMap<>();

    public static void main(String[] args) {
        RotatedDigits rotate = new RotatedDigits();
        System.out.println(rotate.rotatedDigits(50));
    }

    public int rotatedDigits(int num) {

        map.put(0, 0);
        map.put(1, 1);
        map.put(2, 5);
        map.put(5, 2);
        map.put(6, 9);
        map.put(8, 8);
        map.put(9, 6);

        int count = 0;
        for (int i = 1; i <= num; i++) {
            if (valid(i)) {
                count++;
            }
        }
        return count;
    }

    private boolean valid(int num) {
        int r = 0;
        int result = 0;
        int number = num;
        LinkedList<Integer> list = new LinkedList<>();

        // Extract digits
        while (num > 0) {

            r = num % 10;
            if (map.containsKey(r)) {
                list.addFirst(map.get(r));
            } else {

                // if map doesnot contain digits, return false
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

}
