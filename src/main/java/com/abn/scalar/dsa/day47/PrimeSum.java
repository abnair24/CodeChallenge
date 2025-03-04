package com.abn.scalar.dsa.day47;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
Given an even number A ( greater than 2 ), return two prime numbers whose sum will be equal to the given number.

If there is more than one solution possible, return the lexicographically smaller solution.

If [a, b] is one solution with a <= b, and [c,d] is another solution with c <= d, then
[a, b] < [c, d], If a < c OR a==c AND b < d.

NOTE: A solution will always exist. Read Goldbach's conjecture.

Input: 4
o/p: [2, 2]
 */

public class PrimeSum {

    public int[] primeSum(int A) {

        int[] result = getAllPrimes(A);
        int startPtr = 0;
        int endPtr = result.length - 1;
        int[] ans = new int[2];

        while(startPtr <= endPtr) {
            int sum = result[startPtr] + result[endPtr];
            if(sum > A) {
                endPtr --;
            } else if(sum < A) {
                startPtr ++;
            } else {
                ans = new int[]{result[startPtr], result[endPtr]};
                break;
            }
        }
        return ans;
    }

    private int[] getAllPrimes(int A) {

        int[] sieve = new int[A + 1];
        int count = 0;
        for(int i = 2; i < sieve.length; i++) {
            sieve[i] = 1;
            count ++;
        }

        for(int i =  2; i <= Math.sqrt(A); i++) {
            if(sieve[i] == 1) {
                for (int j = i * i; j <= A; j = j+i) {
                    if(!(sieve[j] == 0)) {
                        count --;
                    }
                    sieve[j] = 0;
                }
            }
        }

        int[] result = new int[count];
        int index = 0;

        for(int i = 2; i <= A; i++) {
            if(sieve[i] == 1) {
                result[index++] = i;
            }
        }
        return result;
    }

    public static void main(String[] args) {

        PrimeSum primeSum = new PrimeSum();
        System.out.println(Arrays.toString(primeSum.primeSum(4)));
    }
}
