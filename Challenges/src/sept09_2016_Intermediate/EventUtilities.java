package sept09_2016_Intermediate;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class EventUtilities
{
	
	public static final String DATEFORMAT = "MM/dd/yyyy";
	public static final String TIMEFORMAT = "HH:mm";
	
	/**
	 * Parses date from console input
	 * @param dateInput provided by user 
	 * @return date 
	 * @throws DateEventException 
	 */
	public static Date ParseDate(String fetchConsoleInput) throws DateEventException
	{
		if(fetchConsoleInput != null)
		{
			DateFormat timeFormat = new SimpleDateFormat(DATEFORMAT);
			timeFormat.setLenient(false);
			try
			{
				return timeFormat.parse(fetchConsoleInput);
			} 
			catch (ParseException e)
			{
				throw new DateEventException();
			}
		}
		return null;
	}
	

	/**
	 * Validates the title is 3-30 chars
	 * @param title string
	 * @return boolean
	 */
	public static boolean validateTitle(String title)
	{
		if(title != null)
			return(title.length() >= 3 && title.length() <= 30);
		return false;
	}

	/**
	 * Validates the description is less then 300 chars
	 * @param description
	 * @return
	 */
	public static boolean validateDescription(String description)
	{
		if(description != null)
			return(description.length() <= 300);
		return false;
	}

	/**
	 * Validates the date is correct MM-DD-YYYY
	 * @param date
	 * @return 
	 */
	public static boolean validateDate(String dateAsString)
	{
		if(dateAsString != null)
		{
			DateFormat dateFormat = new SimpleDateFormat(DATEFORMAT);
			dateFormat.setLenient(false);
			try
			{
				dateFormat.parse(dateAsString);
				return true;
			} 
			catch (ParseException e)
			{
				return false;
			}
		}
		
		return false;
	}

	/**
	 * Validate time.
	 * 
	 * @param hourAsString
	 * @return boolean
	 */
	public static boolean validateTime(String hourAsString)
	{
		if(hourAsString != null)
		{
			DateFormat dateFormat = new SimpleDateFormat("HH:mm");
			dateFormat.setLenient(false);
			try
			{
				dateFormat.parse(hourAsString);
				return true;
			} 
			catch (ParseException e)
			{
				return false;
			}
		}
		
		return false;
	}

	/**
	 * Parses time as Date
	 * @param fetchConsoleInput
	 * @return
	 * @throws DateEventException 
	 */
	public static Date ParseTime(String fetchConsoleInput) throws DateEventException
	{
		if(fetchConsoleInput != null)
		{
			DateFormat timeFormat = new SimpleDateFormat(TIMEFORMAT);
			timeFormat.setLenient(false);
			try
			{
				return timeFormat.parse(fetchConsoleInput);
			} 
			catch (ParseException e)
			{
				throw new DateEventException();
			}
		}
		return null;
	}
	
	/**
	 * My custom exception class.
	 */
	static class DateEventException extends Exception
	{
		/**
		 * Generated serial version uid 
		 */
		private static final long serialVersionUID = 5447214688780290507L;

		public DateEventException()
		{
		    super();
		}
	}

}
