package com.abn.dsalgos.algo.dp;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.collections.Lists;

import java.util.Iterator;
import java.util.List;

public class MinimumSubsetDifferenceTest {

    @DataProvider
    public Iterator<Object[]> dp() {

        List<Object[]> list = Lists.newLinkedList();
        list.add(new Object[] {new int[] {1, 2, 3, 9}, 3});
        list.add(new Object[] {new int[] {1, 2, 7, 1, 5}, 0});
        list.add(new Object[] {new int[] {14, 45, 24, 12, 61, 63, 14, 32, 78, 32, 17, 39, 38, 31, 57, 23, 14, 32, 58, 34, 18, 12, 63, 45, 11, 47, 53, 96, 10, 37}, 0});

        return list.iterator();
    }


    @Test (dataProvider = "dp")
    public void test(int[] array, int expected) {
        MinimumSubsetDifference minimumSubsetDifference = new MinimumSubsetDifference();
        Assert.assertEquals(minimumSubsetDifference.minimumSubsetSumDiff(array), expected);
    }
}
