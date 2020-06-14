package Main;

import ATM.Home;
import ATM.OpeningGUI;

public class Main {
    /*
    Working method that will start the execution of the application
     */
    public static void Working() {

        // Making an object of the Opening GUI
        OpeningGUI O1 = new OpeningGUI();
        // Show the opening GUI
        O1.ShowOpeningGUI();

        // Sleep for 3 seconds
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Hide the opening GUI
        O1.HideOpeningGUI();

        // Making an object of the home window and start the execution
        Home H1 = new Home();
        H1.showHome();

    }
    /*
    Main Method
     */
    public static void main(String[] args) {
        Working();
    }
}
