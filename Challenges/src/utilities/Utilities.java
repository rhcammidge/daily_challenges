package utilities;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import org.apache.commons.io.input.CloseShieldInputStream;

public class Utilities 
{

	/**
	 * Prompts user for input.  Returns next line from input. 
	 * @param prompt message to present user
	 * @return string result or null.
	 */
	public static String fetchConsoleInput(String prompt)
	{
		InputStreamReader is = null;
		BufferedReader br = null;
		String result = null;
		
		try 
		{
			is = new InputStreamReader(new CloseShieldInputStream(System.in));
			br = new BufferedReader(is);
			
			while(true)
			{
				System.out.print(prompt);
				result = br.readLine();
				return result;
			}
			
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
		finally
		{
			if(br != null)
			{
				try
				{
					br.close();
				}
				catch(IOException e)
				{
					e.printStackTrace();
				}
			}			
			
		}
		return result;		
	}
		
		
}

