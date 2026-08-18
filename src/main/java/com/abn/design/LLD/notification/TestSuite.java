package com.abn.design.LLD.notification;

import com.abn.design.LLD.notification.benchMark.BenchMarkRunner;
import com.abn.design.LLD.notification.benchMark.IBenchMark;
import com.abn.design.LLD.notification.benchMark.TPCDSBenchmark;
import com.abn.design.LLD.notification.benchMark.TPCHBenchmark;
import com.abn.design.LLD.notification.cloudConfig.AWSCloudConfig;
import com.abn.design.LLD.notification.cloudConfig.AzureCloudConfig;
import com.abn.design.LLD.notification.cloudConfig.GoogleCloudConfig;
import com.abn.design.LLD.notification.cloudConfig.ICloudConfig;
import com.abn.design.LLD.notification.factory.BenchmarkFactory;
import com.abn.design.LLD.notification.factory.CloudConfigFactory;
import com.abn.design.LLD.notification.factory.NotifierFactory;
import com.abn.design.LLD.notification.notifiers.EmailNotifier;
import com.abn.design.LLD.notification.notifiers.INotifier;
import com.abn.design.LLD.notification.notifiers.PagerDutyNotifier;
import com.abn.design.LLD.notification.notifiers.SlackNotifier;
import com.google.common.collect.ImmutableList;

public class TestSuite {

    public static void main(String[] args) {

        CloudConfigFactory.register("AWS", () -> new AWSCloudConfig());
        CloudConfigFactory.register("Azure", () -> new AzureCloudConfig());
        CloudConfigFactory.register("Google", () -> new GoogleCloudConfig());

        ICloudConfig awsCloudConfig = CloudConfigFactory.create("AWS");
        ICloudConfig azureCloudConfig = CloudConfigFactory.create("Azure");
        ICloudConfig googleCloudConfig = CloudConfigFactory.create("Google");

        ImmutableList<ICloudConfig> cloudConfigs = ImmutableList.of(awsCloudConfig, azureCloudConfig, googleCloudConfig);

        NotifierFactory.register("Slack", () -> new SlackNotifier());
        NotifierFactory.register("PagerDuty", () -> new PagerDutyNotifier());
        NotifierFactory.register("Email", () -> new EmailNotifier());

        INotifier slackNotifier = NotifierFactory.create("Slack");
        INotifier pagerDutyNotifier = NotifierFactory.create("PagerDuty");
        INotifier emailNotifier = NotifierFactory.create("Email");

        for(ICloudConfig cloudConfig : cloudConfigs) {
            BenchmarkFactory.register("TPCDS", () -> new TPCDSBenchmark(cloudConfig));
            BenchmarkFactory.register("TPCH", () -> new TPCHBenchmark(cloudConfig));

            IBenchMark tpcdsBenchmark = BenchmarkFactory.create("TPCDS");
            IBenchMark tpchBenchmark = BenchmarkFactory.create("TPCH");

            BenchMarkRunner tpcdsBenchmarkRunner = new BenchMarkRunner(tpcdsBenchmark);
            BenchMarkRunner tpchBenchmarkRunner = new BenchMarkRunner(tpchBenchmark);

            for(BenchMarkRunner runner : ImmutableList.of(tpcdsBenchmarkRunner, tpchBenchmarkRunner)) {

                runner.registerNotifier(slackNotifier);
                runner.registerNotifier(pagerDutyNotifier);
                runner.registerNotifier(emailNotifier);
                runner.run();
            }
        }
    }
}
