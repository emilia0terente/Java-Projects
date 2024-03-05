package org.example.Presentation;

import org.example.DataAccess.CilentDAO;
import org.example.model.Client;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.reflect.Field;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.sql.Connection;

public class ClientInterface extends JFrame {
    //insert, add, edit, delete, update, show all button
    private CilentDAO clientDAO;
    GUI gui = new GUI();
    private JTable table;
    private JButton back;
    private JButton showAll;
    private JButton insert;
    private JButton delete;
    JScrollPane scrollPane;
    private JLabel idLabel;
    private JTextField idField;
    private JLabel nameLabel;
    private JTextField nameField;
    private JLabel phoneNrLabel;
    private JTextField phoneNrField;
    private JLabel emailLabel;
    private JTextField emailField;

    //private JButton update;
    public ClientInterface(GUI gui, Connection connection) {
        ClientInterface clientInterface = this;
        clientDAO = new CilentDAO(connection, this);
        this.setTitle("Clients");
        this.setSize(500, 600);
        this.setLocationRelativeTo(null);

        scrollPane = new JScrollPane(table);
        getContentPane().add(scrollPane, BorderLayout.CENTER);
        north();
        south();
    }

    public void south() {
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
        showAll.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                clientDAO.viewAll();
            }
        });
        insert.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });

        buttonPanel.add(back);
        buttonPanel.add(showAll);
        buttonPanel.add(insert);
        buttonPanel.add(delete);
        getContentPane().add(buttonPanel, BorderLayout.SOUTH);

    }

    public void north() {
        JPanel inputPanel = new JPanel(new GridLayout(4, 2));
        idLabel = new JLabel("ID:");
        idField = new JTextField();
        nameLabel = new JLabel("Name:");
        nameField = new JTextField();
        phoneNrLabel = new JLabel("Phone Number:");
        phoneNrField = new JTextField();
        emailLabel = new JLabel("Email:");
        emailField = new JTextField();

        inputPanel.add(idLabel);
        inputPanel.add(idField);
        inputPanel.add(nameLabel);
        inputPanel.add(nameField);
        inputPanel.add(phoneNrLabel);
        inputPanel.add(phoneNrField);
        inputPanel.add(emailLabel);
        inputPanel.add(emailField);
        getContentPane().add(inputPanel, BorderLayout.NORTH);
    }
}