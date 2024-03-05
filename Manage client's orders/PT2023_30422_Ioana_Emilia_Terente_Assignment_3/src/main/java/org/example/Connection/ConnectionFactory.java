package org.example.Connection;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ConnectionFactory {
    private static final Logger LOGGER= Logger.getLogger(ConnectionFactory.class.getName());
    private static final String DRIVER="org.postgresql.Driver";
    private static final String DBURL="jdbc:postgresql://localhost:5432/test";
    private static final String USER="postgres";
    private static final String PASS="12345678";

    private static ConnectionFactory singleInstance=new ConnectionFactory();
    private ConnectionFactory(){
        try{
            Class.forName(DRIVER);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
    private Connection createConnection(){
        Connection connection=null;
        try{
            connection= DriverManager.getConnection(DBURL,USER,PASS);
        } catch (SQLException e) {
            LOGGER.log(Level.WARNING,"Not able to connect dataBase");
            e.printStackTrace();
        }
        return connection;
    }
    public static Connection getConnection(){
        return singleInstance.createConnection();
    }
    public static void close(Connection connection){
        if(connection!=null){
            try{
                connection.close();
            } catch (SQLException e) {
                LOGGER.log(Level.WARNING,"Could not close the connection.");
            }
        }
    }
    public static void close(Statement statement){
        if(statement!=null){
            try{
                statement.close();
            } catch (SQLException e) {
                LOGGER.log(Level.WARNING,"Could not close the statement.");
            }
        }
    }
   public static void close(ResultSet resultSet){
        if(resultSet!=null){
            try{
                resultSet.close();
            } catch (SQLException e) {
                LOGGER.log(Level.WARNING,"Could not close the resultSet.");
            }
        }
   }

}
