package com.abn.scalar.dsa.day40;

/*
Given an array of integers A.


A represents a histogram i.e A[i] denotes the height of the ith histogram's bar. Width of each bar is 1.

Find the area of the largest rectangle formed by the histogram.
 */
public class LargestRectangleInHistogram {

    public int largestRectangleArea(int[] A) {

        int len = A.length;
        int[] left = new int[len];
        int[] right = new int[len];

        left[0] = -1;
        right[len - 1] = len;

        for(int i = 1; i < len; i++) {
            int p = i - 1;
            while(p >= 0 && A[p] >= A[i]) {
                p = left[p];
            }
            left[i] = p;
        }

        for(int i = len - 2; i >= 0; i--) {
            int p = i + 1;
            while(p < len && A[p] >= A[i]) {
                p = right[p];
            }
            right[i] = p;
        }

        int maxArea = 0;
        for(int i = 0; i < len; i++) {
            maxArea = Math.max(maxArea, A[i] * (right[i] - left[i] - 1));
        }
        return maxArea;
    }

    public static void main(String[] args) {
        LargestRectangleInHistogram largestRectangleInHistogram = new LargestRectangleInHistogram();

        System.out.println(largestRectangleInHistogram.largestRectangleArea(new int[] {2, 1, 5, 6, 2, 3}));
    }
}
