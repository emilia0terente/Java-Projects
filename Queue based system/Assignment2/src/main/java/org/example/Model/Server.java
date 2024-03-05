package org.example.Model;

import org.example.GUI.SimulationFrame;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;

public class Server implements Runnable{
    //each queue
    private BlockingQueue<Task> server;
    SimulationFrame simulationFrame;
    int serverNo;
    int totalTasks=0;

    //public int getNoOfTasksInQueue(){return server.size();}

    public Server(int nr, SimulationFrame simulationFrame ){
        this.serverNo=nr;
        this.server=new LinkedBlockingDeque<>();
        this.simulationFrame=simulationFrame;
        this.totalTasks=0;
    }
    //0verrides the run and serves the clients while there are clients in the BlockingQueue
    @Override
    public void run() {
        while (true) {
            if(server.isEmpty()){//if no clients
                try {
                    Thread.sleep(1000L);//puts the thread to sleep for one second
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }else {//if clients
                //synchonized acces to ensure that only one thread can have access at a time
                synchronized (this) {
                    try {
                        //serve the client: 1s *  its serviceTime
                        Thread.sleep(1000L * server.peek().getServiceTime());
                        //remove client from BlockingQueue
                        server.remove();
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    }
                }
            }
        }
    }

    //used to display Queue 1 : "here comes method from Task-> toString that displays clients(id,arrivalTime,serviceTime)"
    public String toString(){
        String string="";

        for(Task t: server){
            string+=t.toString();
        }

        return "Queue "+serverNo + " : "+ string;
    }

    public void addClient(Task task){
        server.add(task);
    }
}
