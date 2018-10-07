/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
//package volumestorage;
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
/**
 *
 * @author LinhMac
 */
public class VolumeStorage {

    /**
     * @param args the command line arguments
     */
    JFrame f;
    JPanel mainpanel, p1,p2,p3;
    JTextField tf1, tf2, tf3, tf4,tf5;
    JTextArea textArea1, textArea2, textArea3;
    JButton bt1,bt2,bt3;
    JLabel lb1,lb2,lb3,lb4,lb5,lb6;
    JScrollPane jScrollPane1, jScrollPane2, jScrollPane3;
     int count1 =0, count2=0;
     double volume1=0, volume2=0, sum1=0, sum2=0, sum3=0;
     double l=0, w=0;
     double h1=0, h2=0;

     
     public VolumeStorage()
    {
        GUI();
    }
    
     public void GUI()
    {
        f = new JFrame("Volume Storage");
        f.setSize(720,620);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
       mainpanel = new JPanel(); 
       mainpanel.setBorder(BorderFactory.createLineBorder(Color.black));
       mainpanel.setLayout(new BoxLayout(mainpanel, BoxLayout.Y_AXIS));
       p1 = new JPanel();
       p1.setBorder(BorderFactory.createLineBorder(Color.black));
       p1.setPreferredSize(new Dimension(700, 210));
       

       p2 = new JPanel();
       p2.setBorder(BorderFactory.createLineBorder(Color.black));
       p2.setPreferredSize(new Dimension(700, 210));
       
        lb1 = new JLabel("Width: ");
        tf1 = new JTextField(10);
        lb2 = new JLabel("Length: ");
        tf2 = new JTextField(10);
        lb3 = new JLabel("Height: ");
        tf3 = new JTextField(10);
        bt1 = new JButton("Calculate Box");
        
        textArea1 = new JTextArea();
        textArea1.setColumns(30);
        textArea1.setLineWrap(true);
        textArea1.setRows(10);
        textArea1.setWrapStyleWord(false);
        textArea1.setEditable(false);
        jScrollPane1 = new JScrollPane(textArea1);
        
        p1.add(lb1);
        p1.add(tf1);
        p1.add(lb2);
        p1.add(tf2);
        p1.add(lb3);
        p1.add(tf3);
        p1.add(bt1);
        p1.add(jScrollPane1);
        
        
        lb4 = new JLabel("Radius ");
        tf4 = new JTextField(10);
        lb5 = new JLabel("Height: ");
        tf5 = new JTextField(10);
        bt2 = new JButton("Calculate Cylinder");
        textArea2 = new JTextArea();
        textArea2.setColumns(30);
        textArea2.setLineWrap(true);
        textArea2.setRows(10);
        textArea2.setWrapStyleWord(true);
        textArea2.setEditable(false);
        jScrollPane2 = new JScrollPane(textArea2);
        
        p2.add(lb4);
        p2.add(tf4);
        p2.add(lb5);
        p2.add(tf5);
        p2.add(bt2);
        p2.add(jScrollPane2);
        
        mainpanel.add(p1);
        mainpanel.add(p2);
        p3 = new JPanel();
        
        lb6 = new JLabel("Total Volume: ");
        textArea3 = new JTextArea();
        textArea3.setColumns(30);
        textArea3.setLineWrap(true);
        textArea3.setRows(7);
        textArea3.setWrapStyleWord(true);
        textArea3.setEditable(false);
        jScrollPane3 = new JScrollPane(textArea3);
        bt3 = new JButton("Clear All");
        p3.add(lb6);
        p3.add(jScrollPane3);
        p3.add(bt3);
        mainpanel.add(p3);
        
        bt1.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent ae){
                String textFieldValue1 = tf1.getText();
                double width = Double.parseDouble(textFieldValue1);
                String textFieldValue2 = tf2.getText();
                double length = Double.parseDouble(textFieldValue2);
                String textFieldValue3 = tf3.getText();
                double height = Double.parseDouble(textFieldValue3);
                volume1 = width*length*height;
                sum1=sum1+volume1;
                sum3=sum1+sum2;
                textArea1.append("You entered: \n");
                textArea1.append("Width: "+width+"\n");
                textArea1.append("Length: "+length+"\n");
                textArea1.append("Height: "+height+"\n");
                textArea1.append("The volume is: "+volume1+"\n");
                textArea1.append("Total boxes's volume is: "+sum1+"\n");
                textArea1.append("\n");
                textArea3.append("Volumes: \n");
                textArea3.append("Box Volume: "+volume1+"\n");
                textArea3.append("Total Boxes' Volumes: "+sum1+"\n");
                textArea3.append("Cylinder Volume: "+volume2+"\n");
                textArea3.append("Total Cylinders' Volumes: "+sum2+"\n");
                textArea3.append("Total Volume: "+sum3+"\n");
                textArea3.append("\n");
            }});
        bt2.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent ae){
                String textFieldValue4 = tf4.getText();
                double radius = Double.parseDouble(textFieldValue4);
                String textFieldValue5 = tf5.getText();
                double height = Double.parseDouble(textFieldValue5);
               
                volume2 = Math.pow(radius, 2)*height*Math.PI;
                sum2=sum2+volume2;
                sum3=sum1+sum2;
                textArea2.append("You entered: \n");
                textArea2.append("Radius: "+radius+"\n");
                textArea2.append("Height: "+height+"\n");
                textArea2.append("The volume is: "+volume2+"\n");
                textArea2.append("Total boxes's volume is: "+sum2+"\n");
                textArea2.append("\n");
                textArea3.append("Volumes: \n");
                textArea3.append("Box Volume: "+volume1+"\n");
                textArea3.append("Total Boxes' Volumes: "+sum1+"\n");
                textArea3.append("Cylinder Volume: "+volume2+"\n");
                textArea3.append("Total Cylinders' Volumes: "+sum2+"\n");
                textArea3.append("Total Volume: "+sum3+"\n");
                textArea3.append("\n");
            }});
        
        
        bt3.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent ae){
                tf1.setText(null);
                tf2.setText(null);
                tf3.setText(null);
                tf4.setText(null);
                tf5.setText(null);
                textArea1.setText(null);
                textArea2.setText(null);
                textArea3.setText(null);
                sum1=0;
                sum2=0;
                sum3=0;
            }});
        f.add(mainpanel);
        f.setResizable(false);
        f.setVisible(true);
    }
     
  
    public static void main(String[] args) {
        // TODO code application logic here
        new VolumeStorage();
    }
    
}
