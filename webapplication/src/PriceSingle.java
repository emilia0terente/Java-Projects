import java.sql.*;

public class PriceSingle {
    public String[] main() throws SQLException {
        //final String driver="org.postgresql.Driver";
        String url = "jdbc:postgresql://localhost:5432/webapplication";
        String user = "postgres";
        String password = "12345678";

        Connection connection = DriverManager.getConnection(url,user,password);
        Statement statement = connection.createStatement();

        /*
        String table = "authors";
        String query="SELECT* from authors join authorisbn a on authors.authorid = a.authorid join titles t on a.isbn = t.isbn\n" +
                "where copyright='2001';";

        ResultSet rs= statement.executeQuery(query);
        while(rs.next()){
            System.out.println(rs.getString("firstname"));
        }
        * */

        PreparedStatement titlesQuery;
        titlesQuery=connection.prepareStatement("SELECT isbn, title, editionNumber, "
                + "copyright, publisherID, imageFile, price "
                + "FROM titles ORDER BY title");

        String[] titles= new String[17];
        int index =0;

        String[]prices=new String[17];
        int price1 = 0;

        String[] string =new String[17];
        int index1 =0;

        ResultSet results = titlesQuery.executeQuery();
        while(results.next()){
            BookSingle book=new BookSingle();

            book.setISBN(results.getString("isbn"));
            book.setTitle(results.getString("title"));
            book.setEditionNumber(results.getInt("editionNumber"));
            book.setCopyright(results.getString("copyright"));
            book.setPublisherID(results.getInt("publisherID"));
            book.setImageFile(results.getString("imageFile"));
            book.setPrice(results.getDouble("price"));
            titles[index]=book.getTitle();
            prices[price1]= String.valueOf(book.getPrice());
            string[index1]=price1+".  "+prices[price1];
            index++;
            price1++;
            index1++;

        }

        return string;



    }

}
