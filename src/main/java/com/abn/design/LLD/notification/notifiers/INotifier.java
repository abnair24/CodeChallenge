package com.abn.design.LLD.notification.notifiers;

import com.abn.design.LLD.notification.benchMark.BenchmarkResult;

public interface INotifier {

    void notify(BenchmarkResult result);
}
