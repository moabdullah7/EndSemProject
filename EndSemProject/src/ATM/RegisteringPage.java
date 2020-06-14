package ATM;

import BackEnd.UserData;
import ExceptionHandler.InputIncorrectException;
import ExceptionHandler.Validation;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RegisteringPage extends Home {

    // initializing the frame, the user data object
    private JFrame Registering_Page = new JFrame();
    UserData UD  =  new UserData();


    /*
    Method that will handle the entire working of the
    registering window
     */
    public void showRegisteringPage(){

        // Setting up the basic things for the window
        UD = new UserData();
        Registering_Page.setTitle("ATM Simulator");
        Registering_Page.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Registering_Page.setSize(500, 500);
        Registering_Page.setResizable(false);

        // Making a panel
        JPanel RegisteringPanel = new JPanel();
        RegisteringPanel.setLayout(null);
        RegisteringPanel.setSize(300, 350);
        RegisteringPanel.setBounds(18, 80, 450, 350);
        RegisteringPanel.setBackground(new Color(10,142,168));

        // Making another panel, a smaller one
        JPanel jP = new JPanel();
        jP.setLayout(null);
        jP.setSize(300, 50);
        jP.setBounds(18, 10, 450, 50);
        jP.setBackground(new Color(129,211,228));

        // Adding the font
        Font font1 = new Font("Cursive", Font.ITALIC, 15);

        // Adding the prompt that will display the following text
        JLabel prompt = new JLabel("Please Select One Type");
        prompt.setBounds(20, 10, 200, 30);
        prompt.setForeground(new Color(22,22,124));
        prompt.setFont(font1);
        jP.add(prompt);

        // A radio button for one of the two options
        JRadioButton jR1 = new JRadioButton("Current Account");
        jR1.setBounds(240,5,150,15);
        jR1.setBackground(new Color(42,148,202));
        jR1.setForeground(new Color(22,22,124));

        jR1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });

        // A radio button for one of the two options
        JRadioButton jR2 = new JRadioButton("Saving Account");
        jR2.setBounds(240,30,150,15);
        jR2.setBackground(new Color(42,148,202));
        jR2.setForeground(new Color(22,22,124));

        // Adding a button group that will ensure one button is selected at a time
        ButtonGroup AccountType = new ButtonGroup();
        AccountType.add(jR1);
        AccountType.add(jR2);

        jP.add(jR1);
        jP.add(jR2);


        // Adding the panel in the frame
        Registering_Page.add(jP);


        // Adding a text field for full name
        JTextField Full_Name = new JTextField("");
        Full_Name.setBounds(100, 10, 180, 30);
        RegisteringPanel.add(Full_Name);

        Font font = new Font("Times New Roman", Font.BOLD, 16);


        JLabel FullnamePrompt = new JLabel("Name");
        FullnamePrompt.setBounds(20, 10, 100, 30);
        FullnamePrompt.setFont(font);
        RegisteringPanel.add(FullnamePrompt);


        // Adding a text field for user name
        JTextField Username = new JTextField("");
        Username.setBounds(100, 50, 180, 30);
        RegisteringPanel.add(Username);

        // Adding the prompt that will display the following text
        JLabel UsernamePrompt = new JLabel("Username");
        UsernamePrompt.setBounds(20, 50, 100, 30);
        UsernamePrompt.setFont(font);
        RegisteringPanel.add(UsernamePrompt);

        // Adding a text field for password
        JPasswordField SetPassword = new JPasswordField("");
        SetPassword.setBounds(100, 90, 180, 30);
        RegisteringPanel.add(SetPassword);

        // Adding the prompt that will display the following text
        JLabel PasswordPrompt = new JLabel("Password");
        PasswordPrompt.setBounds(20, 90, 100, 30);
        PasswordPrompt.setFont(font);
        RegisteringPanel.add(PasswordPrompt);

        // Adding a text field for phone number
        JTextField PhoneNumber = new JTextField("");
        PhoneNumber.setBounds(100, 130, 180, 30);
        RegisteringPanel.add(PhoneNumber);

        // Adding the prompt that will display the following text
        JLabel PhoneNumberPrompt = new JLabel("Phone #");
        PhoneNumberPrompt.setBounds(20, 130, 100, 30);
        PhoneNumberPrompt.setFont(font);
        RegisteringPanel.add(PhoneNumberPrompt);

        // Adding a text field for address
        JTextField Address = new JTextField("");
        Address.setBounds(100, 170, 340, 30);
        RegisteringPanel.add(Address);

        // Adding the prompt that will display the following text
        JLabel AddressPrompt = new JLabel("Address");
        AddressPrompt.setBounds(20, 170, 100, 30);
        AddressPrompt.setFont(font);
        RegisteringPanel.add(AddressPrompt);

        // Adding a text field for starting balance
        JTextField StartingBalance = new JTextField("");
        StartingBalance.setBounds(140,220,180,30);
        RegisteringPanel.add(StartingBalance);

        // Adding the prompt that will display the following text
        JLabel StatingBalancePrompt = new JLabel("Starting Amount");
        StatingBalancePrompt.setBounds(20,220,140,30);
        StatingBalancePrompt.setFont(font);
        RegisteringPanel.add(StatingBalancePrompt);

        // Adding the prompt that will display the following text
        JButton Signature = new JButton("Add Signature");
        Signature.setBounds(150, 265, 150, 35);

        /*
        Action Listener for the signature button that will open signature pad
         */
        Signature.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                SignaturePad S1 = new SignaturePad(Username.getText());
            }
        });

        // adding the next button
        JButton Next = new JButton("Done");
        Next.setBounds(295, 310, 150, 35);

        // adding the action listener for next button
        Next.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                // Checking the required validation checks in the validation class for full name
                try {
                    Validation.Full_nameCheck(Full_Name.getText());

                }
                // Else display the following message
                catch (InputIncorrectException exception) {
                    JOptionPane.showMessageDialog(null, "Invalid Name");
                }

                // Checking the required validation checks in the validation class for user name
                try {
                    Validation.UsernameCheck(Username.getText());
                }
                // Else display the following message
                catch (InputIncorrectException exception) {
                    JOptionPane.showMessageDialog(null, "Invalid Username");
                }

                // Checking the required validation checks in the validation class for password
                try {
                    Validation.PinCodeValidator(SetPassword.getText());
                }
                // Else display the following message
                catch (InputIncorrectException exception) {
                    JOptionPane.showMessageDialog(null, "Pin Code should only contain 4 digits");
                }

                // Checking the required validation checks in the validation class for phone number
                try {
                    Validation.PhoneNumberValidator(PhoneNumber.getText());
                }
                // Else display the following message
                catch (InputIncorrectException exception) {
                    JOptionPane.showMessageDialog(null, "Invalid Phone Number");
                }

                // Checking the required validation checks in the validation class for address
                try {
                    Validation.AddressValidator(Address.getText());
                }
                // Else display the following message
                catch (InputIncorrectException exception){
                    JOptionPane.showMessageDialog(null, "Enter Address");
                }

                // Checking the required validation checks in the validation class for starting balance
                try {
                    Validation.Balance_Check(StartingBalance.getText());
                }
                // Else display the following message
                catch (InputIncorrectException exception){
                    JOptionPane.showMessageDialog(null, "Enter a valid Balance");
                }

                // If all the necessary conditions for validations are checked and all of the conditions are true then
                if (!(Full_Name.getText().isEmpty() || Username.getText().isEmpty() || SetPassword.getText().isEmpty()
                        || PhoneNumber.getText().isEmpty() || Address.getText().isEmpty() || StartingBalance.getText().isEmpty()) && Validation.PhoneNumber && Validation.Username && Validation.PinCode
                        && Validation.Fullname && Validation.Address && Validation.Balance && (jR1.isSelected() || jR2.isSelected())) {
                    /*
                    Create a new Thread for the User Login and save all the user data in the UD object of the UserData Class
                     */
                    Thread T1 = new Thread(() -> CreateUserLogin(Username.getText(), SetPassword.getText()));
                    T1.start();
                    UD.setFull_name(Full_Name.getText());
                    UD.setUsername(Username.getText());
                    UD.setPinCode(SetPassword.getText());
                    UD.setAddress(Address.getText());
                    UD.setPhoneNumber(PhoneNumber.getText());
                    UD.setBalance(Integer.parseInt(StartingBalance.getText()));

                    // Select the current or savings account type based on the selection button
                    if (jR1.isSelected())
                        UD.setAccount_Type("Current Account");
                    else if (jR2.isSelected())
                        UD.setAccount_Type("Saving Account");

                    /*
                    Create a new Thread for the User Login i.e( User Password)
                     */
                    Thread SaveUserInfo = new Thread(() -> CreateUserData(UD, Integer.parseInt(SetPassword.getText())));
                    SaveUserInfo.start();

                    // Hiding registration page and showing the entire information through the confirmation gui window
                    hideRegistrationPage();
                    ConfirmationGUI AddInfo = new ConfirmationGUI(UD);
                    AddInfo.showConfirmationGUI();
                }
                // Select one of the account type message
                else
                    {

                        JOptionPane.showMessageDialog(null, "Select one of the account type!");
                }
            }
        });
        // Adding buttons
        RegisteringPanel.add(Next);
        RegisteringPanel.add(Signature);


        // Setting up the background
        ImageIcon Image_Background = new ImageIcon("registration.png");
        Image Background = Image_Background.getImage();
        Image temp_Img = Background.getScaledInstance(1000, 800, Image.SCALE_SMOOTH);
        Image_Background = new ImageIcon(temp_Img);

        // Setting up the Label, and inserting the image
        JLabel label = new JLabel("", Image_Background, JLabel.CENTER);
        label.setBounds(0, 0, 500, 500);
        label.add(RegisteringPanel);


        // Setting up the gui window
        Registering_Page.add(label);
        Registering_Page.setLocationRelativeTo(null);
        Registering_Page.setVisible(true);


    }

    /*
    Method that will hide the
    Registration Window
     */
    private void hideRegistrationPage()
    {
        Registering_Page.setVisible(false);
    }


}
