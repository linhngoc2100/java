/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stackquiz;
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.util.*;
/**
 *
 * @author tomng
 */
public class StackQuiz {

    /**
     * @param args the command line arguments
     */
    JFrame f;
    JPanel p;
    JTextField tf1;
    JTextArea textArea;
    JButton bt1,bt2,bt3;
    JLabel lb1;
    JScrollPane jScrollPane1;
     StringBuilder s1;
     String s,s2;
    Stack st;
    public StackQuiz()
    {
        GUI();
    }
    
    public void GUI(){
        f = new JFrame("Stack functions: push, pop, emptyStack");
       
        f.setSize(660,480);
        //f.setLayout(new FlowLayout());
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        p = new JPanel();
        Font font1 = new Font("SansSerif", Font.BOLD, 20);
        tf1 = new JTextField(10);
        tf1.setFont(font1);
        textArea = new JTextArea();
        textArea.setColumns(30);
        textArea.setLineWrap(true);
        textArea.setRows(10);
        textArea.setWrapStyleWord(true);
        textArea.setEditable(false);
        textArea.setFont(font1);
        jScrollPane1 = new JScrollPane(textArea);
        bt1 = new JButton("Push");
        bt2 = new JButton("Pop");
        bt3 = new JButton("Empty Stack");
        st = new Stack();
        s1 = new StringBuilder();
        bt1.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent ae){
                if(tf1.getText().trim().isEmpty())
                {
                    JOptionPane.showMessageDialog(f,
                    "Input cannot be empty.",
                    "Inane error",
                    JOptionPane.ERROR_MESSAGE);
                }else{
                    String textFieldValue = tf1.getText();
                    
                    st.push(textFieldValue);
                    textArea.append("Push: "+textFieldValue+"\n");
                     textArea.append("Current Stack after pushing: "+st+"\n");
                    }
                    //textArea.append("Current Stack: "+st+"\n");
                  /*  for (Object obj  : st) {
                        s = (String)obj;
                        s1.append(s);
                        s1.append(" ");
                     
                     System.out.println("Pushed: "+s1);
                        
                    }*/
                  
                   
                   // textArea.append("\n");
        
                
            }});
        
        bt2.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent ae){
                if (!st.isEmpty()) {
                s2 = (String)st.pop();
                textArea.append("Pop: "+s2+"\n");
                textArea.append("Current Stack After poping: "+st+"\n");}
                else{JOptionPane.showMessageDialog(f,
                    "Stack is empty. cannot pop",
                    "Inane error",
                    JOptionPane.ERROR_MESSAGE);}
                    
                
            }});
        bt3.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent ae){
                if (!st.isEmpty()) {
                st= new Stack();
                textArea.append("Stack after empty: "+st+"\n");}
                else{JOptionPane.showMessageDialog(f,
                    "Stack is empty, cannot empty",
                    "Inane error",
                    JOptionPane.ERROR_MESSAGE);}
            }});
        lb1 = new JLabel("Please Enter the strings: ");
        p.add(lb1);
        p.add(tf1);
        p.add(bt1);
        p.add(bt2);
        p.add(bt3);
        p.add(jScrollPane1);
        
        f.add(p);
        f.setVisible(true);
        f.setResizable(false);
    }
    public static void main(String[] args) {
        // TODO code application logic here
        new StackQuiz();
    }
    
}
