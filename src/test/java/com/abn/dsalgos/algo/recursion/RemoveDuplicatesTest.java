package com.abn.dsalgos.algo.recursion;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.collections.Lists;

import java.util.Iterator;
import java.util.List;

public class RemoveDuplicatesTest {

    RemoveDuplicates removeDuplicates;

    @DataProvider
    public Iterator<Object[]> dp() {
        List<Object[]> lst = Lists.newLinkedList();

        lst.add(new Object[] {"Helloo", "Helo"});
        lst.add(new Object[] {"Thiss iiss aa teesstt", "This is a test"});


        return lst.iterator();
    }

    @Test(dataProvider = "dp")
    public void test(String actual, String expected) throws Exception {
        removeDuplicates = new RemoveDuplicates();

        Assert.assertEquals(removeDuplicates.remDuplicates(actual), expected);
    }
}
