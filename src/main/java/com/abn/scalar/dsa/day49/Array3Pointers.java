package com.abn.scalar.dsa.day49;

/*
You are given 3 sorted arrays A, B and C.

Find i, j, k such that : max(abs(A[i] - B[j]), abs(B[j] - C[k]), abs(C[k] - A[i])) is minimized.

Return the minimum max(abs(A[i] - B[j]), abs(B[j] - C[k]), abs(C[k] - A[i])).

Return an single integer denoting the minimum max(abs(A[i] - B[j]), abs(B[j] - C[k]), abs(C[k] - A[i])).

Input 1:

 A = [1, 4, 10]
 B = [2, 15, 20]
 C = [10, 12]

Output 1:

 5

Input 2:

 A = [3, 5, 6]
 B = [2]
 C = [3, 4]

Output 2:

 1

Approach:
1. Start with the smallest elements from all three arrays (i=0, j=0, k=0)

2. Calculate the maximum absolute difference between any two elements

3. Update our answer if this maximum difference is smaller than what we've seen so far
4. Increment the index of the array that has the smallest current element

5. Repeat until we reach the end of any array
 */
public class Array3Pointers {

    public int minimize(final int[] A, final int[] B, final int[] C) {

        int i =0;
        int j = 0;
        int k =0;
        int minMaxDiff = Integer.MAX_VALUE;

        while(i < A.length && j < B.length && k <C.length) {

            int diff1 = Math.abs(A[i] - B[j]);
            int diff2 = Math.abs(B[j] - C[k]);
            int diff3 = Math.abs(C[k] - A[i]);

            int maxDiff = Math.max(diff1, Math.max(diff2, diff3));
            minMaxDiff = Math.min(minMaxDiff, maxDiff);
            int min = Math.min(A[i], Math.min(B[j], C[k]));

            if(min == A[i]) {
                i++;
            } else if(min == B[j]) {
                j++;
            } else {
                k++;
            }
        }

        return minMaxDiff;
    }
}
