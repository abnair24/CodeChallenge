package com.abn.learn.dsa.day26Recursion2;

/*
You are given an array A of size N. Write a recursive function that returns the last index at which an integer B is found in the array.

NOTE: If B is not found anywhere in the array then return -1.

A = [6, 5, 6, 2]
B = 6

o/p: 2
 */
public class LastIndexOfNumber {

    public int lastIndex(int[] A, int B) {
        int initialIndex = -1;
        return getIndex(A, B, 0, initialIndex);
    }

    private int getIndex(int[] array, int B, int index, int initialIndex) {
        if(index == array.length) {
            return initialIndex;
        }

        if(array[index] == B) {
            initialIndex = index;
        }
        return getIndex(array, B, index + 1, initialIndex);
    }

    public static void main(String[] args) {

        LastIndexOfNumber lastIndexOfNumber = new LastIndexOfNumber();
        System.out.println(lastIndexOfNumber.lastIndex(new int[] {6, 5, 6, 2}, 6));
    }
}
