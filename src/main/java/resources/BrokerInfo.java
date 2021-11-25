package resources;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public final class BrokerInfo {
    public static List<String> hosts = new ArrayList<>(Arrays.asList(
            "192.168.0.0",
            "192.168.0.1",
            "192.168.0.2",
            "192.168.0.3"
    ));

    public static String myIp = "192.168.0.0";

    public static List<String> getHosts() {
        return hosts;
    }

    public static String getMyIp() {
        return myIp;
    }
}
