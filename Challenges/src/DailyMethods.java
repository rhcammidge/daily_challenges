import sept09_2016_Intermediate.Menu;
import utilities.Utilities;

public class DailyMethods {

	/**
	 * Sept 09 2016 - Easy Challenge #1
	 *  
	 * create a program that will ask the users name, age, and reddit username. have it tell them the information back, in the format:
	 * your name is (blank), you are (blank) years old, and your username is (blank)
	 * for extra credit, have the program log this information in a file to be accessed later.
	 */
	public static void Sept09_2016_Easy() 
	{
		String name = Utilities.fetchConsoleInput("Enter your name: ");
		String age = Utilities.fetchConsoleInput("Enter your age: ");
		String redditUserName = Utilities.fetchConsoleInput("Enter your reddit user name: ");
		System.out.print(String.format("Your name is %s, you are %s, and your username is %s", name, age, redditUserName));		
	}
	
	/**
	 * Sept 09 2016 - Intermediate Challenge #1
	 * 
	 * Create a menu driven program
	 * Using the menu drive program allow a user to add/delete items
	 * The menu should be based on an events calender where users enter the events by hour
	 * No events should be hard-coded.
	 */
	public static void Sept09_2016_Intermediate()
	{
		// Display Menu
		System.out.print("#####EVENT ORGANIZER 3000#####\n");
		
		Menu.parseMenuSelection(Utilities.fetchConsoleInput("Press A to add an item.\nPress E to edit an item.\nPress D to delete an item.\nPress V to view the schedule."));
		
	
		
	}
	

}
