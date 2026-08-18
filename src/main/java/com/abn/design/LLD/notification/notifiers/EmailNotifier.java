package com.abn.design.LLD.notification.notifiers;

import com.abn.design.LLD.notification.benchMark.BenchmarkResult;

public class EmailNotifier implements INotifier {

    @Override
    public void notify(BenchmarkResult result) {
        System.out.println("Notifying to email: " + result);
    }
}
