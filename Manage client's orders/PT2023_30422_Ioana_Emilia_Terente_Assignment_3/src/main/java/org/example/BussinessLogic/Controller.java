package org.example.BussinessLogic;

import org.example.Connection.ConnectionFactory;
import org.example.Presentation.ClientInterface;
import org.example.Presentation.GUI;
import org.example.Presentation.OrderInterface;
import org.example.Presentation.ProductInterface;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;

public class Controller {
    private GUI gui;
    private ClientInterface clientInterface;
    private ProductInterface productInterface;
    private OrderInterface orderInterface;
    public void start(){
        Connection connection= ConnectionFactory.getConnection();
        gui=new GUI();
        gui.setVisible(true);
        clientInterface=new ClientInterface(gui,connection);
        productInterface=new ProductInterface(gui,connection);
        orderInterface=new OrderInterface(gui,connection);
        initializeButtons();
    }
    public void initializeButtons(){
        gui.clientButtonAddActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                gui.setVisible(false);
                clientInterface.setVisible(true);
            }
        });

        gui.productButtonAddActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                gui.setVisible(false);
                productInterface.setVisible(true);
            }
        });

        gui.orderButtonAddActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                gui.setVisible(false);
                orderInterface.setVisible(true);
            }
        });
    }
}
