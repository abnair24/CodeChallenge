package com.abn.scalar.dsa.day48Lab;

/*

Given a sorted array of integers (not necessarily distinct) A and an integer B, find and return how many pair of integers ( A[i], A[j] ) such that i != j have sum equal to B.

Since the number of such pairs can be very large, return number of such pairs modulo (109 + 7).

Input 1:

A = [1, 1, 1]
B = 2
Input 2:

A = [1, 5, 7, 10]
B = 8

Output 1:

 3
Output 2:

 1
 */
public class PairSumII {

    public int solve(int[] A, int B) {

        int startPtr = 0;
        int endPtr = A.length - 1;
        long count = 0;
        long sum = 0;
        long mod = 1000000007;

        while(startPtr < endPtr) {

            sum = A[startPtr] + A[endPtr];

            if(sum > B) {
                endPtr --;
            } else if(sum < B) {
                startPtr ++;
            } else if(sum == B ) {

                /*
                Sample : 4 4 4 5 5 5 5 6 6 6 6 , B = 10
                startPtr at 5 & endPtr at 5
                 */
                if(A[startPtr] == A[endPtr]) {
                    long len = endPtr - startPtr + 1;
                    count = count + (len * (len - 1) / 2) % mod;
                    break;
                }

                /*
                Sample : 4 4 4 5 5 5 5 6 6 6 6 , B = 10
                A[startPtr] = 4 & A[endPtr] = 6
                 */

                int current = A[startPtr];
                int left = 0;
                while(A[startPtr] == current) {
                    startPtr ++;
                    left ++;
                }
                current = A[endPtr];
                int right = 0;
                while(A[endPtr] == current) {
                    endPtr --;
                    right ++;
                }
                count = count + (left * right) % mod;
            }
        }
        count = count % mod;
        return (int) count;
    }

    public static void main(String[] args) {

        PairSumII pairSumII = new PairSumII();
        int[] input = new int[] {0, 1, 2, 4, 4, 4, 4, 5, 5, 5, 5, 6, 6, 6, 6, 6, 7, 10};
        System.out.println(pairSumII.solve(input, 10));
    }
}
