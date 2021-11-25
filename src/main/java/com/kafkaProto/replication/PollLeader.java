package com.kafkaProto.replication;



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
            }
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private String getLeaderData(String topicId) {
        // TODO hit zookeeper to get leader ip of the topic
        // TODO hit the leader to get the new data
        return null;
    }


}
