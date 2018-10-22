package com.abn.dsalgos.challenges.linkedList;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ReverseLinkedListIterativeTest {

    private ReverseLinkedListIterative<Integer> reverseLinkedListIterative;

    @BeforeMethod
    public void setup() throws Exception {
        reverseLinkedListIterative = new ReverseLinkedListIterative<>();
    }

    @Test
    public void test() throws Exception {
        reverseLinkedListIterative.insertFirst(1);
        reverseLinkedListIterative.insertLast(2);
        reverseLinkedListIterative.insertLast(3);
        reverseLinkedListIterative.insertLast(4);
        reverseLinkedListIterative.insertLast(5);

        reverseLinkedListIterative.reverseLinkedList();
    }

}
