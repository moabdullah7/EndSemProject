package ATM;

import BackEnd.UserData;
import ExceptionHandler.InputIncorrectException;
import ExceptionHandler.Validation;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class WithdrawGUI extends LoginWindow {

    // initializing the frame, and the user data object
    private JFrame Withdraw_page = new JFrame();
    private UserData Transferred_Data;

    /*
     Adding the UserData object in the constructor so every calculation
     has it's own affect in the constructor when it's object is built
     */
    public WithdrawGUI(UserData UD){

        this.Transferred_Data = UD;
    }

    /*
    Method that will handle the entire working of the withdraw window
     */
    public void showWithdrawGUI(){

        // Basic setting of the window
        Withdraw_page.setTitle("ATM Simulator");
        Withdraw_page.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Withdraw_page.setSize(500,500);
        Withdraw_page.setResizable(false);
        Withdraw_page.setVisible(true);
        Withdraw_page.setLocationRelativeTo(null);

        // Adding a text field for the desired amount
        JTextField withdraw = new JTextField("");
        withdraw.setBounds(170,210,180,30);
        withdraw.setBackground(new Color(12,104,124));
        withdraw.setForeground(new Color(158,199,252));
        Withdraw_page.add(withdraw);

        // Setting up the font
        Font font = new Font("Times new Roman", Font.BOLD|Font.ITALIC, 20);

        // Adding the label for withdraw prompt text
        JLabel withdrawPrompt = new JLabel("Enter Withdraw Amount");
        withdrawPrompt.setBounds(150,150,300,40);
        withdrawPrompt.setBackground(new Color(12,104,124));
        withdrawPrompt.setForeground(new Color(158,199,252));
        withdrawPrompt.setFont(font);
        Withdraw_page.add(withdrawPrompt);

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
                if ((withdraw.getText().isEmpty())){

                    JOptionPane.showMessageDialog(null,"Please Enter Desired Values");
                }
                /*
                Making sure that withdraw amount is less than actual amount through the Balance update check method
                of the Validation Class, if yes then deduct the following amount with the help of UserData class
                and updating the Amounts in Balance Inquiry class
                 */
                else
                    {

                    try
                    {
                        Validation.Balance_Update_Check(  (int) Transferred_Data.getBalance(), Integer.parseInt(withdraw.getText()));
                        float previousBalance = Transferred_Data.getBalance();
                        Transferred_Data.setBalance(Transferred_Data.getBalance() - Integer.parseInt(withdraw.getText()));
                        hideWithdrawGUI();
                        BalanceInquiryGUI BI = new BalanceInquiryGUI(Transferred_Data, previousBalance);
                        BI.showBalanceInquiry();

                    }
                    /*
                    Error message incase of invalid entry
                     */
                    catch (InputIncorrectException exception){
                        JOptionPane.showMessageDialog(null, "You do not have sufficient balance.");
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
                hideWithdrawGUI();
            }
        });

        // Adding the buttons
        Withdraw_page.add(Confirm);
        Withdraw_page.add(back);


        // Setting up the background image
        ImageIcon Image_Background = new ImageIcon("withdraw.png");
        Image Background =  Image_Background.getImage();
        Image temp_Img = Background.getScaledInstance(535,500, Image.SCALE_SMOOTH);
        Image_Background = new ImageIcon(temp_Img);

        // Adding the image with Label
        JLabel label = new JLabel("", Image_Background, JLabel.CENTER);
        label.setBounds(0,0,500,500);

        // Adding the label
        Withdraw_page.add(label);
    }

    /*
    Method that will hide the
    Withdraw Window
     */
    private void hideWithdrawGUI() {
        Withdraw_page.setVisible(false);
    }
}
