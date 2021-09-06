package com.abn.dsalgos.algo;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;

/*
Rearrange a given array so that Arr[i] becomes Arr[Arr[i]] with O(1) extra space.

Input : [1, 0]
Return : [0, 1]
 */

public class RearrangeArray {

    public static void arrangeArray(ArrayList<Integer> a) {
        Map<Integer, Integer> hm = new LinkedHashMap<>();

        for (int i = 0; i < a.size(); i++) {
            hm.put(i, a.get(i));
        }

        hm.forEach((k, v) ->
                System.out.print(a.get(v) + " "));
    }

    public static void main(String[] args) {
        ArrayList<Integer> input = new ArrayList<>();
        input.add(4);
        input.add(0);
        input.add(2);
        input.add(1);
        input.add(3);

        arrangeArray(input);
    }
}
