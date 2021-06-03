package com.abn.dsalgos.algo.recursion;

import com.abn.dsalgos.ds.linkedList.MyLinkedList;
import com.abn.dsalgos.utils.LinkNode;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.collections.Lists;

import java.util.Iterator;
import java.util.List;

public class LinkedListLengthRecursionTest {

    MyLinkedList<Integer> ll1 = new MyLinkedList<>();
    MyLinkedList<Integer> ll2 = new MyLinkedList<>();

    LinkedListLengthRecursion linkedListLengthRecursion = new LinkedListLengthRecursion();

    @DataProvider
    public Iterator<Object[]> dp() {
        List<Object[]> lst = Lists.newLinkedList();

        ll1.insertLast(1);
        ll1.insertLast(2);
        ll1.insertLast(4);

        ll2.insertLast(2);

        lst.add(new Object[] {ll1.getFirstNode(), 3});
        lst.add(new Object[] {ll2.getFirstNode(), 1});

        return lst.iterator();
    }

    @Test (dataProvider = "dp")
    public void test(LinkNode<Integer>head, int expected) throws Exception {

        Assert.assertEquals(linkedListLengthRecursion.lengthOfLinkedList(head), expected);
    }
}
