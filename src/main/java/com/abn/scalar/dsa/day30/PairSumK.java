package com.abn.scalar.dsa.day30;

import java.util.HashSet;

/*
Given an arr[ N ] and K.
Check if there exists a pair ( i , j ) such that, arr[ i ] + arr[ j ] = K && i != j
 */
public class PairSumK {

    public boolean solve(int[] array, int k) {

        HashSet<Integer> set = new HashSet<>();

        for(int num : array) {
            if(set.contains(k - num)) {
                return true;
            } else {
                set.add(num);
            }
        }

        return false;
    }

    public static void main(String[] args) {

        PairSumK pairSumK = new PairSumK();
        pairSumK.solve(new int[] {8, 9, 2, -2, 4, 10, 11}, 18);
    }
}
