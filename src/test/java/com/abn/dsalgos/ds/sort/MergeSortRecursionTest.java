package com.abn.dsalgos.ds.sort;

import com.abn.dsalgos.sortAlgos.MergeSortRecursion;
import org.junit.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.collections.Lists;

import java.util.Iterator;
import java.util.List;

public class MergeSortRecursionTest {

    MergeSortRecursion mergeSortRecursion = new MergeSortRecursion();

    @DataProvider
    public Iterator<Object[]> dp() {

        List<Object[]> list = Lists.newLinkedList();

        list.add(new Object[] {new int[] {5, 6, 1, 2, 4, 3, 5, 8}, new int[] {1, 2, 3, 4, 5, 5, 6, 8}});
        list.add(new Object[] {new int[] {7, 1, 3}, new int[] {1, 3, 7}});
        list.add(new Object[] {new int[] {1}, new int[] {1}});
        list.add(new Object[] {new int[] {-2, 3, -5}, new int[] {-5, -2, 3}});


        return list.iterator();
    }

    @Test(dataProvider = "dp")
    public void test(int[] actual, int[] expected) {
        Assert.assertArrayEquals(mergeSortRecursion.mergeSort(actual), expected);
    }
}

