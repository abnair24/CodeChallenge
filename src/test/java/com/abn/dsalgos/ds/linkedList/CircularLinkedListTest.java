package com.abn.dsalgos.ds.linkedList;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class CircularLinkedListTest {

    private MyCircularLinkedList<Integer> myCircularLinkedList;

    @BeforeMethod
    public void setup() throws Exception  {
        myCircularLinkedList = new MyCircularLinkedList<>();
    }

    @Test
    public void test() throws Exception {
        myCircularLinkedList.insertFirst(1);
        myCircularLinkedList.insertLast(10);
        myCircularLinkedList.insertFirst(0);
        myCircularLinkedList.insertLast(5);
        myCircularLinkedList.insertLast(6);
        myCircularLinkedList.insertLast(7);
        myCircularLinkedList.insertLast(8);

        myCircularLinkedList.print();

        Assert.assertEquals((int) myCircularLinkedList.elementAt(5),6);
    }
}
