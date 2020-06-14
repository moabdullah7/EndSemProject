package ATM;

import ExceptionHandler.InputIncorrectException;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.awt.image.RenderedImage;
import java.io.File;
import java.io.IOException;

public class SignaturePad extends RegisteringPage {

    /*
    Constructor of the signature pad that will take user name as parameter
    and saving the user signature in a seperate gui window
     */
    public SignaturePad(String s) {

        // Initializing the frame
        JFrame frame = new JFrame("Signature Pad!");
        // A drawpad that is used for drawing
        final DrawPad drawPad = new DrawPad();
        frame.add(drawPad, BorderLayout.CENTER);


        // Adding a clear button
        JButton clearButton = new JButton("Clear");
        /*
        Adding an action listener that will erase all the
        stuff on the draw pad
         */
        clearButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                drawPad.clear();
            }
        });

        // Adding a save button
        JButton saveButton = new JButton("Save");
        /*
        Adding an action listener that will save all the
        stuff on the draw pad
         */
        saveButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                // If is username is empty then throw an error message
                if (s.isEmpty()){
                    try {
                        throw new InputIncorrectException();
                    } catch (InputIncorrectException ex) {
                        JOptionPane.showMessageDialog(null, "Enter Username First");
                    }
                }
                // save the drawpad
                else
                    {
                    drawPad.save(s);
                    frame.setVisible(false);
                }
            }
        });

        // Save all the stuff on the window w
        frame.add(clearButton, BorderLayout.SOUTH);
        frame.add(saveButton, BorderLayout.NORTH);
        frame.setSize(400, 400);
        frame.setResizable(false);
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);
    }

}
class DrawPad extends JComponent {

    // All built-in features of the drawPad that is used for drawing
    BufferedImage image;
    Graphics2D graphics2D;
    int currentX, currentY, oldX, oldY;

    /*
    Constructor that gets the initial point and the final point
    and then draw a line with the help of graphics 2D
    on the drawpad
     */
    public DrawPad() {
        setDoubleBuffered(false);
        addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent e) {
                oldX = e.getX();
                oldY = e.getY();
            }
        });
        addMouseMotionListener(new MouseMotionAdapter() {
            public void mouseDragged(MouseEvent e) {
                currentX = e.getX();
                currentY = e.getY();
                if (graphics2D != null)
                    graphics2D.drawLine(oldX, oldY, currentX, currentY);
                repaint();
                oldX = currentX;
                oldY = currentY;
            }
        });
    }

    // Paint components of the drawpad that is used for basic height, width stuff
    public void paintComponent(Graphics g) {
        if (image == null) {
            image = new BufferedImage(getSize().width, getSize().height, BufferedImage.TYPE_INT_RGB);
            graphics2D = image.createGraphics();
            graphics2D.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                    RenderingHints.VALUE_ANTIALIAS_ON);
            clear();
        }
        g.drawImage(image, 0, 0, null);
    }

    // Clear that will clear all the lines and stuff on the drawpad
    public void clear() {
        graphics2D.setPaint(Color.white);
        graphics2D.fillRect(0, 0, getSize().width, getSize().height);
        graphics2D.setPaint(Color.black);
        repaint();
    }

    /*
    Save image function that will save the signature of each user based on their username
     */
    public void save(String saveNumber){
        RenderedImage rendImage = image;

        // Saving format
        File file = new File("Signature" + saveNumber + ".jpg");
        try {
            ImageIO.write(rendImage, "jpg", file);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}

