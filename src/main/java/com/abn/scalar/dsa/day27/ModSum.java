package com.abn.scalar.dsa.day27;

/*
Given an array of integers A, calculate the sum of A [ i ] % A [ j ] for all possible i, j pairs. Return sum % (109 + 7) as an output.

 A = [1, 2, 3]
 o/p: 5

 Explanation 1:

 (1 % 1) + (1 % 2) + (1 % 3) + (2 % 1) + (2 % 2) + (2 % 3) + (3 % 1) + (3 % 2) + (3 % 3) = 5

 Approach:

Calculate the frequency of all the elements from 1 to 1000.
For all values i from 1 to 1000 calculate sumi as sum of i % A[j] , where 1 <= j <= n
Sum of all such ((sumi) * (frequency of i)) would be the final answer.

 */
public class ModSum {

    public int solve(int[] array) {

        int[] frq = new int[1000];
        for (int n : array) {
            frq[n] ++;
        }

        int ans = 0;

        for(int i = 1; i <= 1000; i ++) {

            for(int j = 1; j <= 1000; j++) {

                int val = i % j;
                ans += (frq[i] * frq[j] * val) % 1000000007;
                ans = ans % 1000000007;
            }
        }

        return ans;
    }
}
