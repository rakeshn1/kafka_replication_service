package com.kafkaProto.replication;

import org.json.JSONObject;

public class Zookeeper {

    public static Boolean sendTopicReplica(JSONObject reqBody){
        // TODO send topic data (leader, replica ips to zookeeper)
        System.out.println(reqBody.get("topicId"));
        System.out.println(reqBody.get("leader"));
        System.out.println(reqBody.get("replica"));
        return true;
    }
}
