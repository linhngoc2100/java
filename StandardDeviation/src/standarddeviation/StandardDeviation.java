/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package standarddeviation;
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.io.*;
import java.util.*;
/**
 *
 * @author tomng
 */
public class StandardDeviation {

    JFrame f;
    JPanel p;
    JTextField tf1;
    JTextArea textArea;
    JButton bt1,bt2;
    JLabel lb1;
    JScrollPane jScrollPane1;
     int sum=0, count =0;
     int sizeOfStack=0;
     double aveFS =0, aveSD=0;
     double sde=0, sum2=0,sum3=0, sum4=0;
    
    public StandardDeviation()
    {
        GUI();
    }
    
    public void GUI()
    {
        f = new JFrame("Average Family Size");
       
        f.setSize(600,480);
        //f.setLayout(new FlowLayout());
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        p = new JPanel();
        tf1 = new JTextField(10);
        textArea = new JTextArea();
        textArea.setColumns(30);
        textArea.setLineWrap(true);
        textArea.setRows(10);
        textArea.setWrapStyleWord(true);
        textArea.setEditable(false);
        jScrollPane1 = new JScrollPane(textArea);
        bt1 = new JButton("Calculate");
        bt2 = new JButton("Clear All");
       Stack<Integer> stack = new Stack<Integer>();
        bt1.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent ae){
                count ++;
                if(tf1.getText().trim().isEmpty())
                {
                    JOptionPane.showMessageDialog(f,
                    "Family size cannot be empty.",
                    "Inane error",
                    JOptionPane.ERROR_MESSAGE);
                }else{
                String textFieldValue = tf1.getText();
                
                int value = Integer.parseInt(textFieldValue);
                if(value>0){
                    stack.push(value);
                    sizeOfStack=stack.size();
                    System.out.println("Size of Stack :"+sizeOfStack);
                System.out.println("Family number: "+count);
                System.out.println("Size: "+value);
                sum=sum+value;
                System.out.println("Total Size: "+ sum);
                aveFS = (double)sum/count;
                
                System.out.println("AVE: "+ aveFS);
                textArea.append("Family number: "+count+"\n");
                textArea.append("Size: "+value+"\n");
                textArea.append("Total Family number: "+count+"\n");
                textArea.append("Total Size: "+sum+"\n");
                textArea.append("New Average Family Size: "+aveFS+"\n");
                textArea.append("New Average Size: "+aveSD+"\n");
                textArea.append("New Average Size1: "+sum4+"\n");
            }
                else
                {
                    JOptionPane.showMessageDialog(f,
                    "Family size must be greater than 0.",
                    "Inane error",
                    JOptionPane.ERROR_MESSAGE);
                }
                }
                    }
        });
        for(int i=0; i<sizeOfStack;i++){
                     Integer y = (Integer) stack.pop();
                     
                     sum2 = (y*1.0)-aveFS;
                      System.out.println("sum2: "+ y);
                     sum3=sum3+ Math.pow(sum2,2);
                     aveSD=(double)sum3/sizeOfStack;
                     
                     sum4=Math.sqrt(sum3);
                }
        bt2.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent ae){
                tf1.setText(null);
                textArea.setText(null);
                count=0;
                sum=0;
                aveFS=0;
            
            }
        });
        
        lb1 = new JLabel("Please Enter the family size: ");
        p.add(lb1);
        p.add(tf1);
        p.add(bt1);
        p.add(bt2);
        p.add(jScrollPane1);
        
        f.add(p);
        f.setVisible(true);
    }
    
    public static void main(String[] args) {
        // TODO code application logic here
        new StandardDeviation();
    }
     
}
