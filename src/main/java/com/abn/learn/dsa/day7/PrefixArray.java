package com.abn.learn.dsa.day7;

import java.util.ArrayList;

/*
Given an array A of N integers. Construct prefix sum of the array in the given array itself.

A = [1, 2, 3, 4, 5]
o/p: [1, 3, 6, 10, 15]

A = [4, 3, 2]
o/p: [4, 7, 9]

 */

public class PrefixArray {

    public ArrayList<Integer> solve(ArrayList<Integer> A) {
        ArrayList<Integer> prefixArray = new ArrayList<>(A.size());
        prefixArray.add(0, A.get(0));

        for (int i = 1; i < A.size(); i++) {
            int sum = prefixArray.get(i - 1) + A.get(i);
            prefixArray.add(i, sum);
        }
        return prefixArray;
    }

    public static void main(String[] args) {

        PrefixArray prefixArray = new PrefixArray();

        ArrayList<Integer> array_list = new ArrayList<>();
        array_list.add(1);
        array_list.add(2);
        array_list.add(3);
        array_list.add(4);
        array_list.add(5);

        System.out.println(prefixArray.solve(array_list));
    }

}


