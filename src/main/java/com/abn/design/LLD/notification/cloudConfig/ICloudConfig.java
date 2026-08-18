package com.abn.design.LLD.notification.cloudConfig;

import com.abn.design.LLD.notification.connectionConfig.IConnection;

public interface ICloudConfig {

    String getProviderName();

    IConnection getConnection();
}
