package com.abn.scalar.dsa.day18;

/*

Given a binary array []. We can swap a single 0 with 1.
Find the maximum consecutive 1's we can get in the array[ ] after atmost 1 swap.

111000 : 3

111011101 : 7
 */
public class MaxConsecutiveOnesInBinaryArraySwap {

    public int solve(String A) {
        int total =0;
        for(int i = 0; i < A.length(); i++) {
            if(A.charAt(i) == '1') {
                total ++;
            }
        }

        if(total == A.length()) {
            return A.length();
        }

        int ans = 0;
        int count = 0;
        for(int i = 0; i < A.length(); i++) {
            if(A.charAt(i) == '0') {
                int left = 0;
                int j = i-1;
                while(j >=0 && A.charAt(j) == '1') {
                    left ++;
                    j --;
                }

                int right = 0;
                j = i +1;
                while( j < A.length() && A.charAt(j) == '1' ) {
                    right ++;
                    j++;
                }
                if(left + right == total) {
                    count = left + right;
                } else {
                    count = left + right + 1;
                }
                ans =   Math.max(ans, count);
            }
        }
        return ans;
    }
}