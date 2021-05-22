package com.abn.dsalgos.challenges.linkedList;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ReverseLinkedListInKgroupsTest {

    private ReverseInKGroup<Integer> reverseLinkedListIterative;

    @BeforeMethod
    public void setup() throws Exception {
        reverseLinkedListIterative = new ReverseInKGroup<>();
    }

    @Test
    public void test() throws Exception {

        reverseLinkedListIterative.insertFirst(1);
        reverseLinkedListIterative.insertLast(2);
        reverseLinkedListIterative.insertLast(3);
        reverseLinkedListIterative.insertLast(4);
        reverseLinkedListIterative.insertLast(5);
        reverseLinkedListIterative.insertLast(6);
        reverseLinkedListIterative.insertLast(7);

        reverseLinkedListIterative.reverseInBlocks(reverseLinkedListIterative.getFirstNode(),2);
    }

    @Test
    public void test1() throws Exception {
        reverseLinkedListIterative.insertFirst(1);
        reverseLinkedListIterative.insertLast(2);
        reverseLinkedListIterative.insertLast(3);
        reverseLinkedListIterative.insertLast(4);
        reverseLinkedListIterative.insertLast(5);
        reverseLinkedListIterative.insertLast(6);
        reverseLinkedListIterative.insertLast(7);

        reverseLinkedListIterative.reverseInBlocks(reverseLinkedListIterative.getFirstNode(),7);
    }

    @Test
    public void test3() throws Exception {
        reverseLinkedListIterative.insertFirst(1);
        reverseLinkedListIterative.insertLast(2);
        reverseLinkedListIterative.insertLast(3);
        reverseLinkedListIterative.insertLast(4);
        reverseLinkedListIterative.insertLast(5);
        reverseLinkedListIterative.insertLast(6);
        reverseLinkedListIterative.insertLast(7);

        reverseLinkedListIterative.reverseInBlocks(reverseLinkedListIterative.getFirstNode(),3);
    }

    @Test
    public void test4() throws Exception {
        reverseLinkedListIterative.insertFirst(1);
        reverseLinkedListIterative.insertLast(2);
        reverseLinkedListIterative.insertLast(3);
        reverseLinkedListIterative.insertLast(4);
        reverseLinkedListIterative.insertLast(5);
        reverseLinkedListIterative.insertLast(6);
        reverseLinkedListIterative.insertLast(7);

        reverseLinkedListIterative.reverseInBlocks(reverseLinkedListIterative.getFirstNode(),4);
    }

    @Test
    public void test5() throws Exception {
        reverseLinkedListIterative.insertFirst(1);
        reverseLinkedListIterative.insertLast(2);
        reverseLinkedListIterative.insertLast(3);
        reverseLinkedListIterative.insertLast(4);
        reverseLinkedListIterative.insertLast(5);
        reverseLinkedListIterative.insertLast(6);

        reverseLinkedListIterative.reverseInBlocks(reverseLinkedListIterative.getFirstNode(),3);
    }

    @Test
    public void test6() {
        reverseLinkedListIterative.insertFirst(1);
        reverseLinkedListIterative.insertLast(2);
        reverseLinkedListIterative.insertLast(3);
        reverseLinkedListIterative.insertLast(4);
        reverseLinkedListIterative.insertLast(5);
        reverseLinkedListIterative.insertLast(6);

        reverseLinkedListIterative.reverseInBlocks(reverseLinkedListIterative.getFirstNode(),1);
    }
}
