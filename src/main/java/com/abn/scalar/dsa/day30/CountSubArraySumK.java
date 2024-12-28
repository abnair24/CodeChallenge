package com.abn.scalar.dsa.day30;

import java.util.HashMap;
import java.util.Map;

/*
Given an array of integers A and an integer B.
Find the total number of subarrays having sum equals to B.

A = [1, 0, 1]
B = 1
o/p: 4

A = [0, 0, 0]
B = 0
o/p: 6

Approach;
calculate prefix sum
p[j] - p[i-1] = target
p[i-1] = p[j] - target.

Find if map has p[j] - target present, if so update count. If not add p[j] in the map
 */
public class CountSubArraySumK {

    public int solve(int[] array, int k) {

        int[] prefix = new int[array.length];
        int count = 0;

        prefix[0] = array[0];

        for(int i = 1; i < array.length; i++) {
            prefix[i] = array[i] + prefix[i - 1];
        }

        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1); // adding to ensure if first prefix element is same as target sum.

        for(int i = 0; i < array.length; i++) {

            int pairNum = prefix[i] - k;
            if(map.containsKey(pairNum)) {
                count += map.get(pairNum);
            }

            map.put(prefix[i], map.getOrDefault(prefix[i], 0) + 1);
        }

        return count;
    }

    public static void main(String[] args) {

        CountSubArraySumK countSubArraySumK = new CountSubArraySumK();
        System.out.println(countSubArraySumK.solve(new int[] {-2,16,-12,5,7,-1,2,12,11}, 17));
        System.out.println(countSubArraySumK.solve(new int[] {19,-10,-13,10,-13,6,7,2,18,-19,-4}, 19));
    }
}
