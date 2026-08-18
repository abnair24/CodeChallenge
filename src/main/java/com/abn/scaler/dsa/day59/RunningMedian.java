package com.abn.scaler.dsa.day59;

import java.util.PriorityQueue;

/*
Flipkart is currently dealing with the difficulty of precisely estimating and displaying the expected delivery time for orders to a specific pin code. The existing method relies on historical delivery time data for that pin code, using the median value as the expected delivery time. As the order history expands with new entries, Flipkart aims to enhance this process by dynamically updating the expected delivery time whenever a new delivery time is added. The objective is to find the expected delivery time after each new element is incorporated into the list of delivery times. End Goal: With every addition of new delivery time, requirement is to find the median value.

Why Median ? The median is calculated because it provides a more robust measure of the expected delivery time The median is less sensitive to outliers or extreme values than the mean. In the context of delivery times, this is crucial because occasional delays or unusually fast deliveries (outliers) can skew the mean significantly, leading to inaccurate estimations.


Given an array of integers, A denoting the delivery times for each order. New arrays of integer B and C are formed, each time a new delivery data is encountered, append it at the end of B and append the median of array B at the end of C. Your task is to find and return the array C.

NOTE:

If the number of elements is N in B and N is odd, then consider the median as B[N/2] ( B must be in sorted order).
If the number of elements is N in B and N is even, then consider the median as B[N/2-1]. ( B must be in sorted order).



Problem Constraints

1 <= length of the array <= 100000
1 <= A[i] <= 109



Input Format

The only argument given is the integer array A.



Output Format

Return an integer array C, C[i] denotes the median of the first i delivery times.



Example Input

Input 1:

 A = [1, 2, 5, 4, 3]
Input 2:

 A = [5, 17, 100, 11]




Example Output

Output 1:

 [1, 1, 2, 2, 3]
Output 2:

 [5, 5, 17, 11]
 */
public class RunningMedian {

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

        RunningMedian runningMedian = new RunningMedian();
        int[] result = runningMedian.solve(new int[] {1, 2, 5, 4, 3});
        for (int val : result) {
            System.out.print(val + " ");
        }
        System.out.println();
        result = runningMedian.solve(new int[] {5, 17, 100, 11});
        for (int val : result) {
            System.out.print(val + " ");

        }
    }
}
