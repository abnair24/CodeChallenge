package com.abn.dsalgos.algo.merge;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.collections.Lists;

import java.util.Iterator;
import java.util.List;

public class MergeTwoSortedArrayTest {

    MergeTwoSortedArrays arrays;

    @DataProvider
    public Iterator<Object[]> dp() {
        List<Object[]> lst = Lists.newLinkedList();

        lst.add(new Object[] {new int[]{1,2,3,0,0,0}, 3, new int[]{2, 5, 6}, 3, new int[]{1,2,2,3,5,6}});

        return lst.iterator();
    }

    @Test(dataProvider = "dp")
    public void test(int[] array1, int m, int[] array2, int n, int[] expected) throws Exception {
        arrays = new MergeTwoSortedArrays();

        Assert.assertEquals(arrays.merge(array1, m, array2, n), expected);
    }
}
