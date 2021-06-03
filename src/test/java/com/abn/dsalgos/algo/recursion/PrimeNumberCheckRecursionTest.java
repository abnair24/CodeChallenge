package com.abn.dsalgos.algo.recursion;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.collections.Lists;

import java.util.Iterator;
import java.util.List;

public class PrimeNumberCheckRecursionTest {

    PrimeNumberCheckRecursion primeNumberCheckRecursion;

    @BeforeClass
    public void before() throws Exception {
        primeNumberCheckRecursion = new PrimeNumberCheckRecursion();
    }

    @DataProvider
    public Iterator<Object[]> dp() {

        List<Object[]> list = Lists.newLinkedList();

        list.add(new Object[] {13, true});
        list.add(new Object[] {1, false});
        list.add(new Object[] {0, false});
        list.add(new Object[] {14, false});
        list.add(new Object[] {23, true});
        list.add(new Object[] {113, true});

        return list.iterator();
    }

    @Test(dataProvider = "dp")
    public void test(int number, boolean expected) {
        Assert.assertEquals(primeNumberCheckRecursion.isPrimeCheck(number), expected);
    }
}
