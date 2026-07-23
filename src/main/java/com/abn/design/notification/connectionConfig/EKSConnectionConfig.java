package com.abn.design.notification.connectionConfig;

public class EKSConnectionConfig implements IConnection {

    @Override
    public void execute(String query) {
        System.out.println("Executing query on EKS connection: " + query);
    }
}
