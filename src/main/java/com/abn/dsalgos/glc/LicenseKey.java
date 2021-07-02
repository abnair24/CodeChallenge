package com.abn.dsalgos.glc;

public class LicenseKey {

    public String licenseKeyFormat(String license, int k) {

        String s = license.replace("-", "").toUpperCase();

        int len = s.length();

        int groupLen = len % k;

        StringBuilder sb = new StringBuilder();
        sb.append(s.charAt(0));

        int count = 0;
        for (int i = 1; i < len; i++) {
            if (groupLen == 0 && i % k == 0) {
                sb.append("-");
            } else if (groupLen > 0 && i == groupLen) {
                sb.append("-");
                count++;
            } else if (groupLen > 0 && (i + 1) % k == 0) {
                sb.append("-");
            }
            sb.append(s.charAt(i));
        }

        return sb.toString();
    }
}
