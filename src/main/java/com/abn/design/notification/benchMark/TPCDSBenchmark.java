package com.abn.design.notification.benchMark;

import com.abn.design.notification.cloudConfig.ICloudConfig;
import com.abn.design.notification.connectionConfig.IConnection;

public class TPCDSBenchmark implements IBenchMark {
    ICloudConfig cloudConfig;

    public TPCDSBenchmark(ICloudConfig cloudConfig) {
        // Setup cloud configuration
       this.cloudConfig = cloudConfig;
    }

    @Override
    public BenchmarkResult executeFetchResult(String queryName) {

        IConnection connection = cloudConfig.getConnection();

        long start = System.currentTimeMillis();
        connection.execute("TPC-DS Q67");
        long duration = System.currentTimeMillis() - start;

        // Simulate running the TPC-DS benchmark and collecting results
        return new BenchmarkResult.Builder()
                .withQueryName("TPC-DS Q67")
                .withDurationMs(duration)
                .withCloudProvider(cloudConfig.getProviderName())
                .withP95Latency(100)
                .withStatus(true)
                .build();
    }
}
