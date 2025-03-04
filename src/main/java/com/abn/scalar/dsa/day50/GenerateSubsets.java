package com.abn.scalar.dsa.day50;

import java.util.ArrayList;
import java.util.LinkedList;

/*
Given a set of distinct integers A, return all possible subsets that can be formed from the elements of array A.
A = [1, 2, 3]

[
 []
 [1]
 [1, 2]
 [1, 2, 3]
 [1, 3]
 [2]
 [2, 3]
 [3]
]
 */
public class GenerateSubsets {

    ArrayList<ArrayList<Integer>> result = new ArrayList<>();
    public ArrayList<ArrayList<Integer>> subsets(ArrayList<Integer> A) {
        // code here
        LinkedList<Integer> track = new LinkedList<>();
        backtrack(A, track, 0);
        return result;
    }

    private void backtrack(ArrayList<Integer> array,LinkedList<Integer> track, int start) {

        result.add(new ArrayList<>(track)) ;

        for(int i = start; i < array.size(); i ++) {
            track.add(array.get(i));
            backtrack(array, track, i + 1);
            track.removeLast();
        }
    }
}
