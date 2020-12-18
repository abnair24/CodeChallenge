package com.abn.dsalgos.challenges.string;

public class ReorganizeString {

    public static String reorganizeString(String str) {

        int length = str.length();
        int mid = length/2 ;
        StringBuffer sb = new StringBuffer();

        for(int i = 0; i <mid; i++) {
            if(str.charAt(i) == str.charAt(length-mid+i)) {
                sb.append("");
                break;
            } else {
                sb.append(str.charAt(i));
                sb.append(str.charAt(length-mid+i));
            }
        }
        if(length%2!=0) {
            sb.append(str.charAt(mid));
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        reorganizeString("vvvlo");
    }
}
