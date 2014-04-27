[![Stories in Ready](https://badge.waffle.io/agilarity/jbehave-stories.png?label=ready&title=Ready)](https://waffle.io/agilarity/jbehave-stories)
[![Build Status](https://travis-ci.org/agilarity/jbehave-stories.svg?branch=master)](https://travis-ci.org/agilarity/jbehave-stories)

This project provides a useful base class for running [JBehave](http://jbehave.org/reference/stable/) test scenarios.

### Base Class Features
1. Fail when a step is pending.
2. Show test results in the console.
3. Report fine grained tests results.
4. Look for story files at or below the current package.
5. Filter story file names with the <tt>story.filter</tt> system property.

### Usage
1. Extend <tt>JBehaveStories</tt> and use normal test class naming conventions.
2. Put your story files at or below the test package, under <tt>src/test/resources</tt>.
3. Run your test class as a normal JUnit test.

> You can find a complete example in the <tt>com.agilarity.examples.smoke</tt> package.