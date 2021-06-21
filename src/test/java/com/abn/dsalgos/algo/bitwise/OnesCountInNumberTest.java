package com.abn.dsalgos.algo.bitwise;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.collections.Lists;

import java.util.Iterator;
import java.util.List;

public class OnesCountInNumberTest {

    @DataProvider
    public Iterator<Object[]> dp() {

        List<Object[]> list = Lists.newLinkedList();

        list.add(new Object[] {7, 3});
        list.add(new Object[] {10, 2});
        list.add(new Object[] {15, 4});
        list.add(new Object[] {1, 1});
        list.add(new Object[] {0, 0});

        return list.iterator();
    }

    @Test(dataProvider = "dp")
    public void test(int num, int expected) throws Exception {

        Assert.assertEquals(new OnesCountInNumber().countOnes(num), expected);
    }
}
