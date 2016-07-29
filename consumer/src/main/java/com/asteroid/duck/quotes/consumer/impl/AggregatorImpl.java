package com.asteroid.duck.quotes.consumer.impl;

import com.asteroid.duck.quotes.Quote;
import com.asteroid.duck.quotes.QuoteService;
import com.asteroid.duck.quotes.consumer.Aggregator;
import com.asteroid.duck.quotes.consumer.QuoteAggregator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Aggregates quotes
 */
public class AggregatorImpl implements QuoteAggregator
{
	/** service to get individual quotes from */
	private QuoteService service;
	/**
	 * how many quotes retruned in each call to
	 * {@link com.asteroid.duck.quotes.consumer.QuoteAggregator#getSomeQuotes()}
	 */
	private int count = 10;

	public AggregatorImpl() {
		Aggregator.setSingleton(this);
	}

	private void bindQuoteService(final QuoteService service)
	{
		this.service = service;
	}

	private void unbindQuoteService(final QuoteService service)
	{
		if (service == this.service)
		{
			this.service = null;
		}
	}


	@Override
	public List<String> getSomeQuotes()
	{
		ArrayList<String> results = new ArrayList<String>();
		if (service != null)
		{
			for (int i = 0; i < count; i++)
			{
				Quote quote = service.getRandomQuote();
				results.add(quote.getQuote());
			}
		}
		return Collections.unmodifiableList(results);
	}
}
