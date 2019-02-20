package sc_asgn1.dateValidator;

import java.util.Hashtable;
import java.util.Map;

public class DateValidation
{
	private final static Map<Integer, Integer> yearMap = new Hashtable<>();
	private final static Map<Integer, Integer> leapYearMap = new Hashtable<>();
	private static DateValidation dateValidation = null;
	
	public static DateValidation getInstance()
	{
		if(dateValidation == null)
			return new DateValidation();
		return dateValidation;
	}
	
	private DateValidation()
	{
		yearMap.put(1, 31);
		yearMap.put(2, 28);
		yearMap.put(3, 31);
		yearMap.put(4, 30);
		yearMap.put(5, 31);
		yearMap.put(6, 30);
		yearMap.put(7, 31);
		yearMap.put(8, 31);
		yearMap.put(9, 30);
		yearMap.put(10, 31);
		yearMap.put(10, 30);
		yearMap.put(10, 31);

		leapYearMap.put(1, 31);
		leapYearMap.put(2, 29);
		leapYearMap.put(3, 31);
		leapYearMap.put(4, 30);
		leapYearMap.put(5, 31);
		leapYearMap.put(6, 30);
		leapYearMap.put(7, 31);
		leapYearMap.put(8, 31);
		leapYearMap.put(9, 30);
		leapYearMap.put(10, 31);
		leapYearMap.put(10, 30);
		leapYearMap.put(10, 31);	
	}
	
	//month validator
	private boolean validateMonth(int month) throws IllegalArgumentException
	{
		if(month > 0 && month <= 12)
			return true;
		else
			throw new IllegalArgumentException("Month should be in range 1 to 12");
	}
	
	//leap year validator
	private boolean isLeapYear(int year) throws IllegalArgumentException
	{
		return (year % 400 == 0) || ((year % 4 == 0) && (year % 100 != 0));
	}
	
	private boolean validateDay(int day) throws IllegalArgumentException
	{
		if(day <= 31 && day > 0)
			return true;
		else
			throw new IllegalArgumentException("Day should be in range from 1 to 31");
	}
	
	//month days validater 
	public boolean validateDate(int day, int month, int year) throws IllegalArgumentException
	{
		try
		{
			if(validateYear(year) && validateDay(day) && validateMonth(month))
			{
				if(!isLeapYear(year))
				{
					int localDay = yearMap.get(month);
					if(day <= localDay)
						return true;
					else
						throw new IllegalArgumentException("day = " + day + " for this month = " + month + " is not valid");
				}
				else
				{
					int localDay = leapYearMap.get(month);
					if(day <= localDay)
						return true;
					else
						throw new IllegalArgumentException("day = " + day + " for this month = " + month + " is not valid (leap year)");
				}
			}
			return false;
			
		}
		catch(IllegalArgumentException exp)
		{
			throw exp;
		}
	}
	
	private boolean validateYear(int year) throws IllegalArgumentException
	{
		if(year > 1999 || year < 1950)
			throw new IllegalArgumentException("Year should be in range 1950 to 1999");
		return true;
	}

	
}
