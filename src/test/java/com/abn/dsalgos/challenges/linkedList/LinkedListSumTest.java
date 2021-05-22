package com.abn.dsalgos.challenges.linkedList;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LinkedListSumTest {

    private LinkedListSum<Integer> linkedList1;
    private LinkedListSum<Integer> linkedList2;

    @BeforeMethod
    public void setup() throws Exception{
        linkedList1 = new LinkedListSum<>();
        linkedList2 = new LinkedListSum<>();
    }

    @Test
    public void insertFirstTest() {
        linkedList1.insertLast(7);
        linkedList1.insertLast(1);
        linkedList1.insertLast(6);

        linkedList2.insertLast(5);
        linkedList2.insertLast(9);
        linkedList2.insertLast(2);

        Assert.assertEquals(linkedList1.getNumber() + linkedList2.getNumber(), 912);

    }
}
