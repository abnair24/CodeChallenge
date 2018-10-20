package com.abn.dsalgos.challenges.linkedList;

import com.abn.dsalgos.challenges.KthFromLastLinkedList;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class KthFromLastLinkedListTest {

    private KthFromLastLinkedList<Object> linkedList;


    @BeforeMethod
    public void setup() throws Exception{
        linkedList = new KthFromLastLinkedList<>();
    }

    @Test
    public void nthFromLastTest() throws Exception {
        linkedList.insertFirst(30);
        linkedList.insertFirst(4);
        linkedList.insertFirst(5);
        linkedList.insertLast(6);
        linkedList.insertLast(9);
        linkedList.insertLast(11);
        linkedList.insertLast(8);
        linkedList.insertLast(10);
        linkedList.insertLast(20);
        linkedList.insertFirst(0);
        Assert.assertEquals(linkedList.findKthFromLast(3),8);

    }
}
