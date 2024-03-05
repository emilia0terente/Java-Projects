package org.example.DataAccess;

import org.example.Connection.ConnectionFactory;

import java.beans.IntrospectionException;
import java.beans.PropertyDescriptor;
import java.lang.reflect.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class AbstractDAO<T> {
    protected static final Logger LOGGER = Logger.getLogger(AbstractDAO.class.getName());

    private final Class<T> type;
    Connection connection = null;
    PreparedStatement statement = null;
    ResultSet resultSet = null;


    public AbstractDAO() {
        this.type = (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
    }
    private String createSelectQuery(String field) {
        StringBuilder sb = new StringBuilder();
        sb.append("SELECT * FROM ");
        sb.append(type.getSimpleName());
        if (field != null) {
            sb.append(" WHERE ").append(field).append(" = ?");
        }
        return sb.toString();
    }

    public List<T> findAll() {
        List<T> list = new ArrayList<>();
        String query = createSelectQuery(null); // Select all records
        try {
            connection = ConnectionFactory.getConnection();
            statement = connection.prepareStatement(query);
            list = createObjects(statement.executeQuery());
        } catch (SQLException e) {
            LOGGER.log(Level.WARNING, type.getName() + "DAO:findAll " + e.getMessage());
           e.printStackTrace();
        } finally {
            ConnectionFactory.close(statement);
            ConnectionFactory.close(connection);
        }
        return list;
    }

    public T findById(int id) {
        String query = createSelectQuery("id");
        try {
            connection = ConnectionFactory.getConnection();
            statement = connection.prepareStatement(query);
            statement.setInt(1, id);
            resultSet = statement.executeQuery();

            return createObjects(resultSet).get(0);
        } catch (SQLException e) {
            LOGGER.log(Level.WARNING, type.getName() + "DAO:findById " + e.getMessage());
        } finally {
            ConnectionFactory.close(resultSet);
            ConnectionFactory.close(statement);
            ConnectionFactory.close(connection);
        }
        return null;
    }

    private List<T> createObjects(ResultSet resultSet) {
        List<T> list = new ArrayList<T>();
        Constructor[] actors = type.getDeclaredConstructors();
        Constructor ctor = null;
        for (int i = 0; i < actors.length; i++) {
            ctor = actors[i];
            if (ctor.getGenericParameterTypes().length == 0)
                break;
        }
        try {
            while (resultSet.next()) {
                ctor.setAccessible(true);
                T instance = (T)ctor.newInstance();
                for (Field field : type.getDeclaredFields()) {
                    String fieldName = field.getName();
                    Object value = resultSet.getObject(fieldName);
                    PropertyDescriptor propertyDescriptor = new PropertyDescriptor(fieldName, type);
                    Method method = propertyDescriptor.getWriteMethod();
                    method.invoke(instance, value);
                }
                list.add(instance);
            }
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (SecurityException e) {
            e.printStackTrace();
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
            Throwable cause = e.getCause();
            if (cause != null) {
                cause.printStackTrace();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (IntrospectionException e) {
            e.printStackTrace();
        }
        return list;
    }

    public void insert(T t) throws IllegalAccessException {
        String table=t.getClass().getSimpleName();
        StringBuilder sb=new StringBuilder();
        sb.append("insert into ").append(table).append(" (");
        Field[] fields =t.getClass().getDeclaredFields();
        int i=0;
        for(Field field:fields){
            field.setAccessible(true);
            sb.append(field.getName());
            if(i<fields.length-1){ sb.append(",");}
            i++;
        }
        sb.append(")").append(" values (");
        for (int j=0;j<fields.length;j++){
            fields[j].setAccessible(true);
            Object val=fields[j].get(t);
            sb.append("'").append(val).append("'");
            if(j<fields.length-1) {sb.append(",");}
        }
        sb.append(")");
        System.out.println(sb.toString());
        try {
            connection = ConnectionFactory.getConnection();
            statement = connection.prepareStatement(sb.toString());
            statement.executeUpdate(sb.toString());
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            ConnectionFactory.close(statement);
            ConnectionFactory.close(connection);
        }
    }

    public void update(T t) throws IllegalAccessException {

        String table=t.getClass().getSimpleName();
        StringBuilder sb=new StringBuilder();
        sb.append("update ").append(table).append(" set ");
        Field[] fields =t.getClass().getDeclaredFields();
        int i=0;
        for(Field field:fields){
            field.setAccessible(true);
            sb.append(field.getName()).append(" ='");
            Object value=fields[i].get(t);
            sb.append(value).append("'");
            if(i<fields.length-1) {sb.append(",");}
            i++;
        }
        sb.append(" where id=");
        Object id=fields[0].get(t);
        sb.append(id).append(";");
        try {
            connection = ConnectionFactory.getConnection();
            statement = connection.prepareStatement(sb.toString());
            System.out.println(sb);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            ConnectionFactory.close(statement);
            ConnectionFactory.close(connection);
        }
    }

    public void delete(T t) throws IllegalAccessException {
        String table=t.getClass().getSimpleName();
        StringBuilder sb=new StringBuilder();
        sb.append("delete from ").append(table).append(" where id= ?");
        Field[] fields =t.getClass().getDeclaredFields();
        fields[0].setAccessible(true);
        Object id=fields[0].get(t);
        try {
            connection = ConnectionFactory.getConnection();
            statement = connection.prepareStatement(String.valueOf(sb));
            statement.setObject(1, id);
            statement.executeUpdate();
        } catch (SQLException e) {
           e.printStackTrace();
        }finally {
            ConnectionFactory.close(statement);
            ConnectionFactory.close(connection);
        }
    }

}
