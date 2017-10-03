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
		
	}
	public Events Delete(Event e)
	{
		return this;
	}
	public Events Edit()
	{
		return this;
	}
	public Events View()
	{
		return null;
	}
	public void Save(String filename)
	{
		
	}
	
	public void Load(String filename)
	{
		
	}
}
