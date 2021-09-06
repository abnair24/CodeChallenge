package com.abn.dsalgos.challenges.queue;

import java.util.Stack;

public class QueueWithTwoStacks<T> {
    Stack<T> stack1, stack2;

    public QueueWithTwoStacks() {
        stack1 = new Stack<>();
        stack2 = new Stack<>();
    }

    public int size() {
        return stack1.size() + stack2.size();
    }

    public void enqueue(T value) {
        stack1.push(value);
    }

    private void shiftStacks() {
        if (stack2.isEmpty()) {
            while (!stack1.isEmpty()) {
                stack2.push(stack1.pop());
            }
        }
    }

    public T dequeue() {
        shiftStacks();
        return stack2.pop();
    }

    public T peek() {
        shiftStacks();
        return stack2.peek();
    }
}
