package com.kafkaProto.replication;

import resources.ReplicaUtils;

import java.io.File;
import java.io.IOException;

public class CreateTopicReplica {

    public static Boolean create(String ip, String topicId) {
        // TODO : create API call to create new topic in specied ip broker

        // new API call to create-new-topic
        return false;
    }

    public static Boolean createNewTopic(String topicId) {
        String FilePath = ReplicaUtils.getTopicPath(topicId);
        File temp = new File(FilePath);
        temp.getParentFile().mkdirs(); // creates directory if not exist
        boolean exists = temp.exists();
        if (exists) {
            System.out.println("Topic Already exist");
            return false;
        } else {
            try {
                temp.createNewFile();
                return true;
            } catch (IOException e) {
                System.out.println("Creation of topic failed");
                return true;
            }

        }
    }
}


