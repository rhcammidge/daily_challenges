package sept09_2016_Intermediate;

import java.util.List;

import com.fasterxml.jackson.core.util.DefaultPrettyPrinter;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;
public class Events
{
	
	public List<Event> list;
	
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
	public void View(Date date)
	{
		List<Event> sortedEventList = getSortedListByDate(date);
		// You can specify styles if you want
		DateFormat format = DateFormat.getDateInstance();
		// Set time zone information if you want.
		// Display List
		for(int i = 0; i < sortedEventList.size(); i++)
		{
			System.out.println("Event Number: " + i + 1);
			System.out.println("Event Name: " + sortedEventList.get(i).title);
			System.out.println("Event Description: " + sortedEventList.get(i).description);
			System.out.println("Event Date: " + format.format(sortedEventList.get(i).date));
			System.out.println("Event Time: " + format.format(sortedEventList.get(i).time));
		}
		
	}
	
	/**
	 * Sort a list of today's events
	 * @param date
	 * @return the sorted list
	 */
	private List<Event> getSortedListByDate(Date date)
	{
		List<Event> sortedDayList = new ArrayList<Event>();
		// Naive way... sort the daily list of events by time  TODO implement comparator https://stackoverflow.com/questions/5805602/how-to-sort-list-of-objects-by-some-property
		for(Event e : list)
		{
			if(e.date.equals(date))
			{
				if(sortedDayList.size() == 0)
					sortedDayList.add(e);
				
				for(int i = 0; i < sortedDayList.size(); i++)
				{
					if(e.time.getTime() < sortedDayList.get(i).time.getTime() && (i != 0) && e.time.getTime() > sortedDayList.get(i+1).time.getTime())
					{
						sortedDayList.add(i, e);
					}
				}				
			}
		}
		
		return sortedDayList;
		
	}
	
	/**
	 * Save as JSON to a file
	 */
	public void Save()
	{
		ObjectMapper mapper = new ObjectMapper();
		ObjectWriter writer = mapper.writer(new DefaultPrettyPrinter());
		try
		{
			writer.writeValue(new File("c:\\eventplanner.json"), list);
		} 
		catch (IOException e)
		{
			System.out.println("Unable to save :( IO Exception!");
		}
		
	}
	
	/**
	 * Load from default filea
	 * @param filename
	 */
	@SuppressWarnings("unchecked")
	public void Load(String filename)
	{
		ObjectMapper mapper = new ObjectMapper();
		try
		{
			this.list = (List<Event>) mapper.readValue(new File("c:\\eventplanner.json"), Events.class);
		} 
		catch (IOException e)
		{
			System.out.println("Unable to load :( IO Exception!");
		}
	}
}
