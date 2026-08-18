package com.abn.design.LLD.notification.benchMark;

import com.abn.design.LLD.notification.notifiers.INotifier;

import java.util.ArrayList;
import java.util.List;

public class BenchMarkRunner {

    private List<INotifier> notifierList = new ArrayList<>();
    private IBenchMark benchMark;

    public BenchMarkRunner(IBenchMark benchMark) {
        this.benchMark = benchMark;
    }

    public void registerNotifier(INotifier notifier) {
        notifierList.add(notifier);
    }

    public void run() {
        BenchmarkResult result = benchMark.executeFetchResult("queryName");

        for(INotifier notifier: notifierList) {
            notifier.notify(result);
        }
    }
}
