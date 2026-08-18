package com.abn.design.LLD.testRunner;

import java.util.Set;

class RetryRunner implements TestCase {
    private final TestCase delegate;
    private final int maxAttempts;

    RetryRunner(TestCase delegate, int maxAttempts) {
        this.delegate = delegate; this.maxAttempts = maxAttempts;
    }
    @Override
    public String name() {
        return delegate.name();
    }
    @Override
    public Set<String> tags() {
        return delegate.tags();
    }
    @Override
    public void run() throws Exception {
        Exception last = null;
        for (int attempt = 1; attempt <= maxAttempts; attempt++) {
            try {
                delegate.run();
                return;
            }      // success on any attempt wins
            catch (Exception e) {
                last = e;
            }
        }
        throw last;                               // all attempts failed
    }
}
// usage: runner.register(new RetryingTest(flakyTest, 3));
