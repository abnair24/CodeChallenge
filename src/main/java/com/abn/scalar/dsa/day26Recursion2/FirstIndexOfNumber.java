package com.abn.scalar.dsa.day26Recursion2;

/*
You are given an array A of size N. Write a recursive function that returns the first index at which an integer B
is found in the array.

NOTE: If B is not found anywhere in the array then return -1.

A = [-3, 5, 6, 2]
B = 6

o/p: 2

A = [0, 1, 0, 2]
B = 3

o/p: -1
 */
public class FirstIndexOfNumber {

    public int firstIndex(int[] A, int B) {

        return getIndex(A, B, 0);
    }

    private int getIndex(int[] array, int B, int index) {

        if(index == array.length) {
            return -1;
        }

        if(array[index] == B) {
            return index;
        }
        return getIndex(array, B, index + 1);
    }

    public static void main(String[] args) {
        FirstIndexOfNumber firstIndexOfNumber = new FirstIndexOfNumber();
        System.out.println(firstIndexOfNumber.firstIndex(new int[] {-3, 5, 6, 2}, 6));
    }
}
