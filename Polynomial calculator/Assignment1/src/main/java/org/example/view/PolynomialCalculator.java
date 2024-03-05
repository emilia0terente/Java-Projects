package org.example.view;

import org.example.logic.Operations;
import org.example.model.Polynomial;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PolynomialCalculator {
    JTextField txt1;
    JTextField txt2;
    JLabel l1;
    JLabel l2;
    JLabel l3;
    JLabel l4;

    JButton addition;
    JButton substraction;
    JButton multiplyication;
    JButton integration;
    JButton derivation;
    JTextField txt3;

    public PolynomialCalculator (){
        System.out.println("GUI successfully loaded");
        showGUI();
    }
    public void showGUI(){
        JFrame f=new JFrame("Polynomial Calculator");
        addComponent(f.getContentPane());
        f.setSize(600,400);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setResizable(false);
        f.setVisible(true);
        f.setLocationRelativeTo(null);
    }

    private void define(){
        l1=new JLabel("Fist polynomial : ");
        l2=new JLabel("Second polynomial : ");
        l3=new JLabel("Result of operation :");
        l4=new JLabel("Example of polynomial: +2+2x-3x^4+x^6. (Specify the sign and the degree.)");
        txt1=new JTextField();txt2=new JTextField();
        addition=new JButton("Add");addition.addActionListener(add);
        substraction=new JButton("Subtract");substraction.addActionListener(sub);
        multiplyication=new JButton("Multiply");multiplyication.addActionListener(mul);
        integration=new JButton("Integrate"); integration.addActionListener(integr);
        derivation=new JButton("Derivative");derivation.addActionListener(dev);
        txt3=new JTextField();txt3.setEditable(false);

    }
    private void bounds(){
        l1.setBounds(5,20,130,35);
        l2.setBounds(5,65,130,35);
        txt1.setBounds(140,20,400,35 );
        txt2.setBounds(140,65,400,35);
        addition.setBounds(40,120,70,30);
        substraction.setBounds(135,120,90,30);
        multiplyication.setBounds(250,120,90,30);
        integration.setBounds(365,120,90,30);
        derivation.setBounds(475,120,100,30);
        l3.setBounds(5,180,130,35);
        txt3.setBounds(140,180,300,40);
        l4.setBounds(5,250,595,200);
    }
    private void addComponent(Container p){
        p.setLayout(null);
        define();
        p.add(addition);p.add(substraction);p.add(multiplyication);p.add(integration);p.add(derivation);
        p.add(l1);p.add(l2);p.add(l3);p.add(l4);
        p.add(txt1);p.add(txt2);p.add(txt3);
        bounds();
    }
    ActionListener add=new ActionListener() {
        final Operations op = new Operations();

        @Override
        public void actionPerformed(ActionEvent e) {
            String p1 = txt1.getText();
            String p2 = txt2.getText();
            Polynomial polynomial1=new Polynomial();
            Polynomial.fromString(p1,polynomial1);
            Polynomial polynomial2=new Polynomial();
            Polynomial.fromString(p2,polynomial2);
            Polynomial result=op.add(polynomial1,polynomial2);
            txt3.setText(result.hashToString());
        }
    };
    ActionListener sub=new ActionListener() {
        final Operations op=new Operations();
        @Override
        public void actionPerformed(ActionEvent e) {
            String p1 = txt1.getText();
            String p2 = txt2.getText();
            Polynomial polynomial1=new Polynomial();
            Polynomial.fromString(p1,polynomial1);
            Polynomial polynomial2=new Polynomial();
            Polynomial.fromString(p2,polynomial2);
            Polynomial result=op.substraction(polynomial1,polynomial2);
            txt3.setText(result.hashToString());
        }
    };

    ActionListener mul=new ActionListener() {
        final Operations op=new Operations();
        @Override
        public void actionPerformed(ActionEvent e) {
            String p1 = txt1.getText();
            String p2 = txt2.getText();
            Polynomial polynomial1=new Polynomial();
            Polynomial.fromString(p1,polynomial1);
            Polynomial polynomial2=new Polynomial();
            Polynomial.fromString(p2,polynomial2);
            Polynomial result=op.multiply(polynomial1,polynomial2);
            txt3.setText(result.hashToString());
        }
    };
    ActionListener integr=new ActionListener() {
        final Operations op=new Operations();
        @Override
        public void actionPerformed(ActionEvent e) {
            String p1 = txt1.getText();
            Polynomial polynomial1=new Polynomial();
            Polynomial.fromString(p1,polynomial1);
            Polynomial result=op.integrate(polynomial1);
            txt3.setText(result.hashToString());
        }
    };
    ActionListener dev=new ActionListener() {
        final Operations op=new Operations();
        @Override
        public void actionPerformed(ActionEvent e) {
            String p1 = txt1.getText();
            Polynomial polynomial1=new Polynomial();
            Polynomial.fromString(p1,polynomial1);
            Polynomial result=op.derivate(polynomial1);
            txt3.setText(result.hashToString());
        }
    };
}

