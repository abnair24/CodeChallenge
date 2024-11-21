package com.abn.learn.dsa.day7;

import java.util.ArrayList;

public class PrefixArrayInSameArray {

    public ArrayList<Integer> solve(ArrayList<Integer> list) {

        ArrayList<ArrayList<Integer>> B = new ArrayList<>();

        for (int i = 1; i < list.size(); i++) {
            int sum = list.get(i - 1) + list.get(i);
            list.set(i, sum);
        }
        return list;
    }

    public static void main(String[] args) {
        PrefixArrayInSameArray prefixArray = new PrefixArrayInSameArray();

        ArrayList<Integer> array_list = new ArrayList<>();
        array_list.add(1);
        array_list.add(2);
        array_list.add(3);
        array_list.add(4);
        array_list.add(5);

        System.out.println(prefixArray.solve(array_list));
    }
}
