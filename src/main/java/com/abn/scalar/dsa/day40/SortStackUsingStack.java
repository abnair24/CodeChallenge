package com.abn.scalar.dsa.day40;

import java.util.Stack;

public class SortStackUsingStack {

    public int[] solve(int[] A) {

        Stack<Integer> stack1 = new Stack<>();
        Stack<Integer> stack2 = new Stack<>();

        for(int i = 0; i < A.length; i++) {
            if(stack1.isEmpty() || stack1.peek() < A[i]) {
                stack1.push(A[i]);
            } else {
                while(!stack1.isEmpty() && stack1.peek() > A[i]) {
                    stack2.push(stack1.pop());
                }
                stack1.push(A[i]);
                while(!stack2.isEmpty()) {
                    stack1.push(stack2.pop());
                }
            }
        }
        for(int i = A.length - 1; i >= 0 ; i --) {
            A[i] = stack1.pop();
        }

        return A;
    }

    public static void main(String[] args) {
        SortStackUsingStack sortStackUsingStack = new SortStackUsingStack();
        sortStackUsingStack.solve(new int[] {66,96,43,28,14,1,41,76,70,81,22,11,42,78,4,88,70,43,90,6,12});
    }
}
