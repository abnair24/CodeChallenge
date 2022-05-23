package com.abn.dsalgos.algo.slidingWindo;

/*
Given an array of integers nums and an integer k, return the number of contiguous subarrays
where the product of all the elements in the subarray is strictly less than k.

nums = [10,5,2,6], k = 100
Output: 8
Explanation: The 8 subarrays that have product less than 100 are:
[10], [5], [2], [6], [10, 5], [5, 2], [2, 6], [5, 2, 6]

https://leetcode.com/problems/subarray-product-less-than-k/

 */
public class SubArrayProductLessThanK {

    public int subArrayProduct(int[] array, int k) {

        int start = 0;
        int count = 0;

        int product = 1;

        for(int i = 0; i < array.length; i++) {

            product *= array[i];

            if(product >= k) {

                product /= array[start];
                start ++;
            }

            count += i - start + 1;
        }
        return count;
    }
}
