package com.abn.dsalgos.challenges;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class QueueWithTwoStacksTest {

    QueueWithTwoStacks<Object> q;

    @BeforeMethod
    public void setup() throws Exception {
        q = new QueueWithTwoStacks<>();
    }

    @Test
    public void addAndPop() throws Exception {
        q.enqueue(1);
        q.enqueue(2);
        q.enqueue(3);
        q.enqueue(4);

        Assert.assertEquals(q.dequeue(),1);
        Assert.assertEquals(q.peek(),2);
    }
}
