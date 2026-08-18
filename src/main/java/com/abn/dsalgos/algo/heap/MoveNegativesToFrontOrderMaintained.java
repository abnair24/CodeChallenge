package com.abn.dsalgos.algo.heap;



// Given an array of integers, move all negative numbers to the front of the array while maintaining the order of the positive numbers. The solution should be
// done in-place with O(n) time complexity and O(n) space complexity.
public class MoveNegativesToFrontOrderMaintained {

    public int[] moveNegativesToFront(int[] arr) {
        int n = arr.length;
        int[] neg = new int[n];
        int[] pos = new int[n];
        int ni = 0;
        int pi = 0;

        for(int i = 0; i < n; i++) {
            if(arr[i] < 0) {
                neg[ni++] = arr[i];
            } else {
                pos[pi++] = arr[i];
            }
        }

        int index = 0;
        for(int i = 0; i < ni; i++) {
            arr[index ++] = neg[i];
        }

        for(int i = 0; i < pi; i++) {
            arr[index ++] = pos[i];
        }
        return arr;
    }
}
