package com.abn.dsalgos.algo.twoPointer;

import com.abn.dsalgos.algo.twoPointers.HappyNumber;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.collections.Lists;

import java.util.Iterator;
import java.util.List;

public class HappyNumberTest {

    HappyNumber happyNumber;

    @DataProvider
    public Iterator<Object[]>dp() {
        List lst = Lists.newLinkedList();
        lst.add(new Object[] { 12, false });
        lst.add(new Object[] { 23, true });
        lst.add(new Object[] { 19, true });
        lst.add(new Object[] { 2, false });
        lst.add(new Object[] { 1, true });
        lst.add(new Object[] { 0, false });

        return lst.iterator();
    }

    @Test(dataProvider = "dp")
    public void test(int num, boolean status) {
        happyNumber = new HappyNumber();
        Assert.assertEquals(happyNumber.isHappyNumber(num), status);
    }
}
