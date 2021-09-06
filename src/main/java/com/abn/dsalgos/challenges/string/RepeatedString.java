package com.abn.dsalgos.challenges.string;

public class RepeatedString {

    public long repeatedCount(String str, long n) {
        long count = 0;

        if (str.length() == 1 && str == "a") {
            count = str.length() * n;
        } else if (str.length() <= n) {
            for (int i = 0; i < str.length(); i++) {
                if (str.charAt(i) == 'a') {
                    count++;
                }
            }
            long repeatTimes = n / str.length();

            count = count * repeatTimes;

            if (n % str.length() != 0) {
                for (int i = 0; i < (n % str.length()); i++) {
                    if (str.charAt(i) == 'a') {
                        count++;
                    }
                }
            }
        } else if (str.length() > n) {
            for (int i = 0; i < n % str.length(); i++) {
                if (str.charAt(i) == 'a') {
                    count++;
                }
            }

        }

        return count;
    }
}
