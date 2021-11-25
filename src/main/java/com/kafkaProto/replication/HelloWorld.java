package com.kafkaProto.replication;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class HelloWorld {
    public static void main(String[] args) throws IOException {
//        System.out.println("Hello Replicas");
//
//        // check if file exist
//        File temp = new File("com/kafkaProto/topics");
//        boolean exists = temp.exists();
//
        // create new file
//        File myObj = new File("filename.txt");
//        if (myObj.createNewFile()) {
//            System.out.println("File created: " + myObj.getName());
//        } else {
//            System.out.println("File already exists.");
//        }

//        // append content to file
//        try
//        {
//            String filename= "MyFile.txt";
//            FileWriter fw = new FileWriter(filename,true); //the true will append the new data
//            fw.write("add a line\n");//appends the string to the file
//            fw.close();
//        }
//        catch(IOException ioe)
//        {
//            System.err.println("IOException: " + ioe.getMessage());
//        }

//        ManageTopicFile.CreateTopicFile("first",false);
        ManageTopicFile.readTopicAtPosition("first", 2,2);

    }
}
