// File name: Connect Four

// Written by: Elick Coval  
// Description: This program simulates the game Connect 4 where one player has 
//              to get 4 tokens in a row either vertically, horizontally, or
//              diagonally. Upon completion the program will display the winner
//              and reset the board.
//  
// Challenges: Figuring out how to check for a win was by far the hardest thing
//              it took a very long time and took away from some of the other
//              things I wanted to add to this program.
//
// Time Spent: 25 hrs
// Revision History:
// Date:        By:      Action:
// ---------------------------------------------------
/* 11/18/2016   EC      Started work on creating the board. Tried to make an 
 *                      array of panels but couldn't do it.
 * 
 * 11/23/2016   EC      Finished creating board, set up buttons and aligned.
 *                      Started work on button functionality.
 * 
 * 11/24/2016   EC      Buttons now work correctly, displaying opposite colors
 *                      per turn. Starting work on checking for a win every turn
 *
 * 11/31/2016   EC      Win check works vertically and horizontally but having 
 *                      trouble with diagonally.
 *
 * 12/9/2016    EC      Finally figured out diagonal win check, added board 
 *                      clear on win and exception handling.
 */
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class ConnectFour extends JPanel implements ActionListener {

    //create instance variables
    public static int Rows = 6, Columns = 7;
    private int Row = 5, Column = 0, player1 = 1, player2 = -1, winner = 0;
    private boolean turn = true, found = false;
    private Color color;
    private JButton Col0, Col1, Col2, Col3, Col4, Col5, Col6;
    private int board[][] = new int[Rows][Columns];

    public ConnectFour() {

        // set layout to null allowing button positioning
        setLayout(null);

        // add buttons and action listeners
        Col0 = new JButton("Drop");
        Col0.setBounds(50, 460, 60, 30);
        Col0.setFont(new Font("Arial", Font.BOLD, 11));
        Col0.addActionListener(this);
        add(Col0);

        Col1 = new JButton("Drop");
        Col1.setBounds(115, 460, 60, 30);
        Col1.setFont(new Font("Arial", Font.BOLD, 11));
        Col1.addActionListener(this);
        add(Col1);

        Col2 = new JButton("Drop");
        Col2.setBounds(180, 460, 60, 30);
        Col2.setFont(new Font("Arial", Font.BOLD, 11));
        Col2.addActionListener(this);
        add(Col2);

        Col3 = new JButton("Drop");
        Col3.setBounds(245, 460, 60, 30);
        Col3.setFont(new Font("Arial", Font.BOLD, 11));
        Col3.addActionListener(this);
        add(Col3);

        Col4 = new JButton("Drop");
        Col4.setBounds(310, 460, 60, 30);
        Col4.setFont(new Font("Arial", Font.BOLD, 11));
        Col4.addActionListener(this);
        add(Col4);

        Col5 = new JButton("Drop");
        Col5.setBounds(375, 460, 60, 30);
        Col5.setFont(new Font("Arial", Font.BOLD, 11));
        Col5.addActionListener(this);
        add(Col5);

        Col6 = new JButton("Drop");
        Col6.setBounds(440, 460, 60, 30);
        Col6.setFont(new Font("Arial", Font.BOLD, 11));
        Col6.addActionListener(this);
        add(Col6);

        // clear the board and array 
        
        initializeGame();

    }//end constructor

    // used to alternate players
    
    public int currentPlayer() {

        if (turn) {
            turn = false;
            return player1;
        } else {
            turn = true;
            return player2;
        }

    }
    
    // finds the next available row from the bottom

    public int nextAvailRow(int col) {

        for (int row = Rows - 1; row >= 0; row--) {
            if (board[row][col] == 0) {
                return row;
            }
        }

        return -1;
    }

    // button functionality
    
    public void actionPerformed(ActionEvent e) throws ArrayIndexOutOfBoundsException {
        try {
            if (e.getSource() == Col0) {
                Column = 0;
                Row = nextAvailRow(0);
                board[Row][Column] = currentPlayer();
                repaint();
                checkWinner(board, Row, Column);

            } else if (e.getSource() == Col1) {
                Column = 1;
                Row = nextAvailRow(1);
                board[Row][Column] = currentPlayer();
                repaint();
                checkWinner(board, Row, Column);

            } else if (e.getSource() == Col2) {
                Column = 2;
                Row = nextAvailRow(2);
                board[Row][Column] = currentPlayer();
                repaint();
                checkWinner(board, Row, Column);

            } else if (e.getSource() == Col3) {
                Column = 3;
                Row = nextAvailRow(3);
                board[Row][Column] = currentPlayer();
                repaint();
                checkWinner(board, Row, Column);

            } else if (e.getSource() == Col4) {
                Column = 4;
                Row = nextAvailRow(4);
                board[Row][Column] = currentPlayer();
                repaint();
                checkWinner(board, Row, Column);

            } else if (e.getSource() == Col5) {
                Column = 5;
                Row = nextAvailRow(5);
                board[Row][Column] = currentPlayer();
                repaint();
                checkWinner(board, Row, Column);

            } else if (e.getSource() == Col6) {
                Column = 6;
                Row = nextAvailRow(6);
                board[Row][Column] = currentPlayer();
                repaint();
                checkWinner(board, Row, Column);

            }
        } catch (ArrayIndexOutOfBoundsException error) {
            JOptionPane.showMessageDialog(null, "No more pieces can fit in that row! Try again");;
        }
    }

   // method for checking each row for a winner
    
    public int checkRow(int[][] piece) {
        for (int i = 0; i < Rows; i++) {
            for (int j = 0; j < Columns - 3; j++) {
                if (piece[i][j] == player1 && piece[i][j + 1] == player1 && piece[i][j + 2] == player1 && piece[i][j + 3] == player1) {
                    found = true;
                    return player1;
                } else if (piece[i][j] == player2 && piece[i][j + 1] == player2 && piece[i][j + 2] == player2 && piece[i][j + 3] == player2) {
                    found = true;
                    return player2;
                }
            }
        }
        return 0;
    }

    //method for checking each column for a winner
    
    public int checkCol(int[][] piece) {

        for (int i = 0; i < Rows - 3; i++) {
            for (int j = 0; j < Columns; j++) {
                if (piece[i][j] == player1 && piece[i + 1][j] == player1 && piece[i + 2][j] == player1 && piece[i + 3][j] == player1) {
                    found = true;
                    return player1;
                } else if (piece[i][j] == player2 && piece[i + 1][j] == player2 && piece[i + 2][j] == player2 && piece[i + 3][j] == player2) {
                    found = true;
                    return player2;
                }
            }
        }
        return 0;
    }

    // method for checking for winners ascending diagonally
    
    public int checkDiagUp(int[][] piece) {

        for (int i = 3; i < Rows; i++) {
            for (int j = 0; j < Columns - 3; j++) {
                if (piece[i][j] == player1 && piece[i - 1][j + 1] == player1 && piece[i - 2][j + 2] == player1 && piece[i - 3][j + 3] == player1) {
                    found = true;
                    return player1;
                } else if (piece[i][j] == player2 && piece[i - 1][j + 1] == player2 && piece[i - 2][j + 2] == player2 && piece[i - 3][j + 3] == player2) {
                    found = true;
                    return player2;
                }
            }
        }
        return 0;
    }

    // method for checking for winners descending diagonally
    
    public int checkDiagDown(int[][] piece) {

        for (int i = 3; i < Rows; i++) {
            for (int j = 3; j < Columns; j++) {
                if (piece[i][j] == player1 && piece[i - 1][j - 1] == player1 && piece[i - 2][j - 2] == player1 && piece[i - 3][j - 3] == player1) {
                    found = true;
                    return player1;
                } else if (piece[i][j] == player2 && piece[i - 1][j - 1] == player2 && piece[i - 2][j - 2] == player2 && piece[i - 3][j - 3] == player2) {
                    found = true;
                    return player2;
                }
            }
        }
        return 0;
    }
    
    // comes here after button click, checks for a winner

    public void checkWinner(int[][] piece, int currRow, int currCol) {

        //while (!found) {
            winner = checkRow(piece);
           //  if (found) {
//                 break;
//             }
            winner = checkCol(piece);
          //   if (found) {
//                 break;
//             }
            winner = checkDiagUp(piece);
          //   if (found) {
//                 break;
//             }
            winner = checkDiagDown(piece);
         //    if (found) {
//                 break;
//             }
            //break;
       // }
        
        // if there is a winner, display message and reset board

        if (winner == player1) {
            JOptionPane.showMessageDialog(null, "Red wins! CONGRATULATIONS!!!");
            initializeGame();
            repaint();
        } else if (winner == player2) {
            JOptionPane.showMessageDialog(null, "Black wins! CONGRATULATIONS!!!");
            initializeGame();
            repaint();
        }
    }

    // clear the board array
    
    public void initializeGame() {

        for (int i = 0; i < Rows; i++) {
            for (int j = 0; j < Columns; j++) {
                board[i][j] = 0;
            }
        }
        found = false;
        turn = true;
    }
    
     // set the background color and call drawBoard
    
    public void paintComponent(Graphics g) {

        super.paintComponent(g);

        setBackground(Color.BLUE);

        this.drawBoard(g);

    }//end method paint


    //draw the correct color of the pieces depending on the array
    
    public void checkColor(int location) {
        switch (location) {
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

    // draw the board and pieces
    
    public void drawBoard(Graphics g) {

        int xPos = 50;
        int yPos = 50;

        for (int i = 0; i < Rows; i++) {
            for (int j = 0; j < Columns; j++) {
                checkColor(board[i][j]);
                g.setColor(color);
                g.fillOval(xPos, yPos, 60, 60);
                xPos += 65;
            }
            yPos += 65;
            xPos = 50;
        }

    }
    
    //start main method

    public static void main(String args[]) {
        JFrame frame = new JFrame("Connect 4");
        ConnectFour draw = new ConnectFour();
        frame.add(draw);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 600);
        frame.setVisible(true);

    }//end main method
}
