package com.abn.design.notification.notifiers;

import com.abn.design.notification.benchMark.BenchmarkResult;

public interface INotifier {

    void notify(BenchmarkResult result);
}
