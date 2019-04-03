/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package customerlist;
import java.io.*;
import java.util.Scanner;
/**
 *
 * @author dalut3278
 */
public class CustomerList {
    
    public static int phoneNumber, customers;
    public static String name, postalCode;
    public static String[] names = new String[customers];
    public static String[] postalCodes = new String[customers];
    public static String[] phoneNumbers = new String[customers];

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
    }
    
    public static void read(){
        try{
        BufferedReader names = new BufferedReader(new FileReader("Y:\\Documents\\NetBeansProjects\\CustomerList\\List.txt"));
    }catch(FileNotFoundException e){
     System.out.println("Error: File Not Found");
        }
    }
    
    public static void write(){
        File dataFile = new File("Customer List");
		FileWriter out;
		BufferedWriter writeFile;
		Scanner input = new Scanner(System.in);
                

		
		try {
			out = new FileWriter(dataFile,true);
			writeFile = new BufferedWriter(out);
			for (int i = 0; i < 2; i++) {
				System.out.print("Enter Customers Name: ");
				customers = input.next();
				System.out.print("Enter Customers Phone Number: ");
				phoneNumber = input.nextInt();
                                System.out.print("Enter Customers Postal Code: ");
				postalCode = input.next();
				writeFile.write(customers);
				writeFile.newLine();
				writeFile.write(String.valueOf(phoneNumber));
				writeFile.newLine();
                                writeFile.write(String.valueOf(postalCode));
				writeFile.newLine();
			}  	
    		writeFile.close();
    		out.close();
    		System.out.println("Data written to file.");
                } catch (IOException e) {
                        System.out.println("Problem writing to file.");
                        System.err.println("IOException: " + e.getMessage());
                }
           }
      }	

    
    

