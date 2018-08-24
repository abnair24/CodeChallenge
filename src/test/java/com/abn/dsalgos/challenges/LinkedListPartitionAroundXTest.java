package com.abn.dsalgos.challenges;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LinkedListPartitionAroundXTest {


    private LinkedListPartitionAroundX<Object> linkedList;


    @BeforeMethod
    public void setup() throws Exception{
        linkedList = new LinkedListPartitionAroundX<>();
    }

    @Test
    public void partitionTest() throws Exception {
        linkedList.insertLast(30);
        linkedList.insertLast(4);
        linkedList.insertLast(5);
        linkedList.insertLast(6);
        linkedList.insertLast(9);
        linkedList.insertLast(11);
        linkedList.insertLast(8);
        linkedList.insertLast(3);
        linkedList.insertLast(20);
        linkedList.insertFirst(50);
        linkedList.partition(linkedList.getFirstNode(), 6);
        //linkedList.print();
    }

    @Test
    public void partitionTestHighValues() throws Exception {
        linkedList.insertLast(10);
        linkedList.insertLast(20);
        linkedList.insertLast(30);
        linkedList.insertLast(40);
        linkedList.insertFirst(50);
        linkedList.insertFirst(35);
        linkedList.partition(linkedList.getFirstNode(),6);
    }

    @Test
    public void partitionTestLowValues() throws Exception {
        linkedList.insertLast(10);
        linkedList.insertLast(20);
        linkedList.insertLast(30);
        linkedList.insertLast(40);
        linkedList.insertFirst(50);
        linkedList.insertFirst(35);
        linkedList.partition(linkedList.getFirstNode(),55);
    }
}
