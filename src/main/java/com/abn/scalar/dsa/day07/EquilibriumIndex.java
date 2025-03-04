package com.abn.scalar.dsa.day07;

/*
You are given an array A of integers of size N.

Your task is to find the equilibrium index of the given array

The equilibrium index of an array is an index such that the sum of elements at lower indexes is equal to the sum of elements
 at higher indexes.

If there are no elements that are at lower indexes or at higher indexes, then the corresponding sum of elements is
considered as 0.

A = [-7, 1, 5, 2, -4, 3, 0]

o/p: 3

i   Sum of elements at lower indexes    Sum of elements at higher indexes
0                   0                                   7
1                  -7                                   6
2                  -6                                   1
3                  -1                                  -1
4                   1                                   3
5                  -3                                   0
6                   0                                   0


A = [1, 2, 3]

o/p: -1
 */

public class EquilibriumIndex {

    public int solve(int[] array) {

        for(int i = 1; i < array.length; i++) {

            array[i] = array[i - 1] + array[i];
        }

        for(int i = 0; i < array.length; i++) {

            int lowerSum = 0;
            int upperSum = 0;

            if(i == 0) {
                lowerSum = 0;
            } else {
                lowerSum = array[i - 1];
            }
            upperSum = array[array.length - 1] - array[i];

            if(lowerSum == upperSum) {
                return i;
            }
        }

        return -1;
    }

    public static void main(String[] args) {

        EquilibriumIndex equilibriumIndex = new EquilibriumIndex();
        System.out.println(equilibriumIndex.solve(new int[] {-7, 1, 5, 2, -4, 3, 0}));
    }
}
