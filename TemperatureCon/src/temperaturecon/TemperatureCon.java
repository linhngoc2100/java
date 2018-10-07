/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package temperaturecon;
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.util.*;
/**
/**
 *
 * @author tomng
 */
public class TemperatureCon {

    /**
     * @param args the command line arguments
     */
    JFrame f;
    JPanel p;
    JTextField tf1;   
    JLabel lb1,lb2;
    JScrollPane jScrollPane1;
    double tmC=0;
    
    public TemperatureCon(){
        GUI();
    }
    
    public void GUI(){
        f = new JFrame("Average Family Size");
        p = new JPanel();
         Font font1 = new Font("SansSerif", Font.BOLD, 25);
        p.setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        c.gridx = 0;
        c.gridy = 0;
        f.setSize(680,480);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        tf1 = new JTextField(10);
       
        lb1 = new JLabel("Please Enter the Temperature: "); 
     
        lb2 = new JLabel("0");
        tf1.setFont(font1);
        lb1.setFont(font1);
        lb2.setFont(font1);
        tf1.addActionListener(new ActionListener() {
                @Override
                    public void actionPerformed(ActionEvent event) {
                        String temp=tf1.getText();
                        double tmF = Double.parseDouble(temp);
                        System.out.println(tmF);
                        tmC =((5.0/9.0)*(tmF-32));
                           System.out.println(tmC);
                        lb2.setText(String.valueOf(tmC));
                }
            });
        p.add(lb1, c);
        c.gridx = 1;
        c.gridy = 0;
        p.add(tf1, c);
        c.gridx = 0;
        c.gridy = 1;
        p.add(lb2, c);
        c.gridx = 1;
        c.gridy = 1;
        
        f.add(p);
       
       // f.add(p);
        f.setVisible(true);
        
    }
    public static void main(String[] args) {
        // TODO code application logic here
        new TemperatureCon();
    }
    
}
