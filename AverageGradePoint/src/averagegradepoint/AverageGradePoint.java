/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package averagegradepoint;
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
/**
 *
 * @author tomng
 */
public class AverageGradePoint {

    /**
     * @param args the command line arguments
     * 
     */
     JFrame f;
    JPanel p;
    JTextField tf1;
    JTextArea textArea;
    JButton bt1,bt2;
    JLabel lb1,lb2;
    JScrollPane jScrollPane1;
     double sum=0, count =0;
     double aveGP =0, value=0;
     String theLtgrade1,theLtgrade2;
     int count2=0;
   
     
    public  AverageGradePoint(){
        GUI();
    }
    
    public void GUI()
    {
        f = new JFrame("Average Grade Point");
        f.setSize(600,480);
        
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        p = new JPanel();
        

        tf1 = new JTextField(10);
        textArea = new JTextArea();
        textArea.setColumns(30);
        textArea.setLineWrap(true);
        textArea.setRows(20);
        textArea.setWrapStyleWord(true);
        textArea.setEditable(false);
        jScrollPane1 = new JScrollPane(textArea);
        bt1 = new JButton("Calculate");
        bt2 = new JButton("Clear All");
        lb2 = new JLabel("Please Enter Grade Point(4.0,3.5...): ");
        bt1.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent ae){
                count++;
                count2++;
                if(tf1.getText().trim().isEmpty())
                {
                    JOptionPane.showMessageDialog(f,
                    "Grade cannot be empty.",
                    "Inane error",
                    JOptionPane.ERROR_MESSAGE);
                }else
                {
                    String textFieldValue = tf1.getText();
                
                    value = Double.parseDouble(textFieldValue);
                    if(value>4 || value<0){
                        
                        JOptionPane.showMessageDialog(f,
                        "Grade cannot be greater than 4 or less than 0.",
                        "Inane error",
                        JOptionPane.ERROR_MESSAGE);
                    }
                    else{
                    sum=sum+value;
                    theLtgrade1 =letterGrade(value);
                    
                    aveGP = sum/count;
                    theLtgrade2 =letterGrade(aveGP);
                    displayinfo(theLtgrade1,theLtgrade2);
                 
                }
                }
        }});
        
        bt2.addActionListener((ActionEvent ae) -> {
            tf1.setText(null);
            textArea.setText(null);
            count=0;
            count2=0;
            sum=0;
            aveGP=0;
        });
        p.add(lb2);
        p.add(tf1);
        p.add(bt1);
        p.add(bt2);
        p.add(jScrollPane1);
        
        f.add(p);
        f.setVisible(true);
        f.setResizable(false);
    }
    public String letterGrade(double gp){
        
        String theLetter;
        if(gp==4.0)
            theLetter="A";
        else if(gp<4.0 && gp>=3.7)
            theLetter="A-";
        else if(gp<3.7 && gp>=3.2)
            theLetter="B+";
        else if(gp<3.2 && gp>=3.0)
            theLetter="B";
        else if(gp<3.0 && gp>=2.7)
            theLetter="B-";
        else if(gp<2.7 && gp>=2.3)
            theLetter="C+";
        else if(gp<2.3 && gp>=2.0)
            theLetter="C";
        else if(gp<2.0 && gp>=1.7)
            theLetter="C-";
        else if(gp<1.7 && gp>=1.3)
            theLetter="D+";
        else if(gp<1.3 || gp>=1.0)
            theLetter="D";
        else if(gp<1.0 && gp>=0.7)
            theLetter="D-";
        else
            theLetter="F";
        return theLetter;
    }      
    public void displayinfo(String a, String b){
        
        textArea.append("Order: "+count2+"\n");
        textArea.append("Grade point entered: "+value+"\n");
        textArea.append("Grade letter: "+a+"\n");
        textArea.append("Total Grade: "+sum+"\n");
        textArea.append("Total Size: "+count2+"\n");
        textArea.append("Grade Average: "+aveGP+"\n");
        textArea.append("Grade Average Letter: "+b+"\n");
        textArea.append("\n");
    }
                
    public static void main(String[] args) {
        // TODO code application logic here
        new  AverageGradePoint();
    }
    
}
