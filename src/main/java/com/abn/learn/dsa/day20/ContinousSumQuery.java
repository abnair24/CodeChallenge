package com.abn.learn.dsa.day20;

/*
There are A beggars sitting in a row outside a temple. Each beggar initially has an empty pot.
When the devotees come to the temple, they donate some amount of coins to these beggars.
Each devotee gives a fixed amount of coin(according to their faith and ability) to some K beggars sitting next to each other.

Given the amount P donated by each devotee to the beggars ranging from L to R index,
where 1 <= L <= R <= A,

find out the final amount of money in each beggar's pot at the end of the day, provided they don't fill their pots by any other means.
For ith devotee
B[i][0] = L,
B[i][1] = R,
B[i][2] = P, given by the 2D array B

Input 1:-
A = 5
B = [[1, 2, 10], [2, 3, 20], [2, 5, 25]]

O/P: 10 55 45 25 25
 */
public class ContinousSumQuery {

    public int[] solve(int A, int[][] B) {

        int[] array = new int[A];

        for(int i = 0; i < B.length; i++) {
            int s = B[i][0];
            int e = B[i][1];
            int v = B[i][2];

            array[s-1] = array[s-1] + v;
            if(e < A) {
                array[e] = array[e] - v;
            }
        }

        for(int i = 1; i < A; i++) {
            array[i] = array[i] + array[i-1];
        }

        return array;
    }
}
