package com.abn.dsalgos.challenges.linkedList;

import org.testng.annotations.Test;

public class LinkedListSumOfNumbersTest {

    @Test
    public void test1() throws Exception {
        LinkedListSumOfNumbers ll1 = new LinkedListSumOfNumbers();
        ll1.insertFirst(6);
        ll1.insertLast(7);
        ll1.insertLast(3);

        LinkedListSumOfNumbers ll2 = new LinkedListSumOfNumbers();
        ll2.insertFirst(8);
        ll2.insertLast(3);
        ll2.insertLast(5);

        LinkedListSumOfNumbers sum = new LinkedListSumOfNumbers();
        sum.print(ll1.getFirstNode());
        System.out.println("+");
        sum.print(ll2.getFirstNode());
        sum.print(sum.sumOfNumbers(ll1, ll2));
    }

    @Test
    public void test2() throws Exception {
        LinkedListSumOfNumbers ll1 = new LinkedListSumOfNumbers();
        ll1.insertFirst(5);
        ll1.insertLast(0);
        ll1.insertLast(0);

        LinkedListSumOfNumbers ll2 = new LinkedListSumOfNumbers();
        ll2.insertFirst(5);

        LinkedListSumOfNumbers sum = new LinkedListSumOfNumbers();
        sum.print(ll1.getFirstNode());
        System.out.println("+");
        sum.print(ll2.getFirstNode());

        sum.print(sum.sumOfNumbers(ll1,ll2));
    }

    @Test
    public void test3() throws Exception {
        LinkedListSumOfNumbers ll1 = new LinkedListSumOfNumbers();
        ll1.insertFirst(8);
        ll1.insertLast(3);
        ll1.insertLast(8);

        LinkedListSumOfNumbers ll2 = new LinkedListSumOfNumbers();
        ll2.insertFirst(7);

        LinkedListSumOfNumbers sum = new LinkedListSumOfNumbers();
        sum.print(ll1.getFirstNode());
        System.out.println("+");
        sum.print(ll2.getFirstNode());

        sum.print(sum.sumOfNumbers(ll1,ll2));
    }


}
