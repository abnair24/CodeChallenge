package com.abn.dsalgos.ds.queue;

import com.abn.dsalgos.ds.queue.QArrays;
import org.testng.Assert;
import org.testng.annotations.Test;

public class QArraysTest {

    private QArrays<Integer> qArrays;

    @Test
    public void enqueueTest() throws Exception {
        qArrays = new QArrays<Integer>();
        qArrays.enqueue(1);
        qArrays.enqueue(2);
        qArrays.enqueue(3);

        Assert.assertEquals(Integer.parseInt(qArrays.dequeue().toString()),1);
        Assert.assertEquals(Integer.parseInt(qArrays.dequeue().toString()),2);
    }

}
