package com.abn.scalar.dsa.day59;

/*
The monetary system in DarkLand is really simple and systematic. The locals-only use coins.
 The coins come in different values. The values used are:

 1, 5, 25, 125, 625, 3125, 15625, ...
Formally, for each K >= 0 there are coins worth 5K.

Given an integer A denoting the cost of an item, find and return the smallest number of
coins necessary to pay exactly the cost of the item (assuming you have a sufficient supply
of coins of each of the types you will need).

Input
 A = 47
Input 2:

 A = 9

 Output 1:

 7
Output 2:

 5
 */
public class AnotherCoinProblem {

    public int solve(int A) {

        int i = 0;

        int largest = 0;

        while (Math.pow(5, i) <= A) {
            largest = i;
            i++;
        }

        int coins = 0;
        i = largest;
        while (A > 0) {
            int num = (int) Math.pow(5, i);
            coins = coins + (A / num);
            A = A % num;
            i--;
        }

        return coins;
    }

    public static void main(String[] args) {

        AnotherCoinProblem anotherCoinProblem = new AnotherCoinProblem();
        System.out.println(anotherCoinProblem.solve(47));
    }
}
