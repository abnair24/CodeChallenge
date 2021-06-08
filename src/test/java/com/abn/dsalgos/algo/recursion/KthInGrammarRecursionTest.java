package com.abn.dsalgos.algo.recursion;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.collections.Lists;

import java.util.Iterator;
import java.util.List;

public class KthInGrammarRecursionTest {

    KthInGrammarRecursion kthInGrammarRecursion = new KthInGrammarRecursion();

    @DataProvider
    public Iterator<Object[]> dp() {

        List<Object[]> list = Lists.newLinkedList();

        list.add( new Object[] {1, 1, 0});
        list.add( new Object[] {4, 3, 1});
        list.add( new Object[] {5, 11, 0});
        list.add( new Object[] {4, 8, 1});

        return list.iterator();
    }

    @Test (dataProvider = "dp")
    public void test(int n, int k, int expected) {
        Assert.assertEquals(kthInGrammarRecursion.getKthSymbol(n, k), expected);
    }
}
