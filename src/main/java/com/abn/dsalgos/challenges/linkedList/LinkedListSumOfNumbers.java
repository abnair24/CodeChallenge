package com.abn.dsalgos.challenges.linkedList;

import com.abn.dsalgos.utils.Node;

import java.util.NoSuchElementException;

public class LinkedListSumOfNumbers {

    /* Given two number represent by linked list, calculate sum of the numbers and store
     result in new linked list. Each node of linked list is represented by single digit and
      head node is most significant digit.

     For example:
     Sum of two number:
             56712
             +6359

             63071

 Algorithm:
  * Create two linkedlist which will represent above two numbers.
  * Reverse both linked list.
  * Add two node values (Each node is being represented as single digit)  starting from heads of two linkedlist.
  * If sum is of above two node values is more than 10, then forward the carry.

  */
    private Node first;
    private Node last;

    public LinkedListSumOfNumbers() {
        first = null;
        last = null;
    }

    public void insertFirst(Integer value) {
        Node newLink = new Node(value);
        if (isEmpty()) {
            last = newLink;
        } else {
            newLink.next = first;
        }
        first = newLink;
    }

    public void insertLast(Integer value) {
        Node newLink = new Node(value);
        if (isEmpty()) {
            first = newLink;
        } else {
            last.next = newLink;
        }
        last = newLink;

    }

    public boolean isEmpty() {
        return first == null;
    }

    public Integer getFirst() {
        Node temp = first;
        if (temp == null) {
            throw new NoSuchElementException();
        } else {
            return temp.data;
        }
    }

    public Integer getLast() {
        Node temp = last;
        if (temp == null) {
            throw new NoSuchElementException();
        } else {
            return temp.data;
        }
    }

    public Node getFirstNode() {
        Node temp = first;
        if (temp == null) {
            throw new NoSuchElementException();
        } else {
            return temp;
        }
    }

    public void print(Node firstNode) {
        Node n = firstNode;
        while (n != null) {
            System.out.print(n.data + "");
            n = n.next;
        }
        System.out.println();
    }

    public Node reverseLinkedList(Node firstNode) {
        Node currentNode = firstNode;
        Node prevNode = null;
        Node nextNode;

        while (currentNode != null) {
            // Getting the next node and storing
            nextNode = currentNode.next;
            // linking current node to null (for first case and late to prev nods)
            currentNode.next = prevNode;
            //iterating
            prevNode = currentNode;
            currentNode = nextNode;
        }
        firstNode = prevNode;
        return firstNode;
    }

    public Node sumOfNumbers(LinkedListSumOfNumbers l1, LinkedListSumOfNumbers l2) {

        Node head1 = reverseLinkedList(l1.getFirstNode());
        Node head2 = reverseLinkedList(l2.getFirstNode());

        int carry = 0;
        int sum;

        Node sumHead = null;
        Node sumNode = null;

        int count = 0;

        while (head1 != null || head2 != null) {
            count++;

            sum = carry;
            if (head1 != null) {
                sum = sum + head1.data;
                head1 = head1.next;
            }

            if (head2 != null) {
                sum = sum + head2.data;
                head2 = head2.next;
            }

            carry = sum / 10;
            sum = sum % 10;

            if (count == 1) {
                sumNode = new Node(sum);
                sumHead = sumNode;
            } else {
                Node tempNode = new Node(sum);
                sumNode.next = tempNode;
                sumNode = sumNode.next;
            }
        }

        if (carry != 0) {
            sumNode.next = new Node(carry);
        }

        return reverseLinkedList(sumHead);
    }

}
