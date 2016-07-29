package com.asteroid.duck.quotes.integration;

import com.asteroid.duck.quotes.consumer.Aggregator;
import com.asteroid.duck.quotes.consumer.QuoteAggregator;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.ops4j.pax.exam.Inject;
import org.ops4j.pax.exam.junit.ExamReactorStrategy;
import org.ops4j.pax.exam.junit.JUnit4TestRunner;
import org.ops4j.pax.exam.spi.reactors.EagerSingleStagedReactorFactory;
import org.osgi.framework.BundleContext;

import static org.junit.Assert.*;

@RunWith(JUnit4TestRunner.class)
@ExamReactorStrategy(EagerSingleStagedReactorFactory.class)
public class ConsumerTest extends IntegrationTest
{
	@Test
	public void testConsumer() {
		QuoteAggregator singleton = Aggregator.getSingleton();
		assertNotNull(singleton);
	}
}
