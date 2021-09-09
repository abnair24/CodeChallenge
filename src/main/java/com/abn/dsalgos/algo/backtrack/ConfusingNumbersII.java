package com.abn.dsalgos.algo.backtrack;

import org.testng.Assert;

import java.util.LinkedList;
import java.util.List;

/*
A confusing number is a number that when rotated 180 degrees becomes a different number with each digit valid.

We can rotate digits of a number by 180 degrees to form new digits.

When 0, 1, 6, 8, and 9 are rotated 180 degrees, they become 0, 1, 9, 8, and 6 respectively.
When 2, 3, 4, 5, and 7 are rotated 180 degrees, they become invalid.
Note that after rotating a number, we can ignore leading zeros.

For example, after rotating 8000, we have 0008 which is considered as just 8.
Given an integer n, return the number of confusing numbers in the inclusive range [1, n].

Input: n = 20
Output: 6
Explanation: The confusing numbers are [6,9,10,16,18,19].
 */
public class ConfusingNumbersII {

    List<List<Integer>> result = new LinkedList<>();
    int[] rotateValues = {0, 1, -1, -1, -1, -1, 9, -1, 8, 6};

    public int permute(int n) {

        LinkedList<Integer> track = new LinkedList<>();

        int[] valid = {0, 1, 6, 8, 9};

        backtrack(n, valid, 0, track);
        return result.size();
    }

    private void backtrack(int n, int[] valid, int index, LinkedList<Integer> track) {

        int num = 0;
        if (!track.isEmpty()) {
            num = getNumber(track);
        }

        if (num > n) {
            return;
        }

        if (num != 0 && num <= n) {
            if(isConfusedNumber(num)) {
                result.add(new LinkedList<>(track));
            }
        }

        if(num * 10 > n) {
            return;
        }

        for (int i = 0; i < valid.length; i++) {

            if (track.isEmpty() && valid[i] == 0) {
                continue;
            }

            track.add(valid[i]);
            backtrack(n, valid, index + 1, track);
            track.removeLast();
        }
    }

    private int getNumber(LinkedList<Integer> track) {

        int number = 0;
        for (int i = 0; i < track.size(); i++) {
            number = number * 10 + track.get(i);
        }
        return number;
    }

    private boolean isConfusedNumber(int num) {

        int temp = num;
        int res = 0;

        while (temp > 0) {

            int digit = temp % 10;
            res = res * 10 + rotateValues[digit];

            temp /= 10;
        }
        return res != num;
    }

    public static void main(String[] args) {
        //Timing out for below number. Except this one, all cases are passing
//        System.out.println(new ConfusingNumbersII().permute(1000000000));

        Assert.assertEquals(new ConfusingNumbersII().permute(10), 3);
        Assert.assertEquals(new ConfusingNumbersII().permute(20), 6);
        Assert.assertEquals(new ConfusingNumbersII().permute(100), 19);
        Assert.assertEquals(new ConfusingNumbersII().permute(100000000), 389627);
        Assert.assertEquals(new ConfusingNumbersII().permute(3999819), 30976);
    }
}
