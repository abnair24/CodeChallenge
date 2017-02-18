package com.abn.dsalgos.ds;

import com.abn.dsalgos.exceptions.EmptyStackException;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 * Created by aswathyn on 14/02/17.
 */
public class StackLinkListTest {

    private StackLinkList<Object> stack;
    private static final Object OBJECT_A = new Object();
    private static final Object OBJECT_B = new Object();

    @BeforeMethod
    public void setup() throws Exception {
        stack = new StackLinkList<>();
    }

    @Test
    public void pushTwoObjectsTest() {
        pushObjects(OBJECT_A,OBJECT_B);
        Assert.assertEquals(2,stack.size());
    }

    @Test
    public void stackSizeTest() {
        Assert.assertEquals(0,stack.size());
    }

    @Test
    public void nullArgumentTest() {
        stack.push(null);
    }

    @Test
    public void pushAndPopTest() throws Exception {
        pushObjects(OBJECT_A,OBJECT_B);
        Assert.assertEquals(OBJECT_B,stack.pop());
        Assert.assertEquals(OBJECT_A,stack.pop());
    }


    @Test
    public void peekTest() throws Exception {
        pushObjects(OBJECT_A, OBJECT_B);
        Assert.assertEquals(OBJECT_B, stack.peek());
    }

    @Test(expectedExceptions = EmptyStackException.class)
    public void peekOnEmptyStackTest() throws Exception {
        stack.peek();
    }

    @Test(expectedExceptions = EmptyStackException.class)
    public void popEmptyStackTest() throws Exception {
        stack.push(OBJECT_A);
        stack.pop();
        Assert.assertEquals(0,stack.size());
        stack.pop();
    }

    private void pushObjects(Object... objects) {
        for(Object object : objects) {
            stack.push(object);
        }
    }
}
