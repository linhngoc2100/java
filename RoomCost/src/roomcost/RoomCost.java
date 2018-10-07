/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package roomcost;
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
/**
 *
 * @author tomng
 */
public class RoomCost {

    /**
     * @param args the command line arguments
     */
    JFrame f;
    JPanel p;
    JTextField tf1,tf2,tf3;
    JTextArea textArea;
    JButton bt1,bt2;
    JLabel lb1,lb2,lb3;
    JScrollPane jScrollPane1;
     double sum=0, count =0;
     double area =0, costArea=0, totalcost=0;
     
    public RoomCost(){
        GUI();
    }
    
    public void GUI(){
        f = new JFrame("Average Family Size");
       
        f.setSize(600,480);
        //f.setLayout(new FlowLayout());
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        p = new JPanel();
        lb1 = new JLabel("Please Enter Width: ");
        tf1 = new JTextField(10);
        lb2 = new JLabel("Please Enter Length: ");
        tf2 = new JTextField(10);
        lb3 = new JLabel("Please Enter Cost: ");
        tf3 = new JTextField(10);
        textArea = new JTextArea();
        textArea.setColumns(30);
        textArea.setLineWrap(true);
        textArea.setRows(10);
        textArea.setWrapStyleWord(true);
        textArea.setFont(new Font("Serif", Font.BOLD, 18));
        textArea.setEditable(false);
        jScrollPane1 = new JScrollPane(textArea);
        bt1 = new JButton("Calculate");
        bt2 = new JButton("Clear All");
        
         bt1.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent ae){
                if(tf1.getText().trim().isEmpty()||tf2.getText().trim().isEmpty()||tf3.getText().trim().isEmpty())
                {
                    JOptionPane.showMessageDialog(f,
                    "Input fields cannot be empty.",
                    "Inane error",
                    JOptionPane.ERROR_MESSAGE);
                }else{
                String value1 = tf1.getText();
                double width = Double.parseDouble(value1);
                String value2 = tf2.getText();
                double length = Double.parseDouble(value2);
                String value3 = tf3.getText();
                double cost = Double.parseDouble(value3);
                
                area = width*length;
                costArea = area*cost;
                totalcost= totalcost+costArea;
                sum = sum+area;
                textArea.append("You entered width and length: "+width +"    "+length+ "\n");
                textArea.append("Cost entered: "+cost+"\n");
                textArea.append("Area: "+area+"\n");
                textArea.append("Area Cost: "+costArea+"\n");
                textArea.append("Total Area: "+sum+"\n");
                textArea.append("Total Cost: "+totalcost+"\n");
                textArea.append("\n");
                }
            }});
         
        bt2.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent ae){
                tf1.setText(null);
                tf2.setText(null);
                tf3.setText(null);
                textArea.setText(null);
                totalcost=0;
                costArea=0;
                sum=0;
            }});
        p.add(lb1);
        p.add(tf1);
        p.add(lb2);
        p.add(tf2);
        p.add(lb3);
        p.add(tf3);
        p.add(bt1);
        p.add(bt2);
        p.add(jScrollPane1);
        
        f.add(p);
        f.setVisible(true);
    }
    public static void main(String[] args) {
        // TODO code application logic here
        new RoomCost();
    }
    
}
