package com.abn.dsalgos.codility;

import java.util.Stack;

/*
Given an array A consisting of N distinct integers. Sort array A such that , divide array into one or more slices. Sort each slice
and join the sorted slice in same order. Joined slices makes the array in sorted fashion. Write the function to return maximum slices needed to sort array.

eg:
{2, 4, 1, 6, 5, 9, 7} : 3
   (2, 4,1) , (6, 5), (9, 7)

{4, 3, 2, 6, 1} : 1

{2, 1, 6, 4, 3, 7 } : 3

 */

public class MaxSlices {

    public int maxSlices(int [] array) {

        Stack<Integer> stack = new Stack<>();
        stack.push(array[0]);

        for(int i = 1; i< array.length; i++) {

            if(array[i] > stack.peek()) {
                stack.push(array[i]);
            } else {

                int last = stack.pop();
                while(stack.size() > 0 && array[i] <stack.peek()) {
                    stack.pop();
                }
                stack.push(last);

            }
        }
        return stack.size();
    }


    public static void main(String[] args) {

        MaxSlices maxSlices = new MaxSlices();
//
       System.out.println(maxSlices.maxSlices(new int[] {2, 4, 1, 6, 5, 9, 7}));
        System.out.println(maxSlices.maxSlices(new int[] {4, 3,2, 6, 1}));
        System.out.println(maxSlices.maxSlices(new int[]{2,1,6,4,3,7}));
        System.out.println(maxSlices.maxSlices(new int[]{1, 7, 5, 4, 2, 12}));
    }
}
