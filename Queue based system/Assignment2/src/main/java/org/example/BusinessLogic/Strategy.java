package org.example.BusinessLogic;


import org.example.GUI.SimulationFrame;
import org.example.Model.Server;
import org.example.Model.Task;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class Strategy {
    ArrayList<Thread> queue=new ArrayList<>();
    ArrayList<Server> servers=new ArrayList<>();
    BlockingQueue<Task> tasks=new LinkedBlockingQueue<>();
    SimulationFrame simulationFrame;

    int maxSimTime=0;
    int time=0;

    //which server's queue to add the task to
    private int currentQueue=0;

    public Strategy(){

    }


    public void init(){
        ArrayList<Task> aux=new ArrayList<>();
        //generate clients
        for(int i=0; i<Integer.parseInt(simulationFrame.getTxt1().getText()); i++){
            Task client = new Task(i, 0, 0);
            client.generate(Integer.parseInt(simulationFrame.getTxt4().getText()),Integer.parseInt(simulationFrame.getTxt5().getText()),
                    Integer.parseInt(simulationFrame.getTxt6().getText()),Integer.parseInt(simulationFrame.getTxt7().getText()));
            //random generates arrival and service time
            aux.add(client);
        }
        //put clients in BlockingQueue already sorted by arrivalTime
        aux.sort(new Comparator<Task>() {
            @Override
            public int compare(Task o1, Task o2) {
                return o1.getArrivalTime()-o2.getArrivalTime();
            }
        });
        tasks.addAll(aux);

        //generate threads for each queue
        for(int i=0 ; i<Integer.parseInt(simulationFrame.getTxt2().getText());i++){
            Server server =new Server(i,simulationFrame);
            servers.add(server);
            Thread thread= new Thread(server);//generate thread
            queue.add(thread);//add it to the queue
            queue.get(i).start();// start it //thread.start();
        }

        //gets maxSimTime from GUI
        maxSimTime=Integer.parseInt(simulationFrame.getTxt3().getText());
    }

    //starts the simulation
    public void work() {
        new Thread(() -> {
            while (time <= maxSimTime) {
                while (!tasks.isEmpty() && tasks.peek().getArrivalTime() == time) {
                    try {
                        int serverToServe=currentQueue % servers.size();
                        servers.get(serverToServe).addClient(tasks.take());
                        currentQueue++;
                    } catch (Exception e) {
                        e.printStackTrace();}
                    }
                String string=""; string+="Time: "+time+"\n"; string+="Waiting clients: ";
                for(Task t: tasks){
                    string+=t.toString() + "; ";
                }
                string+="\n";
                for (Server s: servers) {
                    string += s.toString()+"\n";
                }
                simulationFrame.updateLogs(string);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();}
                time++;}
            for(Thread t: queue){
                t.interrupt();}
        }).start();
    }

    ActionListener start = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            init();
            work();
        }
    };

    public void compile(){
        simulationFrame=new SimulationFrame();
        simulationFrame.getSimulation().addActionListener(start);
    }

    public static void main(String [] args){
        Strategy strategy=new Strategy();
        strategy.compile();
    }


}
