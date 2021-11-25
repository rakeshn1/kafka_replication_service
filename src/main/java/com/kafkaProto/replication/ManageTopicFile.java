package com.kafkaProto.replication;

import resources.ReplicaServiceConfig;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class ManageTopicFile {
    public static void CreateTopicFile(String topicName, Boolean isReplica) throws IOException {
        String FilePath = getTopicPath(topicName);
        File temp = new File(FilePath);
        temp.getParentFile().mkdirs();
        boolean exists = temp.exists();
        if(exists){
            // send response that topic already exists.
        }else{
            temp.createNewFile();
        }
    }

    private static String getTopicPath(String TopicName){
        String path = ReplicaServiceConfig.PATH_TOPICS + TopicName + ReplicaServiceConfig.PATH_DEFAULT_PARTITION + TopicName + ReplicaServiceConfig.FORMAT_LOG;
        return path;
    }

    public static void AppendNewMessage(String topicName, String Message) throws IOException {
        String FilePath = getTopicPath(topicName);
        try
        {
            FileWriter fw = new FileWriter(FilePath,true); //the true will append the new data
            fw.write("\n");
            fw.write(Message);//appends the string to the file
            fw.close();
        }
        catch(IOException ioe)
        {
            System.err.println("IOException: " + ioe.getMessage());
            // return error specifying file not exist or some other error
        }
    }
}
