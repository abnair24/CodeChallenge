package com.abn.learn.dsa.day24BitManipulation2;

/*
You are given an array of integers A of size N.

The value of a subarray is defined as BITWISE OR of all elements in it.

Return the sum of value of all subarrays of A % 109 + 7.

 A = [1, 2, 3, 4, 5]

 o/p: 71

 Value([1]) = 1
 Value([1, 2]) = 3
 Value([1, 2, 3]) = 3
 Value([1, 2, 3, 4]) = 7
 Value([1, 2, 3, 4, 5]) = 7
 Value([2]) = 2
 Value([2, 3]) = 3
 Value([2, 3, 4]) = 7
 Value([2, 3, 4, 5]) = 7
 Value([3]) = 3
 Value([3, 4]) = 7
 Value([3, 4, 5]) = 7
 Value([4]) = 4
 Value([4, 5]) = 5
 Value([5]) = 5
 Sum of all these values = 71

 If ith bit in one element is 1, since its OR ,it will be contributing to overall. Finding contribution of unset bit and then substract from
 total subarray.

 */
public class AllSubarrayOR {

    public int solve(int[] A) {
        long n = A.length;
        long tot_subArray = (n * (n + 1)) / 2;
        long ans = 0;
        for (int i = 0; i < 32; i++) {
            long subArray = 0;
            long bitzero = 0;
            for (int j = 0; j < n; j++) {
                if ((A[j] & (1 << i)) == 0) {
                    bitzero ++;
                }
                if ((A[j] & (1 << i)) > 0 || j == n - 1) {
                    subArray += (bitzero * (bitzero + 1)) / 2;
                    // to handle case of ith of all numbers is 1 and not to carry forward bitzero value.
                    bitzero = 0;
                }
            }
            ans += (tot_subArray - subArray) * (long) Math.pow(2, i);
            ans = ans % 1000000007;
        }
        return (int) ans;
    }

    public static void main(String[] args) {
        AllSubarrayOR allSubarrayOR = new AllSubarrayOR();
        System.out.println(allSubarrayOR.solve(new int[] {1, 2, 3}));
    }
}
