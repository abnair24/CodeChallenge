package com.abn.design.notification.notifiers;

import com.abn.design.notification.benchMark.BenchmarkResult;

public class PagerDutyNotifier implements INotifier {

    @Override
    public void notify(BenchmarkResult result) {
        System.out.println("Notifying to pager duty: " + result);
    }
}
