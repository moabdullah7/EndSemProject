package ATM;

import BackEnd.Records;
import BackEnd.UserData;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Calendar;

public class BalanceInquiryGUI extends LoginWindow {

    // initializing the frame, userdata object and float that will contain the previous balances
    JFrame Balance_page = new JFrame();
    private UserData Transferred_Data;
    private float previousBalance;

    // Constructor containing userdata object, float variable
    public BalanceInquiryGUI(UserData UD, float previousBalance) {
        this.Transferred_Data = UD;
        this.previousBalance = previousBalance;
    }


    /*
    Method that will handle the entire working of the balance inquiry window
     */
    public void showBalanceInquiry() {

        // Basic settings of the window
        Balance_page.setTitle("ATM Simulator");
        Balance_page.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Balance_page.setSize(500, 500);
        Balance_page.setResizable(false);
        Balance_page.setVisible(true);
        Balance_page.setLocationRelativeTo(null);

        // Adding the background image
        ImageIcon Image_Background = new ImageIcon("balanceInquiry.png");
        Image Background = Image_Background.getImage();
        Image temp_Img = Background.getScaledInstance(490, 500, Image.SCALE_SMOOTH);
        Image_Background = new ImageIcon(temp_Img);

        // Adding the label to set up the image
        JLabel label = new JLabel("", Image_Background, JLabel.CENTER);
        label.setBounds(0, 0, 500, 500);

        // A jPanel showing all the details of the user
        JPanel balanceInquiry = new JPanel();
        balanceInquiry.setLayout(null);
        balanceInquiry.setSize(250, 380);
        balanceInquiry.setBounds(45, 20, 400, 400);
        balanceInquiry.setBackground(new Color(129,211,228));
        Balance_page.add(balanceInquiry);

        // Adding fonts
        Font font = new Font("Times new Roman",Font.ITALIC|Font.BOLD,18);

        Font font1 = new Font("Times new Roman",Font.BOLD,20);

        // Label showing following text
        JLabel info = new JLabel("Transaction Details are as Follows");
        info.setBounds(20, 50, 400, 30);
        info.setBackground(new Color(12,104,124));
        info.setForeground(new Color(12,104,124));
        info.setFont(font1);

        // Labels showing full name of the user using the UserData Object (i.e, Transferred_Data)
        JLabel name = new JLabel("FULL NAME:    " + Transferred_Data.getFull_name());
        name.setBounds(30, 100, 400, 30);
        name.setBackground(new Color(12,104,124));
        name.setForeground(new Color(12,104,124));
        name.setFont(font);

        // Labels showing username of the user using the UserData Object (i.e, Transferred_Data)
        JLabel username = new JLabel("Username:    " + (Transferred_Data.getUsername()));
        username.setBounds(30, 130, 400, 30);
        username.setBackground(new Color(12,104,124));
        username.setForeground(new Color(12,104,124));
        username.setFont(font);

        // Labels showing account type of the user using the UserData Object (i.e, Transferred_Data)
        JLabel address = new JLabel("Account Type:    " + Transferred_Data.getAccount_Type());
        address.setBounds(30, 160, 400, 30);
        address.setBackground(new Color(12,104,124));
        address.setForeground(new Color(12,104,124));
        address.setFont(font);

        // Labels showing previous balance of the user using the UserData Object (i.e, Transferred_Data)
        JLabel number = new JLabel("Previous Balance:    " + previousBalance);
        number.setBounds(30, 190, 400, 30);
        number.setBackground(new Color(12,104,124));
        number.setForeground(new Color(12,104,124));
        number.setFont(font);

        // Labels showing current balance of the user using the UserData Object (i.e, Transferred_Data)
        JLabel Balance = new JLabel("Current Balance:    " + Transferred_Data.getBalance());
        Balance.setBounds(30, 220, 400, 30);
        Balance.setBackground(new Color(12,104,124));
        Balance.setForeground(new Color(12,104,124));
        Balance.setFont(font);

        // Labels showing time and date of the user using the UserData Object (i.e, Transferred_Data)
        JLabel account_type = new JLabel("D & T: " + Calendar.getInstance().getTime());
        account_type.setBounds(30, 250, 400, 30);
        account_type.setBackground(new Color(12,104,124));
        account_type.setForeground(new Color(12,104,124));
        account_type.setFont(font);


        // Adding all the things in the window
        balanceInquiry.add(name);
        balanceInquiry.add(username);
        balanceInquiry.add(account_type);
        balanceInquiry.add(address);
        balanceInquiry.add(number);
        balanceInquiry.add(Balance);

        // Adding the next button
        JButton Next = new JButton("Next");
        Next.setBounds(270, 425, 150, 35);
        Balance_page.add(Next);

        /*
        Setting the Action Listener of the next button that will show the Thank you window
         */
        Next.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                // Setting up a new thread to avoid window halt
                Thread T = new Thread(new ThankYou());
                T.start();
                // Updating all the data into the new Thread
                Thread Updater = new Thread(() -> Records.SaveUserData(Transferred_Data,
                        Integer.parseInt(Transferred_Data.getPinCode())));
                Updater.start();
            }
        });

        // Adding the label
        Balance_page.add(label);
    }

    /*
    Method that will hide the balance inquiry window
     */
    private void hideBalanceInquiry() {

        Balance_page.setVisible(false);
    }
}


