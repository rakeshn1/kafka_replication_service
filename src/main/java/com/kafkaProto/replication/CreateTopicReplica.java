package com.kafkaProto.replication;

import resources.ReplicaUtils;

import java.io.File;
import java.io.IOException;

public class CreateTopicReplica {

    public static Boolean create(String ip, String topicId) {
        System.out.println("Topic " + topicId + " created on " + ip);
        // TODO implement creating a file for the replica topic
        String FilePath = ReplicaUtils.getTopicPath(topicId);
        File temp = new File(FilePath);
        temp.getParentFile().mkdirs();
        boolean exists = temp.exists();
        if (exists) {
            // send response that topic already exists.
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


