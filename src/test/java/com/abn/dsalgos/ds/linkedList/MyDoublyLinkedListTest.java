package com.abn.dsalgos.ds.linkedList;

import com.abn.dsalgos.ds.linkedList.MyDoublyLinkedList;
import com.abn.dsalgos.exceptions.EmptyLinkedListException;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.NoSuchElementException;

/**
 * Created by aswathyn on 17/02/17.
 */
public class MyDoublyLinkedListTest {

    private MyDoublyLinkedList<Object> doublyLinkedList;
    private static final Object OBJECT_A = new Object();
    private static final Object OBJECT_B = new Object();
    private static final Object OBJECT_C = new Object();
    private static final Object OBJECT_D = new Object();


    @BeforeMethod
    public void setup() throws Exception{
        doublyLinkedList = new MyDoublyLinkedList<>();
    }

    @Test
    public void insertFirstTest() throws Exception {
        doublyLinkedList.insertFirst(OBJECT_A);
        doublyLinkedList.insertFirst(OBJECT_B);
        Assert.assertEquals(2, doublyLinkedList.size());
        Assert.assertEquals(OBJECT_B,doublyLinkedList.peek());
    }

    @Test
    public void insertLastTest() throws Exception {
        doublyLinkedList.insertLast(OBJECT_A);
        doublyLinkedList.insertLast(OBJECT_B);
        Assert.assertEquals(OBJECT_A,doublyLinkedList.peek());
    }

    @Test
    public void insertAfterTest() throws Exception {
        doublyLinkedList.insertFirst(OBJECT_B);
        doublyLinkedList.insertFirst(OBJECT_A);
        doublyLinkedList.insertAfter(OBJECT_B,OBJECT_C);
        Assert.assertEquals(OBJECT_C,doublyLinkedList.deleteLast());
    }

    @Test
    public void deleteFirstTest() throws Exception {
        doublyLinkedList.insertFirst(OBJECT_A);
        doublyLinkedList.insertFirst(OBJECT_B);
        Assert.assertEquals(OBJECT_B,doublyLinkedList.deleteFirst());
    }

    @Test
    public void deleteLastTest() throws Exception {
        doublyLinkedList.insertFirst(OBJECT_A);
        doublyLinkedList.insertFirst(OBJECT_B);
        Assert.assertEquals(OBJECT_A,doublyLinkedList.deleteLast());
    }

    @Test
    public void deleteValueTest() throws Exception {
        doublyLinkedList.insertLast(OBJECT_A);
        doublyLinkedList.insertLast(OBJECT_B);
        doublyLinkedList.insertLast(OBJECT_C);
        Assert.assertEquals(OBJECT_B,doublyLinkedList.delete(OBJECT_B));
    }

    @Test(expectedExceptions = NoSuchElementException.class)
    public void deleteOnEmptyList() throws Exception {

        doublyLinkedList.delete(OBJECT_A);
    }

    @Test(expectedExceptions = IndexOutOfBoundsException.class)
    public void deleteNonExistingValueFromList() throws Exception {
        doublyLinkedList.insertFirst(OBJECT_A);
        doublyLinkedList.insertFirst(OBJECT_C);
        doublyLinkedList.delete(OBJECT_B);
    }

    @Test(expectedExceptions = EmptyLinkedListException.class)
    public void deleteLastOnEmptyList() throws Exception {

        doublyLinkedList.deleteLast();
    }

    @Test(expectedExceptions = EmptyLinkedListException.class)
    public void deleteFirstOnEmptyList() throws Exception {

        doublyLinkedList.deleteFirst();
    }

    @Test(expectedExceptions = NoSuchElementException.class)
    public void insertAfterNonExistingValue() throws Exception {
        doublyLinkedList.insertFirst(OBJECT_A);
        doublyLinkedList.insertFirst(OBJECT_C);
       doublyLinkedList.insertAfter(OBJECT_B,OBJECT_D);
    }

}
