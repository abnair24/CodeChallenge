package com.abn.design.notification.cloudConfig;

import com.abn.design.notification.connectionConfig.GKEConnectionConfig;
import com.abn.design.notification.connectionConfig.IConnection;

public class GoogleCloudConfig implements ICloudConfig {


    @Override
    public String getProviderName() {
       return "Google Cloud";
    }

    @Override
    public IConnection getConnection() {
        return new GKEConnectionConfig();
    }
}
