// File name: Draw Shapes

// Written by: Elick Coval  
// Description: This program allows the user to draw different shapes within the
//              window. When the user clicks on a different shape, the filled
//              box, or changes the color, the change is reflected instantly on
//              the screen.
//  
// Challenges: Getting the shape to display correct going to and from different
//             quadrants was definitely a challenge. Initially getting the 
//             starting x and y values took a little time. But getting starting
//             upper left point for the shapes took the most time.
//
// Time Spent: 10.5hrs
// Revision History:
// Date:        By:      Action:
// ---------------------------------------------------
/* 10/28/2016   EC      Set up GUI, decided that the buttons looked better sort
 *                      of floating at the top, more immersive.
 * 
 * 10/30/2016   EC      Created logic for selected correct shape and whether to
 *                      fill or not. Struggling with clicking to and from
 *                      quadrants other than 2 to 4.
 * 
 * 10/31/2016   EC      Figured out the quadrant issue once I thought it through
 *                      and put cleaned up the code a little, created seperate
 *                      methods for flipping X and Y and added the adjustments. 
 *
 * 11/1/2016    EC      Thinking about how I can implement this polymorphically
 *                      instead of using if-else logic structure.
 */
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class DrawShapes extends JPanel {

    //create class variables
    private int startX, startY, height, width, endX, endY, hold;
    private JPanel panel;
    private JComboBox<String> shapes;
    private JCheckBox filledBox;
    private JButton pickColorJButton;
    private String pickedShape;
    private Color color = Color.RED;
    private boolean pressed = false, filled = false;

    // start constructor
    public DrawShapes() {
        
        setBackground(Color.BLACK);

        // set up shape combo box
        shapes = new JComboBox();
        shapes.addItem("Line");
        shapes.addItem("Rectangle");
        shapes.addItem("Square");
        shapes.addItem("Round Rectangle");
        shapes.addItem("Oval");
        shapes.addItem("Circle");

        // add item listener to combo box to change shape when clicked
        shapes.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent event) {
                if (event.getStateChange() == ItemEvent.SELECTED) {
                    pickedShape = (String) shapes.getSelectedItem();
                }
            }
        });

        // set up filled check box
        filledBox = new JCheckBox("Filled");
        filledBox.addItemListener(new ItemListener() // anonymous inner class
        {

            public void itemStateChanged(ItemEvent event) {
                if (filledBox.isSelected()) {
                    filled = true;
                } else {
                    filled = false;
                }
                repaint();
            }
        });
        // set up pickColorJButton and register its event handler
        pickColorJButton = new JButton("Pick Color");
        pickColorJButton.addActionListener(
                new ActionListener() // anonymous inner class
        {
            // display JColorChooser when user clicks button
            public void actionPerformed(ActionEvent event) {
                color = JColorChooser.showDialog(
                        null, "Pick Color", color);
                // set default color, if no color is returned
                if (color == null) {
                    color = Color.LIGHT_GRAY;
                }
            } // end method actionPerformed
        } // end anonymous inner class
        ); // end call to addActionListener

        // add components to JPanel
        panel = new JPanel();
        panel.add(shapes);
        panel.add(pickColorJButton);
        panel.add(filledBox);
        panel.setBackground(Color.BLACK);

        // collect X and Y when mouse is pressed
        addMouseListener(
                new MouseAdapter() {
            public void mousePressed(MouseEvent event) {
                startX = event.getX();
                startY = event.getY();
                pressed = true;
            }
        // collect X and Y when mouse is released    
            public void mouseReleased(MouseEvent event) {
                endX = event.getX();
                endY = event.getY();
                repaint();
            }
        });
        
        // add the GUI components to the top of the screen
        add(panel, BorderLayout.NORTH); // add button

    }//end constructor
    
    // method for flipping shape on X axis and adjusting the width
    public void flipXAndAdjustLength() {
        hold = endX;
        endX = startX;
        startX = hold;
        width = Math.abs(endX - startX);
    }
    
    // method for flipping shape on Y axis and adjusting the height
    public void flipYAndAdjustHeight() {
        hold = endY;
        endY = startY;
        startY = hold;
        height = Math.abs(endY - startY);
    }

    // method for adjusting the coordinates of the top left for correct shape attributes
    public void getCoordinates() {
        
        // if shape is a line do nothing, otherwise flip correctly
        if (pickedShape != "Line") {

            height = Math.abs(endY - startY);
            width = Math.abs(endX - startX);
            
            // from quadrant 3 to 2
            if (startY > endY && startX < endX) {
                flipYAndAdjustHeight();
            }
            
            // from quadrant 2 to 3
            if (startX > endX && startY < endY) {
                flipXAndAdjustLength();
            }
            
            // from quadrant 4 to 1
            if (startX > endX && startY > endY) {
                flipXAndAdjustLength();
                flipYAndAdjustHeight();
            }
            // make sure squares and circles have the same width and height
            if (pickedShape == "Square" || pickedShape == "Circle") {
                if (width < height) {
                    width = height;
                }
            }
        }
    }

    // draw shape
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        
        // set shape color from JColorChooser or red by default
        g.setColor(color);
        
        // only draw shape if user released button
        if (!pressed) {

            getCoordinates();
            
            // logic for choosing which shape to draw and whether to fill
            if (pickedShape == "Rectangle" && !filled) {
                g.drawRect(startX, startY, width, height);
            } else if (pickedShape == "Rectangle" && filled) {
                g.fillRect(startX, startY, width, height);
            } else if (pickedShape == "Square" && !filled) {
                g.drawRect(startX, startY, width, width);
            } else if (pickedShape == "Square" && filled) {
                g.fillRect(startX, startY, width, width);
            } else if (pickedShape == "Round Rectangle" && !filled) {
                g.drawRoundRect(startX, startY, width, height, 50, 50);
            } else if (pickedShape == "Round Rectangle" && filled) {
                g.fillRoundRect(startX, startY, width, height, 50, 50);
            } else if (pickedShape == "Oval" && !filled) {
                g.drawOval(startX, startY, width, height);
            } else if (pickedShape == "Oval" && filled) {
                g.fillOval(startX, startY, width, height);
            } else if (pickedShape == "Circle" && !filled) {
                g.drawOval(startX, startY, width, width);
            } else if (pickedShape == "Circle" && filled) {
                g.fillOval(startX, startY, width, width);
            } else {
                g.drawLine(startX, startY, endX, endY);
            }
            repaint();
        }
        pressed = false;
    }//end method paint

    //start main method
    public static void main(String args[]) {
        JFrame application = new JFrame("Draw Shapes");
        DrawShapes draw = new DrawShapes();
        application.add(draw);
        application.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        application.setSize(800, 600);
        application.setVisible(true);
    }//end main method
}
