package com.abn.dsalgos.algo.twoPointers;

import java.util.Stack;

/*
Given an array of unique positive integers, for each integer,
return the first larger element in the array to the left. If there's no larger element, return -1 for it.

arr = [70, 90, 40, 35, 30, 39, 10]

ans = [-1, -1, 90, 40, 35, 40, 39]

In place swapping is done.
 */

public class LargeElementToLeft {

    public int[] largeElement(int[] array) {

        Stack<Integer> s = new Stack<>();
        s.push(array[0]);

        array[0] = -1;
        int temp;

        // Traverse from i = 1;
        for (int i = 1; i < array.length; i++) {

            // Top of the stack will have previous value.
            // Compare top of stack with current value, if current value is greater pop stack
            while (!s.empty() && s.peek() < array[i]) {
                s.pop();
            }

            //store current value in temp as in place swapping of array is done.
            temp = array[i];

            // if stack doesnt have values, then there is no large element to the left of current value
            if (s.isEmpty()) {
                array[i] = -1;
            } else {
                array[i] = s.peek();
            }

            s.push(temp);
        }
        return array;
    }
}
