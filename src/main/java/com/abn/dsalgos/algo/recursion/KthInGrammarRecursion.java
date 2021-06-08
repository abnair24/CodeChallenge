package com.abn.dsalgos.algo.recursion;

/*
Given two integer n and k, return the kth (1-indexed) symbol in the nth row of a table of n rows.
We build a table of n rows (1-indexed). We start by writing 0 in the 1st row.
Now in every subsequent row, we look at the previous row and replace each occurrence of 0 with 01,
and each occurrence of 1 with 10.

n =1  : 0
n =2  : 0 1
n =3  : 0 1 1 0
n =4  : 0 1 1 0 1 0 0 1

n = 4, k = 6 ==> 0

Explanation :
For any level, no of symbols present is 2 ^ (n-1)
ie; n = 4, symbols = 8.

First half of symbols for nth row is full (n-1)th row symbols . And second half of nth row is compliment of n-1 th row symbols.

If k < middle of nth row, then symbol is same as kth value in n-1 row.
If k > middle of nth row, then symbol is compliment of symbol in (k-mid)th position in n-1 row. ie; g(n-1, k - mid)

 */
public class KthInGrammarRecursion {

    public int getKthSymbol(int n, int k) {

        if(n == 1) {
            return 0;
        }

        int mid = (int) Math.pow(2,(n-1))/2;

        if(k <= mid) {
            return getKthSymbol(n - 1, k);
        }
        return 1 - getKthSymbol(n - 1, k - mid);
    }
}
