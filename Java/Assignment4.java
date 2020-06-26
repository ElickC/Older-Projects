
import java.awt.*;
//import java.awt.event.MouseMotionAdapter;
import java.awt.event.MouseEvent;
import java.awt.Graphics;
import java.awt.event.*;
import javax.swing.*;

public class Assignment4 extends JPanel {

    //create instant variables
    private int startX, startY, height, length, endX, endY, hold;
    private JPanel panel;
    private JComboBox<String> shapes;
    private JCheckBox filledBox;
    private JButton pickColorJButton;
    private String pickedShape = "";
    private Color color = Color.RED;
    private boolean pressed = false, filled = false, reversed = false;

    //private final ArrayList<Point> points = new ArrayList<>();
    public Assignment4() {

        setBackground(Color.BLACK);

        shapes = new JComboBox();
        shapes.addItem("Line");
        shapes.addItem("Rectangle");
        shapes.addItem("Square");
        shapes.addItem("Round Rectangle");
        shapes.addItem("Oval");
        shapes.addItem("Circle");

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
            // display JColorChooser when user clicks button
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

        addMouseListener(
                new MouseAdapter() {
            public void mousePressed(MouseEvent event) {
                startX = event.getX();
                startY = event.getY();
                pressed = true;
            }

            public void mouseReleased(MouseEvent event) {
                endX = event.getX();
                endY = event.getY();
                    repaint();
            }
        });
        setLayout(new BorderLayout());
        //  add(drawJPanel, BorderLayout.CENTER ); // add colorJPanel
        add(panel, BorderLayout.NORTH); // add button

    }//end constructor
    public void flipX(){
        
    }
    public void flipY(){
        
    }
    public void getCoords() {
        if (pickedShape == "Circle" || pickedShape == "Oval") {
                length = Math.abs(endX - startX);
                height = Math.abs(endY - startY);
                if (length < height)
                length = height;
            } else {
                length = Math.abs(endX - startX);
                height = Math.abs(endY - startY);
                
                if(startY > endY){
                    
                   startY -= height;
                    height = endY-startY  ;
                    
                }   
                
                if (pickedShape == "Square"){
                    if (length < height) {
                    length = height;
                }}
            }
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(color);
        
        getCoords();

        if (!pressed) {
            if (pickedShape == "Rectangle" && !filled) {
                g.drawRect(startX, startY, length, height);
            } else if (pickedShape == "Rectangle" && filled) {
                g.fillRect(startX, startY, length, height);
            } else if (pickedShape == "Square" && !filled) {
                g.drawRect(startX, startY, length, length);
            } else if (pickedShape == "Square" && filled) {
                g.fillRect(startX, startY, length, length);
            } else if (pickedShape == "Round Rectangle" && !filled) {
                g.drawRoundRect(startX, startY, length, height, 50, 50);
            } else if (pickedShape == "Round Rectangle" && filled) {
                g.fillRoundRect(startX, startY, length, height, 50, 50);
            } else if (pickedShape == "Oval" && !filled) {
                g.drawOval(startX, startY, length, height);
            } else if (pickedShape == "Oval" && filled) {
                g.fillOval(startX, startY, length, height);
            } else if (pickedShape == "Circle" && !filled) {
                g.drawOval(startX, startY, length, length);
            } else if (pickedShape == "Circle" && filled) 
                g.fillOval(startX, startY, length, length);
             else {
                g.drawLine(startX, startY, endX, endY);
            }
            repaint();
        }
        pressed = false;
    }//end method paint

    public static void main(String args[]) {
        JFrame application = new JFrame("Draw Oval");
        Assignment4 doa = new Assignment4();
        application.add(doa);
        application.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        application.setSize(500, 400);
        application.setVisible(true);
    }//end main method
}

//
//hold = startX;
//        startX = endX;
//        endX = hold;
//        hold = startY;
//        startY = endY;
//        endY = hold;