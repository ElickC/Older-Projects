package newpackage;

import javax.swing.*;
import java.awt.*;
 
public class MyFirstGUI extends JFrame{
    
private JLabel label1, label2, label3, restlLabel;
private JTextField fName, lName;
private JButton okButton, clearButton; 
private JPanel p1,p2,p3,p4,p5,p6;
private String firstName, lastName;
 
public MyFirstGUI(){
 
super("First GUI Application");
 
p1 = new JPanel();
    label1 = new JLabel("First Name: ");
    fName = new JTextField(20);
    p1.setLayout(new FlowLayout(FlowLayout.LEFT));
    p1.add(label1);
    p1.add(fName);
 
p2 = new JPanel();
    label2 = new JLabel("Last Name: ");
    lName = new JTextField(20);
    p2.setLayout(new FlowLayout(FlowLayout.LEFT));
    p2.add(label2);
    p2.add(lName);
 
p3 = new JPanel();
    label3 = new JLabel("Message Label: ");
    restlLabel = new JLabel();
    p3.setLayout(new FlowLayout(FlowLayout.LEFT));
    p3.add(label3);
    p3.add(restlLabel);
    
p4 = new JPanel();
    okButton = new JButton("OK"); 
    clearButton = new JButton("Clear");
    p4.add(okButton);
    p4.add(clearButton);
 
p5 = new JPanel();
    p5.setLayout(new GridLayout(4, 1));
    p5.add(p1);
    p5.add(p2);
    p5.add(p3);
    p5.add(p4);
 

p6 = new JPanel();
p6.setLayout(new BorderLayout());
p6.add(p5, BorderLayout.CENTER);
add(p6);

firstName = fName.getText();
lastName = lName.getText();
restlLabel.setText("with firstNAme and lastName here!");
}//end constructor
 
 
public static void main(String[] args) {
 
MyFirstGUI frame = new MyFirstGUI();
frame.setSize(400, 300);
frame.setVisible(true);
frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
frame.setLocationRelativeTo(null);



}
}

