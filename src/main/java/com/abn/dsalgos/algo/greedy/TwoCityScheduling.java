package com.abn.dsalgos.algo.greedy;

import java.util.Arrays;
import java.util.Comparator;

/*

A recruiter plans to hire n people and conducts their interviews at two different locations of the company. H
e evaluates the cost of inviting candidates to both these locations. The plan is to invite 50% at one location,
and the rest at the other location, keeping costs to a minimum.
We are given an array, costs, where costs[i]=[aCosti,bCosti], the cost of inviting the ith person to City A is aCosti,
and the cost of inviting the same person to City B is bCosti.
You need to determine the minimum cost to invite all the candidates for the interview such that exactly n/2 people
are invited in each city.

Constraints:
2≤ costs.length ≤100
costs.length is even
1≤aCosti,bCosti≤1000

Approach:

The steps of the solution according to the above-mentioned methodology are given below:
1. Declare a variable, totalCost, initialized to 0.
2. Sort the costs array in ascending order based on the difference between the cost of sending a person to
   City A versus sending the same person to City B.
3. Iterate over the sorted costs array to calculate the minimum costs required to send n/2 people to each city.
   We will perform the following steps:
       a. For the first n/2 elements in the costs array, add aCosti to the total cost for inviting candidates to City A.
       b. For the remaining n/2 elements in the costs array, add bCosti to the total cost for inviting candidates to City B.
       c. Return the total minimum cost after traversing the costs array.


 */
public class TwoCityScheduling {

    public int solve(int[][] costs) {

        Arrays.sort(costs, (a, b) -> (a[0] - a[1]) - (b[0] - b[1]));

        int length = costs.length;
        int total = 0;

        for(int i = 0; i < length/2; i++) {
            total += costs[i][0] + costs[length - 1][1];
        }

        return total;
    }

    public static void main(String[] args) {
        TwoCityScheduling twoCityScheduling = new TwoCityScheduling();
        System.out.println(twoCityScheduling.solve(new int[][] {
                {10, 20}, {30, 200}, {400, 50}, {30,20}
        }));
    }
}
