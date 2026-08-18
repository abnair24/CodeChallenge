package com.abn.design.LLD.notification.connectionConfig;

public class GKEConnectionConfig implements IConnection {

    @Override
    public void execute(String query) {
        System.out.println("Executing query on GKE connection: " + query);
    }
}
