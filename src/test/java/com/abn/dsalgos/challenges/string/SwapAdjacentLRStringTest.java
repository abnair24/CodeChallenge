package com.abn.dsalgos.challenges.string;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.collections.Lists;

import java.util.Iterator;
import java.util.List;

public class SwapAdjacentLRStringTest {

    SwapAdjacentLRString swap;

    @DataProvider
    public Iterator<Object[]> dp() {

        List<Object[]> data = Lists.newLinkedList();
        data.add(new Object[] { "RXXLRXRXL", "RXXLRXRXL", true,});
        data.add(new Object[] { "XLLR", "LXLX", false});
        data.add(new Object[] { "XL", "LX", true});
        data.add(new Object[] { "LLR", "RRL", false});
        data.add(new Object[] { "XXXXLXXX", "XXXXLXXX", true});

        return data.iterator();
    }

    @Test(dataProvider = "dp")
    public void test(String start, String end, boolean expected) throws Exception {
       swap =  new SwapAdjacentLRString();
       Assert.assertEquals(swap.canTransform(start, end), expected);
    }
}
