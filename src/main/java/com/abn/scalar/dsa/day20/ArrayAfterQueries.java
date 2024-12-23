package com.abn.scalar.dsa.day20;

/*
Given an integer array A where every element is 0, return the
final array after performing multiple queries
Query (i, x): Add x to all the numbers from index i to N-1
Example
Let's say we have a zero-filled array of size 7 with the following
queries:
Query(1, 3) Query(4, -2) Query(3, 1)
Let's perform these queries and see how it works out.

Intial array is 0.
Query(1, 3) -> from index 1 to end, add 3 to all elements.
Query(4, -2) -> from index 4 to end, add -2 to all elements.

final : 0, 3, 3, 4, 2, 2, 2

 */
public class ArrayAfterQueries {

    public int[] solve(int[][] queries, int N) {

        int[] array = new int[N];
        for(int i = 0; i < queries.length; i++) {
            int index = queries[i][0];
            int value = queries[i][1];

            array[index] = array[index] + value;
        }

        //form prefix array
        for(int i = 1; i < N; i++) {
            array[i] = array[i] + array[i -1];
        }

        return array;
    }

    public static void main(String[] args) {
        int[][] queries = new int[][] {
                {1, 3},
                {4, -2},
                {3, 1}
        };

        ArrayAfterQueries arrayAfterQueries = new ArrayAfterQueries();
        arrayAfterQueries.solve(queries, 7);
    }
}
