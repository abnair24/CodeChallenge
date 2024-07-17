package com.abn.dsalgos.glc;


import java.util.ArrayList;
import java.util.List;

/*
Given string array of string in the below format, generate all the missing numbers between 2 numbers in the string atray

{"foo_1", "foo_5"} -> foo_2, foo_3
 */
public class GeneratMissingNumbers {

    public List<String> generate(String[] input) {

        String[] inputSplit = input[0].split("_");
        String baseString = inputSplit[0];
        Integer startNum = Integer.parseInt(inputSplit[1]);
        int lastNum = startNum;
        List<String> missingNumbers = new ArrayList<>();

        for(int i = 1; i < input.length; i++) {

            String lastString = input[i];
            int actualNum = Integer.parseInt(lastString.split("_")[1]);

            while(Math.abs(lastNum - actualNum) != 0) {
                int expectedNum = lastNum + 1;
                if(expectedNum != actualNum) {
                    missingNumbers.add(baseString + "_" + expectedNum);
                }
                lastNum = expectedNum;
            }

        }
        return missingNumbers;
    }

    public static void main(String[] args) {

        GeneratMissingNumbers generatMissingNumbers = new GeneratMissingNumbers();

        System.out.println(generatMissingNumbers.generate(new String[] {"foo_21", "foo_25"}));
        System.out.println(generatMissingNumbers.generate(new String[] {"foo_21", "foo_32"}));
        System.out.println(generatMissingNumbers.generate(new String[] {"foo_1", "foo_2", "foo_4", "foo_9", "foo_10"}));
        System.out.println(generatMissingNumbers.generate(new String[] {"foo_1"}));
    }
}
