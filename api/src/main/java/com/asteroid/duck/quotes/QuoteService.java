package com.asteroid.duck.quotes;

/**
 * A simple service interface for getting famous quotes
 */
public interface QuoteService
{

	/**
	 * Get a random quote
	 * @return the quote
	 */
	public Quote getRandomQuote();
}
