package com.abn.scalar.dsa.day9;

/*
Given an integer array, find the sum of all possible subarrays

for a subarray an index value occurs for sum is :

lets say array = [1, 2 , 3, 4, 5]

index i = 1 can occur in subarray starting from index 0 & 1 and ending in indices from 1 to n-1;

so total occurance of starting index  = i + 2
so total occurance of ending index = i to n-1 => n-i

contribution of array[i] in total sum = no of subarrays containning  i * array[i]
no of subarrays containning  i = (i+2) * (n-i)

value = (i+2) * (n-i) * array[i]
 */
public class SubArrayTotalSum {

    public long solve(int[] array) {

        long ans = 0;
        int n = array.length;
        for(int i = 0; i < n; i++) {

            ans = ans +  (long) (i + 1) * (n - i) * array[i];
        }
        return ans;
    }

    public static void main(String[] args) {
        SubArrayTotalSum subArrayTotalSum = new SubArrayTotalSum();
        System.out.println(subArrayTotalSum.solve(new int[] {2, 4, 1, 3}));
    }
}
