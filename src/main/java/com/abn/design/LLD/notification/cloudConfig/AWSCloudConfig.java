package com.abn.design.LLD.notification.cloudConfig;

import com.abn.design.LLD.notification.connectionConfig.EKSConnectionConfig;
import com.abn.design.LLD.notification.connectionConfig.IConnection;

public class AWSCloudConfig implements ICloudConfig {


    @Override
    public String getProviderName() {
        return "AWS Cloud";
    }

    @Override
    public IConnection getConnection() {
        return new EKSConnectionConfig();
    }
}
