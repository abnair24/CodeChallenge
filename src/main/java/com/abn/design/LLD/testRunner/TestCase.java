package com.abn.design.LLD.testRunner;

import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.ExecutionException;

public interface TestCase {

    String name();
    void run() throws Exception;
    default Set<String> tags() {
        return Set.of();
    }

}
