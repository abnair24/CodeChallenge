package com.abn.dsalgos.algo.binarySearch;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.collections.Lists;

import java.util.Iterator;
import java.util.List;

public class FrequencyInSortedArrayTest {

    @DataProvider
    public Iterator<Object[]> dp() {
        List<Object[]> list = Lists.newLinkedList();

        list.add(new Object[] {new int[] {1, 2, 3, 4, 4, 4, 4, 4, 4, 4, 4, 5, 6, 7, 8, 9, 10, 11}, 4, 8});
        list.add(new Object[] {new int[] {4, 4, 8, 8, 8, 15, 16, 23, 23, 42}, 8, 3});
        list.add(new Object[] {new int[] {3, 5, 5, 5, 5, 7, 8, 8}, 6, 0});

        return list.iterator();
    }

    @Test (dataProvider = "dp")
    public void test(int[] input, int target, int expected)
            throws Exception {
        FrequencyInSortedArray frq = new FrequencyInSortedArray();
        Assert.assertEquals(frq.frequency(input, target), expected);
    }
}
