package com.kafkaProto.replication;


import org.json.JSONObject;
import resources.ReplicaServiceConfig;
import resources.ReplicaUtils;

import java.io.*;
import java.net.*;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.Duration;

public class PollLeader extends Thread{

    boolean _forever;
    String topicId;

    public PollLeader(String topicId){
        this.topicId = topicId;
        this._forever = true;
    }

    public void set_forever(boolean _forever) {
        this._forever = _forever;
    }

    public void run(){
        while(_forever){
            String data = getLeaderData(this.topicId);
            if(data!=null){
                // TODO write to log file
                String filePath = ReplicaUtils.getTopicPath(this.topicId);
                try
                {
                    FileWriter fw = new FileWriter(filePath,true); //the true will append the new data
                    fw.write("\n");
                    fw.write(data);
                    fw.close();
                }
                catch(IOException ioe)
                {
                    System.err.println("IOException: " + ioe.getMessage());
                }
            }
//            try {
//                Thread.sleep(1000);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
        }
    }

    public static String getLeaderData(String topicId) {
        // TODO hit zookeeper to get leader ip of the topic
        String leaderUrl = Zookeeper.getDataFromZookeeper(topicId);
        int lines = ReplicaUtils.getLinesCount(ReplicaUtils.getTopicPath(topicId));
        String data = getData(leaderUrl, topicId, lines);
        System.out.println("+++++++++++++"+data);
        // TODO hit the leader to get the new data
        return data;
    }

    public static String getData(String leaderUrl, String topicId, int offset) {
        try {
            String formedUrl = leaderUrl+":"+ReplicaServiceConfig.REPLICA_SERVICE_PORT+"/leader-sync";
            //String formedUrl ="http://localhost:5676/get_topic_leader/";
            System.out.println("get data url formed : " + formedUrl);
            URL url = new URL(formedUrl);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("POST");
            conn.setRequestProperty("Content-Type", "application/json; charset=UTF-8");
            conn.setRequestProperty("Accept", "application/json");
            conn.setDoOutput(true);
            conn.setDoInput(true);
            JSONObject cred = new JSONObject();
            JSONObject parent=new JSONObject();
            cred.put("topicID",topicId);
            cred.put("offset", offset);

            OutputStreamWriter wr= new OutputStreamWriter(conn.getOutputStream());
            wr.write(cred.toString());
            wr.flush();

            StringBuilder sb = new StringBuilder();
            int HttpResult = conn.getResponseCode();
            if (HttpResult == HttpURLConnection.HTTP_OK) {
                BufferedReader br = new BufferedReader(
                        new InputStreamReader(conn.getInputStream(), "utf-8"));
                String line = null;
                while ((line = br.readLine()) != null) {
                    sb.append(line + "\n");
                }
                br.close();
                return sb.toString();
            } else {
                System.out.println(conn.getResponseMessage());
                return null;
            }

        } catch (Exception e) {
            System.out.println("Exception in NetClientGet:- " + e);
            return null;
        }
    }


}
