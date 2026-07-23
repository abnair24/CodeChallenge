package com.abn.design.notification.notifiers;

import com.abn.design.notification.benchMark.BenchmarkResult;

public class EmailNotifier implements INotifier {

    @Override
    public void notify(BenchmarkResult result) {
        System.out.println("Notifying to email: " + result);
    }
}
