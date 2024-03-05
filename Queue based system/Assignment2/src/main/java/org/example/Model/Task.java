package org.example.Model;

public class Task {
     int id;
     int arrivalTime;//time that enters the queue
     int serviceTime;//period of time that stays in the queue

    public Task(int id, int arrivalTime, int serviceTime) {
        this.id = id;
        this.arrivalTime = arrivalTime;
        this.serviceTime = serviceTime;

    }

    public int getId() {
        return id;
    }

    public int getArrivalTime() {
        return arrivalTime;
    }

    public int getServiceTime() {
        return serviceTime;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setArrivalTime(int arrivalTime) {
        this.arrivalTime = arrivalTime;
    }

    public void setServiceTime(int serviceTime) {
        this.serviceTime = serviceTime;
    }
    public void generate(int arrivalTimeMin, int arrivalTimeMax, int serviceTimeMax, int serviceTimeMin){
        arrivalTime= (int) (Math.random()*(arrivalTimeMax-arrivalTimeMin) + arrivalTimeMin);
        serviceTime= (int) (Math.random()*(serviceTimeMax-serviceTimeMin) + serviceTimeMin);
    }

    public String toString(){
        return "("+id+", "+arrivalTime+", "+serviceTime+")";
    }
}
