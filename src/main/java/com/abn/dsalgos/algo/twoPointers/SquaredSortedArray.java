package com.abn.dsalgos.algo.twoPointers;

public class SquaredSortedArray {

    public int[] squares(int[] array) {
        int len = array.length;
        int[] sqArray = new int[len];
        int startPtr = 0;
        int endPtr = array.length -1;

        for(int i = len-1; i >=0; i--) {
            int leftSquare = array[startPtr] * array[startPtr];
            int rightSquare = array[endPtr] * array[endPtr];

            if (Math.abs(array[startPtr]) > array[endPtr]) {
                sqArray[i] = leftSquare;
                startPtr++;
            } else {
                sqArray[i] = rightSquare;
                endPtr--;
            }
        }
        return sqArray;
    }
}
