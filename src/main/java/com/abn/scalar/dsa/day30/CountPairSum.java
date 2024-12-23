package com.abn.scalar.dsa.day30;

import java.util.HashMap;
import java.util.Map;

/*

You are given an array A of N integers and an integer B. Count the number of pairs (i,j) such that A[i] + A[j] = B and i ≠ j.

Since the answer can be very large, return the remainder after dividing the count with 109+7.

Note - The pair (i,j) is same as the pair (j,i) and we need to count it only once.

A = [3, 5, 1, 2]
B = 8
Input 2:

A = [1, 2, 1, 2]
B = 3


Example Output

Output 1:

1
Output 2:

4
 */
public class CountPairSum {

    public int solve(int[] A, int B) {

        int count = 0;
        Map<Integer, Integer> map = new HashMap<>();

        for(int i = 0; i < A.length; i++) {
            if(map.containsKey(B-A[i])) {
                count = (count + map.get(B - A[i]))%1000000007;

            }
            map.put(A[i], map.getOrDefault(A[i], 0)+1);

        }
        return count;
    }

    public static void main(String[] args) {

        CountPairSum countPairSum = new CountPairSum();
        System.out.println(countPairSum.solve(new int[]{3, 5, 1, 2}, 8));
    }
}
