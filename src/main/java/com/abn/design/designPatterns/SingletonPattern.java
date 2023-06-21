package com.abn.design.designPatterns;

public class SingletonPattern {

    public static void main(String[] args) {

        /*
        Runtime class uses singleton pattern.

        Each jvm instance can have only one instance of Runtime.

        getRuntime() ensures same instance being returned.
         */
        Runtime runtime = Runtime.getRuntime();
    }
}
