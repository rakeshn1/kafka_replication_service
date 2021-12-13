package resources;

public final class ReplicaServiceConfig {
    public final static int REPLICA_SERVICE_PORT = 8700;
    public final static String REPLICA_SERVICE_HOST = "localhost";
    public final static String PATH_TOPICS = "topics/";
    public final static String PATH_DEFAULT_PARTITION = "/partitions/0/";
    public final static String FORMAT_LOG = ".csv";
    public final static String PATH_FULL = PATH_TOPICS + PATH_DEFAULT_PARTITION;
    public final static int ZOOKEEPER_LEADER_PORT = 7777;
    public final static int ZOOKEEPER_LIST_PORT = 7778;
    public final static String ZOOKEEPER_HOST = "172.20.10.12";
    public final static String ZOOKEEPER_GET_LEADER_ENDPOINT = "/get_topic_leader";
}
