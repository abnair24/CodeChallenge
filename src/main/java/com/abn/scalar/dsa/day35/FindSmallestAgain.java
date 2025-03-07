package com.abn.scalar.dsa.day35;


import java.util.Arrays;

/*

Given an integer array A of size N.

If we store the sum of each triplet of the array A in a new list, then find the Bth smallest element among the list.

NOTE: A triplet consists of three elements from the array.
Let's say if A[i], A[j], A[k] are the elements of the triplet then i < j < k.
Approach:

Binary Search + Two Pointers (Optimized)

Sort the array first
Use binary search on the possible sum range (from min sum to max sum)
For each potential sum in the binary search, count how many triplets have a sum less than or equal to it
The counting is done efficiently using a two-pointer technique

This optimization reduces the time complexity to O(N² log R), where R is the range of possible sums.
The binary search approach is especially efficient when:

The array size N is large
The value of B is large
We need to handle multiple queries with different B values
 */
public class FindSmallestAgain {

    public static int findBthSmallestTripletSumOptimized(int[] A, int B) {
        int N = A.length;

        // We need at least 3 elements to form a triplet
        if (N < 3) {
            return -1; // Invalid input
        }

        // Sort the array first
        Arrays.sort(A);

        // Calculate the total number of triplets
        int totalTriplets = (N * (N-1) * (N-2)) / 6;

        if (B > totalTriplets) {
            return -1; // B is larger than the number of triplets
        }

        // Find the minimum and maximum possible sum
        int minSum = A[0] + A[1] + A[2];
        int maxSum = A[N-3] + A[N-2] + A[N-1];

        // Binary search to find the Bth smallest sum
        while (minSum < maxSum) {
            int mid = minSum + (maxSum - minSum) / 2;

            // Count triplets with sum less than or equal to mid
            int count = countTripletsLessThanOrEqual(A, mid);

            if (count < B) {
                minSum = mid + 1;
            } else {
                maxSum = mid;
            }
        }

        return minSum;
    }

    // Helper method to count triplets with sum less than or equal to target
    private static int countTripletsLessThanOrEqual(int[] A, int target) {
        int N = A.length;
        int count = 0;

        for (int i = 0; i < N - 2; i++) {
            int j = i + 1;
            int k = N - 1;

            while (j < k) {
                int sum = A[i] + A[j] + A[k];

                if (sum <= target) {
                    // If sum is <= target, then all triplets with indices i, j, and
                    // any index between j+1 and k will also have sum <= target
                    count += (k - j);
                    j++;
                } else {
                    k--;
                }
            }
        }

        return count;
    }

    public static void main(String[] args) {
        // Example usage
        int[] A = {1, 2, 3, 4, 5};
        int B = 4;
        System.out.println("Bth smallest triplet sum: " +
                findBthSmallestTripletSumOptimized(A, B));
    }
}
