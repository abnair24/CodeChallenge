package com.abn.dsalgos.algo.twoPointers;

/*
 Input : 1, 10, 20, 0, 59, 63, 0, 88, 0
 output : 0, 0, 0, 1, 10, 20 59, 63, 88
 */

public class MoveZeroesToBeginning {

    public int[] moveZero(int[] array) {

        int slow = array.length - 1;
        for (int fast = array.length - 1; fast >= 0; fast--) {
            if (array[fast] != 0) {
                int temp = array[slow];
                array[slow] = array[fast];
                array[fast] = temp;
                slow--;
            }
        }

        return array;
    }
}
