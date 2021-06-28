package com.abn.dsalgos.leetcode30Day;

/*
 Input : 1, 10, 20, 0, 59, 63, 0, 88, 0
 output : 0, 0, 0, 1, 10, 20 59, 63, 88
 */

public class MoveZeroesToBeginning {

    public int[] moveZero(int[] array) {
        int readIndex = array.length-1;
        int writeIndex = array.length -1;

        while(readIndex >= 0) {
            if(array[readIndex] !=0) {
                array[writeIndex]= array[readIndex];
                writeIndex --;
            }
            readIndex --;
        }
        while(writeIndex >= 0) {
            array[writeIndex--] = 0;
        }

        return array;
    }
}
