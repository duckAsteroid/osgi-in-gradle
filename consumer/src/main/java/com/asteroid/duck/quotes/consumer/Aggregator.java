package com.asteroid.duck.quotes.consumer;

public class Aggregator
{
	private static QuoteAggregator SINGLETON = null;

	public static QuoteAggregator getSingleton() {
		return SINGLETON;
	}

	public static void setSingleton(QuoteAggregator instance) {
		SINGLETON = instance;
	}

}
