
import java.awt.event.*;
import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
 
public class ira2 extends JFrame{
    
private JLabel VEAlabel, VEAoutput, VTIoutput, VTIlabel, VWOlabel, VWOoutput,
               VIGlabel, VIGoutput, VNQlabel, VNQoutput, VCITlabel, VCIToutput,
               VWOBlabel, VWOBoutput, totalLabel, addLabel,totalOutput, percentLabel;

private JTextField VTIbox, VEAbox, VWObox, VIGbox, VNQbox, VCITbox, VWOBbox,
                   totalBox, addVTI, addVEA,addVWO, addVIG, addVNQ, addVCIT,
                   addVWOB, veaPercBox, vtiPercBox, vnqPercBox, vwobPercBox, vwoPercBox; 
private JPanel vwobPanel,veaPanel,vtiOutputPanel,veaOutputPanel,vwoPanel,vwoOutputPanel,vnqPanel,
               vtiPanel,vnqOutputPanel,totalPanel,OkAndClearBtnPanel,vwobOutputPanel,firstColumnPanels,secondColumnPanels,masterPanel;
private JButton okButton, clearButton;
private double total = 0;
private static final double VWOB_PERCENTAGE = 0.12
                           ,VEA_PERCENTAGE = 0.25
                           ,VWO_PERCENTAGE = 0.16
                           ,VNQ_PERCENTAGE = 0.12
                           ,VTI_PERCENTAGE = 0.35;

fund VWOB = new fund("VWOB",VWOB_PERCENTAGE);
fund VEA = new fund("VEA", VEA_PERCENTAGE);
fund VWO = new fund("VWO", VWO_PERCENTAGE); 
fund VNQ = new fund("VNQ", VNQ_PERCENTAGE);
fund VTI = new fund("VTI", VTI_PERCENTAGE);        
                
 
public ira2(){
 
super("IRA Calculator"); //title bar
 
vwobPanel = new JPanel();
    VWOBlabel = new JLabel("VWOB:");
    addLabel = new JLabel("Add: ");
    percentLabel = new JLabel("New %:");
    VWOBbox = new JTextField(6);
    addVWOB = new JTextField(4);
    vwobPercBox = new JTextField(2);
  
    vwobPanel.add(VWOBlabel);
    vwobPanel.add(VWOBbox);
    vwobPanel.add(addLabel);
    vwobPanel.add(addVWOB);
    vwobPanel.add(percentLabel);
    vwobPanel.add(vwobPercBox);
    
vwobOutputPanel = new JPanel();
    VWOBoutput = new JLabel("Message Label:");
    vwobOutputPanel.add(VWOBoutput);
      
veaPanel = new JPanel();
    VEAlabel = new JLabel("VEA:");
    VEAbox = new JTextField(6);
    addVEA = new JTextField(4);
    veaPercBox = new JTextField(2);
    
    veaPanel.add(VEAlabel);
    veaPanel.add(VEAbox);
    veaPanel.add(addLabel);
    veaPanel.add(addVEA);
    veaPanel.add(percentLabel);
    veaPanel.add(veaPercBox);
    
veaOutputPanel = new JPanel();
    VEAoutput = new JLabel("Message Label:");
    veaOutputPanel.add(VEAoutput);
    
vwoPanel = new JPanel();
    VWOlabel = new JLabel("VWO:");
    VWObox = new JTextField(6);
    addVWO = new JTextField(4);
    vwoPercBox = new JTextField(2);
    
    vwoPanel.add(VWOlabel);
    vwoPanel.add(VWObox);
    vwoPanel.add(addLabel);
    vwoPanel.add(addVWO);
    vwoPanel.add(percentLabel);
    vwoPanel.add(vwoPercBox);

vwoOutputPanel = new JPanel();
    VWOoutput = new JLabel("Message Label:");
    vwoOutputPanel.add(VWOoutput);
        
vnqPanel = new JPanel();
    VNQlabel = new JLabel("VNQ:");
    VNQbox = new JTextField(6);
    addVNQ = new JTextField(4);
    vnqPercBox = new JTextField(2);
    
    vnqPanel.add(VNQlabel);
    vnqPanel.add(VNQbox);
    vnqPanel.add(addLabel);
    vnqPanel.add(addVNQ);
    vnqPanel.add(percentLabel);
    vnqPanel.add(vnqPercBox);

vnqOutputPanel = new JPanel();
    VNQoutput = new JLabel("Message Label:");
    vnqOutputPanel.add(VNQoutput);
    
  
vtiPanel = new JPanel();
    VTIlabel = new JLabel("VTI:");
    VTIbox = new JTextField(6);
    addVTI = new JTextField(4);
    vtiPercBox = new JTextField(2);
    
    vtiPanel.add(VTIlabel);
    vtiPanel.add(VTIbox);
    vtiPanel.add(addLabel);
    vtiPanel.add(addVTI);
    vtiPanel.add(percentLabel);
    vtiPanel.add(vtiPercBox);
    
vtiOutputPanel = new JPanel();
    VTIoutput = new JLabel("Message Label:");
    vtiOutputPanel.add(VTIoutput);
    
totalPanel = new JPanel();
    totalLabel = new JLabel("Total:");
    totalBox = new JTextField(10);
    totalOutput = new JLabel("Message Label");
    totalPanel.add(totalLabel);
    totalPanel.add(totalBox);
    totalPanel.add(totalOutput);

OkAndClearBtnPanel = new JPanel();
    okButton = new JButton("Calculate"); 
    clearButton = new JButton("Clear");
    OkAndClearBtnPanel.add(okButton);
    OkAndClearBtnPanel.add(clearButton);

firstColumnPanels = new JPanel();
    firstColumnPanels.setLayout(new GridLayout(3,2));
    firstColumnPanels.add(vwobPanel);
    firstColumnPanels.add(vwobOutputPanel);
    firstColumnPanels.add(veaPanel);
    firstColumnPanels.add(veaOutputPanel);
    firstColumnPanels.add(vwoPanel);
    firstColumnPanels.add(vwoOutputPanel);
    
secondColumnPanels = new JPanel();
    secondColumnPanels.setLayout(new GridLayout(3,2));
    secondColumnPanels.add(vnqPanel);
    secondColumnPanels.add(vnqOutputPanel);
    secondColumnPanels.add(vtiPanel);
    secondColumnPanels.add(vtiOutputPanel);
    secondColumnPanels.add(totalPanel);
    
 
masterPanel = new JPanel();
    masterPanel.setLayout(new BorderLayout());
    masterPanel.add(firstColumnPanels, BorderLayout.WEST);
    masterPanel.add(secondColumnPanels, BorderLayout.EAST);
    masterPanel.add(OkAndClearBtnPanel, BorderLayout.SOUTH);
   

add(masterPanel);


 okButton.addActionListener(
         new ActionListener(){
         public void actionPerformed (ActionEvent e){
             try{
                
             
//                ArrayList<fund> fundList = new ArrayList();
//                    fundList.add(VWOB);
//                    fundList.add(VEA);
//                    fundList.add(VWO);
//                    fundList.add(VNQ);
//                    fundList.add(VTI);

                total = 0;  
                calcDisplayedValues();
                
                VWOBoutput.setText("$" + Double.toString(VWOB.getAmount()) 
                                  + "   " + Double.toString(VWOB.calcPercentage()) + "%"
                                  + "% of Total" + Double.toString(VWOB.percentage));
                VEAoutput.setText("$" + Double.toString(VEA.getAmount()) 
                                  + "   " + Double.toString(VEA.calcPercentage()) + "%"
                                  + "% of Total" + Double.toString(VEA.percentage));
                VWOoutput.setText("$" + Double.toString(VWO.getAmount()) 
                                  + "   " + Double.toString(VWO.calcPercentage()) + "%"
                                  + "% of Total" + Double.toString(VWO.percentage));
                VNQoutput.setText("$" + Double.toString(VNQ.getAmount()) 
                                  + "   " + Double.toString(VNQ.calcPercentage()) + "%"
                                  + "% of Total" + Double.toString(VNQ.percentage));
                VTIoutput.setText("$" + Double.toString(VTI.getAmount()) 
                                  + "   " + Double.toString(VTI.calcPercentage()) + "%"
                                  + "% of Total" + Double.toString(VTI.percentage));
                
                totalOutput.setText("New Total: $" + Double.toString(total));
                
                
                 
                
                  
            }    
            
            catch(NumberFormatException ex){
                JOptionPane.showMessageDialog(null,ex +  "\nPlease enter valid numbers only");
                clearOutputLabels();
            }
            
//            outputBox.setText(String.format("%.2f", total));
                 VWOBbox.grabFocus();
                 
             }});   
 
 clearButton.addActionListener(
         new ActionListener(){
         public void actionPerformed (ActionEvent e){
                 clearBoxes();    
                 clearOutputLabels();
                 total = 0;
             }
         }
 );   
    

    VTIbox.addActionListener(
    new ActionListener(){
        public void actionPerformed (ActionEvent e){
            
        }});
    
   

}//end constructor

public class fund {
    
    private String name;
    private double amount, percentage,percentDiff;
    
    public fund(String name, double per){
        this.name = name;
        this.percentage = per;
    }
    
    public void setAmount(double newAmount){
        amount = newAmount;
    }
    
    public void setPercentage(double newPercentage){
        percentage = newPercentage;
    }
    
    public double getPercentage(){
        return percentage;
    }
       
    public String getFundName(){
        return name;
    }
    
    public double getAmount(){
       return amount;
    }
    
     public double calcPercentage(){
        percentDiff = ((amount / total) * 100) - (percentage * 100);
        percentDiff = (int)(percentDiff);
        return percentDiff;
    }
}

public void calcDisplayedValues(){
    
    total = Double.parseDouble(totalBox.getText());
       
    if(!VWOBbox.getText().equals("")){  
       VWOB.amount = Double.parseDouble(VWOBbox.getText());
       if(!addVWOB.getText().equals("")){
           VWOB.amount += Double.parseDouble(addVWOB.getText());
           total += Double.parseDouble(addVWOB.getText());
       }
       if(!vwobPercBox.getText().equals("")){
           VWOB.percentage = Double.parseDouble(vwobPercBox.getText());
       }
    }
    
    else if(!VEAbox.getText().equals("")){  
       VEA.amount = Double.parseDouble(VEAbox.getText());
       if(!addVEA.getText().equals("")){
           VEA.amount += Double.parseDouble(addVEA.getText());
           total += Double.parseDouble(addVEA.getText());
       }
       if(!veaPercBox.getText().equals("")){
           VEA.percentage = Double.parseDouble(veaPercBox.getText());
       }
    }
    
    else if(!VWObox.getText().equals("")){  
       VWO.amount = Double.parseDouble(VWObox.getText());
       if(!addVWO.getText().equals("")){
           VWO.amount += Double.parseDouble(addVWO.getText());
           total += Double.parseDouble(addVWO.getText());
       }
       if(!vwoPercBox.getText().equals("")){
           VWO.percentage = Double.parseDouble(vwoPercBox.getText());
       }
    }
    
    else if(!VNQbox.getText().equals("")){
       VNQ.amount = Double.parseDouble(VNQbox.getText());
       if(!addVNQ.getText().equals("")){
           VNQ.amount += Double.parseDouble(addVNQ.getText());
           total += Double.parseDouble(addVNQ.getText());
       }
       if(!vnqPercBox.getText().equals("")){
           VNQ.percentage = Double.parseDouble(vnqPercBox.getText());
       }
    }
    else if(!VTIbox.getText().equals("")){
       VTI.amount = Double.parseDouble(VTIbox.getText());
       if(!addVTI.getText().equals("")){
           VTI.amount += Double.parseDouble(addVTI.getText());
           total += Double.parseDouble(addVTI.getText());
       }
       if(!vtiPercBox.getText().equals("")){
           VTI.percentage = Double.parseDouble(vnqPercBox.getText());
       }
    }
    
  
}
    

   
    

    

public void clearOutputLabels(){
    VWOBoutput.setText("");
    VEAoutput.setText("");
    VWOoutput.setText("");
    VNQoutput.setText("");
    VTIoutput.setText("");  
    totalOutput.setText("");
    
}

public void clearBoxes(){
    VWOBbox.setText("");
    VTIbox.setText("");
    VEAbox.setText("");
    VWObox.setText("");
    VNQbox.setText("");
    VTIbox.setText("");  
    totalBox.setText("");
    
}
 
public static void main(String[] args) {
 
ira2 frame = new ira2();
frame.setSize(800, 600);
frame.pack();
frame.setVisible(true);
frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
frame.setLocationRelativeTo(null);


}
}
