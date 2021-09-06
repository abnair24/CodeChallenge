package com.abn.dsalgos.challenges.problems;

import java.util.Stack;

/*
Given an array of integers a, return a new array b using the following guidelines:

For each index i in b, the value of bi is the index of the aj nearest to ai and is also greater than ai.
If there are two options for bi, put the leftmost one in bi.
If there are no options for bi, put -1 in bi.
Example

For a = [1, 4, 2, 1, 7, 6], the output should be
nearestGreater(a) = [1, 4, 1, 2, -1, 4].


 */

public class NearestGreater {

    public void nearestGreater(int[] array) {

        int[] result = new int[array.length];
        Stack<Integer> stack = new Stack<>();

        /*
        Find the nearest bigger value in the left side of the number
         */

        for (int i = 0; i < array.length; i++) {
            while (!stack.isEmpty() && array[i] >= array[stack.peek()]) {
                stack.pop();
            }

            result[i] = stack.isEmpty() ? -1 : stack.peek();
            stack.push(i);
        }

        for (int i = array.length - 1; i >= 0; i--) {
            while (!stack.isEmpty() && array[i] >= array[stack.peek()]) {
                stack.pop();
            }

            /*
            Checking if the diff b/n index towards left > diff between index to right
            ie; i - result[i] > stack.peek() -i -> true, then set stack.peek() as result[i];

             */
            if (result[i] == -1 || ((i - result[i]) > (stack.peek() - i))) {
                result[i] = stack.isEmpty() ? -1 : stack.peek();
            }
            stack.push(i);
        }
        for (int k = 0; k < array.length; k++) {
            System.out.print(result[k] + ", ");
        }
    }

    public static void main(String[] args) {
        int[] array = new int[] {1, 9, 4, 5, 6, 7, 8};

        NearestGreater nearestGreater = new NearestGreater();
        nearestGreater.nearestGreater(array);
    }
}
