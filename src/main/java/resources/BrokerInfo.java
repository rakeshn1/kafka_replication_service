package resources;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.Socket;
import java.net.SocketException;
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
            hostList =  Arrays.asList(message.split(","));

        return hostList;
    }

    public static String getMyIp() {
        String ip;
        String  publicIp = null;
        try {
            Enumeration<NetworkInterface> interfaces = NetworkInterface.getNetworkInterfaces();
            while (interfaces.hasMoreElements()) {
                NetworkInterface iface = interfaces.nextElement();
                if (iface.isLoopback() || !iface.isUp())
                    continue;
                Enumeration<InetAddress> addresses = iface.getInetAddresses();
                while(addresses.hasMoreElements()) {
                    InetAddress addr = addresses.nextElement();
                    ip = addr.getHostAddress();
                    if(ip.length() == 14){
                        publicIp = ip;
                    }
                    System.out.println(iface.getDisplayName() + " " + ip);
                }
            }
        } catch (SocketException e) {
            throw new RuntimeException(e);
        }
        if(publicIp == null){
            return myIp;
        }else{
            return publicIp;
        }
    }
}
