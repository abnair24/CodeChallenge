package com.abn.scalar.dsa.day35;

/*
Given two sorted arrays A and B of size M and N respectively, return the median of the two sorted arrays.
Round of the value to the floor integer [2.6=2, 2.2=2]

Input 1:

A = [1, 3]
B = [2]

Output 1:
3
merged array = [1,2,3] and median is 2.

Input 2:

A = [1, 2]
B = [3,4]

Output 2:
3
merged array = [1,2,3,4] and median is (2 + 3) / 2 = 2
 */
public class MedianOfSortedArrays {

    public int solve(int[] A, int[] B) {
        int m = A.length, n = B.length;

        if (m > n) {
            return solve(B, A); // Ensure A is the smaller array
        }

        int low = 0, high = m;
        while (low <= high) {
            int partitionA = (low + high) / 2;
            int partitionB = (m + n + 1) / 2 - partitionA;

            int maxLeftA = (partitionA == 0) ? Integer.MIN_VALUE : A[partitionA - 1];
            int minRightA = (partitionA == m) ? Integer.MAX_VALUE : A[partitionA];

            int maxLeftB = (partitionB == 0) ? Integer.MIN_VALUE : B[partitionB - 1];
            int minRightB = (partitionB == n) ? Integer.MAX_VALUE : B[partitionB];

            if (maxLeftA <= minRightB && maxLeftB <= minRightA) {
                int median;
                if ((m + n) % 2 == 0) {
                    median = (Math.max(maxLeftA, maxLeftB) + Math.min(minRightA, minRightB)) / 2;
                } else {
                    median = Math.max(maxLeftA, maxLeftB);
                }
                return median;
            } else if (maxLeftA > minRightB) {
                high = partitionA - 1;
            } else {
                low = partitionA + 1;
            }
        }
        return -1;
    }
}
