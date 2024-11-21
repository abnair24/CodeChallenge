package com.abn.learn.dsa.day13;


import java.util.Arrays;
import java.util.Collections;

/*
Given an array of n integers minimize the cost to empty given away where cost of removing an element is equal to
sum of all elements left in the array before removal.

int[] array = { 2, 1, 4}
// logic : Remove largest 1st.
cost of removing 4: 4 + 2 + 1 = 7
cost of removing 2:     2 + 1 + 7 = 10
cost of removing 1:         1 + 10 = 11

formula = {a, b, c, d} , a >b > c> d
 => a + 2b + 3c + 4d

 */
public class MinimumCostToRemoveElementFromArray {

    public int solve(int[] array) {

        int[] array1 = Arrays.stream(array)
                .boxed()
                .sorted(Collections.reverseOrder())
                .mapToInt(Integer::intValue)
                .toArray();

        int ans = 0;
        for(int i = 0; i < array1.length; i++) {
            ans = ans + (i+1) * array1[i];
        }

        return ans;
    }
}
