package com.abn.design.LLD.notification.factory;

import com.abn.design.LLD.notification.cloudConfig.ICloudConfig;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Supplier;

public class CloudConfigFactory {

    private static Map<String, Supplier<ICloudConfig>> registry = new HashMap<>();

    public static void register(String type, Supplier<ICloudConfig> supplier) {
        registry.put(type, supplier);
    }

    public static ICloudConfig create(String type) {

        Supplier<ICloudConfig> supplier = registry.get(type);
        if(supplier == null) {
            throw new IllegalArgumentException();
        }
        return supplier.get();
    }
}
