package com.abn.scalar.dsa.day30;

/*
Given an array of positive integers A and an integer B, find and return first continuous subarray which adds to B.

If the answer does not exist return an array with a single integer "-1".

First sub-array means the sub-array for which starting index in minimum.

 A = [1, 2, 3, 4, 5]
 B = 5

 [2, 3]

 A = [5, 10, 20, 100, 105]
 B = 110

 [-1]

Approach :
We can use 2 pointer technique to solve this problem efficiently.
We can keep pointers left and right.

We move right, when our sum < target.
We move left, when sum > target.
If the sum equals our target, we get the left and right and print the sub array.
 */
public class SubArrayWithGivenSum {

    public int[] solve(int[] A, int B) {

        int left = 0;
        int sum = 0;
        int len = A.length;
        int[] pair;

        for(int right = 0; right < len; right++) {
            sum += A[right];

            while(sum > B) {
                sum = sum - A[left];
                left ++;
            }

            if(sum == B) {
                pair = new int[right - left + 1];
                int index = 0;
                for(int i = left; i <= right; i++) {
                    pair[index++] = A[i];
                }

                return pair;
            }
        }
        pair = new int[] {-1};
        return pair;
    }

    public static void main(String[] args) {

        SubArrayWithGivenSum subArrayWithGivenSum = new SubArrayWithGivenSum();
        subArrayWithGivenSum.solve(new int[] {1, 2, 3, 4, 5}, 5);
    }
}
