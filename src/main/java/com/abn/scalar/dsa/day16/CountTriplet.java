package com.abn.scalar.dsa.day16;

/*
You are given an array A of N elements. Find the number of triplets i,j and k such that i<j<k and A[i]<A[j]<A[k]
A = [1, 2, 4, 3]

The triplets that satisfy the conditions are [1, 2, 3] and [1, 2, 4].
 */

import org.checkerframework.checker.units.qual.C;

public class CountTriplet {

    public int solve(int[] array) {

        int n = array.length;
        int ans = 0;
        for (int i = 0; i < n; i++) {
            int left = 0;
            for (int j = i - 1; j >= 0; j--) {
                if (array[j] < array[i]) {
                    left ++;
                }
            }

            int right = 0;
            for (int j = i + 1; j < n; j++) {
                if (array[j] > array[i]) {
                    right ++;
                }
            }
            ans += right * left;
        }

        return ans;
    }

    public static void main(String[] args) {
        CountTriplet countTriplet = new CountTriplet();
        System.out.println(countTriplet.solve(new int[] {1, 2, 4, 3}));
    }
}