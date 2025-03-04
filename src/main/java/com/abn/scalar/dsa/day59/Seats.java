package com.abn.scalar.dsa.day59;

import java.util.ArrayList;
import java.util.List;

/*
There is a row of seats represented by string A. Assume that it contains N seats adjacent to each other.
There is a group of people who are already seated in that row randomly. i.e. some are sitting together & some are scattered.

An occupied seat is marked with a character 'x' and an unoccupied seat is marked with a dot ('.')

Now your target is to make the whole group sit together i.e. next to each other, without having any vacant seat between
them in such a way that the total number of hops or jumps to move them should be minimum.

In one jump a person can move to the adjacent seat (if available).

NOTE: 1. Return your answer modulo 107 + 3.


Input 1:

 A = "....x..xx...x.."
Input 2:

 A = "....xxx"

 Output 1:

 5
Output 2:

 0

 */
public class Seats {

    public int seats(String s) {
        int len = s.length();
        int count = 0;

        List<Integer> list = new ArrayList<>();

        for (int i = 0; i < len; i++) {
            if (s.charAt(i) == 'x') {
                //adding index after the substracting the count to obtain the index to which the seat to be moved than actual diff.
                list.add(i - count);
                count++;
            }
        }

        if(count == 0) {
            return 0;
        }

        int median = (count - 1) / 2;

        int medianIndex = list.get(median);
        long steps = 0;

        for (Integer n : list) {
            steps += Math.abs(n - medianIndex);
        }
        return (int) (steps % 10000003);
    }
}
