package com.abn.dsalgos.challenges.linkedList;

import com.abn.dsalgos.utils.LinkNode;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class RearrangeLastNTest {

    private RearrangeLastN<Integer> linkedList;


    @BeforeMethod
    public void setup() throws Exception{
        linkedList = new RearrangeLastN<>();
    }

    @Test
    public void rearrangeN() throws Exception {
        LinkNode<Integer> first = new LinkNode<>(1);
        LinkNode<Integer> second = new LinkNode<>(2);
        LinkNode<Integer> third = new LinkNode<>(3);
        LinkNode<Integer> fourth = new LinkNode<>(4);
        LinkNode<Integer> fifth = new LinkNode<>(5);
        linkedList.insertFirst(first.data);
        linkedList.insertLast(second.data);
        linkedList.insertLast(third.data);
        linkedList.insertLast(fourth.data);
        linkedList.insertLast(fifth.data);


        linkedList.reverseLastN(linkedList.getFirstNode(),5);
    }

}
