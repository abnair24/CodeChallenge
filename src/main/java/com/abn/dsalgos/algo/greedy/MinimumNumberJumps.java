package com.abn.dsalgos.algo.greedy;

import org.testng.collections.Lists;

import java.util.List;

/*
There is a row of seats. Assume that it contains N seats adjacent to each other.
There is a group of people who are already seated in that row randomly. i.e. some are sitting together & some are scattered.

An occupied seat is marked with a character 'x' and an unoccupied seat is marked with a dot ('.')
Now your target is to make the whole group sit together i.e. next to each other, without having any vacant
seat between them in such a way that the total number of hops or jumps to move them should be minimum.

row having 15 seats represented by the String (0, 1, 2, 3, ......... , 14) -

 . . . . x . . x x . . . x . .
 Now to make them sit together one of approaches is -
                  . . . . . . x x x x . . . . .

                  Total moves = 5;
 */
public class MinimumNumberJumps {

    public int jumps(String s) {

        int len = s.length();
        int count = 0;

        List<Integer> list = Lists.newLinkedList();

        for (int i = 0; i < len; i++) {
            if (s.charAt(i) == 'x') {
                //adding index after the substracting the count to obtain the index to which the seat to be moved than actual diff.
                list.add(i - count);
                count++;
            }
        }

        int median = (count - 1) / 2;

        int medianIndex = list.get(median);
        int steps = 0;

        for (Integer integer : list) {
            steps += Math.abs(integer - medianIndex);
        }
        return steps;
    }
}
