package ATM;

import BackEnd.UserData;
import ExceptionHandler.InputIncorrectException;
import ExceptionHandler.Validation;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DepositGUI extends LoginWindow {

    // initializing the frames and userdata object
    private JFrame Deposit_page = new JFrame();
    private UserData Transferred_Data;

    /*
     Adding the UserData object in the constructor so every calculation
     has it's own affect in the constructor when it's object is built
     */
    public DepositGUI(UserData UD) {

        this.Transferred_Data = UD;
    }

    /*
    Method that will handle the entire working of the withdraw window
     */
    public void showDepositGUI() {

        // Basic setting of the window
        Deposit_page.setTitle("ATM Simulator");
        Deposit_page.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Deposit_page.setSize(500, 500);
        Deposit_page.setResizable(false);
        Deposit_page.setVisible(true);
        Deposit_page.setLocationRelativeTo(null);

        // Adding a text field for the desired amount
        JTextField deposit = new JTextField("");
        deposit.setBounds(170,200,180,30);
        deposit.setBackground(new Color(12,104,124));
        deposit.setForeground(new Color(158,199,252));
        Deposit_page.add(deposit);

        // Setting up the font
        Font font = new Font("Times new Roman",Font.ITALIC|Font.BOLD,20);

        // Adding the label for deposit prompt text
        JLabel depositPrompt = new JLabel("Enter Deposit Amount");
        depositPrompt.setBounds(150,150,300,30);
        depositPrompt.setBackground(new Color(12,104,124));
        depositPrompt.setForeground(new Color(158,199,252));
        depositPrompt.setFont(font);
        Deposit_page.add(depositPrompt);

        // Adding the confirm button
        JButton Confirm = new JButton("Confirm");
        Confirm.setBounds(280,350,160,35);

        /*
        Setting up the action listener for the confirm button
         */
        Confirm.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                // if empty, display the following message
                if ((deposit.getText().isEmpty())) {
                    JOptionPane.showMessageDialog(null, "Please Enter Desired Values");
                }

                 /*
                Making sure that deposit amount is less than a specified amount through the Balance  check method
                of the Validation Class, if yes then add the following amount with the help of UserData class
                and updating the Amounts in Balance Inquiry class
                 */
                else
                    {
                    try{
                        Validation.Balance_Check(deposit.getText());
                        float previousBalance = Transferred_Data.getBalance();
                        Transferred_Data.setBalance(Transferred_Data.getBalance() + Integer.parseInt(deposit.getText()));
                        hideDepositGUI();
                        BalanceInquiryGUI BI = new BalanceInquiryGUI(Transferred_Data,previousBalance);
                        BI.showBalanceInquiry();

                    }
                    /*
                    Error message incase of invalid entry
                     */
                    catch (InputIncorrectException exception)
                    {
                        JOptionPane.showMessageDialog(null, "Enter a valid amount");
                    }

                }
            }
        });

        // Adding the Back button
        JButton back = new JButton("Back");
        back.setBounds(80,350,160,35);

         /*
        Adding the action listener that will make the window back to the Login window
         */
        back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                showLoginWindow(Transferred_Data);
                hideDepositGUI();
            }
        });

        // Adding the buttons
        Deposit_page.add(Confirm);
        Deposit_page.add(back);


        // Setting up the background image
        ImageIcon Image_Background = new ImageIcon("deposit.png");
        Image Background =  Image_Background.getImage();
        Image temp_Img = Background.getScaledInstance(535,500, Image.SCALE_SMOOTH);
        Image_Background = new ImageIcon(temp_Img);

        // Adding the image with Label
        JLabel label = new JLabel("", Image_Background, JLabel.CENTER);
        label.setBounds(0,0,500,500);

        // Adding the label
        Deposit_page.add(label);
    }

    /*
    Method that will hide the
    Withdraw Window
     */
    public void hideDepositGUI() {

        Deposit_page.setVisible(false);
    }

}