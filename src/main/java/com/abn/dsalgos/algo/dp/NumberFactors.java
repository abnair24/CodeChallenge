package com.abn.dsalgos.algo.dp;

import org.testng.Assert;

/*
Given a number ‘n’, implement a method to count how many possible ways there are to express ‘n’ as the sum of 1, 3, or 4.

n : 4
Number of ways = 4

{1,1,1,1}, {1,3}, {3,1}, {4}
 */
public class NumberFactors {

    public int count(int n) {

        int[] cache = new int[n + 1];
        return numberfactor(cache, n);
    }

    public int numberfactor(int[] cache, int n) {

        if(n == 0) {
            return 1;
        }

        if(n < 0) {
            return 0;
        }

        if(cache[n] != 0) {
            return cache[n];
        }

        int countOne = numberfactor(cache, n -1);
        int countThree = numberfactor(cache, n - 3);
        int countFour = numberfactor(cache,n - 4);

        cache[n] = countOne + countThree + countFour;

        return cache[n];
    }

    public static void main(String[] args) {
        NumberFactors numberFactors = new NumberFactors();
        Assert.assertEquals(numberFactors.count(5), 6);
        Assert.assertEquals(numberFactors.count(4), 4);
    }
}
