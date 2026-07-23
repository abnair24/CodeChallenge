package com.abn.design.notification.connectionConfig;

public class AKSConnectionConfig implements IConnection {

    @Override
    public void execute(String query) {
        System.out.println("Executing query on AKS connection: " + query);
    }

}
