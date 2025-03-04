package com.abn.scalar.dsa.day58;

import java.util.Arrays;
import java.util.PriorityQueue;

/*
Given an integer array, nums, and an integer, k, there is a sliding window of size k,
which is moving from the very left to the very right of the array. We can only see the k numbers in the window. Each time the sliding window moves right by one position.

Given this scenario, return the median of the each window. Answers within
 of the actual value will be accepted.
 */
public class SlidingWindowMedian {

    PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a,b) -> (b-a));
    PriorityQueue<Integer> minHeap = new PriorityQueue<>();


    public double[] solve(int[] array, int k) {

        int medianArraySize = array.length - k + 1;
        double[] result = new double[medianArraySize];

        for(int i = 0; i < array.length; i++) {

            insert(array[i]);
            rebalance();

            if(i + 1 - k >= 0) {
                result[i + 1 - k] = findMedian();

                windowRebalance(array, k, i);

                rebalance();
            }
        }
        return result;
    }

    private void insert(int num) {

        if(maxHeap.isEmpty() || maxHeap.peek() > num) {
            maxHeap.offer(num);
        } else {
            minHeap.offer(num);
        }
    }

    private void rebalance() {

        if(maxHeap.size() - minHeap.size() > 1) {
            minHeap.offer(maxHeap.poll());
        } else if(maxHeap.size() < minHeap.size()) {
            maxHeap.offer(minHeap.poll());
        }
    }

    private double findMedian() {

        if(maxHeap.size() == minHeap.size()) {
            return (maxHeap.peek() + minHeap.peek()) / 2.0;
        } else {
           return maxHeap.peek();
        }
    }

    private void windowRebalance(int[] array, int k, int index) {

        if(maxHeap.peek() >= array[index + 1 - k]) {
            maxHeap.remove(array[index + 1 -k]);
        } else {
            minHeap.remove(array[index + 1 - k]);
        }
    }

    public static void main(String[] args) {

        SlidingWindowMedian slidingWindowMedian = new SlidingWindowMedian();
        System.out.println(Arrays.toString(slidingWindowMedian.solve(new int[] {1, 3, -1, 2, -2, -3, 5, 1, 5, 3}, 4)));
        System.out.println(Arrays.toString(slidingWindowMedian.solve(new int[] {4, 7, 2, 21}, 2)));

    }
}

