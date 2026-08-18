package com.abn.design.LLD.testRunner;

import java.util.ArrayList;
import java.util.List;

public class TestRunner {

    private final List<TestCase> testCaseList = new ArrayList<>();
    public void register(TestCase test) {
        testCaseList.add(test);
    }

    public List<TestResult> runAll()
            throws Exception {
        List<TestResult> results = new ArrayList<>();

        for(TestCase testCase : testCaseList) {
            long startTime = System.currentTimeMillis();
            try {
                testCase.run();
                results.add(new TestResult(testCase.name(), Status.PASSED, null, System.currentTimeMillis() - startTime));
            } catch (Exception ex){
                results.add(new TestResult(testCase.name(), Status.FAILED, ex.getMessage(), System.currentTimeMillis() - startTime));
            }
        }
        return results;
    }

}
