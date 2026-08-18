package com.abn.design.LLD.notification.factory;

import com.abn.design.LLD.notification.benchMark.IBenchMark;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Supplier;

public class BenchmarkFactory {

    private static Map<String, Supplier<IBenchMark>> registry = new HashMap<>();

    public static void register(String type, Supplier<IBenchMark> supplier) {
        registry.put(type, supplier);
    }

    public static IBenchMark create(String type) {

        Supplier<IBenchMark> supplier = registry.get(type);
        if(supplier == null) {
            throw new IllegalArgumentException();
        }
        return supplier.get();
    }
}
