package ATM;

import javax.swing.*;
import java.awt.*;

public class ThankYou extends JFrame implements Runnable {


    /*
    Over-riding the run method of the runnable interface
     */
    @Override
    public void run() {

        // Making an object of the thank you class
        ThankYou t1 = new ThankYou();
        t1.setVisible(true);
        // Sleep for 3 seconds
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        // Exit the system
        System.exit(0);
    }

    public ThankYou() {
        // Basic window stuff
        setTitle("Please Thanks");
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(500, 500);

        // Setting up the image background for the thank you window
        ImageIcon Image_Background = new ImageIcon("thankyou.png");
        Image Background = Image_Background.getImage();
        Image temp_Img = Background.getScaledInstance(500, 500, Image.SCALE_SMOOTH);
        Image_Background = new ImageIcon(temp_Img);

        // Adding a label and setting up the background
        JLabel label = new JLabel("", Image_Background, JLabel.CENTER);
        label.setBounds(0, 0, 535, 500);

        // Basic window gui stuff
        add(label);
        setLocationRelativeTo(null);
        setVisible(false);

    }

}
