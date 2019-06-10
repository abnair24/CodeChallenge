package com.abn.dsalgos.algo;

/*
You are given an array of integers a.
Any array that you can obtain from a by removing
some elements (possibly none, but not all) is denoted as s.
Among all such arrays s, what is the maximum possible value of p(s)?
Since the answer could potentially be very large, return the value of p(a) / p(s) instead.

For a = [1, 2, -2, -3, 3, 5] , o/p : 180

a: [-4, -2, 10, 20, -3] : -4 * 10 * 20* -3 = 2400

 */
public class MaxProductOfAnySubArray {


    public long maximumSubsetProduct(long[] nums) {

        long neg_count=0;
        long min_neg = Integer.MIN_VALUE;
        long prod = 1;

        if(nums.length == 1) {
            return nums[0];
        }

        for(int i =0; i<nums.length;i++){
            if(nums[i]<0){
                neg_count++;
                min_neg = Math.max(min_neg,nums[i]);
            }
            prod = prod * nums[i];
        }

        if(neg_count %2 ==1) {
            prod = prod /min_neg;
        }
        return prod;
    }
}
