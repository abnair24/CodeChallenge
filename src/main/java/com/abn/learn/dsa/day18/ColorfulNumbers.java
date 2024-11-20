package com.abn.learn.dsa.day18;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/*
Given a number A, find if it is COLORFUL number or not.

If number A is a COLORFUL number return 1 else, return 0.

What is a COLORFUL Number:

A number can be broken into different consecutive sequence of digits.
The number 3245 can be broken into sequences like 3, 2, 4, 5, 32, 24, 45, 324, 245 and 3245.
This number is a COLORFUL number, since the product of every consecutive sequence of digits is different

 */

public class ColorfulNumbers {

    public int colorful(int A) {
        List<Integer> list = new ArrayList<>();
        HashMap<Integer, Integer> freqMap =new HashMap<>();


        while(A >0) {
            list.add(A%10);
            A = A/ 10;
        }

        int product;

        Set<Integer> set = new HashSet<>();

        for(int i = 0; i < list.size(); i++) {
            product = 1;
            for(int j = i; j < list.size(); j++) {

                product = product * list.get(j);

                if(set.contains(product)) {
                    return 0;
                } else {
                    set.add(product);
                }
            }
        }
        return 1;
    }
}