package com.abn.scalar.dsa.day30;

import java.util.HashMap;
import java.util.Map;

/*
Given N elements. Find the first non-repeating element.

N = 6 [ 1 2 3 1 2 5 ]
N = 8 [ 4 3 3 2 5 6 4 5 ] ans 2
N = 7 [ 2 6 8 4 7 2 9 ]ans 6
 */
public class FirstNonRepeatingElement {

    public int solve(int[] array) {

        Map<Integer, Integer> map = new HashMap<>();

        for(int num : array) {
            if(map.containsKey(num)) {
                map.put(num, map.get(num) + 1);
            } else {
                map.put(num, 1);
            }
        }

        for(int i = 0; i < array.length; i++) {
            if(map.get(array[i]) == 1) {
                return array[i];
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        FirstNonRepeatingElement firstNonRepeatingElement = new FirstNonRepeatingElement();

        System.out.println(firstNonRepeatingElement.solve(new int[] {2,6,8,4,7,2,9}));
    }
}
