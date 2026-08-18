package com.abn.design.LLD.notification.benchMark;

import com.abn.design.LLD.notification.cloudConfig.ICloudConfig;
import com.abn.design.LLD.notification.connectionConfig.IConnection;

public class TPCHBenchmark implements IBenchMark {

    ICloudConfig cloudConfig;

    public TPCHBenchmark(ICloudConfig cloudConfig) {
        // Setup cloud configuration
        this.cloudConfig = cloudConfig;
    }

    @Override
    public BenchmarkResult executeFetchResult(String queryName) {
        IConnection connection = cloudConfig.getConnection();

        long start = System.currentTimeMillis();
        connection.execute("TPCH Q67");
        long duration = System.currentTimeMillis() - start;
        return new BenchmarkResult.Builder()
                .withQueryName("TPCH Q67")
                .withDurationMs(duration)
                .withCloudProvider(cloudConfig.getProviderName())
                .withP95Latency(100)
                .withStatus(true)
                .build();
    }
}
