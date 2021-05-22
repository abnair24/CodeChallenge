package com.abn.dsalgos.challenges.linkedList;

import org.testng.annotations.Test;

public class ReverseLinkedListFromMtoNTest {

    public ReverseLinkedListFromMtoN<Integer> list = new ReverseLinkedListFromMtoN<>();

    @Test
    public void test1() throws Exception {

        list.insertFirst(1);
        list.insertLast(2);
        list.insertLast(3);
        list.insertLast(4);
        list.insertLast(5);

        list.print(list.reverseLinkedListFromMtoN(list.getFirstNode(),2,4));

    }

    @Test
    public void test2() throws Exception {
        list.insertFirst(1);
        list.insertLast(2);
        list.insertLast(3);
        list.insertLast(4);
        list.insertLast(5);

        list.print(list.reverseLinkedListFromMtoN(list.getFirstNode(),4,2));
    }

    @Test
    public void test3() throws Exception {
        list.insertFirst(1);
        list.insertLast(2);
        list.insertLast(3);
        list.insertLast(4);
        list.insertLast(5);

        list.print(list.reverseLinkedListFromMtoN(list.getFirstNode(),2,2));
    }

    @Test
    public void test4() throws Exception {
        list.insertFirst(1);
        list.insertLast(2);
        list.insertLast(3);
        list.insertLast(4);
        list.insertLast(5);

        list.print(list.reverseLinkedListFromMtoN(list.getFirstNode(),1,4));
    }

    @Test
    public void test5() throws Exception {
        list.insertFirst(1);
        list.insertLast(2);
        list.insertLast(3);
        list.insertLast(4);
        list.insertLast(5);

        list.print(list.reverseLinkedListFromMtoN(list.getFirstNode(),1,5));
    }
}
