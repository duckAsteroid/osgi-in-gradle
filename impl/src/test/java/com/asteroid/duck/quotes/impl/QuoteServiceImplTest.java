package com.asteroid.duck.quotes.impl;

import com.asteroid.duck.quotes.Quote;
import org.junit.Test;

import static org.junit.Assert.*;

public class QuoteServiceImplTest
{

	@Test
	public void testGetRandomQuote() throws Exception
	{
		QuoteServiceImpl subject = new QuoteServiceImpl();
		for (int i = 0; i < 10000; i++)
		{
			Quote quote = subject.getRandomQuote();
			assertNotNull(quote);
			String string = quote.getQuote();
			assertNotNull("Quote ID:"+quote.getId(),string);
			assertTrue(string.length() > 0);
			assertTrue(quote.getId() > 0);
		}

	}
}