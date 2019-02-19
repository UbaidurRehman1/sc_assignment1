/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sc_asgn1;


import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;
/**
 *
 * @author Hira Tanveer
 */
public class Sc_asgn1 {

    /**
     * @param args the command line arguments
     */
    
    public static void customerInfo(){
        Scanner input = new Scanner(System.in);
        System.out.println("Enter your name: ");
        String name = input.next();
        System.out.println("Enter your birthday: ");
        String bday = input.next();
        System.out.println("Enter your CNIC number: ");
        int cnic = input.nextInt();
        System.out.println("dd-mm-yyyy");
     
        DateFormat formatter = new SimpleDateFormat("dd/mm/yyyy");
        formatter.setLenient(false);
        try {
            Date date= formatter.parse("56/09/2010");
        } catch (ParseException e) {
            System.out.println("Error");
        }
        
    }
    
    
    public static void main(String[] args) {
        customerInfo();
    }
    
}
