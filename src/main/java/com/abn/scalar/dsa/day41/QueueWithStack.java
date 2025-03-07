package com.abn.scalar.dsa.day41;

import java.util.Stack;

/*
Implement a First In First Out (FIFO) queue using stacks only.

The implemented queue should support all the functions of a normal queue (push, peek, pop, and empty).

Implement the UserQueue class:

void push(int X) : Pushes element X to the back of the queue.
int pop() : Removes the element from the front of the queue and returns it.
int peek() : Returns the element at the front of the queue.
boolean empty() : Returns true if the queue is empty, false otherwise.
NOTES:

You must use only standard operations of a stack, which means only push to top, peek/pop from top, size, and is empty operations are valid.
Depending on your language, the stack may not be supported natively. You may simulate a stack using a list or deque (double-ended queue) as
long as you use only a stack's standard operations.

1) UserQueue()
 2) push(20)
 3) empty()
 4) peek()
 5) pop()
 6) empty()
 7) push(30)
 8) peek()
 9) push(40)
 10) peek()
Input 2:

 1) UserQueue()
 2) push(10)
 3) push(20)
 4) push(30)
 5) pop()
 6) pop()


Example Output

Output 1:

 false
 20
 20
 true
 30
 30
Output 2:

 10
 20
 */
public class QueueWithStack {


    static class UserQueue {
        /**
         * Initialize your data structure here.
         */
        static Stack<Integer> stack1, stack2;


        UserQueue() {
            stack1 = new Stack<>();
            stack2 = new Stack<>();
        }

        /**
         * Push element X to the back of queue.
         */
        static void push(int value) {
            stack1.push(value);
        }

        private static void shiftStacks() {
            if (stack2.isEmpty()) {
                while (!stack1.isEmpty()) {
                    stack2.push(stack1.pop());
                }
            }
        }

        /**
         * Removes the element from in front of queue and returns that element.
         */
        static int pop() {
            shiftStacks();
            return stack2.pop();
        }

        /**
         * Get the front element of the queue.
         */
        static int peek() {
            shiftStacks();
            return stack2.peek();
        }

        /**
         * Returns whether the queue is empty.
         */
        static boolean empty() {
            return stack1.empty() && stack2.empty();
        }
    }

}
