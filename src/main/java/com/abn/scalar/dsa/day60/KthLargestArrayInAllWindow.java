package com.abn.scalar.dsa.day60;

import java.util.Arrays;
import java.util.PriorityQueue;

/*
Given an integer array B of size N.

You need to find the Ath largest element in the subarray [1 to i], where i varies from 1 to N. In other words,
find the Ath largest element in the sub-arrays [1 : 1], [1 : 2], [1 : 3], ...., [1 : N].

NOTE: If any subarray [1 : i] has less than A elements, then the output should be -1 at the ith index.
Input 1:

 A = 4
 B = [1 2 3 4 5 6]
Input 2:

 A = 2
 B = [15, 20, 99, 1]


Example Output

Output 1:

 [-1, -1, -1, 1, 2, 3]
Output 2:

 [-1, 15, 20, 20]
 */
public class KthLargestArrayInAllWindow {

    public int[] solve(int k, int[] B) {

        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        for(int i = 0; i < (k); i ++) {
            minHeap.offer(B[i]);
            B[i] = -1;
        }
        B[k-1] = minHeap.peek();

        for(int i = k; i < B.length; i++) {
            minHeap.offer(B[i]);
            minHeap.poll();
            B[i] = minHeap.peek();
        }

        return B;
    }

    public static void main(String[] args) {
        KthLargestArrayInAllWindow kthLargestArrayInAllWindow = new KthLargestArrayInAllWindow();
        System.out.println(Arrays.toString(kthLargestArrayInAllWindow.solve(4, new int[]{1, 2, 3, 4, 5, 6})));
    }
}
