package com.kafkaProto.replication;

import com.sun.net.httpserver.HttpContext;
import com.sun.net.httpserver.HttpServer;
import resources.ReplicaServiceConfig;

import java.io.IOException;
import java.net.InetSocketAddress;

public class ReplicaService {
    private static HttpServer server;

    public static void main(String[] args) throws IOException {
        startReplicaServer();
        addTopicReplicationApi();
    }

    private static void startReplicaServer() throws IOException {
        server = HttpServer.create(new InetSocketAddress(ReplicaServiceConfig.REPLICA_SERVICE_PORT), 0);
        server.start();
        System.out.println("Replica server started on port "+ ReplicaServiceConfig.REPLICA_SERVICE_PORT);
    }

    private static void addTopicReplicationApi(){
        HttpContext context = server.createContext("/create-topic-replica");
        context.setHandler(HandleTopicReplica::handleRequest);
    }

}
