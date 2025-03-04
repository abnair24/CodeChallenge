package com.abn.scalar.dsa.day53;

/*
You are given a doubly linked list which in addition to the next and previous pointers,
it could have a child pointer, which may or may not point to a separate doubly linked list.
These child lists may have one or more children of their own, and so on, to produce a multilevel data structure,
as shown in the example below.

Flatten the list so that all the nodes appear in a single-level, doubly linked list.
You are given the head of the first level of the list.

Input: head = [1,2,3,4,5,6,null,null,null,7,8,9,10,null,null,11,12]
Output: [1,2,3,7,8,11,12,9,10,4,5,6]

1  ->  2  ->  3  ->  4  ->  5  ->  6
   <-     <-  |  <-     <-     <-
              |
              7  -> 8  -> 9  -> 10
                 <- |  <-    <-
                    |
                    11  ->  12
                        <-


o/p:

1 -> 2 -> 3 -> 7 -> 8 -> 11 -> 12 -> 9 -> 10 -> 4 -> 5 -> 6
  <-   <-   <-   <-   <-    <-    <-   <-    <-   <-   <-

 */

import org.checkerframework.checker.units.qual.N;

import java.util.Stack;

class Node {
    public int val;
    public Node prev;
    public Node next;
    public Node child;

    public Node(int val) {
        this.val = val;
    }
}

public class FlattenMultilevelLL {

    public Node flattenMultiLevel(Node root) {

        if(root == null) {
            return root;
        }

        Stack<Node> stack = new Stack<>();
        stack.push(root);

        Node prev = null;

        while(!stack.empty()) {

            Node current = stack.pop();

            if(prev != null) {
                //forming Doubly LL
                prev.next = current;
                current.prev = prev;
            }

            if(current.next != null) {
                stack.push(current.next);
            }

            if(current.child != null) {
                stack.push(current.child);
                current.child = null;
            }

            prev = current;
        }
        return root;
    }

    public static void main(String[] args) {

        Node head = new Node(1);
        head.next = new Node(2);
        head.next.prev = head;

        head.next.next = new Node(3);
        head.next.next.prev = head.next;

        head.next.next.child = new Node(7);

        head.next.next.child.next = new Node(8);
        head.next.next.child.next.prev = head.next.next.child;

        head.next.next.child.next.child = new Node(11);

        head.next.next.child.next.child.next = new Node(12);
        head.next.next.child.next.child.next.prev = head.next.next.child.next.child;

        head.next.next.child.next.next = new Node(9);
        head.next.next.child.next.next.prev = head.next.next.child.next;

        head.next.next.next = new Node(4);
        head.next.next.next.prev = head.next.next;

        head.next.next.next.next = new Node(5);
        head.next.next.next.next.prev =  head.next.next.next;

        head.next.next.next.next.next = new Node(6);
        head.next.next.next.next.next.prev = head.next.next.next.next;

        FlattenMultilevelLL flattenMultilevelLL = new FlattenMultilevelLL();
        flattenMultilevelLL.flattenMultiLevel(head);
    }
}
