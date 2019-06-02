package com.abn.dsalgos.challenges.dp;


/*
Count the number of Binary Substring that start and end with 1

0110 -> 1
01010 -> 1
001001101 -> 6 ( 1001, 10011,1001101, 11, 1101, 101)
 */
public class BinaryStringStartAndEndWithOne {

    public int getCount(String str) {

        int len = str.length();
        int count =0;
        int totalStringCount =0;

        for(int i=0; i<len;i++) {
            if((str.charAt(i)-'0') == 1 ) {
                count+= 1;
            }
        }

        if(count!=0) {
            totalStringCount = count * (count -1) /2;
        } else {
            totalStringCount = 0;
        }

        return totalStringCount;
    }

}
