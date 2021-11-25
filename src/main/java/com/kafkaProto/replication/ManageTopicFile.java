package com.kafkaProto.replication;

import resources.ReplicaServiceConfig;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class ManageTopicFile {
    public static void CreateTopicFile(String topicName, Boolean isReplica) throws IOException {
        // check if file exist
        String FilePath = ReplicaServiceConfig.PATH_FULL + topicName + ReplicaServiceConfig.FORMAT_LOG;
        File temp = new File(FilePath);
        boolean exists = temp.exists();
        if(exists){
            // send response that topic already exists.
        }else{
            temp.createNewFile();
        }
    }

    public static void AppendNewMessage(String topicName, String Message) throws IOException {
        // check if file exist
        String FilePath = ReplicaServiceConfig.PATH_FULL + topicName + ReplicaServiceConfig.FORMAT_LOG;
        try
        {

            FileWriter fw = new FileWriter(FilePath,true); //the true will append the new data
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
