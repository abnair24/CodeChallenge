package com.abn.sc.dsa.day74;

/*
You are given an array of non-negative integers A, where each element in the array represents the maximum number of steps you can jump forward from that position.

A jump means moving from the current index to another index further in the array within the allowed range of steps defined by the value at the current index. For instance, if A[i] = 3, you can jump to any of the next 3 positions from index i (i.e., i+1, i+2, or i+3), provided these positions are within the bounds of the array.

Your task is to determine the minimum number of jumps required to reach the last index of the array, starting from the first index.

If it's not possible to reach the last index, return -1.

Input 1:
A = [2, 3, 1, 1, 4]

o/p: 2

A = [0, 1, 1, 4]
o/p: -1
 */

public class JumpGameII {

    public int solve(int[] A) {
        if (A == null || A.length <= 1) {
            return 0;
        }

        if (A[0] == 0) {
            return -1;
        }

        int jumps = 0;
        int currentEnd = 0;
        int farthest = 0;

        // We don't need to check the last element
        for (int i = 0; i < A.length - 1; i++) {
            // Update the farthest position we can reach
            farthest = Math.max(farthest, i + A[i]);

            // If we can't move forward from current position
            if (farthest <= i) {
                return -1;
            }

            // If we've reached the end of current jump range
            if (i == currentEnd) {
                jumps++;
                currentEnd = farthest;

                // If we can reach or exceed the last index
                if (currentEnd >= A.length - 1) {
                    return jumps;
                }
            }
        }

        return jumps;
    }

    public static void main(String[] args) {
        JumpGameII minJumps = new JumpGameII();
        System.out.println(minJumps.solve(new int[] {2, 3, 1, 1, 4})); // Output: 2
    }
}
