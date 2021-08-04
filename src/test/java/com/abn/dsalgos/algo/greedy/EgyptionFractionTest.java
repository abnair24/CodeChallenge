package com.abn.dsalgos.algo.greedy;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.collections.Lists;

import java.util.Iterator;
import java.util.List;

public class EgyptionFractionTest {

    @DataProvider
    public Iterator<Object[]> dp() {
        List<Object[]> list = Lists.newLinkedList();

        list.add(new Object[] {2, 3, new String[] {"1/2", "1/6"}});
        list.add(new Object[] {1, 5, new String[] {"1/5"}});
        list.add(new Object[] {6, 5, new String[] {"1/5"}});
        list.add(new Object[] {3, 4, new String[] {"1/2", "1/4"}});

        return list.iterator();
    }

//    @Test (dataProvider = "dp")
//    public void test(int n, int d, String[] result) {
//        EgyptionFraction egyptionFraction = new EgyptionFraction();
//        Assert.assertEquals(egyptionFraction.getUnitFraction(n, d), result);
//    }

    @Test
    public void test2() {
        String isPass = "";
        try {
            String a = "cat";
            String b = "rat";
            Assert.assertTrue(a.equals(b),"message");
            isPass="PASS";
        }catch(Exception e) {
            isPass = "FAIL";
        }
        System.out.println(isPass);
    }
}
