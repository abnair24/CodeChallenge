package com.abn.dsalgos.algo.greedy;

import java.util.Arrays;

/*
A big ship with numerous passengers is sinking, and there is a need to evacuate these people
with the minimum number of life-saving boats. Each boat can carry, at most, two persons however,
the weight of the people cannot exceed the carrying weight limit of the boat.

We are given an array, people, where people[i] is the weight of the ith person, and an infinite number of boats,
where each boat can carry a maximum weight, limit. Each boat carries, at most, two people at the same time.
This is provided that the sum of the weight of these people is under or equal to the weight limit.

You need to return the minimum number of boats to carry all persons in the array.

Constraints:
1 ≤ people.length ≤ 5x10^3

1 ≤ people[i] ≤ limit ≤ 3×10^3

 */
public class BoatsToSavePeople {

    public int rescueBoats(int[] array, int limit) {

        Arrays.sort(array);
        int sptr = 0;
        int eptr = array.length - 1;
        int boats = 0;

        while(sptr <= eptr) {
            if (array[sptr] + array[eptr] <= limit) {
                sptr++;
            }
            eptr --;

            boats++;
        }
        return boats;
    }

    public static void main(String[] args) {

        BoatsToSavePeople boats = new BoatsToSavePeople();
        System.out.println(boats.rescueBoats(new int[] {3,1,4,2,4}, 4));
        System.out.println(boats.rescueBoats(new int[] {1,1,1,1,2}, 3));
        System.out.println(boats.rescueBoats(new int[] {1,2}, 3));
        System.out.println(boats.rescueBoats(new int[] {5,5,5,5}, 5));
        System.out.println(boats.rescueBoats(new int[] {3,2,5,5}, 5));

    }
}
