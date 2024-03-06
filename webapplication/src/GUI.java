import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;


// A GUI program is written as a subclass of Frame - the top-level container
// This subclass inherits all properties from Frame, e.g., title, icon, buttons, content-pane

public class GUI{

    public static void main(String args[]) {

        JFrame frame4=new JFrame("BookShop Login");
            frame4.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame4.setBounds(450, 190, 1014, 597);
            frame4.setResizable(false);
            JPanel contentPane = new JPanel();
            frame4.setContentPane(contentPane);
            contentPane.setLayout(null);

            JLabel lblNewLabel = new JLabel("Login");
            lblNewLabel.setForeground(Color.BLACK);
            lblNewLabel.setFont(new Font("Times New Roman", Font.PLAIN, 46));
            lblNewLabel.setBounds(423, 13, 273, 93);
            contentPane.add(lblNewLabel);

            JTextField textField = new JTextField();
            textField.setFont(new Font("Tahoma", Font.PLAIN, 32));
            textField.setBounds(481, 170, 281, 68);
            contentPane.add(textField);
            textField.setColumns(10);

            JPasswordField passwordField = new JPasswordField();
            passwordField.setFont(new Font("Tahoma", Font.PLAIN, 32));
            passwordField.setBounds(481, 286, 281, 68);
            contentPane.add(passwordField);

            JLabel lblUsername = new JLabel("Username");
            lblUsername.setBackground(Color.BLACK);
            lblUsername.setForeground(Color.BLACK);
            lblUsername.setFont(new Font("Tahoma", Font.PLAIN, 31));
            lblUsername.setBounds(250, 166, 193, 52);
            contentPane.add(lblUsername);

            JLabel lblPassword = new JLabel("Password");
            lblPassword.setForeground(Color.BLACK);
            lblPassword.setBackground(Color.CYAN);
            lblPassword.setFont(new Font("Tahoma", Font.PLAIN, 31));
            lblPassword.setBounds(250, 286, 193, 52);
            contentPane.add(lblPassword);

            JButton btnNewButton = new JButton("Login");
            btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 26));
            btnNewButton.setBounds(545, 392, 162, 73);
            contentPane.add(btnNewButton);

            JLabel label4 = new JLabel("");
            label4.setBounds(0, 0, 1008, 562);
            contentPane.add(label4);

        frame4.setVisible(true);

            btnNewButton.addActionListener(new ActionListener() {

                public void actionPerformed(ActionEvent e) {
                    String userName = textField.getText();
                    String password = passwordField.getText();
                    try {
                        String url = "jdbc:postgresql://localhost:5432/webapplication";
                        String user = "postgres";
                        String password1 = "12345678";

                        Connection connection = DriverManager.getConnection(url,user,password1);
                        PreparedStatement st = connection.prepareStatement("Select name, password from student where name=? and password=? ");

                        st.setString(1, userName);
                        st.setString(2, password);
                        ResultSet rs = st.executeQuery();
                        if (rs.next()) {
                            frame4.dispose();
                            JOptionPane.showMessageDialog(btnNewButton, "You have successfully logged in");

                            JFrame frame = new JFrame("Book Shop");
                            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                            frame.setSize(800,500);


                            //Creating the panel at bottom and adding components
                            JPanel panel = new JPanel(); // the panel is not visible in output
                            //JLabel label = new JLabel("Enter Text");
                            //JTextField tf = new JTextField(); // accepts upto 20 characters
                            JButton yes = new JButton("YES");
                            JButton no = new JButton("NO");
                            //panel.add(label); // Components Added using Flow Layout
                            // panel.add(tf);
                            panel.add(yes);
                            panel.add(no);


                            //color of the panel
                            Color c1 = new Color(154, 71, 71);//using RGB
                            panel.setBackground(c1);

                            ImageIcon image =new ImageIcon("webapplication/image.jpg");
                            Image i=image.getImage();
                            Image temp=i.getScaledInstance(800,500,Image.SCALE_DEFAULT);
                            image=new ImageIcon(temp);
                            JLabel back=new JLabel(image);
                            back.setLayout(null);



                            //Adding Components to the frame.
                            frame.getContentPane().add(BorderLayout.SOUTH, panel);
                            //frame.getContentPane().add(BorderLayout.CENTER, l1);
                            frame.getContentPane().add(BorderLayout.CENTER, back);
                            frame.pack();
                            frame.setVisible(true);

                            no.addActionListener(new ActionListener() {
                                public void actionPerformed(ActionEvent e) {
                                    JLabel l = new JLabel("Ok! Have a nice day!");
                                    l.setFont(new Font("Monaco",Font.PLAIN,20));
                                    l.setBackground(Color.white);
                                    JFrame frame2 = new JFrame("Book Shop");
                                    frame2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                                    frame2.setSize(386,500);
                                    frame2.add(l);


                                    ImageIcon image =new ImageIcon("webapplication/goodbye.jpg");
                                    Image i=image.getImage();
                                    Image temp=i.getScaledInstance(386,500,Image.SCALE_DEFAULT);
                                    image=new ImageIcon(temp);
                                    JLabel back=new JLabel(image);
                                    back.setLayout(null);

                                    JPanel p1=new JPanel();
                                    p1.add(l);
                                    p1.setSize(30,30);

                                    frame2.getContentPane().add(BorderLayout.CENTER, back);
                                    frame2.setVisible(true);
                                    Timer timer = new Timer(5000, new ActionListener(){
                                        public void actionPerformed(ActionEvent evt) {
                                            frame2.dispose();
                                            frame2.setVisible(false);
                                            frame.dispose();
                                            frame.setVisible(false);
                                        }
                                    });
                                    timer.setRepeats(false);
                                    timer.start();
                                    //frame1.pack();
                                }
                            });

                            yes.addActionListener(new ActionListener() {
                                public void actionPerformed(ActionEvent e) {
                                    JLabel l = new JLabel("Let's place an order! " +
                                            "\r\n" + " Which book would you like to add to your cart?");
                                    l.setBounds(400, 80, 1000, 50);
                                    l.setFont(new Font("Monaco", Font.PLAIN, 15));
                                    Color c3 = new Color(154, 71, 71);
                                    l.setForeground(Color.BLACK);
                                    JFrame frame1 = new JFrame("Book Shop");
                                    frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                                    frame1.setSize(800, 500);
                                    frame1.add(l);


                                    JPanel p1 = new JPanel();
                                    p1.add(l);
                                    p1.setSize(30, 30);
                                    p1.setBackground(c3);

                                    TitleSingle title = new TitleSingle();
                                    //PriceSingle price=new PriceSingle();

                                    String[] titles;
                                    //String[]prices;

                                    try {
                                        titles=title.main();
                                        Connect connect=new Connect();
                                        connect.statement.executeUpdate("delete from cart where cart.title in(select title from cart);");//empty the cart when run program
                                    } catch (SQLException ex) {
                                        throw new RuntimeException(ex);
                                    }
                                    JComboBox<String> t = new JComboBox<>(titles);

                                    JButton addToCart = new JButton("ADD TO CART");
                                    JButton viewCart = new JButton("VIEW CART");
                                    p1.add(t);
                                    p1.add(addToCart);

                                    frame1.getContentPane().add(BorderLayout.CENTER, p1);
                                    frame1.getContentPane().add(BorderLayout.SOUTH, viewCart);
                                    frame1.setVisible(true);
                                    //frame1.pack();

                                    String[] books=new String[17];
                                    addToCart.addActionListener(new ActionListener() {
                                        public void actionPerformed(ActionEvent e) {
                                            JFrame message = new JFrame("INFO");
                                            JOptionPane.showMessageDialog(message,"Item succsessfully added to cart!");
                                            //String[] books=new String[17];
                                            int price=0;
                                            int index=0;

                                            books[index]=(String)t.getSelectedItem();
                                            index++;


                                            //BookSingle b=new BookSingle();
                                            //b.main()=books;
                                            // String table = "titles";
                                            for(int i=0;i<index;i++) {
                                                String query1 = "SELECT price from titles where title='" + books[i] + "'";
                                                String query2 = "INSERT into cart values ('"+books[i]+"')";


                                                try {
                                                    Connect connect = new Connect();
                                                    connect.statement.executeUpdate(query2);
                                                    // String query="INSERT INTO cart values('"+books+"')";
                                                    ResultSet rs = connect.statement.executeQuery(query1);
                                                    while(rs.next()){
                                                        price+=rs.getInt("price");
                                                    }
                                                    // JOptionPane.showMessageDialog(null, "Ready for the next book?");
                                                    //setVisible(false);


                                                } catch (SQLException ex) {
                                                    throw new RuntimeException(ex);
                                                }
                                            }


                                        }
                                    });

                                    viewCart.addActionListener(new ActionListener() {
                                        @Override
                                        public void actionPerformed(ActionEvent e) {
                                            JFrame frame3=new JFrame("CART");
                                            frame3.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                                            frame3.setSize(800,600);

                                            JLabel l3 = new JLabel("Here is your order: ");
                                            l3.setBounds(400, 80, 1000, 50);
                                            l3.setFont(new Font("Monaco", Font.PLAIN, 20));

                                            JLabel l4 =new JLabel();
                                            String bookss = " ";
                                            float price =  0;
                                            float priceT=0;

                                            try{
                                                String query= "SELECT title from cart";
                                                Connect connect=new Connect();
                                                ResultSet rs= connect.statement.executeQuery(query);
                                                //ResultSet rs1= connect.statement.executeQuery(queryp);
                                                while(rs.next()){
                                                    bookss+=rs.getString("title")+"   ";
                                                }

                                                // rs=connect.statement.executeQuery();
                                            } catch (Exception ex) {
                                                throw new RuntimeException(ex);
                                            }
                                            //Connect connect= null;
                                            // for (int i = 0; i < books.length; i++) {
                                            try {
                                                Connect connect = new Connect();
                                                String  queryp = "select sum(price) as price from titles where titles.title in(SELECT title from cart);";
                                                ResultSet rs1 = connect.statement.executeQuery(queryp);
                                                //}
                                                //JOptionPane.showMessageDialog(null, queryp);
                                                while (rs1.next()) {
                                                    price += rs1.getDouble("price");
                                                }


                                            } catch(SQLException ex){
                                                throw new RuntimeException(ex);
                                            }


                                            l4.setText(bookss+" : "+price+".");

                                            //JLabel l5 =new JLabel();
                                            //l5.setText("The total price of the cart is: "+priceT+".");
                                            JPanel p3 = new JPanel();
                                            JButton placeOrder = new JButton("PLACE ORDER");

                                            //l5.add(placeOrder);
                                            p3.add(l3);
                                            p3.add(l4);
                                            //p3.add(l5);
                                            p3.setSize(30, 30);
                                            p3.setBackground(c3);

                                            frame3.getContentPane().add(BorderLayout.CENTER, p3);
                                            frame3.getContentPane().add(BorderLayout.SOUTH, placeOrder);
                                            frame3.setVisible(true);


                                            placeOrder.addActionListener(new ActionListener() {
                                                @Override
                                                public void actionPerformed(ActionEvent e) {
                                                    JOptionPane.showMessageDialog(null, "Your order was placed!");
                                                    frame3.dispose();
                                                    frame3.setVisible(false);
                                                    frame1.dispose();
                                                    frame1.setVisible(false);
                                                    frame.dispose();
                                                    frame.setVisible(false);
                                                    //JOptionPane.showMessageDialog(null, "Your order was placed!");

                                                }
                                            });


                                        }
                                    });


                                }
                            });
                        } else {
                            JOptionPane.showMessageDialog(btnNewButton, "Wrong Username & Password");
                        }
                    } catch (SQLException sqlException) {
                        sqlException.printStackTrace();
                    }



                        }
                    });
                }

    }
