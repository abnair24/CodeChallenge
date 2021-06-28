package com.abn.dsalgos.algo.dp;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.collections.Lists;

import java.util.Iterator;
import java.util.List;

public class TargetSumSymbolsTest {

    @DataProvider
    public Iterator<Object[]> dp() {

        List<Object[]> list = Lists.newLinkedList();
        list.add(new Object[] {new int[] {1, 1, 2, 3}, 1, 3});
        list.add(new Object[] {new int[] {1, 2, 7, 1}, 9, 2});

        return list.iterator();
    }

    @Test (dataProvider = "dp")
    public void test(int[] input, int target, int expected) {
        TargetSumSymbols targetSumSymbols = new TargetSumSymbols();
        Assert.assertEquals(targetSumSymbols.targetSum(input, target), expected);
    }
}
