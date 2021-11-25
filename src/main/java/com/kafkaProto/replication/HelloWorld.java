package com.kafkaProto.replication;

import java.io.File;
import java.io.IOException;

public class HelloWorld {
    public static void main(String[] args) throws IOException {
        System.out.println("Hello Replicas");

        // check if file exist
        File temp = new File("com/kafkaProto/topics");
        boolean exists = temp.exists();

        // create new file
        File myObj = new File("filename.txt");
        if (myObj.createNewFile()) {
            System.out.println("File created: " + myObj.getName());
        } else {
            System.out.println("File already exists.");
        }
    }
}
