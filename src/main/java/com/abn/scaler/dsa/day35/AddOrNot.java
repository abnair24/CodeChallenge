package com.abn.scaler.dsa.day35;

import java.util.Arrays;

/*
Given an array of integers A of size N and an integer B.

In a single operation, any one element of the array can be increased by 1. You are allowed to do at most B such operations.

Find the number with the maximum number of occurrences and return an array C of size 2,
where C[0] is the number of occurrences, and C[1] is the number with maximum occurrence.
If there are several such numbers, your task is to find the minimum one.

 A = [3, 1, 2, 2, 1]
 B = 3
 o/p: [4, 2]

 A = [5, 5, 5]
 B = 3
 o/p: [3, 5]
 */
public class AddOrNot {

    public int[] solve(int[] A, int B) {
        Arrays.sort(A);
        int maxCount = 0, maxElement = 0;
        int currentCount = 0;
        long sum = 0;
        int start = 0, end = 0;

        while (end < A.length) {
            long req = (long) A[end] * currentCount - sum;

            while (req > B) {
                sum -= A[start];
                start++;
                currentCount --;
                req = (long) A[end] * currentCount - sum;
            }

            currentCount++;
            sum += A[end];

            if (currentCount > maxCount) {
                maxCount = currentCount;
                maxElement = A[end];
            }
            end++;
        }

        return new int[] {maxCount, maxElement};
    }

    public static void main(String[] args) {

        AddOrNot addOrNot = new AddOrNot();
        System.out.println(Arrays.toString(addOrNot.solve(new int[] {3, 1, 2, 2, 1}, 3)));
        System.out.println(Arrays.toString(addOrNot.solve(new int[] {5, 5, 5}, 3)));
    }
}
