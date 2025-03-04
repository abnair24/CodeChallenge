package com.abn.scalar.dsa.day31;

/*
Given an array of integers A of size N that is a permutation of [0, 1, 2, ..., (N-1)],
if we split the array into some number of "chunks" (partitions), and individually sort each chunk.
After concatenating them in order of splitting, the result equals the sorted array.

What is the most number of chunks we could have made?


Input 1:

 A = [1, 2, 3, 4, 0]
Output 1:

 1

Input 2:

 A = [2, 0, 1, 3]

Output 2:

 2

Iterate Through the Array: Loop through each element in the array `A`.
	•	Update Maximum Value: Keep track of the maximum value encountered so far (`maxSoFar`) by comparing it with the current element `Ai`.
	•	Check Chunk Boundary: If the current index `i` equals the maximum value `maxSoFar`, it means all elements before this index are smaller or equal to `i`, making this position a valid chunk boundary. Increment the chunk count (`chunks++`).
	•	Return Chunk Count: After iterating through the entire array, return the total number of chunks found.

 */
public class MaxChunks {

    public int maxChunksToSorted(int[] A) {
        int chunks = 0;
        int maxSoFar = 0;

        for (int i = 0; i < A.length; i++) {
            maxSoFar = Math.max(maxSoFar, A[i]);
            if (i == maxSoFar) {
                chunks++;
            }
        }

        return chunks;
    }
}
