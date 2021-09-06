package com.abn.dsalgos.ds.queue;

import com.abn.dsalgos.utils.LinkNode;

import java.util.NoSuchElementException;


/**
 * Created by aswathyn on 16/02/17.
 */
public class PriorityQLinkList<T extends Comparable<T>> {

    private LinkNode<T> head;
    private int size;

    public PriorityQLinkList() {
        head = null;
        size = 0;
    }

    public boolean isEmpty() {
        return head == null;
    }

    public void insert(T value) {
        LinkNode<T> newLink = new LinkNode<>(value);

        LinkNode<T> prev = null;
        LinkNode<T> current = head;

//        if(size==0) {
//            head=newLink;
//        }
//        else if(size==1)
//        {
//            if(current.data.compareTo(value) <=0)
//            {
//                prev=head;
//                head=newLink;
//                head.next=prev;
//            }
//        }
//        else {
//            boolean newLinkInserted=false;
//            while (current!=null)
//            {
//                if(current.data.compareTo(value) > 0)
//                {
//                    prev=current;
//                    current=current.next;
//                }
//                else
//                {
//
//                    prev.next=newLink;
//                    newLink.next=current;
//                    newLinkInserted=true;
//                    break;
//                }
//            }
//            if(!newLinkInserted)
//            {
//                prev.next=newLink;
//            }
//        }


        while (current != null && current.data.compareTo(value) > 0) {
            prev = current;
            current = current.next;
        }

        if (prev == null) {
            head = newLink;
        } else {
            prev.next = newLink;
        }
        newLink.next = current;
        size++;
    }

    public T delete() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        } else {
            LinkNode<T> temp = head;
            head = head.next;
            size--;
            return temp.data;
        }

    }

    public T peek() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        } else {
            return head.data;
        }
    }

    public int size() {
        return size;
    }
}
