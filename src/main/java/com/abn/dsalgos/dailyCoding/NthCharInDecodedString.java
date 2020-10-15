package com.abn.dsalgos.dailyCoding;


/*

String a3b4c1k1
Decode and output at Kth position:

 */
public class NthCharInDecodedString {

    public static void main(String[] args) {
        System.out.println(decodeChar("a1b1c3",2));
    }

//    public static String characterAt(String input1, int input2) {
//        String temp ="";
//        int count = 0;
//        String finalString = "";
//
//        for(int i =0; i< input1.length()-1;) {
//            temp = "";
//            count = 0;
//
//            while (i < input1.length() && !Character.isDigit(input1.charAt(i))) {
//                temp += input1.charAt(i);
//                i++;
//            }
//
//            while (i < input1.length() && Character.isDigit(input1.charAt(i))) {
//                count = Character.getNumericValue(input1.charAt(i));
//                i++;
//            }
//
//            for (int j = 1; j <= count; j++) {
//                finalString += temp;
//            }
//        }
//
//        if((input2 > finalString.length())) {
//            return "-1";
//        } else {
//            char ch = finalString.charAt(input2 - 1);
//            return Character.toString(ch);
//        }
//    }

    public static String decodeChar(String input, int pos) {

        int runLength = 0;

        for(int i=1; i< input.length(); i= i+2) {
            runLength = runLength + Character.getNumericValue(input.charAt(i));
//            System.out.println(runLength);

            if(runLength >= pos) {

                return Character.toString(input.charAt(i-1));
            }
        }
        return "-1";
    }
}
