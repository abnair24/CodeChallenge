package com.abn.dsalgos.algo.heap;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.collections.Lists;

import java.util.Iterator;
import java.util.List;

public class MedianSlidingWindowTest {

    @DataProvider
    public Iterator<Object[]> dp() {

        List<Object[]> list = Lists.newLinkedList();

        list.add(new Object[] {new int[] {1, 2}, 2, new double[] {1.5}});
        list.add(new Object[] {new int[] {1, 3, -1, -3, 5, 3, 6, 7}, 3, new double[] {1.0, -1.0, -1.0, 3.0, 5.0, 6.0}});

        return list.iterator();
    }

    @Test (dataProvider = "dp")
    public void test(int[] input, int k, double[] expected) {

        Assert.assertEquals(new MedianSlidingWindow().medianSliding(input, k), expected);
    }
}
