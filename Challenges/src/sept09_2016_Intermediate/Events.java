package sept09_2016_Intermediate;

import java.util.List;
import java.util.ArrayList;

public class Events
{
	
	List<Event> list;
	
	public Events()
	{
		list = new ArrayList<Event>();
	}
	public void Add(Event event)
	{
		list.add(event);
		System.out.println("Event added successfully.");
		
	}
	public Events Delete(Event event)
	{
		return this;
	}
	public Events Edit()
	{
		return this;
	}
	public void View()
	{
		Menu.displayViewOptions();
		for(Event e : list)
		{
			
		}
	}
	public void Save(String filename)
	{
		
	}
	
	public void Load(String filename)
	{
		
	}
}
