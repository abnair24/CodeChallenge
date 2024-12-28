package com.abn.scalar.dsa.day30;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/*
You are given an array of N integers, A1, A2 ,..., AN and an integer B. Return the of count of distinct numbers
in all windows of size B.

Formally, return an array of size N-B+1 where i'th element in this array contains number of distinct elements
in sequence Ai, Ai+1 ,..., Ai+B-1.

NOTE: if B > N, return an empty array.

Input 1:

 A = [1, 2, 1, 3, 4, 3]
 B = 3
 o/p:  [2, 3, 3, 2]


 A = [1, 1, 2, 2]
 B = 1

 [1, 1, 1, 1]
 */
public class DistinctNumbersInWindow {

    public int[] dNums(int[] A, int B) {
        int count;
        int[] countArray = new int[A.length - B + 1];

        if(B == 1) {
            Arrays.fill(countArray, 1);
            return countArray;
        }

        Map<Integer, Integer> map = new HashMap<>();

        for(int i = 0; i < B; i++) {
            map.put(A[i], map.getOrDefault(A[i], 0)+ 1);
        }

        count = map.size();
        countArray[0] = count;
        int rightPtr = B;
        int leftPtr = 0;
        int index = 1;

        while(rightPtr < A.length) {

            if(map.get(A[leftPtr]) - 1 == 0) {
                map.remove(A[leftPtr]);
            } else {
                map.put(A[leftPtr], map.get(A[leftPtr])-1);
            }
            map.put(A[rightPtr], map.getOrDefault(A[rightPtr],  0) + 1);

            rightPtr ++;
            leftPtr ++;
            countArray[index ++] = map.size();
        }
        return countArray;
    }

    public static void main(String[] args) {
        DistinctNumbersInWindow distinctNumbersInWindow = new DistinctNumbersInWindow();
        System.out.println(Arrays.toString(distinctNumbersInWindow.dNums(new int[] {1, 2, 1, 3, 4, 3}, 3)));
        System.out.println(Arrays.toString(distinctNumbersInWindow.dNums(new int[] {2, 1, 0, 0, 3, 5}, 1)));
    }
}
