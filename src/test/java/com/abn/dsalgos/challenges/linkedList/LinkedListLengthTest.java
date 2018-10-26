package com.abn.dsalgos.challenges.linkedList;

import org.testng.Assert;
import org.testng.annotations.Test;

public class LinkedListLengthTest {

    LinkedListLength<Integer>linkedListLength = new LinkedListLength<>();

    @Test
    public void test() throws Exception {
        linkedListLength.insertFirst(10);
        linkedListLength.insertLast(11);
        linkedListLength.insertLast(1);
        linkedListLength.insertLast(3);
        linkedListLength.insertFirst(0);

        Assert.assertEquals(linkedListLength.length(),5);
    }
}
