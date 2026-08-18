package com.abn.design.leetcode;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class FlakyAnalyzer {

    static class TestRun {
        public int id;
        public List<TestResult> results;
    }
    @JsonIgnoreProperties(ignoreUnknown = true)
    static class TestResult {

        public String name;
        public String status;
    }
    static class TestStatus {

        public String name;
        public int passed;
        public int failed;
        public int totalRuns;
        public double failRate;
        public String verdict;
    }

    static List<TestRun> parse(String json) throws Exception {
        ObjectMapper mapper = new ObjectMapper();
        return mapper.readValue(json, new TypeReference<List<TestRun>>() {});
    }

    public static List<TestStatus> analyze(List<TestRun> runs) {
        Map<String, TestStatus> testStatusMap = new LinkedHashMap<>();

        TestStatus testStatus;
        for(TestRun r : runs) {
            for( TestResult res: r.results) {

                if(!testStatusMap.containsKey(res.name)) {
                    testStatus = new TestStatus();
                    testStatus.name = res.name;
                    testStatusMap.put(res.name, testStatus);
                }

                testStatus = testStatusMap.get(res.name);
                testStatus.totalRuns ++;

                if(res.status.equals("FAIL")) {
                    testStatus.failed ++;
                } else {
                    testStatus.passed ++;
                }
            }
        }

        for(TestStatus ts : testStatusMap.values()) {
            if(ts.passed == 0) {
                ts.verdict = "BROKEN";
            } else if(ts.failed == 0) {
                ts.verdict = "STABLE";
            } else {
                ts.verdict = "FLAKY";
            }
            ts.failRate = (double) ts.failed / ts.totalRuns;
        }
        return new ArrayList<>(testStatusMap.values());
    }

    static void print(List<TestStatus> stats) {
        System.out.printf("%-10s %-8s %-8s %-8s %s%n", "Test", "Passes", "Fails", "FailureRate", "Verdict");
        for (TestStatus s : stats) {
            System.out.printf("%-10s %-8d %-8d %-8s %s%n",
                    s.name, s.passed, s.failed, s.failRate, s.verdict);
        }
    }

    public static void main(String[] args)
            throws Exception {

        String json = """
        [
          {"id":1,"results":[{"name":"login","status":"PASS"},{"name":"logout","status":"FAIL"},{"name":"search","status":"PASS"},{"name":"payment","status":"FAIL"}]},
          {"id":2,"results":[{"name":"login","status":"PASS"},{"name":"logout","status":"PASS"},{"name":"search","status":"PASS"},{"name":"payment","status":"FAIL"}]},
          {"id":3,"results":[{"name":"login","status":"PASS"},{"name":"logout","status":"FAIL"},{"name":"search","status":"FAIL"},{"name":"payment","status":"FAIL"}]},
          {"id":4,"results":[{"name":"login","status":"PASS"},{"name":"logout","status":"PASS"},{"name":"search","status":"PASS"},{"name":"payment","status":"FAIL"}]},
          {"id":5,"results":[{"name":"login","status":"PASS"},{"name":"logout","status":"FAIL"},{"name":"search","status":"PASS"},{"name":"payment","status":"FAIL"}]}
        ]
        """;

        print(analyze(parse(json)));
    }
}
