package com.abn.scaler.dsa.day39;

import java.util.Stack;

/*
Design a stack that supports push, pop, top, and retrieve the minimum element in constant time.
push(x) -- Push element x onto stack.
pop() -- Removes the element on top of the stack.
top() -- Get the top element.
getMin() -- Retrieve the minimum element in the stack.
NOTE:
All the operations have to be constant time operations.
getMin() should return -1 if the stack is empty.
pop() should return nothing if the stack is empty.
top() should return -1 if the stack is empty.
 */
public class MinStack {

    private Stack<Integer[]> stack;      // Main stack to store elements

    public MinStack() {

        stack = new Stack<>();
    }

    public void push(int x) {

        int min = stack.isEmpty() ? x : Math.min(x, getMin());
        stack.push(new Integer[]{x, min});
    }

    public void pop() {
        if (stack.isEmpty()) {
            return;
        }

        stack.pop();
    }

    public int top() {
        if (stack.isEmpty()) {
            return -1;
        }

        return stack.peek()[0];
    }

    public int getMin() {
        if (stack.isEmpty()) {
            return -1;
        }

        return stack.peek()[1];
    }
}
