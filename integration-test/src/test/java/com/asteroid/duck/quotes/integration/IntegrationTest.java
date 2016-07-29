package com.asteroid.duck.quotes.integration;

import org.apache.commons.io.IOUtils;
import org.ops4j.pax.exam.Option;
import org.ops4j.pax.exam.junit.Configuration;
import org.ops4j.pax.exam.options.ProvisionOption;
import org.ops4j.pax.exam.options.UrlProvisionOption;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static org.ops4j.pax.exam.CoreOptions.*;

public class IntegrationTest
{
	@Configuration
	public static Option[] configure() throws IOException
	{
		List<ProvisionOption> testedBundles = testedBundles();
		Option[] result = options(
						cleanCaches(),/*
						mavenBundle("org.apache.felix","org.apache.felix.shell", "1.4.3").startLevel(2),
						mavenBundle("org.apache.felix","org.apache.felix.shell.remote", "1.1.2").startLevel(2),
						mavenBundle("org.apache.felix","org.apache.felix.scr","1.0.8").startLevel(2),
						mavenBundle("org.slf4j", "slf4j-simple", "1.7.13").noStart(), */
						provision(testedBundles.toArray(new ProvisionOption[testedBundles.size()])),
						junitBundles(),

						bundleStartLevel(3),
						dsProfile(),
						logProfile()
		);
		return result;
	}

	private static List<ProvisionOption> testedBundles() throws IOException
	{
		File workingDirFile = new File(".").getAbsoluteFile();
		String workingDir = workingDirFile.getParentFile().getParentFile().toString();
		System.out.println(workingDir);
		File gradleClassPathFile = new File("build/gradle.classpath");
		List<String> classpath = IOUtils.readLines(new FileInputStream(gradleClassPathFile));
		ArrayList<ProvisionOption> options = new ArrayList<ProvisionOption>(classpath.size());
		for(String pathEntry : classpath)
		{
			if (pathEntry.startsWith(workingDir)
							|| pathEntry.contains("commons-io")
							|| pathEntry.contains("scr"))
			{
				File pathFile = new File(pathEntry);
				UrlProvisionOption opt = bundle(pathFile.toURI().toString());
				UrlProvisionOption urlProvisionOption = opt.startLevel(3);
				opt.start(true);
				options.add(opt);
			}
		}
		return options;
	}
}
