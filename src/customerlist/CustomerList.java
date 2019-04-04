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
    public static String name, postalCode, line, out;
    public static String[] names = new String[customers];
    public static String[] postalCodes = new String[customers];
    public static String[] phoneNumbers = new String[customers];
    public static BufferedReader text;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        read();
    }
    
    public static void read(){
        
        line = "";
        out = "Customers:\n";
        try{
        text = new BufferedReader(new FileReader("Y:\\Documents\\NetBeansProjects\\CustomerList\\List\\CustomerList.txt"));
    }catch(FileNotFoundException e){
     System.out.println("Error: File Not Found");
        }
 
        do {
           try{ 
               line = (text.readLine());
           }catch(IOException e){}
           
           if(line != null){
            out += (line + "\n");
            
           }else{
              try{ text.close(); }catch(IOException e){}
           }
            
        }while(line != null);
        
        System.out.println(out);
        
    }
    
    public static void write(){
        File dataFile = new File("Y:\\Documents\\NetBeansProjects\\CustomerList\\List\\CustomerList.txt");
		FileWriter out;
		BufferedWriter writeFile;
		Scanner input = new Scanner(System.in);
                
		try {
			out = new FileWriter(dataFile,true);
			writeFile = new BufferedWriter(out);
			for (int i = 0; i < 2; i++) {
				System.out.print("Enter Customers Name: ");
				name = input.next();
				System.out.print("Enter Customers Phone Number: ");
				phoneNumber = input.nextInt();
                                System.out.print("Enter Customers Postal Code: ");
				postalCode = input.next();
				writeFile.write(name);
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

    
    

