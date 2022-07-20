package com.abn.dsalgos.algo.twoPointers;


public class AddNumberStrings {

    int carry = 0;
    int sum = 0;

    public String addStrings(String num1, String num2) {

        if(num1.equals("0")){
            return num2;
        }

        if(num2.equals("0")) {
            return num1;
        }

        StringBuilder sb = new StringBuilder();

        String revNum1 = reverse(num1);
        String revNum2 = reverse(num2);

        int len = num1.length() < num2.length() ? num1.length() : num2.length();

        calculateSum(sb, len, revNum1, revNum2);

        if(num1.length() > len) {
            sb = calculateSum(sb, len, revNum1);
        }

        if(num2.length() > len) {
            sb = calculateSum(sb, len, revNum2);
        }

        if(carry > 0) {
            sb.append(carry);
        }

        return reverse(sb.toString());
    }

    private StringBuilder calculateSum(StringBuilder sb, int len, String num1) {

        for(int i = len ; i < num1.length(); i++) {
            sum = carry + num1.charAt(i) - '0';

            carry = 0;
            if(sum > 9) {
                carry = sum / 10;
                sum = sum % 10;
            }

            sb.append(sum);
        }

        return sb;
    }

    private StringBuilder calculateSum(StringBuilder sb, int len, String num1, String num2) {

        sum = 0;
        carry = 0;

        for(int i = 0; i < len; i++) {
            sum = carry + num1.charAt(i) - '0' + num2.charAt(i) - '0';

            carry = 0;
            if(sum > 9) {
                carry = sum / 10;
                sum = sum % 10;
            }

            sb.append(sum);
        }
        return sb;
    }

    private String reverse(String s) {
        StringBuilder sb = new StringBuilder();
        for(int i = s.length() - 1 ; i >= 0; i --) {
            sb.append(s.charAt(i));
        }
        return sb.toString();
    }

    public static void main(String[] args) {

        AddNumberStrings addNumberStrings = new AddNumberStrings();
        System.out.println(addNumberStrings.addStrings("389", "55"));
        System.out.println(addNumberStrings.addStrings("9999", "111"));
        System.out.println(addNumberStrings.addStrings("237", "284"));
        System.out.println(addNumberStrings.addStrings("999", "0"));
    }
}
