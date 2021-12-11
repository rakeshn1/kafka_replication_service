package com.kafkaProto.replication;

import resources.ReplicaServiceConfig;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;

public class ManageTopicFile {
    public static void CreateTopicFile(String topicName, Boolean isReplica) throws IOException {
        String FilePath = getTopicPath(topicName);
        File temp = new File(FilePath);
        Boolean isCreated = temp.getParentFile().mkdirs();
        System.out.println("file creation status : " + isCreated );
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
            // return error :  file not exist or some other error
        }
    }

    public static String readTopicAtPosition(String topicName, int start, int end ) throws IOException {
        FileInputStream fis = null;

        try {
            // create new file input stream
            fis = new FileInputStream(getTopicPath(topicName));
            // skip bytes from file input stream
            fis.skip(start);
            byte[] bytes = new byte[end];
            int i = fis.read(bytes);
            System.out.println("Total bytes read :- " + i);
            for (byte b: bytes) {
                char c = (char) b;
                System.out.print(c);
            }
            fis.close();
        } catch(Exception ex) {
            // if any error occurs
            ex.printStackTrace();
        } finally {
            // releases all system resources from the streams
            if(fis!=null)
                fis.close();
        }
        return null;
    }
}
