package com.abn.scalar.dsa.day39;

import java.util.Arrays;
import java.util.Stack;


/*
Given an array A, find the nearest smaller element G[i] for every element A[i] in the array such that the element has an index smaller than i.


More formally,

G[i] for an element A[i] = an element A[j] such that

j is maximum possible AND

j < i AND

A[j] < A[i]

Elements for which no smaller element exist, consider the next smaller element as -1.

Example Input

Input 1:


 A = [4, 5, 2, 10, 8]

Input 2:


 A = [3, 2, 1]



Example Output

Output 1:


 [-1, 4, -1, 2, 2]

Output 2:


 [-1, -1, -1]
 */
public class NearestSmallerElement {

    public int[] solve(int[] A) {

        Stack<Integer> stack = new Stack<>();
        int[] result = new int[A.length];

        stack.push(A[0]);
        result[0] = -1;

        for(int i = 1; i< A.length; i++) {
            while(!stack.isEmpty() && A[i] <= stack.peek()) {
                stack.pop();
            }

            if(!stack.isEmpty()) {
                result[i] = stack.peek();
            } else {
                result[i] = -1;
            }

            stack.push(A[i]);
        }

        return result;
    }

    public static void main(String[] args) {

        NearestSmallerElement nearestSmallerElement = new NearestSmallerElement();
        System.out.println(Arrays.toString(nearestSmallerElement.solve(new int[] {34,35,27,42,5,28,39,20,28})));

    }
}
