package org.example.Presentation;

import javax.swing.*;
import java.awt.event.ActionListener;

public class GUI extends JFrame {
    private JLabel title;

    private JButton clientButton;
    private JButton productButton;
    private JButton orderButton;
    public GUI(){
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setBounds(100,100,350,400);
        this.getContentPane().setLayout(null);
        this.setTitle("Database Management");

        clientButton = new JButton("Client");
        clientButton.setBounds((getWidth() - 100) / 2, (getHeight() - 30) / 2 - 50, 100, 30);

        productButton = new JButton("Product");
        productButton.setBounds((getWidth() - 100) / 2, (getHeight() - 30) / 2, 100, 30);

        orderButton = new JButton("Order");
        orderButton.setBounds((getWidth() - 100) / 2, (getHeight() - 30) / 2 + 50, 100, 30);

        getContentPane().add(clientButton);
        getContentPane().add(productButton);
        getContentPane().add(orderButton);
    }
    public void clientButtonAddActionListener(ActionListener actionListener){
        clientButton.addActionListener(actionListener);
    }
    public void productButtonAddActionListener(ActionListener actionListener){
        productButton.addActionListener(actionListener);
    }
    public void orderButtonAddActionListener(ActionListener actionListener){
        orderButton.addActionListener(actionListener);
    }

}
