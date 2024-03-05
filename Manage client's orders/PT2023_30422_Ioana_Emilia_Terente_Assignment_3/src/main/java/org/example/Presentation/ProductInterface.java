package org.example.Presentation;

import org.example.DataAccess.CilentDAO;
import org.example.DataAccess.ProductDAO;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;

public class ProductInterface extends JFrame {
    private ProductDAO productDAO;
    GUI gui=new GUI();
    private JTable table;
    private JButton back;
    private JButton showAll;
    private JButton insert;
    private JButton delete;
    private JScrollPane scrollPane;
    private JLabel idLabel;
    private JTextField idField;
    private JLabel nameLabel;
    private JTextField nameField;
    private JLabel priceLabel;
    private JTextField priceField;
    private JLabel stockLabel;
    private JTextField stockField;

    public ProductInterface(GUI gui, Connection connection) {
        ProductInterface productInterface = this;
        productDAO = new ProductDAO(connection,productInterface);
        this.setTitle("Products");
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
        nameLabel = new JLabel("Name:");
        nameField = new JTextField();
        priceLabel = new JLabel("Price:");
        priceField = new JTextField();
        stockLabel = new JLabel("Stock:");
        stockField = new JTextField();

        inputPanel.add(idLabel);
        inputPanel.add(idField);
        inputPanel.add(nameLabel);
        inputPanel.add(nameField);
        inputPanel.add(priceLabel);
        inputPanel.add(priceField);
        inputPanel.add(stockLabel);
        inputPanel.add(stockField);

        getContentPane().add(inputPanel, BorderLayout.NORTH);
    }
}
