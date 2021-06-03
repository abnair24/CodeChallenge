package com.abn.dsalgos.algo.recursion;

import org.junit.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.collections.Lists;

import java.util.Iterator;
import java.util.List;

public class NumberConversionRecursionTest {

    NumberConversionRecursion numberConversionRecursion = new NumberConversionRecursion();

    @DataProvider
    public Iterator<Object[]> dp() {
        List<Object[]> list = Lists.newLinkedList();

        list.add(new Object[] {19, 10011});
        list.add(new Object[] {0, 0});
        list.add(new Object[] {1, 1});
        list.add(new Object[] {2, 10});
        list.add(new Object[] {10, 1010});

        return list.iterator();
    }

    @Test(dataProvider = "dp")
    public void test(int number, int expected) {
        Assert.assertEquals(numberConversionRecursion.decToBin(number), expected);
    }
}
