package com.abn.dsalgos.algo.greedy;

import java.util.ArrayList;
import java.util.List;

/*
Given a positive fraction, break it down into its Egyptian fractions.Every positive fraction can be represented as the sum of its unique unit fractions

Eg: 2/3  ==> 1/2 , 1/6
 */
public class EgyptionFraction {

    List<String> result = new ArrayList<>();

    public String[] getUnitFraction(int numerator, int denominator) {

        if (denominator == 0 || numerator == 0) {
            return null;
        }

        if (denominator % numerator == 0) {
            result.add("1/" + denominator / numerator);
            return result.toArray(new String[0]);
        }

        if (numerator % denominator == 0) {
            return null;
        }

        if (numerator > denominator) {
            return getUnitFraction(numerator % denominator, denominator);
        }

        int n = denominator / numerator + 1;
        result.add("1/" + n);

        return getUnitFraction(numerator * n - denominator, denominator * n);
    }
}
