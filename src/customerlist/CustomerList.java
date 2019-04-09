/*
 * David Lutelmowski
 * 08/04/2019
 * Customer List
 */
package customerlist;

import java.io.*;
import java.util.Scanner;

/**
 *
 * @author dalut3278
 */
public class CustomerList {

    public static int customers;
    public static String name, postalCode, line, out, in, phoneNumber;
    public static String[] names = new String[customers];
    public static String[] postalCodes = new String[customers];
    public static String[] phoneNumbers = new String[customers];
    public static BufferedReader text;
    public static BufferedWriter writeFile;
    public static boolean adding = true;
    public static Scanner input = new Scanner(System.in);
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        read();
        write();
    }

    // Open file and show list of customers 
    public static void read() {

        line = "";
        out = "Customers:\n";
        try {
            text = new BufferedReader(new FileReader("Y:\\Documents\\NetBeansProjects\\CustomerList\\List\\CustomerList.txt"));
        } catch (FileNotFoundException e) {
            System.out.println("Error: File Not Found");
        }

        do {
            try {
                line = (text.readLine());
            } catch (IOException e) {
            }

            if (line != null) {
                out += (line + "\n");

            } else {
                try {
                    text.close();
                } catch (IOException e) {
                }
            }

        } while (line != null);

        System.out.println(out);
    }
    // Open file for writing
    public static void write() {
        File dataFile = new File("Y:\\Documents\\NetBeansProjects\\CustomerList\\List\\CustomerList.txt");
        FileWriter out;

        try {
            out = new FileWriter(dataFile, true);
            writeFile = new BufferedWriter(out);
    // Getting new information and writing it to the file
            while (adding != false){
                System.out.print("Enter Customers Name: ");
                name = input.next() + ":";
                System.out.print("Enter Customers Phone Number (no dashes or spaces): ");
                phoneNumber = input.next();
                System.out.print("Enter Customers Postal Code in the form (B3J4R5): ");
                postalCode = input.next();
                writeFile.write(name);
                writeFile.newLine();
                writeFile.write(phoneNumber);
                writeFile.newLine();
                writeFile.write(postalCode);   
                writeFile.newLine();
              
                 adding = next();
            }

            System.out.println("Data written to file.");
            System.exit(0);
            } catch (IOException e) {
            System.out.println("Problem writing to file.");
            System.err.println("IOException: " + e.getMessage());
        }
    }
    // Asks user if they would like to add another customer
        public static boolean next() {
        System.out.print("Would you like to add another customer? 1 - Yes / 2 - No : ");
        in = "";
        in = input.next();
        if (in.equals("1")) {
            return true;
        }else if(in.equals("2")){
            try{ writeFile.close(); }catch(IOException e){}
            return false;  
        }else{
            next();
            System.out.println(in);
        }
        return true;
    }
}
