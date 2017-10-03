package sept09_2016_Intermediate;

import java.text.DateFormat;
import java.text.SimpleDateFormat;

import sept09_2016_Intermediate.EventUtilities.DateEventException;
import utilities.Utilities;

public class Menu
{
	
	
	public enum MenuCommand
	{
		menuActionAdd,
		menuActionEdit,
		menuActionInvalid, 
		menuActionDelete
	}
	
	/**
	 * Parses the menu selection from the user
	 * A - Adds an item
	 * E - Edits an item
	 * D - Deletes an item
	 * V - View Schedule
	 * 
	 * @param menuInput string user pressed
	 * @return 
	 * @return 
	 */
	public static boolean parseMenuSelection(String menuInput, Events allEvents)
	{
		System.out.println("You pressed: " + menuInput);
		boolean invalidSelection = false;
		
		if(allEvents == null)
			allEvents = new Events();
		
		while(!invalidSelection)
		{
			menuInput = menuInput.toUpperCase();
			switch(menuInput)
			{
				case "A":
					Event event = new Event();
					System.out.println("Adding a new event.");
					
					// Parse and validate title (re-ask if invalid).
					while(event.title == null || !EventUtilities.validateTitle(event.title))
					{
						if(event.title != null)
							System.out.println("Invalid title.  Please have 1 to 30 characters.");
						
						event.title = Utilities.fetchConsoleInput("Enter the name of the event:");										
					}
					
					// Parse and validate date (re-ask if invalid).
					DateFormat dateFormat = new SimpleDateFormat(EventUtilities.DATEFORMAT);
					while(event.date == null || !EventUtilities.validateDate(dateFormat.format(event.date)))
					{
						// Parse date
						try
						{
							event.date = EventUtilities.ParseDate(Utilities.fetchConsoleInput("Enter the date of the event (MM/DD/YYYY):"));
						} 
						catch (DateEventException e)
						{
							System.out.println("Invalid date.  Format should be MM/DD/YYYY and be a validate date.");	
						} 
					}
					
					
					// Parse and validate hour (re-ask if invalid).
					DateFormat hourFormat = new SimpleDateFormat(EventUtilities.TIMEFORMAT);
					while(event.time == null || !EventUtilities.validateTime(hourFormat.format(event.time)))
					{
						// Parse time
						try
						{
							event.time = EventUtilities.ParseTime(Utilities.fetchConsoleInput("Enter the time of the event 24h  ie 15:25(hh:mm):")); // Parse time
						} 
						catch (DateEventException e)
						{
							System.out.println("Invalid time.  Format should be hh:mm and be a valid time.");	
						} 
					}

					// Parse and validate description (re-ask if invalid).
					while(event.description == null || !EventUtilities.validateDescription(event.description))
					{
						if(event.description != null)
							System.out.println("Invalid Description.  Maximum 300 characters.");						
						
						event.description = Utilities.fetchConsoleInput("Enter the despcription of the event:");
					}	
				
					// Add event
					allEvents.Add(event);
					invalidSelection = false;
					return false;
				case "E":
					allEvents.Edit();
					invalidSelection = false;
					return false;
				case "D":
					//allEvents.Delete();
					invalidSelection = false;
					return false;
				case "V":
					allEvents.View();
					invalidSelection = false;
					return false;
				case "X":
					System.out.println("Thanks for using EVENT ORGANIZER 3000!");
					return true;
				default:
					invalidSelection = true;
					
				if(invalidSelection)
					menuInput = Utilities.fetchConsoleInput("Please try again: ");	
			}
		}
		return true;
	}

	public static void displayViewOptions()
	{
		
		// View specific day
		
	}


}
