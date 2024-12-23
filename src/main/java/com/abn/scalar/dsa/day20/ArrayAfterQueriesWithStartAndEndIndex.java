package com.abn.scalar.dsa.day20;

/*
Given an integer array A such that all the elements in the array
are 0. Return the final array after performing multiple queries

Query: (i, j, x): Add x to all the elements from index i to j
Given that i <= j
Examples
Let's take an example, say we have the zero-filled array of size 7
and the queries are given as
 q1 = (1, 3, 2)
 q2 = (2, 5, 3)
 q3 = (5, 6, -1)

 Array = [0,0,0,0,0, 0, 0, 0]

 Approach : add value at start index and end index + 1 add -negative value to nullify post end index
 */

public class ArrayAfterQueriesWithStartAndEndIndex {

    public int[] solve(int N, int[][] B) {

        int[] array = new int[N];

        for(int i = 0; i < B.length; i++) {
            int s = B[i][0];
            int e = B[i][1];
            int v = B[i][2];

            array[s] = array[s] + v;
            if(e + 1 < N) {
                array[e+1] = array[e+1] - v;
            }
        }

        for(int i = 1; i < N; i++) {
            array[i] = array[i] + array[i-1];
        }

        return array;
    }

    public static void main(String[] args) {

        int[][] start = new int[][] {{1, 3, 2}, {2, 5, 3}, {5, 6, -1}};

        ArrayAfterQueriesWithStartAndEndIndex arrayAfterQueriesWithStartAndEndIndex = new ArrayAfterQueriesWithStartAndEndIndex();
        arrayAfterQueriesWithStartAndEndIndex.solve(8, start);
    }
}
