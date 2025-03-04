package com.abn.scalar.dsa.day58;

import java.util.PriorityQueue;

/*
Misha loves eating candies. She has been given N boxes of Candies.

She decides that every time she will choose a box having the minimum number of
candies, eat half of the candies and put the remaining candies in the other box that has the minimum number of candies.
Misha does not like a box if it has the number of candies greater than B so she
won't eat from that box. Can you find how many candies she will eat?

NOTE 1: If a box has an odd number of candies then Misha will eat the floor(odd / 2).

NOTE 2: The same box will not be chosen again.

 */
public class MishaAndCandies {

    public int solve(int[] array, int B) {

        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for(int i = 0; i < array.length; i++) {
            pq.add(array[i]);
        }

        int totalCandies = 0;
        int remainingCandies = 0;

        while(!pq.isEmpty()) {

            int min = pq.poll();
            min = min + remainingCandies;

            pq.offer(min);
            min = pq.poll();

            if(min <= B) {
                int half = min / 2;
                totalCandies = totalCandies + half;
                remainingCandies = min - half;
            }
        }

        return totalCandies;
    }

    public static void main(String[] args) {

        MishaAndCandies mishaAndCandies = new MishaAndCandies();
        System.out.println(mishaAndCandies.solve(new int[] {3, 2, 3}, 4));
        System.out.println(mishaAndCandies.solve(new int[] {1, 2, 1}, 2));
    }
}
