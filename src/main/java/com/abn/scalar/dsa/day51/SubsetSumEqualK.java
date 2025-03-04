package com.abn.scalar.dsa.day51;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/*
Given an integer array A of size N.


You are also given an integer B, you need to find whether their exist a subset in A whose sum equal B.

If there exist a subset then return 1 else return 0.

Note : Sum of elements of an empty subset is 0.

Input 1:

 A = [3, 34, -3, 12, 5, 2]
 B = 9
Input 2:

 A = [-8, 34, 4, 0, -5, -2]
 B = -20


Example Output

Output 1:

 1
Output 2:

 0
 */
public class SubsetSumEqualK {

    List<List<Integer>> result = new ArrayList<>();

    public int findSubset(int[] array, int target) {

        if(array.length == 1 && array[0] != target) {
            return 0;
        }

        LinkedList<Integer> track = new LinkedList<>();
        backtrack(array, target, 0, track,0);

        return result.isEmpty() ? -1 : 1;

    }

    private void backtrack(int[] array, int target, int index, LinkedList<Integer> track, int sum) {

        if(sum == target) {
            result.add(new ArrayList<>(track));
            return;
        }

        if(index >= array.length) {
            return;
        }

        track.add(array[index]);

        backtrack(array, target, index + 1, track, sum + array[index]);

        track.removeLast();
        backtrack(array, target, index + 1, track, sum);
    }

    public static void main(String[] args) {

        SubsetSumEqualK subsetSumEqualK = new SubsetSumEqualK();
        System.out.println(subsetSumEqualK.findSubset(new int[] {7, 3, 8}, 10));
        System.out.println(subsetSumEqualK.findSubset(new int[] {-5, 3}, -2));
    }
}
