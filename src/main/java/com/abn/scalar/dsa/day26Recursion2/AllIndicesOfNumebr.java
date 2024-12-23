package com.abn.scalar.dsa.day26Recursion2;

import java.util.Arrays;

/*
Given an array of integers A with N elements a target
integer B, find all indices at which B occurs in
the array
It is guaranteed that B exists atleast once in the array

A = [4 5 3 1 5 4 5 ] B= 5

o/p: [1, 4, 6]
 */
public class AllIndicesOfNumebr {

    public int[] solve(int[] array, int B) {
        return getIndex(array, B, 0, 0);
    }

    private int[] getIndex(int[] array, int B, int index, int count) {

        if(index == array.length) {

            return new int[count];
        }

        if(array[index] == B) {
            int[] ans = getIndex(array, B, index + 1, count + 1);
            ans[count] = index;
            return ans;
        } else {
            return getIndex(array, B, index + 1, count);
        }

    }

    public static void main(String[] args) {
        AllIndicesOfNumebr allIndicesOfNumebr = new AllIndicesOfNumebr();
        System.out.println(Arrays.toString(allIndicesOfNumebr.solve(new int[] {4, 5, 3, 1, 5, 4, 5}, 5)));
    }
}
