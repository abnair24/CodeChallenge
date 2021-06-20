package com.abn.dsalgos.algo.bitwise;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.collections.Lists;

import java.util.Iterator;
import java.util.List;

public class PowerOfTwoTest {

    @DataProvider
    public Iterator<Object[]> dp() {

        List<Object[]> list = Lists.newLinkedList();

        list.add(new Object[] {8, true});
        list.add(new Object[] {6, false});
        list.add(new Object[] {1, true});
        list.add(new Object[] {7, false});

        return list.iterator();
    }

    @Test(dataProvider = "dp")
    public void test(int num, boolean status) {
        Assert.assertEquals(new PowerOfTwo().isPowerTwo(num), status);
    }
}
