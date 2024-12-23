package com.abn.scalar.dsa.day14;

/*
Add 2 binary numbers
 */

public class BinaryAddition {

    public static void main(String[] args) {

        BinaryAddition binaryAddition = new BinaryAddition();
        System.out.println(binaryAddition.solve("110", "10"));
        System.out.println(binaryAddition.solve("1010110111001101101000", "1000011011000000111100110"));
    }

    public String solve(String num1, String num2) {

        int len1 = num1.length();
        int len2 = num2.length();

        String revA = reverse(num1);
        String revB = reverse(num2);

        int sum;
        int carry = 0;

        int count = 0;
        StringBuilder sb = new StringBuilder();

        int len = len1 > len2 ? len1 : len2;

        while(len1 > 0 || len2 > 0) {

            sum = carry;

            if(len1 > 0) {
                sum += Character.getNumericValue(revA.charAt(count));
                len1 --;
            }

            if(len2 > 0) {
                sum += Character.getNumericValue(revB.charAt(count));
                len2 --;
            }

            count ++;
            carry = sum / 2;
            sum = sum % 2;

            sb.append(sum);

            if(count == len && carry > 0) {
                sb.append(carry);
            }
        }

        return sb.reverse().toString();
    }

    private String reverse(String str) {

        StringBuilder sb = new StringBuilder();
        int len = str.length();

        for (int i = len - 1; i >= 0; i--) {
            sb.append(str.charAt(i));
        }
        return sb.toString();
    }
}
