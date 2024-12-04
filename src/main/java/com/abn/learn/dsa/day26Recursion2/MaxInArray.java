package com.abn.learn.dsa.day26Recursion2;

/*
Given an array A of size N, write a recursive function that returns the maximum element of the array.
 */
public class MaxInArray {

    public int getMax(int[] A) {

        return findMax(A, 0, Integer.MIN_VALUE);
    }

    private int findMax(int[] array, int index, int maximum) {

        if(index == array.length) {
            return maximum;
        }

        maximum = Math.max(array[index], maximum);
        return findMax(array, (index + 1), maximum);
    }

    public static void main(String[] args) {

        MaxInArray maxInArray = new MaxInArray();
        System.out.println(maxInArray.getMax(new int[] {4, 5, -1, 2, 9, 3, 8, 0}));
    }
}
