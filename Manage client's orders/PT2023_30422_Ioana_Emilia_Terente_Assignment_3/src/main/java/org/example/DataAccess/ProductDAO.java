package org.example.DataAccess;

import org.example.Connection.ConnectionFactory;
import org.example.Presentation.ProductInterface;
import org.example.model.Client;
import org.example.model.Product;

import java.sql.*;
import java.util.List;

public class ProductDAO extends AbstractDAO<Product> {
    private Statement statement;
    private ProductInterface productInterface;
    private Connection connection;

    public ProductDAO(Connection c, ProductInterface productInterface) {
        this.connection = c;
        this.productInterface = productInterface;
        try {
            this.statement = c.createStatement();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void addProduct(int productID, String name, int price, int stock) throws IllegalAccessException {
        Product product = new Product(productID, name, price, stock);
        insert(product);
    }

    public void editProduct(int productID, String name, int price, int stock) {
        String query = "SELECT * FROM product WHERE productID = ?";
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        try {
            connection = ConnectionFactory.getConnection();
            statement = connection.prepareStatement(query);
            statement.setObject(1, productID);
            resultSet = statement.executeQuery();
            if (resultSet.next()) {
                Product product = new Product(resultSet.getInt("productID"), resultSet.getString("name"),
                        resultSet.getInt("price"), resultSet.getInt("stock"));
                if (name != null)
                    product.setName(name);
                if (price != 0)
                    product.setPrice(price);
                if (stock != 0)
                    product.setStock(stock);
                update(product);
            }
        } catch (SQLException | IllegalAccessException e) {
            e.printStackTrace();
        }
    }

    public void deleteProduct(int productID) {
        String query = "SELECT * FROM product WHERE productID = ?";
        PreparedStatement statement = null;
        try {
            connection = ConnectionFactory.getConnection();
            statement = connection.prepareStatement(query);
            statement.setObject(1, productID);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                Product product = new Product(resultSet.getInt("productID"), resultSet.getString("name"),
                        resultSet.getInt("price"), resultSet.getInt("stock"));
                delete(product);
            }
        } catch (SQLException | IllegalAccessException e) {
            e.printStackTrace();
        }
    }
}

