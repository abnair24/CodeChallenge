package com.abn.dsalgos.leetcode30Day;

public class MoveZeroesToEndInPlace {
    /*
    Given an array nums, write a function to move all 0's to the end of it while
    maintaining the relative order of the non-zero elements.

    Input: [0,1,0,3,12]
    Output: [1,3,12,0,0]
     */

    public int[] pushZeroes(int[] arr) {

        int start = 0;
        int second = start + 1;
        int len = arr.length;

        while (second < len) {
            if (arr[start] != 0) {
                ++start;
                ++second;
            } else if (arr[second] == 0) {
                ++second;
            } else if (arr[start] == 0) {
                int temp = arr[start];
                arr[start] = arr[second];
                arr[second] = temp;
                ++start;
                ++second;
            }
        }
        return arr;
    }

    public int[] push(int[] arr) {
        int readIndex = 0;
        int writeIndex = 0;
        int len = arr.length;

        while (readIndex < len) {
            if (arr[readIndex] != 0) {
                arr[writeIndex] = arr[readIndex];
                writeIndex++;
            }
            readIndex++;
        }

        while (writeIndex < len) {
            arr[writeIndex++] = 0;
        }

        return arr;
    }
}
