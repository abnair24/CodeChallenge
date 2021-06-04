package com.abn.dsalgos.algo.recursion;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.collections.Lists;

import java.util.Iterator;
import java.util.List;

public class PalindromeRecursionTest {

    PalindromeRecursion palindromeRecursion = new PalindromeRecursion();

    @DataProvider
    public Iterator<Object[]> dp() {

        List<Object[]> list = Lists.newLinkedList();

        list.add(new Object[] {"malayalam", true});
        list.add(new Object[] {"elle", true});
        list.add(new Object[] {"hello", false});
        list.add(new Object[] {"x", true});

        return list.iterator();
    }

    @Test(dataProvider = "dp")
    public void test(String str, boolean expected) {

        Assert.assertEquals(palindromeRecursion.isPalindrome(str), expected);
    }
}
