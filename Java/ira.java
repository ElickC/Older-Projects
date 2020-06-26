
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
private JPanel p1VTI,p2VEA,VTIpanel,VEApanel,p3VWO,VWOpanel,p4VIG,VIGpanel,
               p5VNQ,VNQpanel,p6VCIT,VCITpanel,p7VWOB,VWOBpanel,p8Total,
               p3,p4,p5,p6;
private JButton okButton, clearButton;
private double input = 0;
 
 
public ira(){
 
super("IRA Calculator"); //title bar
 
p1VTI = new JPanel();
    VTIlabel = new JLabel("VTI:");
    extra = new JLabel("Add: ");
    VTIbox = new JTextField(6);
    addVTI = new JTextField(4);
    p1VTI.add(VTIlabel);
    p1VTI.add(VTIbox);
    p1VTI.add(extra);
    p1VTI.add(addVTI);
    
VTIpanel = new JPanel();
    VTIoutput = new JLabel("Message Label:");
    VTIpanel.add(VTIoutput);
      
p2VEA = new JPanel();
    VEAlabel = new JLabel("VEA:");
    extra2 = new JLabel("Add:");
    VEAbox = new JTextField(6);
    addVEA = new JTextField(4);
    p2VEA.add(VEAlabel);
    p2VEA.add(VEAbox);
    p2VEA.add(extra2);
    p2VEA.add(addVEA);
    
VEApanel = new JPanel();
    VEAoutput = new JLabel("Message Label:");
    VEApanel.add(VEAoutput);
    
p3VWO = new JPanel();
    VWOlabel = new JLabel("VWO:");
    extra3 = new JLabel("Add:");
    VWObox = new JTextField(6);
    addVWO = new JTextField(4);
    p3VWO.add(VWOlabel);
    p3VWO.add(VWObox);
    p3VWO.add(extra3);
    p3VWO.add(addVWO);

VWOpanel = new JPanel();
    VWOoutput = new JLabel("Message Label:");
    VWOpanel.add(VWOoutput);
        
p4VIG = new JPanel();
    VIGlabel = new JLabel("VIG:");
    extra4 = new JLabel("Add:");
    VIGbox = new JTextField(6);
    addVIG = new JTextField(4);
    p4VIG.add(VIGlabel);
    p4VIG.add(VIGbox);
    p4VIG.add(extra4);
    p4VIG.add(addVIG);

VIGpanel = new JPanel();
    VIGoutput = new JLabel("Message Label:");
    VIGpanel.add(VIGoutput);
    
p5VNQ = new JPanel();
    VNQlabel = new JLabel("VNQ:");
    extra5 = new JLabel("Add:");
    VNQbox = new JTextField(6);
    addVNQ = new JTextField(4);
    p5VNQ.add(VNQlabel);
    p5VNQ.add(VNQbox);
    p5VNQ.add(extra5);
    p5VNQ.add(addVNQ);

VNQpanel = new JPanel();
    VNQoutput = new JLabel("Message Label:");
    VNQpanel.add(VNQoutput);
    
p6VCIT = new JPanel();
    VCITlabel = new JLabel("VCIT:");
    extra6 = new JLabel("Add:");
    VCITbox = new JTextField(6);
    addVCIT = new JTextField(4);
    p6VCIT.add(VCITlabel);
    p6VCIT.add(VCITbox);
    p6VCIT.add(extra6);
    p6VCIT.add(addVCIT);

VCITpanel = new JPanel();
    VCIToutput = new JLabel("Message Label:");
    VCITpanel.add(VCIToutput);
    
p7VWOB = new JPanel();
    VWOBlabel = new JLabel("VWOB:");
    extra7 = new JLabel("Add:");
    VWOBbox = new JTextField(6);
    addVWOB = new JTextField(4);
    p7VWOB.add(VWOBlabel);
    p7VWOB.add(VWOBbox);
    p7VWOB.add(extra7);
    p7VWOB.add(addVWOB);
    
VWOBpanel = new JPanel();
    VWOBoutput = new JLabel("Message Label:");
    VWOBpanel.add(VWOBoutput);
    
p8Total = new JPanel();
    totalLabel = new JLabel("Total:");
    totalBox = new JTextField(10);
    p8Total.add(totalLabel);
    p8Total.add(totalBox);


p4 = new JPanel();
    okButton = new JButton("Calculate"); 
    clearButton = new JButton("Clear");
    p4.add(okButton);
    p4.add(clearButton);

p5 = new JPanel();
    p5.setLayout(new GridLayout(4,4));
    p5.add(p1VTI);
    p5.add(VTIpanel);
    p5.add(p2VEA);
    p5.add(VEApanel);
    p5.add(p3VWO);
    p5.add(VWOpanel);
    p5.add(p4VIG);
    p5.add(VIGpanel);
    
p3 = new JPanel();
    p3.setLayout(new GridLayout(4,4));
    p3.add(p5VNQ);
    p3.add(VNQpanel);
    p3.add(p6VCIT);
    p3.add(VCITpanel);
    p3.add(p7VWOB);
    p3.add(VWOBpanel);
    p3.add(p8Total);
 
p6 = new JPanel();
    p6.setLayout(new BorderLayout());
    p6.add(p5, BorderLayout.WEST);
    p6.add(p3, BorderLayout.EAST);
    p6.add(p4, BorderLayout.SOUTH);
   

add(p6);


 okButton.addActionListener(
         new ActionListener(){
         public void actionPerformed (ActionEvent e){
             try{
                fund VTI = new fund("VTI");
                fund VEA = new fund("VEA");
                fund VWO = new fund("VWO");
                fund VIG = new fund("VIG");
                fund VNQ = new fund("VNQ");
                fund VCIT = new fund("VCIT");
                fund VWOB = new fund("VWOB");
                
                VTIoutput.setText("$" + Double.toString(VTI.getAmount()) 
                                  + "   " + Double.toString(VTI.calcPercentage()) + "%");
                VEAoutput.setText("$" + Double.toString(VEA.getAmount()) 
                                  + "   " + Double.toString(VEA.calcPercentage()) + "%");
                VWOoutput.setText("$" + Double.toString(VWO.getAmount()) 
                                  + "   " + Double.toString(VWO.calcPercentage()) + "%");
                VIGoutput.setText("$" + Double.toString(VIG.getAmount()) 
                                  + "   " + Double.toString(VIG.calcPercentage()) + "%");
                VNQoutput.setText("$" + Double.toString(VNQ.getAmount()) 
                                  + "   " + Double.toString(VNQ.calcPercentage()) + "%");
                VCIToutput.setText("$" + Double.toString(VCIT.getAmount()) 
                                  + "   " + Double.toString(VCIT.calcPercentage()) + "%");
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
        
        if(name == "VTI" && !VTIbox.getText().equals("")){
           amount = Double.parseDouble(VTIbox.getText());
           if(!addVTI.getText().equals(""))
               amount += Double.parseDouble(addVTI.getText());
           percentage = 0.21;
        }
        else if(name == "VEA" && !VEAbox.getText().equals("")){  
           amount = Double.parseDouble(VEAbox.getText());
           if(!addVEA.getText().equals(""))
               amount += Double.parseDouble(addVEA.getText());
           percentage = 0.18;
        }
        else if(name == "VWO" && !VWObox.getText().equals("")){  
           amount = Double.parseDouble(VWObox.getText());
           if(!addVWO.getText().equals(""))
               amount += Double.parseDouble(addVWO.getText());
           percentage = 0.27;
        }
        else if(name == "VIG" && !VIGbox.getText().equals("")){  
           amount = Double.parseDouble(VIGbox.getText());
           if(!addVIG.getText().equals(""))
               amount += Double.parseDouble(addVIG.getText());
           percentage = 0.08;
        }
        else if(name == "VNQ" && !VNQbox.getText().equals("")){
           amount = Double.parseDouble(VNQbox.getText());
           if(!addVNQ.getText().equals(""))
               amount += Double.parseDouble(addVNQ.getText());
           percentage = 0.16;
        }
        else if(name == "VCIT" && !VCITbox.getText().equals("")){
           amount = Double.parseDouble(VCITbox.getText());
           if(!addVCIT.getText().equals(""))
               amount += Double.parseDouble(addVCIT.getText());
           percentage = 0.05;
        }
        else if(name == "VWOB" && !VWOBbox.getText().equals("")){  
           amount = Double.parseDouble(VWOBbox.getText());
           if(!addVWOB.getText().equals(""))
               amount += Double.parseDouble(addVWOB.getText());
           percentage = 0.05;
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

