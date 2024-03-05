package org.example.model;
//client table from dataBase
public class Client {
    private int clientID;
    private String name;
    private String phoneNumber;
    private String email;

    public Client(int clientID, String name, String phoneNumber, String email) {
        this.clientID = clientID;
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.email = email;
    }

    public int getClientID() {
        return clientID;
    }

    public void setClientID(int clientID) {
        this.clientID = clientID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
