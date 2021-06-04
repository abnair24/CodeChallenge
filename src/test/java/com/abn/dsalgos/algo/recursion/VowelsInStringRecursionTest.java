package com.abn.dsalgos.algo.recursion;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.collections.Lists;

import java.util.Iterator;
import java.util.List;

public class VowelsInStringRecursionTest {

    VowelsInStringRecursion vowelsInStringRecursion = new VowelsInStringRecursion();

    @DataProvider
    public Iterator<Object[]> dp() {
        List<Object[]> list = Lists.newLinkedList();

        list.add(new Object[] {"Hello WORld", 3});
        list.add(new Object[] {"Stack OVERFLOW", 4});
        list.add(new Object[] {"s", 0});
        list.add(new Object[] {"xyz", 0});

        return list.iterator();
    }

    @Test (dataProvider = "dp")
    public void test(String str, int expected) {
        Assert.assertEquals(vowelsInStringRecursion.vowelCount(str), expected);
    }
}
