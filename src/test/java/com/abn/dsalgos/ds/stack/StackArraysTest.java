package com.abn.dsalgos.ds.stack;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 * Created by aswathyn on 14/02/17.
 */
public class StackArraysTest {


    private StackArrays<Object> stack;
    private static final Object OBJECT_A = new Object();
    private static final Object OBJECT_B = new Object();

    @BeforeMethod
    public void setup() throws Exception {
        stack = new StackArrays<Object>();
    }

    @Test
    public void pushTwoObjectsTest() {
        pushObjects(OBJECT_A,OBJECT_B);
        Assert.assertEquals(2,stack.getSize());
    }

    @Test
    public void stackSizeTest() {
        Assert.assertEquals(0,stack.getSize());
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

    @Test(expectedExceptions = ArrayIndexOutOfBoundsException.class)
    public void peekOnEmptyStackTest() throws Exception {
        stack.peek();
    }

    @Test(expectedExceptions = ArrayIndexOutOfBoundsException.class)
    public void popEmptyStackTest() throws Exception {
        stack.push(OBJECT_A);
        stack.pop();
        Assert.assertEquals(0,stack.getSize());
        stack.pop();
    }

    private void pushObjects(Object... objects) {
        for(Object object : objects) {
            stack.push(object);
        }
    }



}
