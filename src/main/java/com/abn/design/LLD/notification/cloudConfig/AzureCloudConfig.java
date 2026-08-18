package com.abn.design.LLD.notification.cloudConfig;

import com.abn.design.LLD.notification.connectionConfig.AKSConnectionConfig;
import com.abn.design.LLD.notification.connectionConfig.IConnection;

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
