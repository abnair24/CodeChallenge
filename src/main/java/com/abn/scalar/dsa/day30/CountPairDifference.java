package com.abn.scalar.dsa.day30;

import java.util.HashMap;
import java.util.Map;

/*
You are given an array A of N integers and an integer B.
Count the number of pairs (i,j) such that A[i] - A[j] = B and i ≠ j.

Since the answer can be very large, return the remainder after dividing the count with 109+7.

Input 1:

A = [3, 5, 1, 2]
B = 4

Output: 1

Input 2:

A = [1, 2, 1, 2]
B = 1

Output: 4

Approach:

We can use a hash-map and store the elements of the array
as the key and its frequency as the value.
We traverse the array from left to right.
Now, for every element we count the number of occurences of
A[i] + B and A[i] - B to its left side and increment that to our answer.

 */
public class CountPairDifference {

    public int solve(int[] A, int B) {

        Map<Integer, Integer> map = new HashMap<>();
        int count = 0;

        for(int i = 0; i <A.length; i++) {
            int sum = A[i] + B;
            int diff = A[i] - B;
            if(map.containsKey(sum)) {
                count += map.get(sum);
            }

            if(map.containsKey(diff)) {
                count += map.get(diff);
            }

            map.put(A[i], map.getOrDefault(A[i], 0) + 1);
        }
        return count;
    }

    public static void main(String[] args) {

        CountPairDifference countPairDifference = new CountPairDifference();
        System.out.println(countPairDifference.solve(new int[] {2,1,2,1,2,1,2,1,2}, 1));
    }
}
