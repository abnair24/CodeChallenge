package com.abn.design.notification.benchMark;

public class BenchmarkResult {

    private String queryName;
    private Long durationMs;
    private Integer p95Latency;
    private Boolean status;
    private String cloudProvider;

    private BenchmarkResult() {
    }

    public String getQueryName() {
        return queryName;
    }

    public Long getDurationMs() {
        return durationMs;
    }

    public Integer getP95Latency() {
        return p95Latency;
    }

    public Boolean getStatus() {
        return status;
    }

    public String getCloudProvider() {
        return cloudProvider;
    }

    public static class Builder {

        // Builder's own staging fields — separate from BenchmarkResult
        private String queryName;
        private Long durationMs;
        private Integer p95Latency;
        private Boolean status;
        private String cloudProvider;

        public Builder withQueryName(String queryName) {
            this.queryName = queryName;
            return this;
        }

        public Builder withDurationMs(Long durationMs) {
            this.durationMs = durationMs;
            return this;
        }

        public Builder withP95Latency(Integer p95Latency) {
            this.p95Latency = p95Latency;
            return this;
        }

        public Builder withStatus(Boolean status) {
            this.status = status;
            return this;
        }

        public Builder withCloudProvider(String cloudProvider) {
            this.cloudProvider = cloudProvider;
            return this;
        }

        public BenchmarkResult build() {
            // Validate required fields before creating the object
            if (this.queryName == null) {
                throw new IllegalArgumentException(
                        "queryName is required");
            }

            // Create a FRESH object every time build() is called
            // Copies from Builder's staging fields into the new object
            // Caller owns this object — Builder cannot mutate it after
            BenchmarkResult result = new BenchmarkResult();
            result.queryName = this.queryName;
            result.durationMs = this.durationMs;
            result.p95Latency = this.p95Latency;
            result.status = this.status;
            result.cloudProvider = this.cloudProvider;
            return result;
        }
    }
}