package com.abn.scalar.dsa.day18;

/*
Given a binary array [ ]. We can almost replace a single 0 with 1.
Find the maximum consecutive 1's we can get in the array[ ] after the replacement.

 */

public class MaxConsecutiveOnesInBinaryArrayReplace {

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
                ans =   Math.max(ans, left + right + 1);
            }
        }
        return ans;
    }
}