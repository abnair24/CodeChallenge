package com.abn.design.notification.cloudConfig;

import com.abn.design.notification.connectionConfig.EKSConnectionConfig;
import com.abn.design.notification.connectionConfig.IConnection;

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
