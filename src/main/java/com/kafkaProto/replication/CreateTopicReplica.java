package com.kafkaProto.replication;

public class CreateTopicReplica {

    public static Boolean create(String ip, String topicId) {
        System.out.println("Topic "+topicId+" created on "+ip);
        // TODO implement caller api
        return true;
    }

}
