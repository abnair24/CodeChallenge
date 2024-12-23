package com.abn.scalar.dsa.day22;

import java.util.ArrayList;

/*
You have a set of non-overlapping intervals. You are given a new interval [start, end], insert this new interval into
the set of intervals (merge if necessary).

You may assume that the intervals were initially sorted according to their start times.

Input 1:

Given intervals [1, 3], [6, 9] insert and merge [2, 5] .
Input 2:

Given intervals [1, 3], [6, 9] insert and merge [2, 6] .


Example Output

Output 1:

[ [1, 5], [6, 9] ]
Output 2:

 [ [1, 9] ]
 */
public class InsertToNonOverlappingInterval {

    public int[][] insert(int[][] A, int[] B) {

        ArrayList<int[]> res = new ArrayList<>();
        int i = 0;
        int n = A.length;

        while (i < n && A[i][1] < B[0]) {
            res.add(A[i]);
            i++;
        }

        while (i < n && A[i][0] <= B[1]) {
            B[0] = Math.min(B[0], A[i][0]);
            B[1] = Math.max(B[1], A[i][1]);
            i++;
        }
        res.add(B);

        // Add all the remaining intervals
        while (i < n) {
            res.add(A[i]);
            i++;
        }

        int[][] result = new int[res.size()][];

        for(int j = 0; j < res.size(); j++) {

            result[j] = res.get(j);
        }

        return result;
    }
}
