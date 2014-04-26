jbehave-stories 
==============
[![Build Status](https://travis-ci.org/agilarity/jbehave-stories.svg?branch=master)](https://travis-ci.org/agilarity/jbehave-stories)

[JBehave](http://jbehave.org/reference/stable/) is an excellent 
[BDD](http://dannorth.net/introducing-bdd/) framework  for Java&trade;. 
However, getting up and running can be a chore. 

This project provides a useful base class that configures JBehave 
to run with familiar JUnit runners.

## JBehaveStories Class Features
1. Fail when a step is pending.
2. Show test results in the console.
3. Report fine grained tests results.
4. Look for story files at or below the current package.
5. Filter story file names with the <tt>story.filter</tt> system property.

## Writing Your Test
1. Extend <tt>JBehaveStories</tt> and use normal test class naming conventions.
2. Put your story files at or below the test package, under <tt>src/test/resources</tt>.
<p>*See the <tt>...examples</tt> packages for details.*</p>

## Running Your Test
1. Run your test class as a normal JUnit test.