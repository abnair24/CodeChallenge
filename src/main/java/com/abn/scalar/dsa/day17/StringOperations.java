package com.abn.scalar.dsa.day17;

public class StringOperations {
    public String solve(String str) {

        String concat = str.concat(str);

        char[] array = concat.toCharArray();

        StringBuilder sb = new StringBuilder();

        for(int i = 0; i < concat.length(); i ++) {

            if(array[i] >= 'a' && array[i] <= 'z') {
                if(array[i] == 'a' || array[i] == 'e' || array[i] == 'i' || array[i] == 'o' || array[i] == 'u') {
                    sb.append('#');
                } else {
                    sb.append(array[i]);
                }
            }
        }
        return sb.toString();

    }

    public static void main(String[] args) {
        StringOperations stringOperations = new StringOperations();
        System.out.println(stringOperations.solve("aei0Uz"));
        System.out.println(stringOperations.solve("AbcaZeoB"));
        System.out.println(stringOperations.solve("wnovRKpe"));

    }
}
