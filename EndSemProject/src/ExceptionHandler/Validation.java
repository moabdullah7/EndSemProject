package ExceptionHandler;

public abstract class Validation {

    /*
     Initializing public data field because these will be used in another
     package for the validation of
     user's attributes
     */
    public static boolean Username = true;
    public static boolean Fullname = true;
    public static boolean PinCode = true;
    public static boolean PhoneNumber = true;
    public static boolean Address = true;
    public static boolean Balance = true;

    /*
    Username check method that ensures the username is not empty
    and it's does not contain abnormal values
     */
    public static void UsernameCheck(String username) throws InputIncorrectException {
        Username = true;
        // Ensures not empty
        if (username.isEmpty()) {
            Username = false;
            throw new InputIncorrectException();
        }
        // Ensures correct values
        for (char c : username.toCharArray()) {
            if (c == 32) {
                Username = true;
            } else if (c < 48 || c > 122) {
                Username = false;
                throw new InputIncorrectException();
            } else if (c > 48 && c < 57) {
                Username = true;
            } else if (c < 91 || c > 96) {
                Username = true;
            } else {
                Username = false;
                throw new InputIncorrectException();
            }
        }
    }

    /*
    Full name check method that ensures the full name is not empty
    and it's does not contain abnormal values
     */
    public static void Full_nameCheck(String name) throws InputIncorrectException {
        Fullname = true;

        // Ensures not empty
        if (name.isEmpty()) {
            Fullname = false;
            throw new InputIncorrectException();

        }
        // Ensures correct values
        for (char c : name.toCharArray()) {
            if (c == 32) {
                Fullname = true;
            } else if (c > 64 && c < 91) {
                Fullname = true;
            } else if (c > 96 && c < 123) {
                Fullname = true;
            } else {
                Fullname = false;
                throw new InputIncorrectException();
            }
        }
    }

    /*
    Pin code check method that ensures the pin code is exactly 4 digits long
    and it's does not contain abnormal values
     */
    public static void PinCodeValidator(String password) throws InputIncorrectException {
        PinCode = true;

        // Pin length 4
        if (password.length() != 4) {
            PinCode = false;
            throw new InputIncorrectException();
        }
        // Correct Values
        for (char c : password.toCharArray()) {
            if (!Character.isDigit(c)) {
                PinCode = false;
                throw new InputIncorrectException();
            }
        }
    }

    /*
    Phone number check method that ensures the phone number is exactly 11 digits long
    and it's does not contain abnormal values
     */
    public static void PhoneNumberValidator(String phonenumber) throws InputIncorrectException {
        PhoneNumber = true;

        // Phone number length 11
        if (phonenumber.length() != 11) {
            PhoneNumber = false;
            throw new InputIncorrectException();
        }

        // Correct Values
        for (char c : phonenumber.toCharArray()) {
            if (!Character.isDigit(c)) {
                PhoneNumber = false;
                throw new InputIncorrectException();
            }
        }
    }

    /*
    Address check method that ensures the Address is not empty
     */
    public static void AddressValidator(String address) throws InputIncorrectException {
        Address = true;
        // Ensures it is not empty
        if (address.isEmpty()) {
            Address = false;
            throw new InputIncorrectException();
        }
    }

    /*
    Balance check method that ensures the Balance is not empty
    and it's does not contain abnormal values
     */
    public static void Balance_Check(String balance) throws InputIncorrectException {
        Balance = true;

        // Ensures not empty
        if (balance.isEmpty()) {
            Balance = false;
            throw new InputIncorrectException();
        }
        // Ensures correct values
        int b = Integer.parseInt(balance);
        if (b < 0 || b > 100000000) {
            Balance = false;
            throw new InputIncorrectException();

        }
    }

    // Balance update check method that ensures that existing balance is sufficient for all transfers
    public static void Balance_Update_Check(int balance, int updater) throws InputIncorrectException {
        if (updater > balance)
            throw new InputIncorrectException();
    }

}
