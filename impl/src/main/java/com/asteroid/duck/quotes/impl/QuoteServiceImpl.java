package com.asteroid.duck.quotes.impl;

import com.asteroid.duck.quotes.Quote;
import com.asteroid.duck.quotes.QuoteService;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * A simple implementation backed by a quote file
 */
public class QuoteServiceImpl implements QuoteService
{
	/** our quotes DB loaded */
	private Map<Integer, String> quotes = new HashMap<Integer, String>();

	public QuoteServiceImpl() throws IOException
	{
		InputStream in = QuoteServiceImpl.class.getResourceAsStream("/db.txt");
		if (in != null)
		{
			loadFrom(in);
		}
	}

	public void loadFrom(InputStream in) throws IOException
	{
		List<String> lines = IOUtils.readLines(in);
		for (String line : lines)
		{
			String[] sections = line.split("\",");
			if (sections.length >= 2)
			{
				String quote = sections[0].replaceAll("\"'?", "");
				Integer id = Integer.parseInt(sections[1]);
				quotes.put(id, quote);
			}
		}
		System.out.println("Loaded "+quotes.size() + " quotes from "+lines.size()+ " lines");
	}

	public Quote getRandomQuote()
	{
		int id = (int)Math.round(Math.random() * quotes.size());
		id = Math.max(id, 1);
		id = Math.min(id, quotes.size());
		String quote = quotes.get(id);
		return new Quote(quote, id);
	}
}
