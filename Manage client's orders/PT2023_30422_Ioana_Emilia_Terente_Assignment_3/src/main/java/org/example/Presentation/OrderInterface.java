package org.example.Presentation;

import org.example.DataAccess.OrderDAO;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;

public class OrderInterface extends JFrame {
    private OrderDAO orderDAO;
    GUI gui=new GUI();
    private JTable table;
    private JButton back;
    private JButton showAll;
    private JButton insert;
    private JButton delete;
    private JScrollPane scrollPane;
    private JLabel idLabel;
    private JTextField idField;
    private JLabel clientIDLabel;
    private JTextField clientIDField;
    private JLabel productIDLabel;
    private JTextField productIDField;
    private JLabel quantityLabel;
    private JTextField quantityField;

    public OrderInterface(GUI gui, Connection connection) {
        OrderInterface orderInterface = this;
        orderDAO = new OrderDAO(connection,orderInterface);
        this.setTitle("Orders");
        this.setSize(500, 600);
        this.setLocationRelativeTo(null);

        // createTable();
        scrollPane = new JScrollPane(table);
        getContentPane().add(scrollPane, BorderLayout.CENTER);
        south();
        north();
    }
    public void south(){
        JPanel buttonPanel = new JPanel(new FlowLayout());
        back = new JButton("Back");
        showAll = new JButton("Show All");
        insert = new JButton("Insert");
        delete = new JButton("Delete");

        back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                gui.setVisible(true);
            }
        });

        buttonPanel.add(back);
        buttonPanel.add(showAll);
        buttonPanel.add(insert);
        buttonPanel.add(delete);
        getContentPane().add(buttonPanel, BorderLayout.SOUTH);
    }
    public void north(){
        JPanel inputPanel = new JPanel(new GridLayout(4, 2));
        idLabel = new JLabel("ID:");
        idField = new JTextField();
        clientIDLabel = new JLabel("Client ID:");
        clientIDField = new JTextField();
        productIDLabel = new JLabel("Product ID:");
        productIDField = new JTextField();
        quantityLabel = new JLabel("Quantity:");
        quantityField = new JTextField();

        inputPanel.add(idLabel);
        inputPanel.add(idField);
        inputPanel.add(clientIDLabel);
        inputPanel.add(clientIDField);
        inputPanel.add(productIDLabel);
        inputPanel.add(productIDField);
        inputPanel.add(quantityLabel);
        inputPanel.add(quantityField);

        getContentPane().add(inputPanel, BorderLayout.NORTH);
    }
}
