package com.abn.dsalgos.glc;

import org.testng.Assert;

import java.util.HashMap;
import java.util.Map;

public class StrobogrammaticNumber {

    public boolean isStrobogrammatic(String num) {

        Map<Integer, Integer> map = new HashMap<>();

        map.put(0, 0);
        map.put(1, 1);
        map.put(6, 9);
        map.put(8, 8);
        map.put(9, 6);

        return isValid(num, map);
    }

    private boolean isValid(String num, Map<Integer,Integer> map) {

        StringBuilder stringBuilder = new StringBuilder();

        for(char ch: num.toCharArray()) {
            int numChar = Character.getNumericValue(ch);

           if(map.containsKey(numChar)) {
               stringBuilder.insert(0, map.get(numChar));
           } else {
               return false;
           }
        }

        if(num.equals(stringBuilder.toString())) {
            return true;
        } else {
            return false;
        }
    }

    public static void main(String[] args) {

        StrobogrammaticNumber strobogrammaticNumber = new StrobogrammaticNumber();
        Assert.assertTrue(strobogrammaticNumber.isStrobogrammatic("69"));
        Assert.assertFalse(strobogrammaticNumber.isStrobogrammatic("962"));
        Assert.assertFalse(strobogrammaticNumber.isStrobogrammatic("6088448809"));
    }
}
