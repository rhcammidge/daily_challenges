package sept09_2016_Intermediate;

import utilities.Utilities;

public class Menu
{

	/**
	 * Parses the menu selection from the user
	 * A - Adds an item
	 * E - Edits an item
	 * D - Deletes an item
	 * V - View Schedule
	 * 
	 * @param menuInput string user pressed
	 * @return 
	 */
	public static void parseMenuSelection(String menuInput)
	{
		System.out.println("You pressed: " + menuInput);
		boolean invalidSelection = false;
		
		while(!invalidSelection)
		{
			menuInput = menuInput.toUpperCase();
			switch(menuInput)
			{
				case "A": 
					addEventMenu();
					invalidSelection = true;
					break;
				case "E":
					editEventMenu();
					invalidSelection = true;
					break;
				case "D":
					deleteEventMenu();
					invalidSelection = true;
					break;
				case "V":
					viewEventMenu();
					invalidSelection = true;
					break;
				default:
					invalidSelection = false;
					menuInput = Utilities.fetchConsoleInput("Please try again: ");
			}	
			
		}
	}

	private static void viewEventMenu()
	{
		// TODO Auto-generated method stub
		
	}

	private static void deleteEventMenu()
	{
		// TODO Auto-generated method stub
		
	}

	private static void editEventMenu()
	{
		// TODO Auto-generated method stub
		
	}

	private static void addEventMenu()
	{
		// TODO Auto-generated method stub
		
	}

}
