/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sc_asgn1;


import java.io.File;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.InputMismatchException;
import java.util.Scanner;

import sc_asgn1.dateValidator.DateValidation;

/**
 *
 * @author Ubaid ur Rehman
 */
public class HotelBooking
{

	private final static String CAPITAL_AlPHABETS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
	private final static String ALPHABETS = " ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
	private final static String LOWERCASE = "abcdefghijklmnopqrstuvwxyz";
	private final static String UPPERCASE = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
	private Scanner input;
	
	public HotelBooking()
	{
		input = new Scanner(System.in);

	}
	
	
	private int getdays() throws IllegalArgumentException
	{
		System.out.println("How many days you want to book room(1-7)?\t");
		try
		{
			int days = input.nextInt();
			input.nextLine();  // Consume newline left-over
			if(days < 1 || days > 7)
			{
				throw new IllegalArgumentException("We do not provide service for more than 7 or less than 1 days");
			}
			return days;
			
		}
		catch(InputMismatchException exp)
		{
			throw new IllegalArgumentException("Enter correct input");
		}
	}
	
	private double getPricePerDay()
	{
		try
		{
			System.out.println("Price Per Day: \t");
			double pricePerday = input.nextDouble();
			input.nextLine();  // Consume newline left-over
			return pricePerday;			
		}
		catch(InputMismatchException exp)
		{
			throw new IllegalArgumentException("Enter right input (price per day)");
		}
	}
	
	private RoomType allotRoom(double pricePerday)
	{
		RoomType roomType = null;
		
		if(pricePerday < 10000 && pricePerday > 0)
			roomType = RoomType.Studio;
		else if(pricePerday >= 10000 && pricePerday <= 25000)
			roomType = RoomType.ExecutiveSuite;
		else if(pricePerday > 50000)
			roomType = RoomType.Cabana;
		else if(pricePerday >= 25001 && pricePerday <= 49999)
			throw new IllegalArgumentException("Price between 25001 to 49999 is not permitted");
		else if(pricePerday <= 0)
			throw new IllegalArgumentException("Price should not be smaller than 0");

		return roomType;
	}
	
	
	private String getName()
	{
		System.out.println("What is your name: \t");
		String name = input.nextLine();
		boolean decision = validateName(name);
		if(decision)
			return name;
		else
			throw new IllegalArgumentException("Name should be correctly formatted");
	}
	
	private boolean validateName(String name)
	{
		return validateTitleCase(name) && validateAlphabets(name) && validateLowerCase(name) && validateUpperCase(name);
	}
	
	private boolean validateLowerCase(String name)
	{
		String[] name_array = name.split(" ");
		for(int i = 0; i < name_array.length; i++)
		{
			String namePart = name_array[i];
			if(LOWERCASE.contains(namePart.substring(0, 1)))
			{
				return false;
			}
		}
		
		return true;
	}
	
	private boolean validateUpperCase(String name)
	{
		String[] name_array = name.split(" ");
		for(int i = 0; i < name_array.length; i++)
		{
			String namePart = name_array[i];
			for(int j = 1; j < namePart.length(); j++)
			{
				if(UPPERCASE.contains(namePart.substring(j, j+1)))
				{
					return false;
				}
			}
		}
		
		return true;
		
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
		System.out.println("What is your birthdate(dd-mm-yyyy):\t");
		String date = input.nextLine();
		try
		{
			boolean decision = validateDate(date);
			if(decision)
				return date;			
			else
				return null;
		}
		catch (IllegalArgumentException exp)
		{
			throw exp;
		}
	}
	
	private boolean validateDate(String _date) throws IllegalArgumentException
	{	
        DateFormat formatter = new SimpleDateFormat("dd-mm-yyyy");
        formatter.setLenient(false);
        try
        {
            Date date= formatter.parse(_date);
         
            String[] dateParts = _date.split("\\-");
            
            String _day = dateParts[0];
            String _month = dateParts[1];
            String _year = dateParts[2];
            
            int day = Integer.parseInt(_day);
            int month = Integer.parseInt(_month);
            int year = Integer.parseInt(_year);
            
            return DateValidation.getInstance().validateDate(day, month, year);
            
        }
        catch(NumberFormatException exp)
        {
        	throw new IllegalArgumentException("Date is not in proper format");        	
        }
        catch (ParseException e)
        {
        	throw new IllegalArgumentException("Date is not in proper format");
        }
	}
	
	
	private long getCNIC()
	{
		try
		{
			System.out.println("Enter your 13 digit CNIC");
			long cnic = input.nextLong();
			input.nextLine();  // Consume newline left-over
			try
			{
				boolean d = validateCNIC(cnic);
				if(d)
					return cnic;
			}
			catch(IllegalArgumentException e)
			{
				throw e;
			}
		}
		catch(InputMismatchException exp)
		{
			throw new IllegalArgumentException("Enter only digits");
		}
		
		return 0;
	}
	
	private boolean validateCNIC(long cnic) throws IllegalArgumentException
	{
		String str = Long.toString(cnic);
		if(str.length() != 13)
			throw new IllegalArgumentException("13 digits only");
		return true;
	}
	
	private boolean uploadPhotocopyCNIC(String path) throws IllegalArgumentException
	{
		File file = new File(path);
		if(file.exists())
		{
			String extension = getFormat(file.getName()).toUpperCase();
			switch (extension) {
			case "PNG":
				return true;
			case "JPEG":
				return true;
			default:
				throw new IllegalArgumentException("Extension should be PNG or JPEG");
			}
		}
		else
			throw new IllegalArgumentException("File not eixsts");		
	}
	
	private String getFormat(String fileName)
	{
		return fileName.split("\\.")[1];
	}
	
	private String getPathOfFile()
	{
		System.out.println("Enter your absolute path of CNIC photocopy:\n");
		String path = input.nextLine();
		try
		{
			uploadPhotocopyCNIC(path);
			return path;			
		}
		catch(IllegalArgumentException exp)
		{
			throw exp;
		}
	}
	
	private int getRating()
	{
		try
		{
			System.out.println("Rate this hotel on your experience(1-5) (or press s to skip):\t");
			String rating = input.nextLine();
			if(rating.equals("s"))
			{
				return -1;
			}
			else
			{
				int _rating = Integer.parseInt(rating);
				validateRating(_rating);
				return _rating;				
			}
			
		}
		catch(NumberFormatException exp)
		{
			throw new IllegalArgumentException("Enter proper input");
		}
		catch(InputMismatchException exp)
		{
			throw new IllegalArgumentException("Enter proper formatted input");
		}
		catch(IllegalArgumentException exp)
		{
			throw exp;
		}
	}
	
	private void validateRating(int rating) throws IllegalArgumentException
	{
		if(rating > 5 || rating < 1)
			throw new IllegalArgumentException("Rating should be in range of 1 to 5");
	}
	
	
    private void register() throws IllegalArgumentException
    {
    	try
    	{
    		int days = getdays();
    		double pricePerday = getPricePerDay();
    		RoomType roomType = allotRoom(pricePerday);
    		String name = getName();
    		String birthdate = getDate();
    		long cnic = getCNIC();
    		String imagePath = getPathOfFile();
    		int rating = getRating();
    		User user = new User(days, roomType, name, birthdate, cnic, imagePath, rating);
    		System.out.println("\n" + user.toString() + "\n");
    		
    	}
    	catch(IllegalArgumentException exp)
    	{
    		System.out.println(exp.getMessage());
    		System.out.println("Try again with correct inputs/format/method:\n\n");
    	}
    }
    
    public void startApplication()
    {
    	do
    	{
    		System.out.println("\n\n***********Welcome in Pakistan Hotel***********\n");
    		register();
    	}while(true);
    }
}
