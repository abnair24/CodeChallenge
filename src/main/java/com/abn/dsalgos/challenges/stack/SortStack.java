package com.abn.dsalgos.challenges;

import java.util.Stack;

public class SortStack {

    Stack<Integer>original;
    Stack<Integer> result;

    public SortStack() {
        original =  new Stack<>();
        result = new Stack<>();

    }

    public void sort(Stack<Integer> s) {
        while (!s.isEmpty()) {
            int temp = s.pop();
            while (!result.isEmpty() && result.peek() > temp) {
                s.push(result.pop());
            }
            result.push(temp);
        }

        while (!result.isEmpty()) {
            s.push(result.pop());
        }
    }
}
