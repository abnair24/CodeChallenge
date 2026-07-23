package com.abn.design.notification.cloudConfig;

import com.abn.design.notification.connectionConfig.AKSConnectionConfig;
import com.abn.design.notification.connectionConfig.IConnection;

public class AzureCloudConfig implements ICloudConfig {

    @Override
    public String getProviderName() {
        return "Azure Cloud";
    }

   @Override
    public IConnection getConnection() {
        return new AKSConnectionConfig();
    }
}
