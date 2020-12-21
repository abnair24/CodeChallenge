package com.abn.dsalgos.challenges.problems;

/*
Given an integer, rotate array k times based on left or right as passed in parameter

input = [1,2,3,4,5,6,7], k = 5, shift = left
output = [6,7,1,2,3,4,5]

input = [1,2,3,4,5,6,7] k = 4, shift = right
output = [4,5,6,7,1,2,3]
 */

public class RotateArrayKtimes {

    /*
    public int[] rotateArray(int[] array,int shift) {

        int length = array.length;
        if(length == 0 || length == 1) {
            return array;
        }
        int[] temp = new int[length];
        int x = shift % length;
        if(x == 0) {
            return array;
        }

        for(int i= 0; i< length - x;i ++) {
            temp[i]= array[i+x];
        }

        for(int i = length-x; i< length ;i++) {
            temp[i]= array[i - (length-x)];
        }
        return temp;
    }

     */

    // O(n) time and O(1) space

    // shiftSide : true -> left, false -> right

    public int[] rotateArray(int[] array, int shift, boolean shiftSide) {
        int len = array.length;
        if(len == 0 || len == 1) {
            return array;
        }

        int x = shift % len;
        if(x == 0) {
            return array;
        }

        reverse(array, 0, len - 1);

        if(shiftSide) {
            reverse(array, 0, len - x - 1);
            reverse(array, len - x, len - 1);
        } else {
            reverse(array, 0, x-1);
            reverse(array, x, len-1);
        }

        return array;
    }

    private void reverse(int[] array, int start, int end) {

        while(start <= end) {
            int temp = array[start];
            array[start] = array[end];
            array[end] = temp;
            start ++;
            end --;
        }
    }
}

