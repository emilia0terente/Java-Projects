package org.example.GUI;

import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class SimulationFrame {
    JTextField txt1, txt2, txt3, txt4, txt5, txt6, txt7;
    JLabel l1, l2, l3, l4, l5;
    JButton simulation;

    JTextArea logsArea;
    JLabel logsLabel;

    JScrollPane scrollArea;
    JFrame f;

    public SimulationFrame(){
        System.out.println("GUI successfully loaded");
        showSimulationFrame();
    }
    public void showSimulationFrame(){
        f=new JFrame("Queues management");
        addComponent(f.getContentPane());
        f.setSize(750,550);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setResizable(false);
        f.setVisible(true);
        f.setLocationRelativeTo(null);
    }

    private void define(){
        l1=new JLabel("N = ");
        l2=new JLabel("Q = ");
        l3=new JLabel("MAX simulation time :");
        l4=new JLabel("MIN/MAX arrival time :");
        l5=new JLabel("MIN/MAX service time :");
        txt1=new JTextField();
        txt2=new JTextField();
        txt3=new JTextField();
        txt4=new JTextField();
        txt5=new JTextField();
        txt6=new JTextField();
        txt7=new JTextField();
        simulation=new JButton("Start simulation");
        logsArea=new JTextArea();
        logsArea.setEditable(false);
        logsArea.setText("");
        logsLabel=new JLabel("Logs :");
        //logsScroll=new JScrollBar();
        scrollArea=new JScrollPane(logsArea);
        scrollArea.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        //logsScroll.setViewportView(logsArea);
        //logsScroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);


    }
    private void bounds(){
        l1.setBounds(5,20,80,35);
        l2.setBounds(5,65,80,35);
        txt1.setBounds(50,20,70,35 );
        txt2.setBounds(50,65,70,35);
        l3.setBounds(5,110,130,35);
        txt3.setBounds(140,110,70,35 );
        l4.setBounds(5,155,130,35);
        txt4.setBounds(140,155,70,35 );
        txt5.setBounds(225,155,70,35 );
        l5.setBounds(5,200,130,35);
        txt6.setBounds(140,200,70,35 );
        txt7.setBounds(225,200,70,35 );
        simulation.setBounds(50,260, 130,35);
//        logsArea.setBounds(400,50,300,400);
//        logsArea.setBounds(400,50,300,400);
        logsLabel.setBounds(450,10,70,35);
       // logsScroll.setBounds(700,50,10,400);
        scrollArea.setBounds(400, 50, 300, 400);

        //txt3.setBounds(140,180,300,40);
        //l4.setBounds(5,250,595,200);
    }
    private void addComponent(Container p) {
        p.setLayout(null);
        define();
        p.add(simulation);
        p.add(l1);
        p.add(l2);
        p.add(l3);
        p.add(l4);
        p.add(l5);
        p.add(txt1);
        p.add(txt2);
        p.add(txt3);
        p.add(txt4);
        p.add(txt5);
        p.add(txt6);
        p.add(txt7);
//        //p.add(logsArea);
//        p.add(logsLabel);
//        //p.add(logsScroll);
//        f.getContentPane().add(scrollArea);

        p.add(logsLabel);
        p.add(scrollArea); // Add the scrollArea to the container
        bounds();
    }

    //writes in output.txt
    public void writeInFile(String text){
        File out=new File("output.txt");
        try{
            FileWriter fileWriter = new FileWriter(out,true);
            fileWriter.write(text);
            fileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void updateLogs(String update){
        logsArea.append((update+"\n"));
        writeInFile(update+"\n");
    }

    public JTextField getTxt1() {
        return txt1;
    }

    public void setTxt1(JTextField txt1) {
        this.txt1 = txt1;
    }

    public JTextField getTxt2() {
        return txt2;
    }

    public void setTxt2(JTextField txt2) {
        this.txt2 = txt2;
    }

    public JTextField getTxt3() {
        return txt3;
    }

    public void setTxt3(JTextField txt3) {
        this.txt3 = txt3;
    }

    public JTextField getTxt4() {
        return txt4;
    }

    public void setTxt4(JTextField txt4) {
        this.txt4 = txt4;
    }

    public JTextField getTxt5() {
        return txt5;
    }

    public void setTxt5(JTextField txt5) {
        this.txt5 = txt5;
    }

    public JTextField getTxt6() {
        return txt6;
    }

    public void setTxt6(JTextField txt6) {
        this.txt6 = txt6;
    }

    public JTextField getTxt7() {
        return txt7;
    }

    public void setTxt7(JTextField txt7) {
        this.txt7 = txt7;
    }

    public JLabel getL1() {
        return l1;
    }

    public void setL1(JLabel l1) {
        this.l1 = l1;
    }

    public JLabel getL2() {
        return l2;
    }

    public void setL2(JLabel l2) {
        this.l2 = l2;
    }

    public JLabel getL3() {
        return l3;
    }

    public void setL3(JLabel l3) {
        this.l3 = l3;
    }

    public JLabel getL4() {
        return l4;
    }

    public void setL4(JLabel l4) {
        this.l4 = l4;
    }

    public JLabel getL5() {
        return l5;
    }

    public void setL5(JLabel l5) {
        this.l5 = l5;
    }

    public JButton getSimulation() {
        return simulation;
    }

    public void setSimulation(JButton simulation) {
        this.simulation = simulation;
    }

    public JTextArea getLogsArea() {
        return logsArea;
    }

    public void setLogsArea(JTextArea logsArea) {
        this.logsArea = logsArea;
    }

    public JLabel getLogsLabel() {
        return logsLabel;
    }

    public void setLogsLabel(JLabel logsLabel) {
        this.logsLabel = logsLabel;
    }

}
