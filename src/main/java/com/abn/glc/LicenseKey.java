package com.abn.glc;

import org.testng.Assert;
import sun.tools.tree.AssignShiftLeftExpression;

public class LicenseKey {

    public String licenseKeyFormat(String license, int k) {

        String s = license.replace("-", "").toUpperCase();

        int len = s.length();

        int groupLen = len % k;

        StringBuilder sb = new StringBuilder();
        sb.append(s.charAt(0));

        int count = 0;
        for(int i = 1; i< len; i++) {
            if(groupLen == 0 && i%k == 0) {
                sb.append("-");
            } else if(groupLen > 0 && i == groupLen) {
                sb.append("-");
                count ++;
            } else if(groupLen > 0 && (i+1) % k == 0) {
                sb.append("-");
            }
            sb.append(s.charAt(i));
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        LicenseKey licenseKey = new LicenseKey();
        Assert.assertEquals(licenseKey.licenseKeyFormat("2-4A0r7-4k", 3), "24-A0R-74K");
        Assert.assertEquals(licenseKey.licenseKeyFormat("5F3Z-2e-9-w", 4), "5F3Z-2E9W");
        Assert.assertEquals(licenseKey.licenseKeyFormat("2-5g-3-J", 2), "2-5G-3J");
        Assert.assertEquals(licenseKey.licenseKeyFormat("a0001afds-", 4), "A-0001-AFDS");
    }
}
