package com.abn.dsalgos.challenges.linkedList;

import org.testng.annotations.Test;

public class LinkedListRemoveAllKvalueTest {

    LinkedListRemoveAllKvalue<Integer> linkedList = new LinkedListRemoveAllKvalue<>();

    @Test
    public void removeKtest() {
        linkedList.insertFirst(3);
        linkedList.insertLast(1);
        linkedList.insertLast(2);
        linkedList.insertLast(3);
        linkedList.insertLast(4);
        linkedList.insertLast(5);
       linkedList.removeKValues(linkedList.getFirstNode(),3);
        linkedList.print();
    }

    @Test
    public void removeKtest1() {
        linkedList.insertFirst(3);
        linkedList.insertLast(1);
        linkedList.insertLast(2);
        linkedList.insertLast(3);
        linkedList.insertLast(4);
        linkedList.insertLast(5);
        linkedList.removeKValues(linkedList.getFirstNode(),7);
        linkedList.print();
    }
}
