package BackEnd;

import java.io.*;
import java.util.HashMap;
import java.util.Scanner;

public abstract class Records  {

    /*
    Static Class Method taking user data object and
    pin code as parameters, basically it writes the user data whenever it
    is being called
     */
    public static void SaveUserData(UserData UD, int PinCode){

        try {
            FileOutputStream fileOut =
                    new FileOutputStream("UserData" + PinCode +  ".ser");
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            // writing user data in the file output stream through object output stream
            out.writeObject(UD);
            // closes the output stream
            out.close();
            // closes the file
            fileOut.close();
        } catch (IOException i) {
            System.out.println(i);
        }
    }

    /*
    whatever user data stored in the file is being retrieved with the
    help of this method
     */
    public static UserData ReadUserData(int PinCode) {
        // used to store the user data
            UserData e = null;
            try {

                FileInputStream fileIn = new FileInputStream("UserData" + PinCode +  ".ser");
                ObjectInputStream in = new ObjectInputStream(fileIn);
                // reading the user data through the object input stream
                e = (UserData) in.readObject();
                in.close();
                // closes the file
                fileIn.close();
            } catch (IOException i) {
                i.printStackTrace();
            } catch (ClassNotFoundException c) {
                System.out.println("UserData class not found");
                c.printStackTrace();

            }
            return e;
        }



    /*
    this method saves the number of users with the help of FileWriter and the
    paramter number provided
     */
    public static void SaveNumber_of_Users(int number) {
        FileWriter fileWriter = null; //Set true for append mode
        try {
            fileWriter = new FileWriter("Bank.txt", true);
        } catch (IOException e) {
            e.printStackTrace();
        }
        PrintWriter printWriter = new PrintWriter(fileWriter);
        printWriter.println(number);  //New line
        // closes the file writer
        printWriter.close();
    }

    /*
    this method retrieves the number of users
    whenever the system want to display the number of users
    this method will be used
     */
    public static int Read_Number_Of_Users(){
        Scanner scanner = null;
        int i = 0;
        try {
            // scanner object to read the user's number
            scanner = new Scanner(new File("Bank.txt"));
            while(scanner.hasNextInt())
            {
                i = scanner.nextInt(); // till there's an upcoming digit
            }
        } catch (FileNotFoundException e) {
            System.out.println("No file Created Yet");
        }

        return i;
    }

    /*
    this method saves the user login information that
    is managed with the help of hashmap and the information is stored with the
    help of buffered writer
    */
    public static void SaveLogin_Info(HashMap<String, Integer> hmap) {
        File file = new File("LoginDetails.txt");

        BufferedWriter bf = null;
        ;

        try {

            //create new BufferedWriter for the output file
            bf = new BufferedWriter(new FileWriter(file));

            //iterate map entries
            for (String h : hmap.keySet()) {

                //put key and value separated by a colon
                bf.write(h + ":" + hmap.get(h));
                //new line
                bf.newLine();
            }

            bf.flush();

        } catch (IOException e) {
            e.printStackTrace();
        } finally {

            try {
                //always close the writer
                bf.close();
            } catch (Exception e) {
            }
        }
    }


    /*
    Method that is used to retrieve the user login information
    with the help of buffered reader
     */
    public static HashMap<String, Integer> getHashMapFromTextFile() {

        HashMap<String, Integer> mapFileContents = new HashMap<String, Integer>();
        BufferedReader br = null;

        try {

            //create file object
            File file = new File("LoginDetails.txt");

            //create BufferedReader object from the File
            br = new BufferedReader(new FileReader(file));

            String line = null;

            //read file line by line
            while ((line = br.readLine()) != null) {
                String[] parts = new String[2];

                //split the line by :
                parts = line.split(":", 2);

                //first part is name, second is age
                String name = parts[0].trim();
                Integer password = Integer.parseInt(parts[1].trim());

                //put name, age in HashMap if they are not empty
                if (!name.equals("") && !password.equals(""))
                    mapFileContents.put(name, password);
            }

        } catch (Exception e) {
            System.out.println("No user created yet");
        } finally {

            //Always close the BufferedReader
            if (br != null) {
                try {
                    br.close();

                } catch
                (Exception e) {
                }
                ;
            }
        }

        // return the hashmap containing the user login credentials
        return mapFileContents;
    }

}
