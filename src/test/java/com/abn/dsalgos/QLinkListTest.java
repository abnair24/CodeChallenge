package com.abn.dsalgos;

import com.abn.dsalgos.exceptions.EmptyQException;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.NoSuchElementException;

/**
 * Created by aswathyn on 15/02/17.
 */
public class QLinkListTest {

    private QLinkList<Object> queue;
    private static final Object OBJECT_A = new Object();
    private static final Object OBJECT_B = new Object();

    @BeforeMethod
    public void setup() throws Exception {
        queue = new QLinkList<>();
    }

    @Test(expectedExceptions = EmptyQException.class)
    public void emptyQueueTest() throws Exception{
        queue.deleteFirst();
    }

    @Test
    public void addToQueueTest() {
        queue.insertLast(5);
        Assert.assertTrue(!queue.isEmpty());
    }

    @Test
    public void addRemoveObjectsTest() throws Exception {
        pushObjects(5,7);
        Assert.assertEquals(5,queue.deleteFirst());
    }

    @Test(expectedExceptions = EmptyQException.class)
    public void removeQueueEmptyTest() throws Exception {
        queue.insertLast(OBJECT_A);
        queue.insertLast(OBJECT_B);
        Assert.assertEquals(OBJECT_A,queue.deleteFirst());
        Assert.assertEquals(OBJECT_B,queue.deleteFirst());
        queue.deleteFirst();
    }

    @Test(expectedExceptions = NoSuchElementException.class)
    public void emptyQPeekTest() throws Exception {
        queue.peek();
    }

    private void pushObjects(Object... objects) {
        for(Object object : objects) {
            queue.insertLast(object);
        }
    }

}
