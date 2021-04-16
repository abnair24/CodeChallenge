package com.abn.dsalgos.algo.slidingWindo;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.collections.Lists;

import java.util.Iterator;
import java.util.List;

public class MinimumWindowSubstringTest {

    MinimumWindowSubstring minimumString;

    @DataProvider
    public Iterator<Object[]> dp() {
        List<Object[]> lst = Lists.newLinkedList();

        lst.add(new Object[] {"ADOBECODEBANC", "ABC", "BANC"});
        lst.add(new Object[] {"a", "a", "a"});
        lst.add(new Object[] {"a", "aa", ""});
        lst.add(new Object[] {"aabdec", "abc", "abdec"});
        lst.add(new Object[] {"adcad", "abc", ""});
        lst.add(new Object[] {"ADOABECODEBFANC", "ABC", "ABEC"});

        return lst.iterator();
    }

    @Test(dataProvider = "dp")
    public void test(String str, String pattern, String expected) throws Exception {
        minimumString = new MinimumWindowSubstring();
        Assert.assertEquals(minimumString.minimumWindow(str, pattern), expected);
    }
}
