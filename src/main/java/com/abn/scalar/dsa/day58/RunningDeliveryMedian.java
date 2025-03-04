package com.abn.scalar.dsa.day58;

import java.util.Arrays;
import java.util.PriorityQueue;

/*
Given an array of integers, A denoting the delivery times for each order. New arrays of integer B and C are formed, each time a new delivery data is encountered, append it at the end of B and append the median of array B at the end of C. Your task is to find and return the array C.

NOTE:

If the number of elements is N in B and N is odd, then consider the median as B[N/2] ( B must be in sorted order).
If the number of elements is N in B and N is even, then consider the median as B[N/2-1]. ( B must be in sorted order).

 A = [1, 2, 5, 4, 3]
 Output 1:

 [1, 1, 2, 2, 3]

 A = [5, 17, 100, 11]
 Output 2:

 [5, 5, 17, 11]
 */
public class RunningDeliveryMedian {

    PriorityQueue<Integer> minHeap = new PriorityQueue<>();
    PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b)-> (b - a));

    public int[] solve(int[] A) {

        int[] result = new int[A.length];
        for(int i = 0; i < A.length; i ++) {

            insert(A[i]);
            rebalance();
            result[i] = findMedian();
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

    private int findMedian() {
      return maxHeap.peek();
    }

    public static void main(String[] args) {

        RunningDeliveryMedian runningDeliveryMedian = new RunningDeliveryMedian();
        System.out.println(Arrays.toString(runningDeliveryMedian.solve(new int[] {59,64,10,39})));
    }
}
