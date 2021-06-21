package com.abn.dsalgos.algo.heap;

import com.abn.dsalgos.algo.binarySearch.MedianOfSortedArrays;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.collections.Lists;

import java.util.Iterator;
import java.util.List;

public class MedianOfSortedArraysTest {

    @DataProvider
    public Iterator<Object[]> dp() {

        List<Object[]> list = Lists.newLinkedList();

//        list.add(new Object[] { new int[]{}, new int[]{1}, 1.0 });
//        list.add(new Object[] { new int[]{1}, new int[]{}, 1.0});
//        list.add(new Object[] { new int[]{}, new int[]{2, 3}, 2.5});

        list.add(new Object[] {new int[]{5, 8, 10, 11, 20}, new int[]{900, 1000}, 11});

        return list.iterator();
    }

    @Test(dataProvider = "dp")
    public void test(int[] a1, int[] a2, double expected) {

        MedianOfSortedArrays medianOfSortedArrays = new MedianOfSortedArrays();
        Assert.assertEquals(medianOfSortedArrays.getMedian(a1, a2), expected);
    }
}
