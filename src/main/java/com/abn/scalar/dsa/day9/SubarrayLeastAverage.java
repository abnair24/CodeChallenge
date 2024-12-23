package com.abn.scalar.dsa.day9;

/*
Given an array A of size N, find the subarray of size B with the least average.

Input 1:
A = [3, 7, 90, 20, 10, 50, 40]
B = 3

Output 1:
3

Input 2:
A = [3, 7, 5, 20, -10, 0, 12]
B = 2

Output 2:
4
 */

public class SubarrayLeastAverage {

    public int solve(int[] array, int B) {

        int n = array.length;
        int sum = 0;
        int res = 0;
        for(int i = 0; i < B; i++) {
            sum += array[i];
        }

        int minSum = sum;

        for(int i = B; i <n ; i++) {
            sum = sum - array[i-B] + array[i];
            if(sum < minSum) {
                minSum = sum;
                res = i - B+1;
            }
        }

        return res;
    }
}
