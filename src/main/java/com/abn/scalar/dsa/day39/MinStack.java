package com.abn.scalar.dsa.day39;

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

    private Stack<Integer> stack;      // Main stack to store elements
    private Stack<Integer> minStack;   // Auxiliary stack to track minimums

    public MinStack() {

        stack = new Stack<>();
        minStack = new Stack<>();
    }

    public void push(int x) {

        stack.push(x);

        // If minStack is empty or x is smaller than current min,
        // push x to minStack. Otherwise, duplicate the current min.
        if (minStack.isEmpty() || x < minStack.peek()) {
            minStack.push(x);
        } else {
            minStack.push(minStack.peek());
        }
    }

    public void pop() {
        if (stack.isEmpty()) {
            return;
        }

        stack.pop();
        minStack.pop();
    }

    public int top() {
        if (stack.isEmpty()) {
            return -1;
        }

        return stack.peek();
    }

    public int getMin() {
        if (minStack.isEmpty()) {
            return -1;
        }

        return minStack.peek();
    }
}
