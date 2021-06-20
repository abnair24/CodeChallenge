package com.abn.dsalgos.algo.bitwise;

/*
Complement of Base 10 Number.

One's compliment can be obtained

num ^ compliment = allbitset;

 == > num ^ allbitset = compliment

1. Find the number of bits in current number's binary form
2. All bit set can be found by pow(2, numberofbits) - 1 : eg: pow(2, 3) - 1;
3. XOR num and allbits

 */
public class ComplimentOfNumber {

    public int compliment(int num) {

        int count = 0;
        int temp = num;

        while(temp > 0) {
            count ++;
            temp = temp >> 1;
        }

        int fullSetBitsNumber = (int) Math.pow(2, count) - 1;

        return num ^ fullSetBitsNumber;
    }
}
