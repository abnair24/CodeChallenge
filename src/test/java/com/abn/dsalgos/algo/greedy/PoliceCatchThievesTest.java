package com.abn.dsalgos.algo.greedy;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.collections.Lists;

import java.util.Iterator;
import java.util.List;

public class PoliceCatchThievesTest {

    @DataProvider
    public Iterator<Object[]> dp() {
        List<Object[]> list = Lists.newLinkedList();
        list.add(new Object[] {new char[] {'T', 'P', 'T', 'T', 'P', 'P', 'T', 'T'}, 2, 3});
        list.add(new Object[] {new char[] {'T', 'P', 'T', 'T', 'P', 'P', 'P', 'T', 'T'}, 1, 3});

        return list.iterator();
    }

    @Test(dataProvider = "dp")
    public void test(char[] input, int k, int expected) {
        PoliceCatchThieves policeCatchThieves = new PoliceCatchThieves();
        Assert.assertEquals(policeCatchThieves.getThiefCount(input, k), expected);
    }
}
