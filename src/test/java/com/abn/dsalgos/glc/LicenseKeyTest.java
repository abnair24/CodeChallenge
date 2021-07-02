package com.abn.dsalgos.glc;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.collections.Lists;

import java.util.Iterator;
import java.util.List;

public class LicenseKeyTest {

    @DataProvider
    public Iterator<Object[]> dp() {
        List<Object[]> list = Lists.newLinkedList();
        list.add(new Object[] {"2-4A0r7-4k", 3, "24-A0R-74K"});
        list.add(new Object[] {"5F3Z-2e-9-w", 4, "5F3Z-2E9W"});
        list.add(new Object[] {"2-5g-3-J", 2, "2-5G-3J"});
        list.add(new Object[] {"a0001afds-", 4, "A-0001-AFDS"});

        return list.iterator();
    }

    @Test
    public void test(String actual, int k, String expected) {
        LicenseKey licenseKey = new LicenseKey();
        Assert.assertEquals(licenseKey.licenseKeyFormat(actual, k), expected);
    }
}
