package com.abn.dsalgos.algo.recursion;

import com.abn.dsalgos.ds.linkedList.MyLinkedList;
import com.abn.dsalgos.utils.LinkNode;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.collections.Lists;

import java.util.Iterator;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LinkedListMergeSortedRecursionTest {

    MyLinkedList<Integer> ll1 = new MyLinkedList<>();
    MyLinkedList<Integer> ll2 = new MyLinkedList<>();
    MyLinkedList<Integer> expected = new MyLinkedList<>();

    LinkedListMergeSortedRecursion linkedListMergeSortedRecursion = new LinkedListMergeSortedRecursion();

    @DataProvider
    public Iterator<Object[]> dp() {
        List<Object[]> lst = Lists.newLinkedList();

        ll1.insertLast(1);
        ll1.insertLast(2);
        ll1.insertLast(4);

        ll2.insertLast(1);
        ll2.insertLast(3);
        ll2.insertLast(4);

        expected.insertLast(1);
        expected.insertLast(1);
        expected.insertLast(2);
        expected.insertLast(3);
        expected.insertLast(4);
        expected.insertLast(4);

        lst.add(new Object[] {ll1.getFirstNode(), ll2.getFirstNode(), expected});

        return lst.iterator();
    }

    @Test(dataProvider = "dp")
    public void test(LinkNode<Integer> ll1, LinkNode<Integer> ll2, MyLinkedList<Integer> expected) {

       assertThat(linkedListMergeSortedRecursion.merge(ll1, ll2)).toString().equals(expected.toString());
    }
}
