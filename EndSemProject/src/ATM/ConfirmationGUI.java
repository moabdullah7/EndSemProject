package ATM;

import BackEnd.UserData;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ConfirmationGUI extends LoginWindow{

    // initializing the frame, and the user data object
    private JFrame frame = new JFrame();
    private UserData Transferred_Data;

    // Setting up the constructor
    public ConfirmationGUI(UserData UD){

        this.Transferred_Data = UD;
    }

    /*
    The Method that will handle the entire working of the
    Confirmation GUI window
     */
    public void showConfirmationGUI(){

        // Setting up the basic window stuff
        frame.setTitle("ATM Simulator");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 500);
        frame.setResizable(false);
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);

        // Image setting up
        ImageIcon Image_Background = new ImageIcon("confirmation.png");
        Image Background = Image_Background.getImage();
        Image temp_Img = Background.getScaledInstance(500, 500, Image.SCALE_SMOOTH);
        Image_Background = new ImageIcon(temp_Img);

        // Adding the label and setting up the background image
        JLabel label = new JLabel("", Image_Background, JLabel.CENTER);
        label.setBounds(0, 0, 500, 500);

        // Making a panel that will display the user information
        JPanel confirmationPanel = new JPanel();
        confirmationPanel.setLayout(null);
        confirmationPanel.setSize(250, 150);
        confirmationPanel.setBounds(50, 10, 400, 350);
        confirmationPanel.setBackground(new Color(129,211,228));
        frame.add(confirmationPanel);

        // Adding font
        Font font = new Font("Times new Roman",Font.ITALIC|Font.BOLD,18);

        // Adding font
        Font font1 = new Font("Times new Roman",Font.BOLD,20);

        // Adding the label displaying the following message
        JLabel info = new JLabel("Account Details are as Follows");
        info.setBounds(40,50,400,30);
        info.setBackground(new Color(12,104,124));
        info.setForeground(new Color(12,104,124));
        info.setFont(font1);

        // Displaying user data user full name
        JLabel name = new JLabel("Full Name:    "+Transferred_Data.getFull_name());
        name.setBounds(50,100,400,30);
        name.setBackground(new Color(12,104,124));
        name.setForeground(new Color(12,104,124));
        name.setFont(font);

        // Displaying user data user, user name
        JLabel username = new JLabel("Username:    "+(Transferred_Data.getUsername()));
        username.setBounds(50,130,400,30);
        username.setBackground(new Color(12,104,124));
        username.setForeground(new Color(12,104,124));
        username.setFont(font);

        // Displaying user data user address
        JLabel address = new JLabel("Address:    "+Transferred_Data.getAddress());
        address.setBounds(50,160,400,30);
        address.setBackground(new Color(12,104,124));
        address.setForeground(new Color(12,104,124));
        address.setFont(font);

        // Displaying user data user phone number
        JLabel number = new JLabel("Phone Number:    "+Transferred_Data.getPhoneNumber());
        number.setBounds(50,190,400,30);
        number.setBackground(new Color(12,104,124));
        number.setForeground(new Color(12,104,124));
        number.setFont(font);

        // Displaying user data user balance
        JLabel Balance = new JLabel("Balance:    " + Transferred_Data.getBalance());
        Balance.setBounds(50,220,400,30);
        Balance.setBackground(new Color(12,104,124));
        Balance.setForeground(new Color(12,104,124));
        Balance.setFont(font);

        // Displaying user data user account type
        JLabel account_type = new JLabel("Account Type:    " + Transferred_Data.getAccount_Type());
        account_type.setBounds(50,250,400,30);
        account_type.setBackground(new Color(12,104,124));
        account_type.setForeground(new Color(12,104,124));
        account_type.setFont(font);

        // Adding all the buttons and labels in the window
        confirmationPanel.add(name);
        confirmationPanel.add(username);
        confirmationPanel.add(address);
        confirmationPanel.add(number);
        confirmationPanel.add(Balance);
        confirmationPanel.add(info);
        confirmationPanel.add(account_type);

        // Adding the home button
        JButton home = new JButton("Home");
        home.setBounds(280,400,160,35);

        // Adding the action listener for the home button
        home.addActionListener(new ActionListener() {
            @Override
            // Displaying the home window
            public void actionPerformed(ActionEvent e) {

                hideConfirmationGUI();
                Home home = new Home();
                home.showHome();

            }
        });

        frame.add(home);

        // Adding the exit button
        JButton exit = new JButton("Exit");
        exit.setBounds(80,400,160,35);

        // Adding the action listener for the exit button that will exit the system
        exit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                hideConfirmationGUI();
                System.exit(0);
            }

        });

        // Adding the buttons
        frame.add(exit);
        frame.add(label);
    }

    /*
    Method that will hide the
    Confirmation Window
     */
    public void hideConfirmationGUI(){

        frame.setVisible(false);
    }
}
