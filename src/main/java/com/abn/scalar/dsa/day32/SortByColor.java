package com.abn.scalar.dsa.day32;

import java.util.Arrays;

/*
Given an array with N objects colored red, white, or blue, sort them so that objects of the same color are adjacent,
with the colors in the order red, white, and blue.

We will represent the colors as,

red -> 0
white -> 1
blue -> 2

Note: Using the library sort function is not allowed.

Input 1 :
    A = [0, 1, 2, 0, 1, 2]
Input 2:

    A = [0]


Example Output

Output 1:
    [0, 0, 1, 1, 2, 2]
Output 2:

    [0]

 */
public class SortByColor {

    public int[] sortColors(int[] A) {

        int[] freq = new int[3];

        for(int i = 0; i < A.length; i++) {
            freq[A[i]]++;
        }

        int index = 0;
        for(int i = 0; i < freq.length; i ++) {
            while(freq[i] > 0) {
                A[index++] = i;
                freq[i] --;
            }
        }

        return A;
    }

    public static void main(String[] args) {

        SortByColor sortByColor = new SortByColor();
        System.out.println(Arrays.toString(sortByColor.sortColors(new int[] {0, 1, 2, 0, 1, 2})));
    }
}
