package com.asteroid.duck.quotes.consumer.impl;

import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class AggregatorImplTest
{

	@Test
	public void testGetSomeQuotesUnbound() throws Exception
	{
		AggregatorImpl subject = new AggregatorImpl();
		List<String> someQuotes = subject.getSomeQuotes();
		assertNotNull(someQuotes);
		assertEquals(0, someQuotes.size());
	}
}