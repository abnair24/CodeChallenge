package com.abn.dsalgos.algo.backtrack;

import java.util.Arrays;

public class LicensePlate {

    static char[] alphabets = "ABCDEFGHIJKLMNOPQRSTUVWXYZ".toCharArray();

    public static void main(String[] args) {
        // max 19244736 -> ZZZZZ
        System.out.println(resolve(19244736, 5));
    }

    public static String resolve(int n, int maxDigits) {
        n = n - 1;
        for (int i = 1; i <= maxDigits + 1; i++) {
            int lowerCriteria = criteria(i - 1, maxDigits);
            int upperCriteria = criteria(i, maxDigits);

            if (lowerCriteria < n && n <= upperCriteria) {
                return resolve(n, i, maxDigits);
            }
        }
        return "";
    }

    public static String resolve(int n, int bin, int maxDigits) {
        int index = maxDigits - 1;
        char[] ans = new char[maxDigits];
        Arrays.fill(ans, '0');
        int lowerCriteria = criteria(bin - 1, maxDigits);
        int upperCriteria = criteria(bin, maxDigits);
        if ((n > (lowerCriteria)) && (n <= upperCriteria)) {
            int key = (n - (lowerCriteria + 1)) / (pow(10, maxDigits - bin + 1));
            int remain = (n - (lowerCriteria + 1)) % pow(10, maxDigits - bin + 1);
            int time = bin - 1;
            while (time > 0) {
                int k = key % 26;
                ans[index] = alphabets[k];
                index--;
                key = key / 26;
                time--;
            }
            while (remain > 0) {
                ans[index] = (char) ('0' + remain % 10);
                index--;
                remain = remain / 10;
            }
        }
        return new String(ans);
    }

    private static int criteria(int bin, int maxDigits) {
        int criteria = 0;
        for (int i = 0; i < bin; i++) {
            criteria += pow(26, i) * pow(10, maxDigits - i);
        }
        return criteria - 1;
    }

    private static int pow(int base, int power) {
        return (int) Math.pow(base, power);
    }
}
