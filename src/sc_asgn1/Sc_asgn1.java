/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sc_asgn1;


import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.PrimitiveIterator.OfDouble;

/**
 *
 * @author Hira Tanveer
 */
public class Sc_asgn1
{

	enum RoomType{
		Studio,
		ExecutiveSuite,
		Cabana
	}
	
	
	private Scanner input;
	private final static char[] capitalAlphabets = {
		'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K',
		'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V',
		'W', 'X', 'Y', 'Z'
	};
	
	private final static String CAPITAL_AlPHABETS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
	private final static String ALPHABETS = " ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
	
	
	public Sc_asgn1()
	{
		input = new Scanner(System.in);
	}
	
	
	private int getRoomNumber()
	{
		int days = input.nextInt();
		if(days > 1 || days < 7)
		{
			new IllegalArgumentException();
		}
		return days;
	}
	
	private double getPricePerDay()
	{
		double pricePerday = input.nextDouble();
		return pricePerday;
	}
	
	private RoomType allotRoom(double pricePerday)
	{
		RoomType roomType = null;
		
		if(pricePerday < 10000)
			roomType = RoomType.Studio;
		else if(pricePerday >= 10000 || pricePerday <= 25000)
			roomType = RoomType.ExecutiveSuite;
		else if(pricePerday > 50000)
			roomType = RoomType.Cabana;
		else if(pricePerday >= 25001 || pricePerday <= 49999)
			throw new IllegalArgumentException("Price between 25001 to 49999 is not permitted");

		return roomType;
	}
	
	
	private String getName()
	{
		String name = input.nextLine();
		boolean decision = validateName(name);
		assert(decision);
		return null;
	}
	
	private boolean validateName(String name)
	{
		return validateTitleCase(name) && validateAlphabets(name);
	}
	
	private boolean validateTitleCase(String name)
	{

		String[] name_array = name.split(" ");
		for(int i = 0; i < name_array.length; i++)
		{
			String namePart = name_array[i];
			if(!CAPITAL_AlPHABETS.contains(namePart.substring(0, 1)))
			{
				return false;
			}
		}
		
		return true;
		
	}
	
	private boolean validateAlphabets(String name)
	{
		char[] array = name.toCharArray();
		for(int i = 0; i < array.length; i++) 
		{
			String characterToBeCompare = Character.toString(array[i]);
			if(!ALPHABETS.contains(characterToBeCompare))
			{
				return false;
			}
		}
		return true;
	}
	
	private String getDate()
	{
		String date = input.nextLine();
		return date;
	}
	
	private boolean validateDate(String _date)
	{
		
        DateFormat formatter = new SimpleDateFormat("dd/mm/yyyy");
        formatter.setLenient(false);
        try
        {
            Date date= formatter.parse(_date);
            Calendar calendar = new GregorianCalendar();
            calendar.setTime(date);
            int year = calendar.get(Calendar.YEAR);
            
        }
        catch (ParseException e)
        {
        	throw new IllegalArgumentException("Date is not in proper format");
        }

		
		return true;
	}
	
	private boolean validateYear(int year)
	{
		if(year > 2000)
			return false;
		return true;
	}
	
	private long getCNIC()
	{
		try
		{
			long cnic = input.nextLong();
			return cnic;
			
		}
		catch(InputMismatchException exp)
		{
			throw new IllegalArgumentException("Enter only digits");
		}
	}
	
	private boolean validateCNIC(long cnic)
	{
		String str = Long.toString(cnic);
		if(str.length() != 13)
			throw new IllegalArgumentException("13 digits only");
	}
	
    public static void customerInfo()
    {
    	
    	
    	Sc_asgn1 app = new Sc_asgn1();
   
    	app.validateDate(app.getDate());
    	
    	/* 
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
 */       
    }
    
    
    public static void main(String[] args) {
        customerInfo();
    }
    
}
