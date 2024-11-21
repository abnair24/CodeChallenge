package com.abn.learn.dsa.day8;

public class SubArraysInRange {

    public int[] solve(int[] A, int B, int C) {
        int len = C-B+1;
        int[] result = new int[len];
        int i = 0;

        while(B <= C) {
            result[i++] = A[B++];
        }

        return result;
    }

    public static void main(String[] args) {
        SubArraysInRange subArraysInRange = new SubArraysInRange();
        subArraysInRange.solve(new int[] {6,3,3,6,7,8,7,3,7}, 1, 2);
    }
}
