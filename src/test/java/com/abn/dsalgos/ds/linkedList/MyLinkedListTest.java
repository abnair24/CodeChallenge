package com.abn.dsalgos.ds.linkedList;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


import java.util.NoSuchElementException;

public class MyLinkedListTest {


    private MyLinkedList<Object> linkedList;
    private static final Object OBJECT_A = new Object();
    private static final Object OBJECT_B = new Object();

    @BeforeMethod
    public void setup() throws Exception{
        linkedList = new MyLinkedList<>();
    }

    @Test
    public void insertFirstTest() {
        linkedList.insertFirst(OBJECT_A);
        linkedList.insertFirst(OBJECT_B);
        Assert.assertEquals(2, linkedList.size());
    }

    @Test(expectedExceptions = NoSuchElementException.class)
    public void getFirstOnEmptyListTest() {
        linkedList.getFirst();
    }

    @Test(expectedExceptions = NoSuchElementException.class)
    public void getLastOnEmptyListTest() {
        linkedList.getLast();
    }

    @Test
    public void getOnInsertFirstTest() {
        linkedList.insertFirst(OBJECT_B);
        linkedList.insertFirst(OBJECT_A);
        Assert.assertEquals(OBJECT_A,linkedList.getFirst());
        Assert.assertEquals(OBJECT_B,linkedList.getLast());
    }

    @Test
    public void getOnInsertLastTest() {
        linkedList.insertLast(OBJECT_B);
        linkedList.insertLast(OBJECT_A);
        Assert.assertEquals(OBJECT_B,linkedList.getFirst());
        Assert.assertEquals(OBJECT_A,linkedList.getLast());
    }

    @Test
    public void insertLastTest() {
        linkedList.insertLast(OBJECT_A);
        linkedList.insertLast(OBJECT_B);
        Assert.assertEquals(2,linkedList.size());
    }

    @Test
    public void deleteFirstTest() throws Exception {
        linkedList.insertLast(OBJECT_A);
        linkedList.insertLast(OBJECT_B);
        Assert.assertEquals(OBJECT_A,linkedList.deleteFirst());
    }

    @Test
    public void deleteTest() {
        linkedList.insertFirst(10);
        linkedList.insertFirst(20);
        linkedList.insertFirst(40);
        linkedList.insertFirst(45);
        Assert.assertEquals(10,linkedList.delete(10));
    }

    @Test(expectedExceptions = NoSuchElementException.class)
    public void deleteFirstOnEmptyList() throws Exception {
        linkedList.deleteFirst();
    }

    @Test(expectedExceptions = NoSuchElementException.class)
    public void deleteOnEmptyList() {
        linkedList.delete(10);
    }

    @Test(expectedExceptions = IndexOutOfBoundsException.class)
    public void deleteNonExistingTest() {
        linkedList.insertLast(10);
        linkedList.insertLast(20);
        linkedList.insertLast(30);
        linkedList.delete(35);
    }

    @Test(expectedExceptions = NoSuchElementException.class)
    public void findOnEmptyList() {
        linkedList.find(10);
    }

    @Test
    public void findElementInList() {
        linkedList.insertFirst(OBJECT_B);
        linkedList.insertFirst(OBJECT_A);
        Assert.assertEquals(OBJECT_A,linkedList.find(OBJECT_A));
    }

    @Test(expectedExceptions = IndexOutOfBoundsException.class)
    public void findNonExistingTest() {
        linkedList.insertLast(10);
        linkedList.insertLast(100);
        linkedList.insertLast(30);
        linkedList.find(35);
    }

    @Test
    public void removeDuplicatesTest() {
        linkedList.insertFirst(10);
        linkedList.insertFirst(20);
        linkedList.insertFirst(30);
        linkedList.insertFirst(10);
        linkedList.insertFirst(50);
        linkedList.insertFirst(30);
        linkedList.removeDuplicate(linkedList.getFirstNode());
        linkedList.print();

    }



}
