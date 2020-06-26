
import java.awt.event.*;
import javax.swing.*;
import java.awt.*;
 
public class Assignment2 extends JFrame{
    
private JLabel fromLbl, inputLbl, toLbl, restlLabel;
private JTextField inputBox, outputBox;
private JRadioButton fButton, cButton, kButton, fButton2, cButton2, kButton2;
private ButtonGroup radioGroup1, radioGroup2; 
private JPanel p3,p1,p2,p4,p5,p6,p7,p8,p9,p10,p11,p12,p13,p14;
 
 
public Assignment2(){
 
super("Temperature Conversion"); //title bar

p1 = new JPanel();
    inputLbl = new JLabel("Convert from: ");
    p1.add(inputLbl);
    
radioGroup1 = new ButtonGroup();
    fButton = new JRadioButton("Fahrenheit",true);
    cButton = new JRadioButton("Celsius");
    kButton = new JRadioButton("Kelvin");
    radioGroup1.add(fButton);
    radioGroup1.add(cButton);
    radioGroup1.add(kButton);
    
p2 = new JPanel();
    p2.add(fButton);
    p2.add(cButton);
    p2.add(kButton);
    p2.setLayout(new GridLayout(3, 1));
 
p3 = new JPanel();
    fromLbl = new JLabel("Enter Numeric Temperature");
    inputBox = new JTextField(5);
    p3.add(fromLbl);
   
p4 = new JPanel();
    inputBox = new JTextField(5);
    p4.add(inputBox);
 
p5 = new JPanel();
    p5.add(p3);
    p5.add(p4);
    p5.setLayout(new GridLayout(2, 1));
  
p6 = new JPanel();
    toLbl = new JLabel("Convert to: ");
    p6.add(toLbl);
    
radioGroup2 = new ButtonGroup();
    fButton2 = new JRadioButton("Fahrenheit",true);
    cButton2 = new JRadioButton("Celsius");
    kButton2 = new JRadioButton("Kelvin");
    radioGroup2.add(fButton2);
    radioGroup2.add(cButton2);
    radioGroup2.add(kButton2);
    
p7 = new JPanel();
    p7.add(fButton2);
    p7.add(cButton2);
    p7.add(kButton2);
    p7.setLayout(new GridLayout(3, 1));

p8 = new JPanel();
    restlLabel = new JLabel("Comparable Temperature is:");
    p8.add(restlLabel);
    
p9 = new JPanel();
    outputBox = new JTextField(5);
    outputBox.setEditable(false);
    p9.add(outputBox);
    
p10 = new JPanel();
    p10.add(p8);
    p10.add(p9);
    p10.setLayout(new GridLayout(2,1));
    
p11 = new JPanel();
   p11.add(p1);
   p11.add(p2);
   p11.setLayout(new GridLayout(1,2));
   
p12 = new JPanel();
   p12.add(p6);
   p12.add(p7);
   p12.setLayout(new GridLayout(1,2));
   
p13 = new JPanel();
   p13.setLayout(new GridLayout(2,2));
   p13.add(p11);
   p13.add(p5);
   p13.add(p12);
   p13.add(p10);
 
add(p13);

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

inputBox.addActionListener(
    new ActionListener(){
        public void actionPerformed (ActionEvent e){
            double total = 0;
            double input = 0;
          
            try{
                input = Double.parseDouble(inputBox.getText());
                
                    if(fButton.isSelected() && cButton2.isSelected())
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
                    else
                        total = input;
            }    
            
            catch(NumberFormatException ex){
                JOptionPane.showMessageDialog(null,ex +  "\nPlease enter valid numbers only");
                inputBox.setText("");
                outputBox.setText("");
            }
            outputBox.setText("");
            outputBox.setText(String.format("%.2f", total));
                 inputBox.grabFocus();
            
        }
    }
);

}//end constructor
 
 
public static void main(String[] args) {
 
Assignment2 frame = new Assignment2();
frame.pack();
frame.setVisible(true);
frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
frame.setLocationRelativeTo(null);

}
}

