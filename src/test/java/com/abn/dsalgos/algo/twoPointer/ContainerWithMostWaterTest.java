package com.abn.dsalgos.algo.twoPointer;

import com.abn.dsalgos.algo.twoPointers.ContainerWithMostWater;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.collections.Lists;

import java.util.Iterator;
import java.util.List;

public class ContainerWithMostWaterTest {

    @DataProvider
    public Iterator<Object[]> dp() {

        List<Object[]> list = Lists.newLinkedList();

        list.add(new Object[] {new int[] {1, 8, 6, 2, 5, 4, 8, 3, 7}, 49});
        list.add(new Object[] {new int[] {1, 1}, 1});
        list.add(new Object[] {new int[] {4, 3, 2, 1, 4}, 16});
        list.add(new Object[] {new int[] {1, 2, 1}, 2});

        return list.iterator();
    }

    @Test (dataProvider = "dp")
    public void test(int[] array, int expected) {

        ContainerWithMostWater containerWithMostWater = new ContainerWithMostWater();
        Assert.assertEquals(containerWithMostWater.maximum(array), expected);
    }
}
