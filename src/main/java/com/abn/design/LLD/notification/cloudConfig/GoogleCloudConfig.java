package com.abn.design.LLD.notification.cloudConfig;

import com.abn.design.LLD.notification.connectionConfig.GKEConnectionConfig;
import com.abn.design.LLD.notification.connectionConfig.IConnection;

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
