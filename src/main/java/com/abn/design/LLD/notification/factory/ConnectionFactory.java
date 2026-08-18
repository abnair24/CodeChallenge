package com.abn.design.LLD.notification.factory;

import com.abn.design.LLD.notification.connectionConfig.IConnection;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Supplier;

public class ConnectionFactory {

    private static Map<String, Supplier<IConnection>> registry = new HashMap<>();

    public static void register(String type, Supplier<IConnection> supplier) {
        registry.put(type, supplier);
    }

    public static IConnection create(String type) {

        Supplier<IConnection> supplier = registry.get(type);
        if(supplier == null) {
            throw new IllegalArgumentException();
        }
        return supplier.get();
    }
}
