package ATM;

import BackEnd.Bank;

import javax.swing.*;
import java.awt.*;

public class OpeningGUI extends Bank {

    //initializing the JFrame for the opening window
    private JFrame OpeningJFrame = new JFrame();

    /* Initializing the bank object in the
    constructor cause it will use all the bank methods
    throughout the project
     */
    public void OpeningGUI() {

        Bank B = new Bank();
    }

    /* Method that handles the working of the
    window and the gui components
     */
    public void ShowOpeningGUI(){

        // Basic setting of the window
        OpeningJFrame.setTitle("ATM Simulator");
        OpeningJFrame.setResizable(false);
        OpeningJFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        OpeningJFrame.setSize(500, 500);


        // inserting the background of the window here
        ImageIcon Image_Background = new ImageIcon("welcome2.png");
        Image Background = Image_Background.getImage();
        Image temp_Img = Background.getScaledInstance(490, 490, Image.SCALE_SMOOTH);
        Image_Background = new ImageIcon(temp_Img);


        // adding JJLabel to insert the background
        JLabel label = new JLabel("", Image_Background, JLabel.CENTER);
        label.setBounds(0, 0, 500, 500);

        // adding the label to the window
        OpeningJFrame.add(label);
        OpeningJFrame.setLocationRelativeTo(null);
        OpeningJFrame.setVisible(true);

    }

    /* method that hides the
    opening  window
     */
    public void HideOpeningGUI() {

        OpeningJFrame.setVisible(false);
    }

}