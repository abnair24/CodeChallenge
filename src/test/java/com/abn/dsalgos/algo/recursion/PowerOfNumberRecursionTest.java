package com.abn.dsalgos.algo.recursion;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.collections.Lists;

import java.util.Iterator;
import java.util.List;

public class PowerOfNumberRecursionTest {

    PowerOfNumberRecursion powerOfNumberRecursion = new PowerOfNumberRecursion();

    @DataProvider
    public Iterator<Object[]> dp() {

        List<Object[]> list = Lists.newLinkedList();

        list.add(new Object[] { 2, 5, 32 });
        list.add(new Object[] { 2, 0, 1 });
        list.add(new Object[] { 5, 4, 625 });
        list.add(new Object[] { 2, 3, 8 });
        list.add(new Object[] { 1, 1, 1 });
        list.add(new Object[] { 2, -1, 0.5 });
        list.add(new Object[] { 5, -2, 0.04000000000000001 });

        return list.iterator();
    }

    @Test(dataProvider = "dp")
    public void test(double num, int power, double expected ) {
        Assert.assertEquals(powerOfNumberRecursion.powRec(num, power), expected);
    }

    @Test(dataProvider = "dp")
    public void test1(double num, int power, double expected ) {
        Assert.assertEquals(powerOfNumberRecursion.powIter(num, power), expected);
    }
}
