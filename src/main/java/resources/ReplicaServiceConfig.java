package resources;

public final class ReplicaServiceConfig {
    public final static int REPLICA_SERVICE_PORT = 8700;
    public final static String REPLICA_SERVICE_HOST = "localhost";
    public final static String PATH_TOPICS = "../Kafka-Proto/kafka/";
    public final static String PATH_DEFAULT_PARTITION = "/partitions/0/";
    public final static String FORMAT_LOG = ".csv";
    public final static String PATH_FULL = PATH_TOPICS + PATH_DEFAULT_PARTITION;
    public final static int ZOOKEEPER_LEADER_PORT = 7777;
    public final static int ZOOKEEPER_LIST_PORT = 7778;
    public static String ZOOKEEPER_HOST = "192.168.43.31";
    public final static String ZOOKEEPER_GET_LEADER_ENDPOINT = "/get_topic_leader";

    public static void setZookeeperIP (String ip) {
        ZOOKEEPER_HOST = ip;
    }
    public static String getZookeeperHost () {
        return ZOOKEEPER_HOST;
    }

}
