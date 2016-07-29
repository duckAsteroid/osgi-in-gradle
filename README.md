# osgi-in-gradle
A simple example of an OSGi project built and tested in Gradle.

The example is based on a service that can generate random famous quotes or sayings. e.g. "3 out of 4 people make up 75% of the population."

This top level project contains several child projects:
  * **api** - this is the Quote service API (the contract)
  * **consumer** - this is a class that consumes instances of the Quote API - it knows nothing about where the quotes come from.
  * **impl** - an implementation of the Quote service API that gets its quotes from some text file
  * **integration-test** - a set of tests that run in OSGi using PAX-EXAm
