package com.abn.dsalgos.algo.slidingWindo;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.collections.Lists;

import java.util.Iterator;
import java.util.List;

public class LongestSubstringWithSameLetterAfterReplacementTest {

    LongestSubstringWithSameLetterAfterReplacement longest;

    @DataProvider
    public Iterator<Object[]> data() {

        List<Object[]> lst = Lists.newLinkedList();
        lst.add(new Object[]{ "aabccbb", 2, 5 });
        lst.add(new Object[]{ "abbcb", 1, 4});
        lst.add(new Object[]{ "abccde", 1, 3});
        lst.add(new Object[]{ "IMNJJTRMJEGMSOLSCCQICIHLQIOGBJAEHQOCRAJQMBIBATGLJDTBNCPIFRDLRIJHRABBJGQAOLIKRLHDRIGERENNMJSDSSMESSTR", 2, 6});

        return lst.iterator();
    }

    @Test(dataProvider = "data")
    public void test(String array, int k, int expected) throws Exception {
        longest = new LongestSubstringWithSameLetterAfterReplacement();
        Assert.assertEquals(longest.findLength(array, k), expected);
    }
}
