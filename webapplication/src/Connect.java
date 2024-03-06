import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Connect {
    Connection connection;
    Statement statement;
    Connect() throws SQLException {
        //final String driver="org.postgresql.Driver";
        String url = "jdbc:postgresql://localhost:5432/webapplication";
        String user = "postgres";
        String password = "12345678";

        connection = DriverManager.getConnection(url, user, password);
        statement = connection.createStatement();
    }
}
