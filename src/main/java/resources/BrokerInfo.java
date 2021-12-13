package resources;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Arrays;
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

            socket = new Socket("192.168.43.31", 7778);
            System.out.println("Connected!");
            InputStream inputStream = socket.getInputStream();
            DataInputStream dataOutputStream = new DataInputStream(inputStream);
            System.out.println("Sending string to the ServerSocket");
            String message = dataOutputStream.readUTF();
            System.out.println("Host ips : " + message);
            dataOutputStream.close();
            System.out.println("Closing socket and terminating program."+ message);
            socket.close();
            hostList =  Arrays.asList(message.split(","));

        return hostList;
    }

    public static String getMyIp() {
        return myIp;
    }
}
