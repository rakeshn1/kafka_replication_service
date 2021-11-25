package com.kafkaProto.replication;

import com.sun.net.httpserver.Headers;
import com.sun.net.httpserver.HttpExchange;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;

public class LeaderSync {
    public static void handleRequest(HttpExchange exchange) throws IOException{
        // TODO compare offsets and send the new data back
        // req body will have latest replica offset

    }

    private static JSONObject getBody(HttpExchange exchange) throws IOException{
        System.out.println("-- body --");
        InputStream is = exchange.getRequestBody();
        Headers requestHeaders = exchange.getRequestHeaders();
        int contentLength = Integer.parseInt(requestHeaders.getFirst("Content-length"));
        byte[] data = new byte[contentLength];
        int length = is.read(data);
        String stringData = new String(data);
        JSONObject jsonObject = new JSONObject(stringData);
        return jsonObject;
    }
}
