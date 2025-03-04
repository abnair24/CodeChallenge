package com.abn.scalar.dsa.day47;

import java.util.Arrays;

/*
Given an integer A. Find the list of all prime numbers in the range [1, A].

input 1: A = 7

Output 1:
[2, 3, 5, 7]

Input 2:A = 12

Output 2:
[2, 3, 5, 7, 11]
 */
public class AllPrimes {

    public int[] solve(int N) {

        int[] sieve = new int[N+1];
        int count = 0;

        for(int i = 2; i < sieve.length; i++) {
            sieve[i] = 1;
            count ++;
        }

        sieve[0] = 0;
        sieve[1] = 0;

        for(int i = 2; i <= Math.sqrt(N); i++) {
            if(sieve[i] == 1){
                for(int j = i * i; j <= N; j = j+i) {
                    //check to find the actual count of prime as same number can be set as 0 multiple
                    // if more divisors are there : eg: 6 -> 2, 3
                    if (!(sieve[j] == 0)) {
                        count--;
                    }
                    sieve[j] = 0;
                }
            }
        }

        int index=0;
        int[] result = new int[count];
        for(int i = 2; i <= N; i++) {
            if(sieve[i] == 1){
                result[index++] = i;
            }
        }
        return result;
    }

    public static void main(String[] args) {

        AllPrimes allPrimes = new AllPrimes();
        System.out.println(Arrays.toString(allPrimes.solve(49)));
    }
}
