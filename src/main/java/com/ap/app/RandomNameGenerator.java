package com.ap.app;

import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Properties;

public class RandomNameGenerator
{
	private Iterator<String> namesIterator;

	public RandomNameGenerator()
	{
		// get usernames
		Properties props = getParticipantsInformation("participants.properties");
		List<String> names = Arrays.asList(props.getProperty("app.names").split(","));
		Collections.shuffle(names);

		// setup iterator
		namesIterator = names.iterator();
	}


	public String getNextName()
	{
		if (namesIterator.hasNext())
		{
			return namesIterator.next();
		}
		return null;
	}

	private Properties getParticipantsInformation(String fileName)
	{
		try
		{
			InputStream inputStream = new FileInputStream(fileName);
			Properties prop = new Properties();
			prop.load(inputStream);

			return prop;
		}
		catch (IOException e)
		{
			throw new IllegalArgumentException("Error loading properties file", e);
		}
	}
}
