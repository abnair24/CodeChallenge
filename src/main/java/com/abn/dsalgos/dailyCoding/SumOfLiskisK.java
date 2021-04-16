package com.abn.dsalgos.dailyCoding;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;


/*
Given an array of integers nums and an integer target, return the two numbers such that they add up to target.

You may assume that each input would have exactly one solution, and you may not use the same element twice.

You can return the answer in any order.

 */
public class SumOfLiskisK {

    public List<Integer> sumOfListIsK(int[] array,int k) throws Exception {
        int length = array.length;

        HashSet<Integer> hm = new HashSet<>();
        List<Integer> list = new ArrayList<>();

        for(int i=0;i<length;i++) {
            if(hm.contains(k-array[i])) {
                System.out.println(array[i] + ":" + (k-array[i]));
            } else {
                hm.add(array[i]);
            }
        }
        return list;
    }
}
