package com.abn.dsalgos.algo.slidingWindo;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.collections.Lists;

import java.util.Iterator;
import java.util.List;

public class SmallestSubarrayWithGivenSumTest {

    SmallestSubarrayWithGivenSum sum;

    @DataProvider
    public Iterator<Object[]> data() {
        List<Object[]> data = Lists.newLinkedList();

        data.add(new Object[] {7, new int[]{2, 1, 5, 2, 3, 2}, 2});
        data.add(new Object[] {7, new int[]{2, 1, 5, 2, 8}, 1});
        data.add(new Object[] {8, new int[]{3, 4, 1, 1, 6}, 3});

        return data.iterator();
    }

    @Test(dataProvider = "data")
    public void test1(int limit, int[] array, int expected) throws Exception {

        sum = new SmallestSubarrayWithGivenSum();
        Assert.assertEquals(sum.findMinSubArray(limit, array), expected);
    }
}
