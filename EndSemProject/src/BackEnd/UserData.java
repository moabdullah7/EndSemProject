package BackEnd;

import java.io.Serializable;


public class UserData implements Serializable {

    // All private fields (Data Encapsulation)
    private String full_name;
    private String username;
    private String PinCode;
    private String Address;
    private float Balance;
    private String PhoneNumber;
    private int Account_Number;
    private String Account_Type;

    // An empty constructor
    public UserData(){

    }

    // Constructor with all values
    public UserData(String full_name, String username, String pinCode, String address,String phoneNumber) {
        this(full_name,username,pinCode,address,0, phoneNumber);
    }

    /*
    UserData that contains all the necessary information about the user
    and setting it's values
     */
    public UserData(String full_name, String username, String pinCode, String address, float balance,
                String phoneNumber) {
        this.full_name = full_name;
        this.username = username;
        PinCode = pinCode;
        Address = address;
        if (balance>=0) {
            Balance = balance;
        } else {
            Balance = 0;
        }
        PhoneNumber = phoneNumber;
    }

    /*
    Getter Method for account number
     */
    public int getAccount_Number() {
        return Account_Number;
    }

    /*
    Setter method for account number
     */
    public void setAccount_Number(int account_Number) {
        Account_Number = account_Number;
    }

    /*
    Getter Method for account type
     */
    public String getAccount_Type() {
        return Account_Type;
    }

    /*
    Setter Method for account type
     */
    public void setAccount_Type(String account_Type) {
        Account_Type = account_Type;
    }

    /*
    Getter Method for full name
     */
    public String getFull_name() {
        return full_name;
    }

    /*
    Setter Method for full name
     */
    public void setFull_name(String full_name) {
        this.full_name = full_name;
    }

    /*
    Getter Method for user name
     */
    public String getUsername() {
        return username;
    }

    /*
    Setter Method for user name
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /*
    Getter Method for account pin
     */
    public String getPinCode() {
        return PinCode;
    }

    /*
    Setter Method for account pin
     */
    public void setPinCode(String pinCode) {
        PinCode = pinCode;
    }

    /*
    Getter Method for address
     */
    public String getAddress() {
        return Address;
    }

    /*
    Setter Method for address
     */
    public void setAddress(String address) {
        Address = address;
    }

    /*
    Getter Method for account balance
     */
    public float getBalance() {
        return Balance;
    }

    /*
    Getter Method for phone number
     */
    public String getPhoneNumber() {
        return PhoneNumber;
    }

    /*
    Setter Method for phone number
     */
    public void setPhoneNumber(String phoneNumber) {
        PhoneNumber = phoneNumber;
    }

    /*
    Setter Method for account balance
     */
    public void setBalance(float balance) {
        Balance = balance;
    }


    /*
    Overriding toString method
    for the desired output
     */
    @Override
    public String toString() {
        return "Full Name " + full_name + '\n' +
                "Username " + username + '\n' +
                "Address " + Address + '\n' +
                "Balance " + Balance + '\n' +
                "PhoneNumber " + PhoneNumber + '\n'+
                "Account_Number" + Account_Number + '\n'+
                "Account_Type" + Account_Type + '\n' ;
    }
}
