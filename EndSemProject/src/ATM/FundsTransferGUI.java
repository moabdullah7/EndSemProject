package ATM;

import BackEnd.UserData;
import ExceptionHandler.InputIncorrectException;
import ExceptionHandler.Validation;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FundsTransferGUI extends LoginWindow {

    // Initializing the frame and the user data object
    private JFrame Fund_transfer_page = new JFrame();
    private UserData Transferred_Data;

    /*
    Constructor containing the user data object
     */
    public FundsTransferGUI(UserData UD) {

        this.Transferred_Data = UD;
    }


    /*
    Method that will handle the entire working of the window
     */
    public void showFundsTransferGUI() {

        // Basic Settings of the window
        Fund_transfer_page.setTitle("ATM Simulator");
        Fund_transfer_page.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Fund_transfer_page.setSize(500, 500);
        Fund_transfer_page.setResizable(false);
        Fund_transfer_page.setVisible(true);
        Fund_transfer_page.setLocationRelativeTo(null);


        // Adding a new Text field that will ask for the account number
        JTextField toAccount = new JTextField("");
        toAccount.setBounds(160,148,180,30);
        toAccount.setBackground(new Color(12,104,124));
        toAccount.setForeground(new Color(158,199,252));
        Fund_transfer_page.add(toAccount);

        // Adding the font
        Font font = new Font("Cursive", Font.ITALIC, 18);

        // Adding the Label for the following text
        JLabel toAccountPrompt = new JLabel("Enter Amount");
        toAccountPrompt.setBounds(160,110,300,30);
        toAccountPrompt.setBackground(new Color(12,104,124));
        toAccountPrompt.setForeground(new Color(158,199,252));
        toAccountPrompt.setFont(font);
        Fund_transfer_page.add(toAccountPrompt);

        // Adding a new Text field that will ask for the amount
        JTextField toAmount = new JTextField("");
        toAmount.setBounds(150,260,180,30);
        toAmount.setBackground(new Color(12,104,124));
        toAmount.setForeground(new Color(158,199,252));
        Fund_transfer_page.add(toAmount);

        // Adding the Label for the following text
        JLabel toAmountPrompt = new JLabel("Enter Account No.");
        toAmountPrompt.setBounds(150,230,300,30);
        toAmountPrompt.setBackground(new Color(12,104,124));
        toAmountPrompt.setForeground(new Color(158,199,252));
        toAmountPrompt.setFont(font);
        Fund_transfer_page.add(toAmountPrompt);

        // Adding the confirm button
        JButton Confirm = new JButton("Confirm");
        Confirm.setBounds(280, 350, 160, 35);

        /*
        Setting up the action listener for the Confirm button
         */
        Confirm.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                // If empty show the following message
                if ((toAccount.getText().isEmpty()) || (toAmount.getText().isEmpty())) {

                    JOptionPane.showMessageDialog(null, "Please Enter Desired Values");

                }
                else // Checking all the conditions that's required in order for that transfer
                // of money to happen
                    {

                    try
                    {
                        Validation.PinCodeValidator(toAccount.getText());
                    }
                    // In case of error, show the following message
                    catch (InputIncorrectException exception){
                        JOptionPane.showMessageDialog(null, "Enter a valid account number.");
                    }

                    /*
                    If amount is greater than current throw an error message, else deduct the amount
                     */
                    try
                    {
                        Validation.Balance_Update_Check(  (int) Transferred_Data.getBalance(), Integer.parseInt(toAmount.getText()));
                        float previousBalance = Transferred_Data.getBalance();
                        Transferred_Data.setBalance(Transferred_Data.getBalance() - Integer.parseInt(toAmount.getText()));
                        hideFundsTransferGUI();
                        BalanceInquiryGUI BI = new BalanceInquiryGUI(Transferred_Data,previousBalance);
                        BI.showBalanceInquiry();

                    }
                    // Show the following message in case of excessive amount
                    catch (InputIncorrectException exception){

                        JOptionPane.showMessageDialog(null, "You do not have sufficient balance.");
                    }


                }

            }
        });

        // Adding the Back button
        JButton back = new JButton("Back");
        back.setBounds(80, 350, 160, 35);

        /*setting up the action listener for the back
        button that will move back to the login window
         */
        back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                showLoginWindow(Transferred_Data);
                hideFundsTransferGUI();

            }
        });

        // Adding the buttons
        Fund_transfer_page.add(Confirm);
        Fund_transfer_page.add(back);

        // Adding the background images
        ImageIcon Image_Background = new ImageIcon("fundsTransfer.png");
        Image Background =  Image_Background.getImage();
        Image temp_Img = Background.getScaledInstance(535,500, Image.SCALE_SMOOTH);
        Image_Background = new ImageIcon(temp_Img);

        // Adding the labels to set up the image
        JLabel label = new JLabel("", Image_Background, JLabel.CENTER);
        label.setBounds(0,0,500,500);


        Fund_transfer_page.add(label);
    }

    /*
    Method that will hide the
    funds transfer Window
     */
    public void hideFundsTransferGUI() {

        Fund_transfer_page.setVisible(false);
    }
}
