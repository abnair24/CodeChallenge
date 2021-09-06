package com.abn.dsalgos.challenges.string;

/*
Find the maximum product of k consecutive digits in a string of length N.
 */

public class MaxProductOfKDigits {

    public int maxProduct(String str, int k) {

        if (k > str.length()) {
            return -1;
        }

        if (k == 0) {
            return 0;
        }

        int product = 1;
        int len = str.length();

        for (int i = 0; i < k; i++) {
            product = product * (str.charAt(i) - '0');
        }

        int maxProd = product;

        for (int i = k; i < len; i++) {

            int temp = str.charAt(i - k) - '0';
            if (temp == 0) {
                break;
            } else {
                product = product * (str.charAt(i) - '0') / temp;
            }

            maxProd = Math.max(maxProd, product);
        }

        return maxProd;
    }
}
