package ATM;

import BackEnd.UserData;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginWindow extends Home {

    // initializing the login window, and the user data object
    private JFrame Login_Page = new JFrame();
    UserData UD;


    public LoginWindow(){

    }

    /*
    Method that handles all the functions of the Login Window,
    passing the userdata object of the User Data Class
     */
    public void showLoginWindow(UserData UD){

        // Setting up the object and the window
        this.UD = UD;
        Login_Page.setTitle("ATM Simulator");
        Login_Page.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Login_Page.setSize(550, 525);
        Login_Page.setResizable(false);


        // Setting up the GUI of the Login Window
        Font font = new Font("Times New Roman", Font.BOLD | Font.ITALIC, 18);
        JButton withdrawal = new JButton("Withdraw");
        withdrawal.setBackground(new Color(12,104,124));
        withdrawal.setForeground(new Color(158,199,252));
        withdrawal.setFocusPainted(false);
        withdrawal.setFont(font);
        withdrawal.setBounds(45, 190, 180, 45);

        /*
        Setting up the Action Listener for the withdrawal button, that will open the
        withdraw window and hides the current window
         */
        withdrawal.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                hideLoginWindow();
                WithdrawGUI withdrawal = new WithdrawGUI(UD);
                withdrawal.showWithdrawGUI();
            }
        });

        // Adding the Deposit Button
        JButton deposit = new JButton("Deposit");
        deposit.setBackground(new Color(12,104,124));
        deposit.setForeground(new Color(158,199,252));
        deposit.setFocusPainted(false);
        deposit.setFont(font);
        deposit.setBounds(45, 260, 180, 45);

        /*
        Setting up the Action Listener for the Deposit button, that will open the
        deposit window and hides the current window
         */
        deposit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                DepositGUI deposit = new DepositGUI(UD);
                deposit.showDepositGUI();
                hideLoginWindow();
            }
        });

        // Adding the Balance Inquiry Button
        JButton balanceInquiry = new JButton("Balance Inquiry");
        balanceInquiry.setBackground(new Color(12,104,124));
        balanceInquiry.setForeground(new Color(158,199,252));
        balanceInquiry.setFocusPainted(false);
        balanceInquiry.setFont(font);
        balanceInquiry.setBounds(50, 330, 180, 45);

        /*
        Setting up the Action Listener for the Balance Inquiry button, that will open the
        balance Inquiry window and hides the current window
         */
        balanceInquiry.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                BalanceInquiryGUI bI = new BalanceInquiryGUI(UD,0);
                bI.showBalanceInquiry();
                hideLoginWindow();
            }
        });

        // Adding the Funds Transfer Button
        JButton fundsTransfer = new JButton("Funds Transfer");
        fundsTransfer.setBackground(new Color(12,104,124));
        fundsTransfer.setForeground(new Color(158,199,252));
        fundsTransfer.setFocusPainted(false);
        fundsTransfer.setFont(font);
        fundsTransfer.setBounds(305, 190, 180, 45);

        /*
        Setting up the Action Listener for the Funds Transfer button, that will open the
        funds transfer window and hides the current window
         */
        fundsTransfer.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                FundsTransferGUI fT = new FundsTransferGUI(UD);
                fT.showFundsTransferGUI();
                hideLoginWindow();

            }
        });

        // Adding the Payment Button
        JButton payment = new JButton("Payments");
        payment.setBackground(new Color(12,104,124));
        payment.setForeground(new Color(158,199,252));
        payment.setFocusPainted(false);
        payment.setFont(font);
        payment.setBounds(305, 260, 180, 45);

        /*
        Setting up the Action Listener for the payment button, that will open the
        payment window and hides the current window
         */
        payment.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                PaymentGUI payment = new PaymentGUI(UD);
                payment.showPaymentGUI();
                hideLoginWindow();

            }
        });

        // Adding the exit button
        JButton exit = new JButton("Exit");
        exit.setBackground(new Color(12,104,124));
        exit.setForeground(new Color(158,199,252));
        exit.setFocusPainted(false);
        exit.setFont(font);
        exit.setBounds(305, 330, 180, 45);

        /*
        Setting up the Action Listener for the exit button, that will
        exit the running of the application
         */
        exit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });



        // Setting up the Font
        Font AccountNumberFont = new Font("Times new Roman",Font.ITALIC|Font.BOLD,20);
        JLabel AccountNumber = new JLabel(" "+UD.getAccount_Number());
        AccountNumber.setFont(AccountNumberFont);
        AccountNumber.setBounds(460,05,90,30);
        AccountNumber.setForeground(new Color(158,199,252));


        // Adding all buttons and things on the window
        Login_Page.add(AccountNumber);
        Login_Page.add(withdrawal);
        Login_Page.add(deposit);
        Login_Page.add(balanceInquiry);
        Login_Page.add(fundsTransfer);
        Login_Page.add(payment);
        Login_Page.add(exit);


        // Setting up the image for the Background
        ImageIcon Image_Background = new ImageIcon("finalized.png");
        Image Background = Image_Background.getImage();
        Image temp_Img = Background.getScaledInstance(535, 500, Image.SCALE_SMOOTH);
        Image_Background = new ImageIcon(temp_Img);

        JLabel label = new JLabel("", Image_Background, JLabel.CENTER);
        label.setBounds(0, 0, 500, 500);


        // Usual window stuff
        Login_Page.add(label);

        Login_Page.setVisible(true);
        Login_Page.setLocationRelativeTo(null);

    }

    /*
    Method that will hide the LoginWindow
     */
    public void hideLoginWindow() {

        Login_Page.setVisible(false);
    }


}
