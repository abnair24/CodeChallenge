package com.abn.dsalgos.challenges.string;


import java.util.stream.IntStream;

/*
Count the number of Binary Substring that start and end with 1

0110 -> 1
01010 -> 1
001001101 -> 6 ( 1001, 10011,1001101, 11, 1101, 101)
 */
public class StringStartAndEndWithOne {

    public int getCount(String str) {

        int len = str.length();
        int count;
        int totalStringCount;

        count = (int) IntStream.range(0, len).filter(i -> (str.charAt(i) - '0') == 1).count();

        if(count!=0) {
            totalStringCount = count * (count -1) /2;
        } else {
            totalStringCount = 0;
        }

        return totalStringCount;
    }

}
