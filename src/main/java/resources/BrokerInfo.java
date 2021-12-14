package resources;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Enumeration;
import java.util.List;

public final class BrokerInfo {
    public static List<String> hosts = new ArrayList<>(Arrays.asList(
            "192.168.43.53"
//            "192.168.0.1",
//            "192.168.0.2",
//            "192.168.0.3"
    ));

    public static String myIp = "localhost";

    public static List<String> getHosts() throws IOException {
        Socket socket = null;
        List<String> hostList = new ArrayList<>();

            socket = new Socket(ReplicaServiceConfig.ZOOKEEPER_HOST, ReplicaServiceConfig.ZOOKEEPER_LIST_PORT);
            System.out.println("Connected!");
            InputStream inputStream = socket.getInputStream();
            DataInputStream dataOutputStream = new DataInputStream(inputStream);
            System.out.println("Sending string to the ServerSocket");
            String message = dataOutputStream.readUTF();
            dataOutputStream.close();
            System.out.println("Closing socket and terminating program."+ message);
            socket.close();
            message = message.replace("[","");
            message = message.replace("]","");
            message = message.replace(" ","");
            hostList =  Arrays.asList(message.split(","));

        return hostList;
    }

    public static String getMyIp() {
        String ip;
        String  publicIp = null;
        Enumeration<NetworkInterface> interfaces = null;
        try {
            interfaces = NetworkInterface.getNetworkInterfaces();
            while (interfaces.hasMoreElements()) {
                NetworkInterface networkInterface = interfaces.nextElement();
                if (!networkInterface.isUp() ) {
                    continue;
                }
                for (InterfaceAddress interfaceAddress : networkInterface.getInterfaceAddresses()) {
                    int npf = interfaceAddress.getNetworkPrefixLength();
                    InetAddress address = interfaceAddress.getAddress();
                    InetAddress broadcast = interfaceAddress.getBroadcast();
                    if (broadcast == null && npf != 8) {
//                    System.out.println(String.format("IPv6: %s; Network Prefix Length: %s", address, npf));
                    } else if (broadcast != null){
                        publicIp = address.toString().replace("/","");
                        System.out.println("MyIP: "+publicIp);
                    }
                }
            }
        } catch (SocketException e) {
            e.printStackTrace();
        }
        if(publicIp == null){
            return myIp;
        }else{
            return publicIp;
        }
    }
}
