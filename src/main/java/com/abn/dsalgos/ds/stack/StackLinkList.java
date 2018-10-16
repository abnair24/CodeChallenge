package com.abn.dsalgos.ds.stack;

import com.abn.dsalgos.exceptions.EmptyStackException;
import com.abn.dsalgos.utils.LinkNode;

/**
 * Created by aswathyn on 14/02/17.
 */
public class StackLinkList<T> {

    private LinkNode<T> top ;
    private int size;


    public StackLinkList() {
        top = null;
        size=0;
    }

    public void push(T value) {

        LinkNode<T> newLink= new LinkNode<>(value);

        newLink.next= top;
        top = newLink;
        size++;
    }

    public T pop() throws Exception{
        if(isEmpty()){
            throw new EmptyStackException();
        } else {
            LinkNode<T> temp = top;
            top = top.next;
            size--;
            return temp.data;
        }
    }

    public void displayList() {
        LinkNode<T>current = top;
        while(current!=null) {
            current.displayLink();
            current=current.next;
        }
        System.out.println(" ");
    }

    public boolean isEmpty() {
        return (top == null);
    }

    public T peek() throws Exception {
        if(isEmpty()) {
            throw new EmptyStackException();
        } else {
            return top.data;
        }

    }

    public int size() {
        return size;
    }


}


