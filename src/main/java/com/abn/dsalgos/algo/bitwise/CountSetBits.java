package com.abn.dsalgos.algo.bitwise;

public class CountSetBits {

    int count = 0;

    public static void main(String[] args) {
        CountSetBits countSetBits = new CountSetBits();
        System.out.println(countSetBits.setBit(10));
    }

    public int setBit(int n) {

        while (n > 0) {
            count += (n & 1);
            n >>= 1;
        }

        return count;
    }
}
