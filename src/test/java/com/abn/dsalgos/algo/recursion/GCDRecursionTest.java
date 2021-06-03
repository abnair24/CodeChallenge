package com.abn.dsalgos.algo.recursion;

import com.beust.jcommander.internal.Lists;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.Iterator;
import java.util.List;

public class GCDRecursionTest {

    GCDRecursion gcdRecursion;

    @BeforeClass
    public void before() throws Exception {
        gcdRecursion = new GCDRecursion();
    }

    @DataProvider
    public Iterator<Object[]> dp() {

        List<Object[]> list = Lists.newLinkedList();

        list.add(new Object[] {18, 24, 6});
        list.add(new Object[] {54, 36, 18});
        list.add(new Object[] {25, 18, 1});
        list.add(new Object[] {10, 0, 10});
        list.add(new Object[] {0, 20, 20});
        list.add(new Object[] {0, 0, 0});

        return list.iterator();
    }

    @Test(dataProvider = "dp")
    public void test(int num1, int num2, int expected) {
        Assert.assertEquals(gcdRecursion.gcd(num1, num2), expected);
    }
}
