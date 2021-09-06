package com.abn.dsalgos.leetcode30Day;

import java.util.HashMap;
import java.util.Map;

public class SingleNumber {

    /*
    Given a non-empty array of integers, every element appears twice except for one. Find that single one.

    Note: Your algorithm should have a linear runtime complexity. Could you implement it without using extra memory?


    Input: [2,2,1]
    Output: 1

    Input: [4,1,2,1,2]
    Output: 4
     */

    public int singleNumberInArray(int[] array) {

        int result = 0;
        Map<Integer, Integer> map = new HashMap<>();

        if (array.length == 1) {
            return array[0];
        }

        for (int i = 0; i < array.length; i++) {
            if (!map.containsKey(array[i])) {
                map.put(array[i], 1);
            } else {
                map.put(array[i], map.get(array[i]) + 1);
            }
        }

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() == 1) {
                result = entry.getKey();
            }
        }

        return result;
    }
}
