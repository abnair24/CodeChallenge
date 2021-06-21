package com.abn.dsalgos.algo.bitwise;

/*
Consider a number N and you need to find if N is a power of 2.

Use bitwise operations.
A number which is power of 2 has only one bit set.

and if a number is power of 2, x & (x-1) == 0. becoz, x-1 is formed by flipping all bit till the
rightmost 1 in x including rightmost 1

eg: 4 => 0100

4 - 1 => 0011 (flip till first 1 in 0100 and including one also. )

if a number is power of 2, it will have only 1 bit set and x-1 of that number will have all bits flipped to the right of that,
which makes '&' operation to 0000
 */
public class PowerOfTwo {

    public boolean isPowerTwo(int x) {

        if (x == 0) {
            return false;
        }

        long n = x;

        if ((n & (n - 1)) == 0) {
            return true;
        }

        return false;
    }
}
