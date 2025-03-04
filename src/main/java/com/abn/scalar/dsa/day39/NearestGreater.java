package com.abn.scalar.dsa.day39;

import java.util.Arrays;
import java.util.Stack;

/*
Given an array A, find the next greater element G[i] for every element A[i] in the array.
The next greater element for an element A[i] is the first greater element on the right side of A[i] in the array, A.


More formally:

G[i] for an element A[i] = an element A[j] such that
    j is minimum possible AND
    j > i AND
    A[j] > A[i]
Elements for which no greater element exists, consider the next greater element as -1.









Problem Constraints

1 <= |A| <= 105


1 <= A[i] <= 107




Input Format

The first and the only argument of input contains the integer array, A.



Output Format

Return an integer array representing the next greater element for each index in A.



Example Input

Input 1:

 A = [4, 5, 2, 10]
Input 2:

 A = [3, 2, 1]



Example Output

Output 1:

 [5, 10, 10, -1]
Output 2:

 [-1, -1, -1]


 */

public class NearestGreater {

    public int[] solve(int[] array) {
        Stack<Integer> stack = new Stack<>();
        int[] result = new int[array.length];

        stack.push(array[array.length - 1]);
        result[array.length - 1] = -1;

        for(int i = array.length - 2; i >= 0; i --) {
            while(!stack.isEmpty() && array[i] >= stack.peek()) {
                stack.pop();
            }

            if(!stack.isEmpty()) {
                result[i] = stack.peek();
            } else {
                result[i] = -1;
            }

            stack.push(array[i]);
        }

        return result;
    }

    public static void main(String[] args) {

        NearestGreater nearestGreater = new NearestGreater();
        System.out.println(Arrays.toString(nearestGreater.solve(new int[] {34,35,27,42,5,28,39,20,28})));
        System.out.println(Arrays.toString(nearestGreater.solve(new int[] {39,27,11,4,24,32,32,1})));


    }
}
