package com.abn.learn.dsa.day24BitManipulation2;

import java.util.ArrayList;

/*
Given an array of positive integers A, two integers appear only once, and all the other integers appear twice.
Find the two integers that appear only once.

Note: Return the two numbers in ascending order.

A = [1, 2, 3, 1, 2, 4]
o/p: [3, 4]

 */
public class TwoNumbersAppearTwice {

    public ArrayList<Integer> solve(ArrayList<Integer> A) {

        int len = A.size();

        int XY = 0;

        for(int num : A) {
            XY = XY ^ num;
        }

        int index = 0;

        for(int i = 0; i < 32; i++) {
            if((XY & (1 << i)) > 0) {
                index = i;
                break;
            }
        }

        int onesGroup = 0;
        int zeroesGroup = 0;

        for(int num : A) {
            if((num & (1 << index)) > 0) {
                onesGroup ^= num;
            } else {
                zeroesGroup ^= num;
            }
        }

        ArrayList<Integer> ans = new ArrayList<>();

        if(onesGroup < zeroesGroup) {
            ans.add(onesGroup);
            ans.add(zeroesGroup);
        } else {
            ans.add(zeroesGroup);
            ans.add(onesGroup);
        }

        return ans;
    }

    public static void main(String[] args) {

        TwoNumbersAppearTwice twoNumbersAppearTwice = new TwoNumbersAppearTwice();

        ArrayList<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(1);
        list.add(2);
        list.add(4);

        twoNumbersAppearTwice.solve(list);
    }
}
