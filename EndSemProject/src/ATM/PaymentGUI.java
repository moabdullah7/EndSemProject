package ATM;

import BackEnd.UserData;
import ExceptionHandler.InputIncorrectException;
import ExceptionHandler.Validation;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PaymentGUI extends LoginWindow{

    // Initializing the frame, userData, Array of options, and Combo Box
    private JFrame Payment_Page = new JFrame();
    private UserData Transferred_Data;
    private String paymentOptions [] = {"Bank Payment", "Gas Bill","Electricity Bill","Water Bill", "Utility Bills","Others"};
    private JComboBox combo;

    // Constructor containg the UserData object
    public PaymentGUI(UserData UD){

        this.Transferred_Data = UD;
    }


    /*
    Method that will handle the entire working of the payment window
     */
    public void showPaymentGUI(){

        // Setting up the basic things
        Payment_Page.setTitle("ATM Simulator");
        Payment_Page.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Payment_Page.setSize(500,500);
        Payment_Page.setResizable(false);
        Payment_Page.setVisible(true);
        Payment_Page.setLocationRelativeTo(null);

        // Adding the payment text field that will ask for amount
        JTextField payment = new JTextField("");
        payment.setBounds(215,250,180,30);
        payment.setBackground(new Color(12,104,124));
        payment.setForeground(new Color(158,199,252));
        Payment_Page.add(payment);

        // Adding the font
        Font font = new Font("Cursive", Font.ITALIC|Font.BOLD, 18);

        // Adding the label that will show the following text
        JLabel paymentPromt = new JLabel("Enter the Payment Amount");
        paymentPromt.setBounds(215,210,250,30);
        paymentPromt.setForeground(new Color(192,192,192));
        paymentPromt.setFont(font);
        Payment_Page.add(paymentPromt);

        // Adding the confirm button
        JButton Confirm = new JButton("Confirm");
        Confirm.setBounds(280,350,160,35);

        /*
        Setting up the action listener for the confirm button
         */
        Confirm.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                // If empty, show the following message
                if ((payment.getText().isEmpty())){
                    JOptionPane.showMessageDialog(null,"Please Enter Desired Values");
                }

                else
                    /*
                    Checks that the amount is not greater than the current present, if not subtract it and saves it in the user data class
                     */
                    {
                    try
                    {
                        Validation.Balance_Update_Check(  (int) Transferred_Data.getBalance(), Integer.parseInt(payment.getText()));
                        float previousBalance = Transferred_Data.getBalance();
                        Transferred_Data.setBalance(Transferred_Data.getBalance() - Integer.parseInt(payment.getText()));
                        hidePaymentGUI();
                        BalanceInquiryGUI BI = new BalanceInquiryGUI(Transferred_Data,previousBalance);
                        BI.showBalanceInquiry();

                    }
                    // Error message in case something goes wrong
                    catch (InputIncorrectException exception){
                        JOptionPane.showMessageDialog(null, "You do not have sufficient balance.");
                    }
                }

            }
        });

        // Adding the back button
        JButton back = new JButton("Back");
        back.setBounds(80,350,160,35);

        /*
        setting up the action listener for the back button
         */
        back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                showLoginWindow(Transferred_Data);
                hidePaymentGUI();

            }
        });

        // Label that will display the following text
        JLabel comboPrompt = new JLabel("Please Select any Option");
        comboPrompt.setBounds(50,90,250,30);
        comboPrompt.setForeground(new Color(192,192,192));
        comboPrompt.setSize(300,35);
        comboPrompt.setFont(font);

        // Combo Box containing the above array of options
        combo = new JComboBox(paymentOptions);
        combo.setBounds(50,130,200,35);
        combo.setBackground(new Color(12,104,124));
        combo.setForeground(new Color(158,199,252));

        // Adding the font
        Font f = new Font("Times new Roman",Font.ITALIC|Font.BOLD,18);
        combo.setFont(f);

        // Adding all above things
        Payment_Page.add(comboPrompt);
        Payment_Page.add(Confirm);
        Payment_Page.add(back);
        Payment_Page.add(combo);


        // Setting up the image
        ImageIcon Image_Background = new ImageIcon("payments.png");
        Image Background =  Image_Background.getImage();
        Image temp_Img = Background.getScaledInstance(510,500, Image.SCALE_SMOOTH);
        Image_Background = new ImageIcon(temp_Img);

        // With the help of the label, setting up the image
        JLabel label = new JLabel("", Image_Background, JLabel.CENTER);
        label.setBounds(0,0,500,500);


        // Adding the label
        Payment_Page.add(label);
    }

    /*
    Method that will hide the
    payment Window
     */
    private void hidePaymentGUI()
    {
        Payment_Page.setVisible(false);
    }
}
