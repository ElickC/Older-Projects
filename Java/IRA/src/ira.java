
import java.awt.event.*;
import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
 
public class ira extends JFrame{
    
private JLabel VEAlabel, VEAoutput, VTIoutput, VTIlabel, VWOlabel, VWOoutput,
               VIGlabel, VIGoutput, VNQlabel, VNQoutput, VCITlabel, VCIToutput,
               VWOBlabel, VWOBoutput, totalLabel, extra, extra2, extra3, extra4,
               extra5, extra6, extra7;

private JTextField VTIbox, VEAbox, VWObox, VIGbox, VNQbox, VCITbox, VWOBbox,
                   totalBox, addVTI, addVEA,addVWO, addVIG, addVNQ, addVCIT,
                   addVWOB; 
private JPanel p1,p2,VTIpanel,VEApanel,p3,VWOpanel,p4,
               p5,VNQpanel,p6,p7,VWOBpanel,p8,p9,p10;
private JButton okButton, clearButton;
private double input = 0;
 
 
public ira(){
 
super("IRA Calculator"); //title bar
 
p1 = new JPanel();
    VWOBlabel = new JLabel("VWOB:");
    extra = new JLabel("Add: ");
    VWOBbox = new JTextField(6);
    addVWOB = new JTextField(4);
    p1.add(VWOBlabel);
    p1.add(VWOBbox);
    p1.add(extra);
    p1.add(addVWOB);
    
VWOBpanel = new JPanel();
    VWOBoutput = new JLabel("Message Label:");
    VWOBpanel.add(VWOBoutput);
      
p2 = new JPanel();
    VEAlabel = new JLabel("VEA:");
    extra2 = new JLabel("Add:");
    VEAbox = new JTextField(6);
    addVEA = new JTextField(4);
    p2.add(VEAlabel);
    p2.add(VEAbox);
    p2.add(extra2);
    p2.add(addVEA);
    
VEApanel = new JPanel();
    VEAoutput = new JLabel("Message Label:");
    VEApanel.add(VEAoutput);
    
p3 = new JPanel();
    VWOlabel = new JLabel("VWO:");
    extra3 = new JLabel("Add:");
    VWObox = new JTextField(6);
    addVWO = new JTextField(4);
    p3.add(VWOlabel);
    p3.add(VWObox);
    p3.add(extra3);
    p3.add(addVWO);

VWOpanel = new JPanel();
    VWOoutput = new JLabel("Message Label:");
    VWOpanel.add(VWOoutput);
        
p4 = new JPanel();
    VNQlabel = new JLabel("VNQ:");
    extra5 = new JLabel("Add:");
    VNQbox = new JTextField(6);
    addVNQ = new JTextField(4);
    p4.add(VNQlabel);
    p4.add(VNQbox);
    p4.add(extra5);
    p4.add(addVNQ);

VNQpanel = new JPanel();
    VNQoutput = new JLabel("Message Label:");
    VNQpanel.add(VNQoutput);
    
  
p5 = new JPanel();
    VTIlabel = new JLabel("VTI:");
    extra7 = new JLabel("Add:");
    VTIbox = new JTextField(6);
    addVTI = new JTextField(4);
    p5.add(VTIlabel);
    p5.add(VTIbox);
    p5.add(extra7);
    p5.add(addVTI);
    
VTIpanel = new JPanel();
    VTIoutput = new JLabel("Message Label:");
    VTIpanel.add(VTIoutput);
    
p6 = new JPanel();
    totalLabel = new JLabel("Total:");
    totalBox = new JTextField(10);
    p6.add(totalLabel);
    p6.add(totalBox);


p7 = new JPanel();
    okButton = new JButton("Calculate"); 
    clearButton = new JButton("Clear");
    p7.add(okButton);
    p7.add(clearButton);

p8 = new JPanel();
    p8.setLayout(new GridLayout(3,2));
    p8.add(p1);
    p8.add(VWOBpanel);
    p8.add(p2);
    p8.add(VEApanel);
    p8.add(p3);
    p8.add(VWOpanel);
    
p9 = new JPanel();
    p9.setLayout(new GridLayout(3,2));
    p9.add(p4);
    p9.add(VNQpanel);
    p9.add(p5);
    p9.add(VTIpanel);
    p9.add(p6);
    
 
p10 = new JPanel();
    p10.setLayout(new BorderLayout());
    p10.add(p8, BorderLayout.WEST);
    p10.add(p9, BorderLayout.EAST);
    p10.add(p7, BorderLayout.SOUTH);
   

add(p10);


 okButton.addActionListener(
         new ActionListener(){
         public void actionPerformed (ActionEvent e){
             try{
                fund VTI = new fund("VTI");
                fund VEA = new fund("VEA");
                fund VWO = new fund("VWO");              
                fund VNQ = new fund("VNQ");
                fund VWOB = new fund("VWOB");
                
                VTIoutput.setText("$" + Double.toString(VTI.getAmount()) 
                                  + "   " + Double.toString(VTI.calcPercentage()) + "%");
                VEAoutput.setText("$" + Double.toString(VEA.getAmount()) 
                                  + "   " + Double.toString(VEA.calcPercentage()) + "%");
                VWOoutput.setText("$" + Double.toString(VWO.getAmount()) 
                                  + "   " + Double.toString(VWO.calcPercentage()) + "%");               
                VNQoutput.setText("$" + Double.toString(VNQ.getAmount()) 
                                  + "   " + Double.toString(VNQ.calcPercentage()) + "%");
                VWOBoutput.setText("$" + Double.toString(VWOB.getAmount()) 
                                  + "   " + Double.toString(VWOB.calcPercentage()) + "%");
                 
                 
            }    
            
            catch(NumberFormatException ex){
                JOptionPane.showMessageDialog(null,ex +  "\nPlease enter valid numbers only");
                clearOutputLabels();
            }
            
//            outputBox.setText(String.format("%.2f", total));
                 VTIbox.grabFocus();
                 
             }});   
 
 clearButton.addActionListener(
         new ActionListener(){
         public void actionPerformed (ActionEvent e){
                 clearBoxes();    
                 clearOutputLabels();
             }
         }
 );   
    

    VTIbox.addActionListener(
    new ActionListener(){
        public void actionPerformed (ActionEvent e){
            
        }});
    
    
    
//      ArrayList<fund> fundList = new ArrayList();
//                fundList.add(VTI);
//                fundList.add(VEA);
//                fundList.add(VWO);
//                fundList.add(VIG);
//                fundList.add(VNQ);
//                fundList.add(VCIT);
//                fundList.add(VWOB);
//                
//                for(fund currentFund : fundList){
//                    currentFund;
//                }


}//end constructor

public class fund{
    private String name;
    private double amount, percentage, total, result;
    
    public fund(String name){
        this.name = name;
        
        if(name == "VWOB" && !VWOBbox.getText().equals("")){  
           amount = Double.parseDouble(VWOBbox.getText());
           if(!addVWOB.getText().equals("")){
               amount += Double.parseDouble(addVWOB.getText());
               total += Double.parseDouble(addVWOB.getText());
           }
           percentage = 0.12;
        }
        else if(name == "VEA" && !VEAbox.getText().equals("")){  
           amount = Double.parseDouble(VEAbox.getText());
           if(!addVEA.getText().equals("")){
               amount += Double.parseDouble(addVEA.getText());
               total += Double.parseDouble(addVEA.getText());
           }
           percentage = 0.25;
        }
        else if(name == "VWO" && !VWObox.getText().equals("")){  
           amount = Double.parseDouble(VWObox.getText());
           if(!addVWO.getText().equals("")){
               amount += Double.parseDouble(addVWO.getText());
               total += Double.parseDouble(addVWO.getText());
           }
           percentage = 0.16;
        }
        else if(name == "VNQ" && !VNQbox.getText().equals("")){
           amount = Double.parseDouble(VNQbox.getText());
           if(!addVNQ.getText().equals("")){
               amount += Double.parseDouble(addVNQ.getText());
               total += Double.parseDouble(addVNQ.getText());
           }
           percentage = 0.12;
        }
        else if(name == "VTI" && !VTIbox.getText().equals("")){
           amount = Double.parseDouble(VTIbox.getText());
           if(!addVTI.getText().equals("")){
               amount += Double.parseDouble(addVTI.getText());
               total += Double.parseDouble(addVTI.getText());
           }
           percentage = 0.35;
        }
                
        total = Double.parseDouble(totalBox.getText());
    }

    public String getFundName(){
        return name;
    }
    
    public double getAmount(){
       return amount;
    }
    
    public double getPercentage(){
        return percentage;
    }
    
    public double calcPercentage(){
        result = ((amount / total) * 100) - (percentage * 100);
        result = (int)(result * 10);
        result /= 10;
        return result;
    }
    
}
    

public void clearOutputLabels(){
    VTIoutput.setText("");
    VEAoutput.setText("");
    VWOoutput.setText("");
    VTIoutput.setText("");  
    
}

public void clearBoxes(){
    VTIbox.setText("");
    VEAbox.setText("");
    VWObox.setText("");
    VTIbox.setText("");  
    
}
 
public static void main(String[] args) {
 
ira frame = new ira();
frame.setSize(800, 600);
frame.pack();
frame.setVisible(true);
frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
frame.setLocationRelativeTo(null);


}
}
