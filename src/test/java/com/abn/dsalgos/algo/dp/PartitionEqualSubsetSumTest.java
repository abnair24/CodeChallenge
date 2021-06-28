package com.abn.dsalgos.algo.dp;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.collections.Lists;

import java.util.Iterator;
import java.util.List;

public class PartitionEqualSubsetSumTest {

    @DataProvider
    public Iterator<Object[]> dp() {

        List<Object[]> list = Lists.newLinkedList();

        list.add(new Object[] {new int[]{1, 2, 3, 4}, true});
        list.add(new Object[] {new int[]{1, 1, 3, 4, 7}, true});
        list.add(new Object[] {new int[]{2, 3, 4, 6}, false});

        return list.iterator();
    }

    @Test(dataProvider = "dp")
    public void test(int[] array, boolean status) {
        PartitionEqualSubsetSum partitionEqualSubsetSum = new PartitionEqualSubsetSum();
        Assert.assertEquals(partitionEqualSubsetSum.canPartition(array), status);
    }
}
