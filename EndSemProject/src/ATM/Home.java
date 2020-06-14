package ATM;

import BackEnd.UserData;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/* Extends the opening gui class thereby
utilizing all it's functionality
 */
public class Home extends OpeningGUI {

    // initializing frame, login window, and userdata to manage the data of the user
    private JFrame Home = new JFrame();
    private LoginWindow lG;
    UserData ActiveUser;

    /* Method that handles the functionality of the
    Home class
     */
    public void showHome(){

        // Basic gui settings
        Home.setTitle("ATM Simulator");
        Home.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Home.setSize(500,500);
        Home.setResizable(false);

        // Adding font
        Font f = new Font("Cursive", Font.ITALIC,20);

        /* Adding text field for the username
         and password
         */
        JTextField Username = new JTextField("");
        Username.setBounds(205,165,130,30);
        Username.setBackground(new Color(12,104,124));
        Username.setForeground(new Color(158,199,252));


        Home.add(Username);

        JPasswordField Password = new JPasswordField("");
        Password.setBounds(205,235,130,30);
        Password.setBackground(new Color(12,104,124));
        Password.setForeground(new Color(158,199,252));

        Home.add(Password);

        /* Setting the prompt for both the username and
        the password
         */
        Font font = new Font("Cursive", Font.ITALIC, 18);
        JLabel UsernamePrompt = new JLabel("Username");
        UsernamePrompt.setBounds(100,160,200,35);
        UsernamePrompt.setForeground(new Color(158,199,252));
        UsernamePrompt.setFont(f);
        Home.add(UsernamePrompt);

        JLabel PasswordPrompt = new JLabel("Password");
        PasswordPrompt.setBounds(100,200,200,35);
        PasswordPrompt.setSize(200,100);
        PasswordPrompt.setForeground(new Color(158,199,252));
        PasswordPrompt.setFont(f);

        Home.add(PasswordPrompt);


        // Adding the Login button
        JButton LoginButton = new JButton("Login");
        LoginButton.setBounds(210,280,100,35);
        LoginButton.setFont(font);

        /* Action Listener for the login button that Verifies the
        Login credentials of the user with the help of the
        LoginVerification method of the Bank Class
         */
        LoginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(LoginVerification(Username.getText(), Password.getText())) {

                    /* If credential are right, it will read the user data from the Records class
                    with the help of password
                     */
                    ReadUserData(Integer.parseInt(Password.getText()));
                    lG = new LoginWindow();
                    lG.showLoginWindow(Current_User);
                    hideHome();

                }
                else
                    // Showing the error message incase things goes wrong
                    JOptionPane.showMessageDialog(null,"Please Enter Valid Login Credentials");
            }
        });



        // Adding Registering button
        JButton RegisterButton = new JButton("Register Yourself");
        RegisterButton.setBounds(170,330,200,35);
        RegisterButton.setFont(font);


        /* Action Listener for the registering button that opens the
        registering window and hides the Home window
         */
        RegisterButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                RegisteringPage R1 = new RegisteringPage();
                R1.showRegisteringPage();
                hideHome();

            }
        });

        // Adding the Login Button to the window
        Home.add(LoginButton);

        // Setting up the background image
        ImageIcon Image_Background = new ImageIcon("home.png");
        Image Background =  Image_Background.getImage();
        Image temp_Img = Background.getScaledInstance(535,490, Image.SCALE_SMOOTH);
        Image_Background = new ImageIcon(temp_Img);

        // With the help of label, adding the background image
        JLabel label = new JLabel("", Image_Background, JLabel.CENTER);
        label.setBounds(0,0,500,500);
        label.add(RegisterButton);

        // Final settings of the window
        Home.add(label);
        Home.setLocationRelativeTo(null);
        Home.setVisible(true);


    }

    /*
    Function that hides the home window
     */
    private void hideHome(){

        Home.setVisible(false);
    }

}