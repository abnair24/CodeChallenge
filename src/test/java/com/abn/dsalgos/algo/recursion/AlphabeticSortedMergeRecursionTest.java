package com.abn.dsalgos.algo.recursion;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.collections.Lists;

import java.util.Iterator;
import java.util.List;

public class AlphabeticSortedMergeRecursionTest {

    AlphabeticSortedMergeRecursion alphabeticSortedMergeRecursion = new AlphabeticSortedMergeRecursion();

    @DataProvider
    public Iterator<Object[]> dp() {
        List<Object[]> list = Lists.newLinkedList();

        list.add(new Object[] {"cnt", "ace", "accent"});
        list.add(new Object[] {"adzz", "bfx", "abdfxzz"});
        list.add(new Object[] {"ackt", "flow", "acfklotw"});
        list.add(new Object[] {"x", "kmn", "kmnx"});
        list.add(new Object[] {"ilno", "a", "ailno"});

        return list.iterator();
    }

    @Test (dataProvider = "dp")
    public void test(String str1, String str2, String expected) {
        Assert.assertEquals(alphabeticSortedMergeRecursion.mergeSortedAlphabets(str1, str2), expected);
    }
}
