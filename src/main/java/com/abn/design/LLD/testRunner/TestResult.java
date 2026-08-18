package com.abn.design.LLD.testRunner;

public class TestResult {

    final String name;
    final Status status;
    final String message;
    final long duration;

    public TestResult(String name, Status status, String message, long duration) {
        this.name = name;
        this.status = status;
        this.message = message;
        this.duration = duration;
    }
}
