package resources;

import resources.ReplicaServiceConfig;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ReplicaUtils {
    public static String getTopicPath(String TopicName){
        String path = ReplicaServiceConfig.PATH_TOPICS + TopicName + ReplicaServiceConfig.PATH_DEFAULT_PARTITION + TopicName + ReplicaServiceConfig.FORMAT_LOG;
        return path;
    }
    public static int getLinesCount(String path) {
        int lines = 0;
        try (BufferedReader reader = new BufferedReader(new FileReader(path))) {
            while (reader.readLine() != null) lines++;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return lines;
    }
}
