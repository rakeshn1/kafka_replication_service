package com.kafkaProto.replication;

import org.json.JSONObject;

public class Zookeeper {

    public static Boolean sendTopicReplica(JSONObject reqBody){
        System.out.println(reqBody.get("topicId"));
        System.out.println(reqBody.get("leader"));
        System.out.println(reqBody.get("replica"));
        return true;
    }
}
