package com.abn.design.notification.benchMark;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Supplier;

public class Factory {

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
