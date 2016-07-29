package com.asteroid.duck.quotes;

/**
 * Represents a quote by a famous person
 */
public class Quote
{
	/** the quote */
	private final String quote;
	/** ID */
	private final int id;

	public Quote(String quote, int id)
	{
		this.quote = quote;
		this.id = id;
	}

	public String getQuote()
	{
		return quote;
	}

	public int getId()
	{
		return id;
	}
}
