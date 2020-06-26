// File name: Temperature Conversion App

// Written by: Elick Coval
 
// Description: This program allows the user to easily convert between
//              Fahrenheit, Celsius, and Kelvin. The user can either enter a 
//              number for conversion and then hit enter or choose the desired
//              temperature conversion and it will calculate automatically.
// Challenges: Figuring out how to call an action event from another action.
//             Setting up the GUI how I planned it.
// Time Spent: 5 hours

// Revision History:
// Date:         		By:      Action:
// ---------------------------------------------------
/* 10/7/2016   (EC)      Created the GUI components and set up most of the 
 *                       panels.                 
 * 
 * 10/9/2013   (EC)      Finished up the GUI, started working on button               
 *                       functionality. Created logic structure for different
 *                       button combinations.
 *
 * 10/14/2013  (EC)      Finally figured out how to get the program to calculate
 *                       when a different button was selected. Added esception 
 *                       handling.
*/      


import java.awt.event.*;
import javax.swing.*;
import java.awt.*;
 
public class Assignment3 extends JFrame{
    
private JLabel fromLbl, inputLbl, toLbl, restlLabel;
private JTextField inputBox, outputBox;
private JRadioButton fButton, cButton, kButton, fButton2, cButton2, kButton2;
private ButtonGroup radioGroup1, radioGroup2; 
private JPanel p3,p1,p2,p4,p5,p6,p7,p8,p9,p10,p11,p12,p13,p14;
 
 
public Assignment3(){
 
super("Temperature Conversion"); //title bar

p1 = new JPanel(); // declare label
    inputLbl = new JLabel("Convert from: ");
    p1.add(inputLbl);
    
radioGroup1 = new ButtonGroup(); // declare first set of buttons
    fButton = new JRadioButton("Fahrenheit",true);
    cButton = new JRadioButton("Celsius");
    kButton = new JRadioButton("Kelvin");
    radioGroup1.add(fButton);
    radioGroup1.add(cButton);
    radioGroup1.add(kButton);
    
p2 = new JPanel(); // get buttons to algin vertically
    p2.add(fButton);
    p2.add(cButton);
    p2.add(kButton);
    p2.setLayout(new GridLayout(3, 1));
 
p3 = new JPanel(); // declare label
    fromLbl = new JLabel("Enter Numeric Temperature");
    p3.add(fromLbl);
   
p4 = new JPanel(); // declare input text field
    inputBox = new JTextField(5);
    p4.add(inputBox);
 
p5 = new JPanel(); // get input box and label to align
    p5.add(p3);
    p5.add(p4);
    p5.setLayout(new GridLayout(2, 1));
  
p6 = new JPanel(); // declare label
    toLbl = new JLabel("Convert to: ");
    p6.add(toLbl);
    
radioGroup2 = new ButtonGroup(); // declare second set of buttons
    fButton2 = new JRadioButton("Fahrenheit",true);
    cButton2 = new JRadioButton("Celsius");
    kButton2 = new JRadioButton("Kelvin");
    radioGroup2.add(fButton2);
    radioGroup2.add(cButton2);
    radioGroup2.add(kButton2);
    
p7 = new JPanel(); // get buttons to align vertically
    p7.add(fButton2);
    p7.add(cButton2);
    p7.add(kButton2);
    p7.setLayout(new GridLayout(3, 1));

p8 = new JPanel(); // declare label
    restlLabel = new JLabel("Comparable Temperature is:");
    p8.add(restlLabel);
    
p9 = new JPanel(); // declare output text field
    outputBox = new JTextField(5);
    outputBox.setEditable(false);
    p9.add(outputBox);
    
p10 = new JPanel(); // get output label and box to align
    p10.add(p8);
    p10.add(p9);
    p10.setLayout(new GridLayout(2,1));
    
p11 = new JPanel(); // get first set of buttons and label to align
   p11.add(p1);
   p11.add(p2);
   p11.setLayout(new GridLayout(1,2));
   
p12 = new JPanel(); // get second set of buttons and label to align
   p12.add(p6);
   p12.add(p7);
   p12.setLayout(new GridLayout(1,2));
   
p13 = new JPanel(); // add everything to last panel and align
   p13.setLayout(new GridLayout(2,2));
   p13.add(p11);
   p13.add(p5);
   p13.add(p12);
   p13.add(p10);

add(p13); // add last panel to Frame

//call inputBox action event when any radio button is clicked
fButton.addActionListener(        
    new ActionListener(){
        public void actionPerformed (ActionEvent e){
            inputBox.postActionEvent();
  }});

cButton.addActionListener(
    new ActionListener(){
        public void actionPerformed (ActionEvent e){
            inputBox.postActionEvent();
  }});

kButton.addActionListener(
    new ActionListener(){
        public void actionPerformed (ActionEvent e){
            inputBox.postActionEvent();
  }});

fButton2.addActionListener(
    new ActionListener(){
        public void actionPerformed (ActionEvent e){
            inputBox.postActionEvent();
  }});

cButton2.addActionListener(
    new ActionListener(){
        public void actionPerformed (ActionEvent e){
            inputBox.postActionEvent();
  }});

kButton2.addActionListener(
    new ActionListener(){
        public void actionPerformed (ActionEvent e){
            inputBox.postActionEvent();
  }});

//functionality for when the user hits enter in the input text field
inputBox.addActionListener(
    new ActionListener(){
        public void actionPerformed (ActionEvent e){
            double total = 0;
            double input = 0;
          
            try{
                input = Double.parseDouble(inputBox.getText());           //user entered number
                
                    if(fButton.isSelected() && cButton2.isSelected())     //button combination logic
                        total = (((input - 32)*5)/9);
                    else if(fButton.isSelected() && kButton2.isSelected())
                        total = (((input - 32)*5)/9) + 273.15;
                    else if(cButton.isSelected() && fButton2.isSelected())
                        total = input * 1.8 + 32;
                    else if(cButton.isSelected() && kButton2.isSelected())
                        total = input + 273.15;
                    else if(kButton.isSelected() && fButton2.isSelected())
                        total = input * 1.8 - 459.67;
                    else if(kButton.isSelected() && cButton2.isSelected())
                        total = input - 273.15;
                    else                             //other scenarios are when the temperature is the same
                        total = input;
            }    
            
            catch(NumberFormatException ex){        //catch non-numeric data entry
                JOptionPane.showMessageDialog(null,ex +  "\nPlease enter valid numbers only");
                inputBox.setText("");
                outputBox.setText("");
            }
            //display converted temperature with two decimal places
            outputBox.setText(String.format("%.2f", total));
            inputBox.grabFocus();
            
        }
    }
);

}//end constructor
 
 
public static void main(String[] args) {
 
//show frame
Assignment3 frame = new Assignment3();
frame.pack();
frame.setVisible(true);
frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
frame.setLocationRelativeTo(null);

}
}

