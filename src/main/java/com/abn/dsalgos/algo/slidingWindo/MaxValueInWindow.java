package com.abn.dsalgos.algo.slidingWindo;

/*
You are given an array of integers nums, there is a sliding window of size k which is moving from
the very left of the array to the very right. You can only see the k numbers
in the window. Each time the sliding window moves right by one position.
 */

//TODO
public class MaxValueInWindow {

    public int[] maxSlidingWindow(int[] arr, int k) {
        int[] array = new int[arr.length - k + 1];

        int start = 0;
        int max = 0;
        int count = 0;

        if (k == 1) {
            return arr;
        }

        for (int i = 0; i < arr.length; i++) {

            max = Math.max(max, arr[i]);

            int len = i - start + 1;
            if (len == k) {
                array[start] = max;
                start++;
                max = arr[start];
            }
        }
        return array;
    }

    public static void main(String[] args) {
        MaxValueInWindow maxValueInWindow = new MaxValueInWindow();
        maxValueInWindow.maxSlidingWindow(new int[] {1, 6, 5, 4, 2, 7, 9}, 3);
    }

}
