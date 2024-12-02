package com.abn.learn.dsa.day24BitManipulation2;

import java.util.ArrayList;
import java.util.Arrays;

/*
Given an array A of length N where all the elements are distinct and are in the range [1, N+2].

Two numbers from the range [1, N+2] are missing from the array A. Find the two missing numbers.

A = [3, 2, 4]
[1, 5]

Approach:
we will calculate the xor of all the elements of the array and
xor this value will all integers from 1 to N+2.
Finally, we will have the xor of the two missing numbers.

Let the missing numbers be X and Y
A bit is set in xor only if corresponding bits in X and Y are different.

So, we find one of the set bits of X^Y and then divide all the element with
that bit set in one group and those with that bit unset in another group.

Here, both X and Y will belong to different group. We can easily find the
missing number in each group.
 */
public class TwoMissingNumbers {

    public ArrayList<Integer> solve(ArrayList<Integer> A) {

        int XY = 0;

        // First XOR loop of all array elements
        for (int i = 0; i < A.size(); i++) {
            XY = XY ^ A.get(i);
        }

        // Second loop to XOR from 1 to N+2
        for (int i = 1; i <= A.size() + 2; i++) {
            XY = XY ^ i;
        }

        int index = 0;

        for (int i = 0; i < 32; i++) {          // To find the recent set bit position
            if ((XY & (1 << i)) != 0) {
                index = i;
                break;
            }
        }

        int onesGroup = 0;
        int zerosGroup = 0;

        // Performing XOR on set bit position for all array elements
        for (int num : A) {
            if ((num & (1 << index)) != 0) {
                onesGroup = onesGroup ^ num;
            } else {
                zerosGroup = zerosGroup ^ num;
            }
        }

        for (int num = 1; num <= A.size() + 2; num++) {
            if ((num & (1 << index)) != 0) {       // Performing XOR on set bit position from 1 to N+2
                onesGroup = onesGroup ^ num;
            } else {
                zerosGroup = zerosGroup ^ num;
            }
        }

        ArrayList<Integer> ans = new ArrayList<>();

        if (onesGroup < zerosGroup) {
            ans.add(onesGroup);
            ans.add(zerosGroup);
        } else {
            ans.add(zerosGroup);
            ans.add(onesGroup);
        }
        return ans;
    }

    public static void main(String[] args) {

        TwoMissingNumbers twoMissingNumbers = new TwoMissingNumbers();

        ArrayList<Integer> input = new ArrayList<>();
        input.add(2);
        input.add(3);
        input.add(4);
        twoMissingNumbers.solve(input);
    }
}
