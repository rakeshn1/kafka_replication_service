package resources;

import resources.ReplicaServiceConfig;

public class ReplicaUtils {
    public static String getTopicPath(String TopicName){
        String path = ReplicaServiceConfig.PATH_TOPICS + TopicName + ReplicaServiceConfig.PATH_DEFAULT_PARTITION + TopicName + ReplicaServiceConfig.FORMAT_LOG;
        return path;
    }
}
