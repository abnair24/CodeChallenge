package com.abn.design.notification.factory;

import com.abn.design.notification.notifiers.INotifier;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Supplier;

public class NotifierFactory {

    private static Map<String, Supplier<INotifier>> registry = new HashMap<>();

    public static void register(String type, Supplier<INotifier> supplier) {
        registry.put(type, supplier);
    }

    public static INotifier create(String type) {

        Supplier<INotifier> supplier = registry.get(type);
        if(supplier == null) {
            throw new IllegalArgumentException();
        }
        return supplier.get();
    }
}
