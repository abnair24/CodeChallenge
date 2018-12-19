package com.abn.dsalgos.challenges.linkedList;

import com.abn.dsalgos.utils.LinkNode;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ReverseLinkedListInKgroupsTest {

    private ReverseLinkedListIterative<Integer> reverseLinkedListIterative;

    @BeforeMethod
    public void setup() throws Exception {
        reverseLinkedListIterative = new ReverseLinkedListIterative<>();
    }

    @Test
    public void test() throws Exception {
        LinkNode<Integer> firstNode = new LinkNode<>(1);
        LinkNode<Integer> secondNode = new LinkNode<>(2);
        LinkNode<Integer> thirdNode = new LinkNode<>(3);
        LinkNode<Integer> fourthNode = new LinkNode<>(4);
        LinkNode<Integer> fifthNode = new LinkNode<>(5);
        LinkNode<Integer> sixthNode = new LinkNode<>(6);
        LinkNode<Integer> seventhNode = new LinkNode<>(7);

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
    public void test6() throws Exception {
        reverseLinkedListIterative.insertFirst(1);
        reverseLinkedListIterative.insertLast(2);
        reverseLinkedListIterative.insertLast(3);
        reverseLinkedListIterative.insertLast(4);
        reverseLinkedListIterative.insertLast(5);
        reverseLinkedListIterative.insertLast(6);

        reverseLinkedListIterative.reverseInBlocks(reverseLinkedListIterative.getFirstNode(),1);
    }
}
