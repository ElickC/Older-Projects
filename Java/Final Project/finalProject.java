 
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class finalProject extends JPanel implements ActionListener {

    //private final GridLayout layout;
    
    public static int Rows = 6, Columns = 7;
    
    //create instance variables
    
    private int Row, Column, player = 0;
    private boolean turn = true;
    private Color color;
    private JButton Col0,Col1,Col2,Col3,Col4,Col5,Col6;
    private int board[][] = new int[Rows][Columns];
   
    public finalProject() {
        
        
        setLayout(null);
       
        Col0 = new JButton("Drop");
        Col0.setBounds(50,460,60,30);
        Col0.setFont(new Font("Arial", Font.BOLD, 11));
        Col0.addActionListener(this);
        add(Col0);
                
        Col1 = new JButton("Drop");
        Col1.setBounds(115,460,60,30);
        Col1.setFont(new Font("Arial", Font.BOLD, 11));
        Col1.addActionListener(this);
        add(Col1);
                
        Col2 = new JButton("Drop");
        Col2.setBounds(180,460,60,30);
        Col2.setFont(new Font("Arial", Font.BOLD, 11));
        Col2.addActionListener(this);
        add(Col2);
        
        Col3 = new JButton("Drop");
        Col3.setBounds(245,460,60,30);
        Col3.setFont(new Font("Arial", Font.BOLD, 11));
        Col3.addActionListener(this);
        add(Col3);
        
        Col4 = new JButton("Drop");
        Col4.setBounds(310,460,60,30);
        Col4.setFont(new Font("Arial", Font.BOLD, 11));
        Col4.addActionListener(this);
        add(Col4);
        
        Col5 = new JButton("Drop");
        Col5.setBounds(375,460,60,30);
        Col5.setFont(new Font("Arial", Font.BOLD, 11));
        Col5.addActionListener(this);
        add(Col5);
        
        Col6 = new JButton("Drop");
        Col6.setBounds(440,460,60,30);
        Col6.setFont(new Font("Arial", Font.BOLD, 11));
        Col6.addActionListener(this);
        add(Col6);
        
        
       
        
       
    }//end constructor
    
 
    public int currentPlayer(){
        if(turn){
            turn = false;
            return 1;
        }
        else{
            turn = true;
            Col0.doClick();
            return -1;
        }      
            
    }

    public void actionPerformed(ActionEvent e) { 
             if(e.getSource() == Col0){
                 Row = 5;
                 while (board[Row][0] != 0){
                    Row--;}
                 board[Row][0] = currentPlayer();
                 
                 repaint();
             }
             else if (e.getSource() == Col1){
                 Row = 5;
                 while (board[Row][1] != 0){
                    Row--;}
                 board[Row][1] = currentPlayer();
                 repaint();
             }
             else if (e.getSource() == Col2){
                 Row = 5;
                 while (board[Row][2] != 0){
                    Row--;}
                 board[Row][2] = currentPlayer();
                 repaint();
             }
             else if (e.getSource() == Col3){
                 Row = 5;
                 while (board[Row][3] != 0){
                    Row--;}
                 board[Row][3] = currentPlayer();
                 repaint();
             }
             else if (e.getSource() == Col4){
                 Row = 5;
                 while (board[Row][4] != 0){
                    Row--;}
                 board[Row][4] = currentPlayer();
                 repaint();
             }
             else if (e.getSource() == Col5){
                 Row = 5;
                 while (board[Row][5] != 0){
                    Row--;}
                 board[Row][5] = currentPlayer();
                 repaint();
             }
             else if (e.getSource() == Col6){
                 Row = 5;
                 while (board[Row][6] != 0){
                    Row--;}
                 board[Row][6] = currentPlayer();
                 repaint();
             }
            
        }
    
    public void paintComponent(Graphics g) {
        
        super.paintComponent(g);
        
            setBackground(Color.BLUE);
            g.setColor(Color.RED);
    
            this.drawBoard(g);
          
           
    }//end method paint
    
    public void initializeGame(){
        
        for (int i = 0; i < Rows; i++){
            for (int j = 0; j < Columns; j++){
                board[i][j] = 0;
            }
    }
    
    }
    public void checkColor(int location){
        switch(location){
                case 0:
                    color = Color.WHITE;
                    break;
                case 1:
                    color = Color.RED;
                    break;
                case -1:
                    color = Color.BLACK;
                    break;
            }
    }
    
    public void drawBoard(Graphics g){
        
        int xPos = 50;
        int yPos = 50;
        
        for (int i = 0; i < Rows; i++){
            for (int j = 0; j < Columns; j++){
                checkColor(board[i][j]);
                g.setColor(color);
                g.fillOval(xPos, yPos, 60, 60);
                xPos += 65;
        }
        yPos += 65;
        xPos = 50;
        }
     
    
        
    }

    public static void main(String args[]) {
      JFrame frame = new JFrame("Connect 4");
        finalProject draw = new finalProject();
        frame.add(draw);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 600);
        frame.setVisible(true);
        
    }//end main method
}

/* Assignment3 frame = new Assignment3();
frame.pack();
frame.setVisible(true);
frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
frame.setLocationRelativeTo(null);


 JFrame application = new JFrame("Draw Shapes");
        Assignment4 draw = new Assignment4();
        application.add(draw);
        application.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        application.setSize(1200, 700);
        application.setVisible(true);    */