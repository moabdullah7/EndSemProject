package BackEnd;

public interface BankMethods {

    // Interface Method for Login Verification
    boolean LoginVerification(String S1, String S2);

    // Interface Method for Creating User Login based on username and pincode
    void CreateUserLogin(String username, String pincode);

    // Interface Method for Creating the user data
    void CreateUserData(UserData UD, int pinCode);
}
