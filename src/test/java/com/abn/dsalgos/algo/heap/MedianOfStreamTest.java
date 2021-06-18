package com.abn.dsalgos.algo.heap;

import org.testng.Assert;
import org.testng.annotations.Test;

public class MedianOfStreamTest {

    MedianOfStream medianOfStream = new MedianOfStream();

    @Test
    public void test() {
        medianOfStream.insert(3);
        medianOfStream.insert(1);
        medianOfStream.insert(2);
        Assert.assertEquals(medianOfStream.findMedian(), 2.0);

        medianOfStream.insert(4);
        Assert.assertEquals(medianOfStream.findMedian(), 2.5);

        medianOfStream.insert(5);
        Assert.assertEquals(medianOfStream.findMedian(), 3.0);
    }
}
