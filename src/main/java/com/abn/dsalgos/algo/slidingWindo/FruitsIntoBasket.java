package com.abn.dsalgos.algo.slidingWindo;

/*
Given an array of characters where each character represents a fruit tree,
 you are given two baskets, and your goal is to put maximum number of fruits
 in each basket. The only restriction is that each basket can have only one type of fruit.

You can start with any tree, but you cant skip a tree once you have started.
You will pick one fruit from each tree until you cannot, i.e., you will stop when
 you have to pick from a third fruit type.

Write a function to return the maximum number of fruits in both the baskets.
 */

import java.util.HashMap;

public class FruitsIntoBasket {

    public int maxFruitCount(char[] arr) {

        int start = 0;
        int maxCount = 0;
        int count;
        HashMap<Character, Integer> hm = new HashMap<>();

        for(int i=0; i< arr.length; i++) {
            hm.put(arr[i], hm.getOrDefault(arr[i], 0) + 1);

            while (hm.size() > 2) {
                hm.put(arr[start], hm.get(arr[start])-1);
                if(hm.get(arr[start]) == 0) {
                    hm.remove(arr[start]);
                }
                start++;
            }
            count = i - start + 1;
            maxCount = Math.max(maxCount, count);
        }
        return maxCount;
    }
}
