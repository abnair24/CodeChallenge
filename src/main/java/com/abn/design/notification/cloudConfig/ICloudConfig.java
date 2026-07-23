package com.abn.design.notification.cloudConfig;

import com.abn.design.notification.connectionConfig.IConnection;

public interface ICloudConfig {

    String getProviderName();

    IConnection getConnection();
}
