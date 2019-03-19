package com.abn.dsalgos.challenges.linkedList;

import com.abn.dsalgos.utils.LinkNode;
import java.util.NoSuchElementException;
import java.util.Stack;

public class ReverseLinkedListFromMtoN<T> {

    private LinkNode<T> first;
    private LinkNode<T> last;
    private int size;

    public ReverseLinkedListFromMtoN() {
        first =null;
        last = null;
        size=0;
    }

    public void insertFirst(T value) {
        LinkNode<T> newLink = new LinkNode<>(value);
        if(isEmpty()) {
            last = newLink;
        } else {
            newLink.next = first;
        }
        first = newLink;
        size++;
    }

    public void insertLast(T value) {
        LinkNode <T> newLink = new LinkNode<>(value);
        if(isEmpty()) {
            first = newLink;
        } else {
            last.next = newLink;
        }
        last = newLink;
        size ++;
    }

    public boolean isEmpty() {
        return first == null;
    }

    public T deleteFirst() throws Exception {
        if(isEmpty()){
            throw new NoSuchElementException();
        } else {
            LinkNode<T> temp = first;
            first = first.next;
            size--;
            return temp.data;
        }
    }

    public LinkNode<T> getFirstNode() {
        LinkNode<T> temp = first;
        if(temp == null){
            throw new NoSuchElementException();
        } else {
            return temp;
        }
    }

    public LinkNode<T> reverseLinkedListFromMtoN(LinkNode<T> node, int m, int n) {
        LinkNode<T> previous = null;
        LinkNode<T> current = node;
        LinkNode<T> temp = null;
        LinkNode<T> head = node;

        int size = 1;
        Stack<LinkNode>stack = new Stack<>();

        /*
        If m == n or m>n return head node;
         */
        if(m>=n) {
            return node;
        }

        if(current == null) {
            return null;
        }

        /*
        Find the previous before the m position
         */
        while(current != null) {

            if(size == (m-1)){
                previous = current;
            }
            if(size == m){
                for(int i = 0; i<= (n-m);i++) {
                    stack.push(current);
                    current =  current.next;
                    size++;
                }
                /*
                If m = 1,previous will be null , then head need to be set as stack peek.
                 */
                if(previous == null) {
                    previous = node;
                    head = stack.peek();
                }
                while(!stack.empty()) {
                    temp = stack.pop();
                    previous.next = temp;
                    previous = previous.next;
                }

                previous.next = current;
            }
            if(current != null) {
                current = current.next;
            }
            size++;
        }
        return head;
    }

    public void print(LinkNode<T> node) {
        LinkNode n = node;
        while (n != null) {
            System.out.print(n.data + " ");
            n = n.next;
        }
        System.out.println();
    }
}
