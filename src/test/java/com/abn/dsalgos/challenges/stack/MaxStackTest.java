package com.abn.dsalgos.challenges.stack;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.EmptyStackException;

/**
 * Created by aswathyn on 18/02/17.
 */
public class MaxStackTest {

    private MaxStack maxStack;


    @BeforeMethod
    public void setup() throws Exception {
        maxStack = new MaxStack();
    }

    @Test
    public void maxStackTest() {
        maxStack.insert(10);
        maxStack.insert(20);
        maxStack.insert(5);
        maxStack.insert(8);
        maxStack.insert(50);
        maxStack.insert(-1);
        maxStack.insert(30);
        maxStack.insert(100);
        maxStack.insert(0);
        Assert.assertEquals(100, maxStack.getMaxData());
    }

    @Test(expectedExceptions = EmptyStackException.class)
    public void maxOnEmptyStackTest() {
        maxStack.getMaxData();
    }

    @Test
    public void maxOnSameValueStack() {
        maxStack.insert(10);
        maxStack.insert(30);
        maxStack.insert(20);
        maxStack.insert(30);
        maxStack.insert(15);
        Assert.assertEquals(30,maxStack.getMaxData());
    }
}
