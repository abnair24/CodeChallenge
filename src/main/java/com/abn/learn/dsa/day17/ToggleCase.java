package com.abn.learn.dsa.day17;

public class ToggleCase {

    public String solve(String str) {

        char[] array = str.toCharArray();

        for(int i = 0; i < array.length; i++) {

            if(array[i] >= 'a' && array[i] <= 'z') {
                array[i] = (char) (array[i] - 32);
            } else {
                array[i] = (char) (array[i] + 32);
            }
        }

        return new String(array);
    }

    public static void main(String[] args) {
        ToggleCase toggleCase = new ToggleCase();
        System.out.println(toggleCase.solve("HelloWORld"));
    }
}
