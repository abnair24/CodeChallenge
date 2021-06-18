package com.abn.dsalgos.algo.heap;

import java.util.Collections;
import java.util.PriorityQueue;

/*
Given an array of numbers and a number ‘k’, find the median of all the ‘k’ sized sub-arrays (or windows) of the array.

Input: nums=[1, 2, -1, 3, 5], k = 2
Output: [1.5, 0.5, 1.0, 4.0]

Explanation:

[(1, 2), -1, 3, 5] -> median is 1.5
[1, (2, -1), 3, 5] -> median is 0.5
[1, 2, (-1, 3), 5] -> median is 1.0
[1, 2, -1, (3, 5)] -> median is 4.0

 */
public class MedianSlidingWindow {

    PriorityQueue<Integer> max;
    PriorityQueue<Integer> min;

    public MedianSlidingWindow() {
        max = new PriorityQueue<>(Collections.reverseOrder());
        min = new PriorityQueue<>();
    }

    public double[] medianSliding(int[] input, int window) {


        double[] result = new double[input.length - window + 1];

        for (int i = 0; i < input.length; i++) {

            insert(input[i]);

            rebalance();

            if (i + 1 - window >= 0) {

                result[i + 1 - window] = findMedian();

                if (max.peek() >= input[i + 1 - window]) {
                    max.remove(input[i + 1 - window]);
                } else {
                    min.remove(input[i + 1 - window]);
                }

                rebalance();
            }
        }
        return result;
    }

    private void insert(int num) {
        if (max.isEmpty() || max.peek() > num) {
            max.add(num);
        } else {
            min.add(num);
        }
    }

    private void rebalance() {
        if (max.size() - min.size() > 1) {
            min.add(max.poll());
        } else if (max.size() < min.size()) {
            max.add(min.poll());
        }
    }

    private double findMedian() {

        if (max.size() == min.size()) {
            return (max.peek() + min.peek()) / 2.0;
        } else {
            return max.peek();
        }
    }
}
