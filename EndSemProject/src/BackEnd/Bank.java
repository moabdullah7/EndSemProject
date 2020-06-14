package BackEnd;

import java.util.HashMap;

public class Bank implements BankMethods {

    // Initialzing the variable, hashmap to store the user name and password, and UserData object Current_User
    private static int Number_of_Users = 1;
    private HashMap<String, Integer> User_Login = new HashMap<>();
    protected UserData Current_User;


    // Bank Constructor containing hashmaps of username and pin from the records method in the records class
    public Bank() {

        User_Login = Records.getHashMapFromTextFile();
    }

    @Override
    /*
    Login Verification that ensures both username and pin code are correctly entered
     */
    public boolean LoginVerification(String S1, String S2) {
        if (User_Login.isEmpty()) {
            return false;
        } else {
            for (String i : User_Login.keySet()) {
                if (S1.equals(i)) {
                    int temp = Integer.parseInt(S2);
                    if (temp == User_Login.get(i))
                        return true;
                }//else{
                   // return false;
                //}
            }
        }
        return false;
    }

    /*
    Overriding the BankMethod Interface method that saves the username and pincode to the records
    method Save Login Info
     */
    @Override
    public void CreateUserLogin(String username, String pincode) {
        int pinCode = Integer.parseInt(pincode);
        User_Login.put(username, pinCode);
        Records.SaveLogin_Info(User_Login);
        Update_No_of_Users();
    }

    /*
    Overriding the BankMethod Interface method that sets the account number and save it to the records
    method Save User Data
     */
    @Override
    public void CreateUserData(UserData U, int pinCode){
        int x = Records.Read_Number_Of_Users();
        U.setAccount_Number(AssignAccountNumber(x));
        Records.SaveUserData(U, pinCode);
    }

    /*
    Update the number of users by one and save it to the records method save number of users
     */
    public void Update_No_of_Users(){
        Number_of_Users = Records.Read_Number_Of_Users();
        Number_of_Users++;
        Records.SaveNumber_of_Users(Number_of_Users);
    }

    // Assigning account numbers starting from 999
    private int AssignAccountNumber(int x) {
        int y = 999;
        return x + y;
    }

    /*
    Read the user data with the help of Records class and it's method
    Read User Data
     */
    public void ReadUserData(int pinCode){
        UserData ActiveUser = Records.ReadUserData(pinCode);
        setCurrent_User(ActiveUser);
    }

    // Method set the current active user
    public void setCurrent_User(UserData UD){
        this.Current_User = UD;
    }

}
