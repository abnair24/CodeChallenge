package com.abn.design.singleton.fileConfigManager;

import java.util.Arrays;
import java.util.List;

public class FileBasedConfigurationManagerImpl extends FileBasedConfigurationManager {

    private static volatile FileBasedConfigurationManagerImpl instance;

    private FileBasedConfigurationManagerImpl() {
    }

    public static FileBasedConfigurationManager getInstance() {

        if (instance == null) {
            synchronized (FileBasedConfigurationManagerImpl.class) {
                if (instance == null) {
                    instance = new FileBasedConfigurationManagerImpl();
                }
            }
        }
        return instance;
    }

    public static void resetInstance() {
        synchronized (FileBasedConfigurationManagerImpl.class) {
            instance = null;
        }
    }

    @Override
    public String getConfiguration(String key) {

        return properties.getProperty(key);
    }

    @Override
    public <T> T getConfiguration(String key, Class<T> type) {
        String value = properties.getProperty(key);
        if (value != null) {
            return convert(value, type);
        }

        return null;
    }

    @Override
    public void setConfiguration(String key, String value) {
        properties.setProperty(key, value);
    }

    @Override
    public <T> void setConfiguration(String key, T value) {
        List<String> validTypes = Arrays.asList("Integer", "Long", "Float", "Double");
        if (!validTypes.contains(value.getClass().getSimpleName())) {
            throw new UnsupportedOperationException("Invalid type: " + value.getClass().getSimpleName());
        }
        properties.setProperty(key, value.toString());
    }

    @Override
    public void removeConfiguration(String key) {
        if(key != null) {
            properties.remove(key);
        }
    }

    @Override
    public void clear() {
        properties.clear();
    }
}
