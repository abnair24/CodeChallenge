package com.abn.dsalgos.algo.slidingWindo;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.collections.Lists;

import java.util.Iterator;
import java.util.List;

public class StringPermutationTest {

    StringPermutation strPerm;

    @DataProvider
    public Iterator<Object[]> dp() {

        List<Object[]> lst = Lists.newLinkedList();

//        lst.add(new Object[] {"eidbaooo", "ab", true});
//        lst.add(new Object[] {"ooolleoooleh", "hello", false});
//        lst.add(new Object[] {"oidbcaf", "abc", true});
//        lst.add(new Object[] {"odicf", "dc", false});
//        lst.add(new Object[] {"bcdxabcdy", "bcdyabcdx", true});
        lst.add(new Object[] {"aaacb", "abc", true});

        return lst.iterator();
    }

    @Test(dataProvider = "dp")
    public void test(String str, String pattern, boolean expected) {
        strPerm = new StringPermutation();
        Assert.assertEquals(strPerm.isStringPermutation(str, pattern), expected);

    }
}
