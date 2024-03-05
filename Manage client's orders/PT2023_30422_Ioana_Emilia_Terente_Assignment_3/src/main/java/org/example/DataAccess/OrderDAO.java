package org.example.DataAccess;

import org.example.Connection.ConnectionFactory;
import org.example.Presentation.OrderInterface;
import org.example.model.Order;
import org.example.model.Product;

import java.sql.*;
import java.util.List;

public class OrderDAO extends AbstractDAO<Order> {
    private Statement statement;
    private OrderInterface orderInterface;
    private Connection connection;

    public OrderDAO(Connection c, OrderInterface orderInterface) {
        this.connection = c;
        this.orderInterface = orderInterface;
        try {
            this.statement = c.createStatement();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void addOrder(int orderID, int clientID, int productID, int quantity) throws IllegalAccessException {
        Order order = new Order(orderID, clientID, productID, quantity);
        insert(order);
    }

    public void editOrder(int orderID, int clientID, int productID, int quantity) {
        String query = "SELECT * FROM `order` WHERE orderID = ?";
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        try {
            connection = ConnectionFactory.getConnection();
            statement = connection.prepareStatement(query);
            statement.setObject(1, orderID);
            resultSet = statement.executeQuery();
            if (resultSet.next()) {
                Order order = new Order(resultSet.getInt("orderID"), resultSet.getInt("clientID"),
                        resultSet.getInt("productID"), resultSet.getInt("quantity"));
                if (clientID != 0)
                    order.setClientID(clientID);
                if (productID != 0)
                    order.setProductID(productID);
                if (quantity != 0)
                    order.setQuantity(quantity);
                update(order);
            }
        } catch (SQLException | IllegalAccessException e) {
            e.printStackTrace();
        }
    }

    public void deleteOrder(int orderID) {
        String query = "SELECT * FROM `order` WHERE orderID = ?";
        PreparedStatement statement = null;
        try {
            connection = ConnectionFactory.getConnection();
            statement = connection.prepareStatement(query);
            statement.setObject(1, orderID);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                Order order = new Order(resultSet.getInt("orderID"), resultSet.getInt("clientID"),
                        resultSet.getInt("productID"), resultSet.getInt("quantity"));
                delete(order);
            }
        } catch (SQLException | IllegalAccessException e) {
            e.printStackTrace();
        }
    }
}

