package org.example.DataAccess;

import org.example.Connection.ConnectionFactory;
import org.example.Presentation.ClientInterface;
import org.example.model.Client;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CilentDAO extends AbstractDAO<Client> {
    private Statement statement;
    private ClientInterface clientInterface;
    private Connection connection;
    public CilentDAO(Connection c, ClientInterface clientInterface){
        this.connection=c;
        this.clientInterface=clientInterface;
        try{
            this.statement=c.createStatement();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void addClient(int id,String name,String phoneNumber,String email) throws IllegalAccessException {
        Client client=new Client(id,name,phoneNumber,email);
        insert(client);
    }
    public void editClient(int id,String name,String phoneNumber,String email) {
        String q="Select * from client where clientID = ?";
        PreparedStatement statement=null;
        ResultSet resultSet=null;
        try {
            connection = ConnectionFactory.getConnection();
            statement = connection.prepareStatement(String.valueOf(q));
            statement.setObject(1, id);
            statement.executeUpdate();
            if(resultSet.next()){
                Client client = new Client(resultSet.getInt("id"), resultSet.getString("name"), resultSet.getString("phoneNumber"), resultSet.getString("email"));
                if(!name.isEmpty())client.setName(name);
                if(!phoneNumber.isEmpty())client.setPhoneNumber(phoneNumber);
                if(!email.isEmpty())client.setEmail(email);
                update(client);
            }
        } catch (SQLException | IllegalAccessException e) {
            e.printStackTrace();
        }
    }
    public void deleteClient(int id) {
        String q="Select * from client where clientID = ?";
        PreparedStatement statement=null;
        try {
            connection = ConnectionFactory.getConnection();
            statement = connection.prepareStatement(String.valueOf(q));
            statement.setObject(1, id);
            if(statement.executeQuery().next()){
                Client client = new Client(statement.executeQuery().getInt("id"), statement.executeQuery().getString("name"), statement.executeQuery().getString("phoneNumber"), statement.executeQuery().getString("email"));
                System.out.println(client.getName());
                delete(client);
            }
        } catch (SQLException | IllegalAccessException e) {
            e.printStackTrace();
        }
    }
    public List<Client> viewAll(){
        return findAll();
    }

}



