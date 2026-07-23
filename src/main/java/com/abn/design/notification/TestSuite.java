package com.abn.design.notification;

import com.abn.design.notification.benchMark.BenchMarkRunner;
import com.abn.design.notification.benchMark.Factory;
import com.abn.design.notification.benchMark.IBenchMark;
import com.abn.design.notification.benchMark.TPCDSBenchmark;
import com.abn.design.notification.benchMark.TPCHBenchmark;
import com.abn.design.notification.cloudConfig.AWSCloudConfig;
import com.abn.design.notification.cloudConfig.AzureCloudConfig;
import com.abn.design.notification.cloudConfig.GoogleCloudConfig;
import com.abn.design.notification.cloudConfig.ICloudConfig;
import com.abn.design.notification.factory.BenchmarkFactory;
import com.abn.design.notification.factory.CloudConfigFactory;
import com.abn.design.notification.factory.NotifierFactory;
import com.abn.design.notification.notifiers.EmailNotifier;
import com.abn.design.notification.notifiers.INotifier;
import com.abn.design.notification.notifiers.PagerDutyNotifier;
import com.abn.design.notification.notifiers.SlackNotifier;
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
