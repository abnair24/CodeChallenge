package com.abn.dsalgos.challenges.string;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.collections.Lists;

import java.util.Iterator;
import java.util.List;

public class StringRevPatternTest {

    StringRevPattern pattern;

    @DataProvider
    public Iterator<Object[]> dp() {
        List<Object[]> lst = Lists.newLinkedList();

        lst.add(new Object[] {"abc", "xyz", 3, "abczyxcbaxyzabczyx"});
        lst.add(new Object[] {"a", "b", 5, "ababababab"});
        lst.add(new Object[] {"abcd", "xy", 2, "abcdyxdcbaxy"});

        return lst.iterator();
    }

    @Test(dataProvider = "dp")
    public void test(String input1, String input2, int k, String expected) throws Exception {

        pattern = new StringRevPattern();
        Assert.assertEquals(pattern.revPattern(input1, input2, k), expected);
    }
}
