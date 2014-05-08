[![Stories in Ready](https://badge.waffle.io/agilarity/jbehave-stories.png?label=ready&title=Ready)](https://waffle.io/agilarity/jbehave-stories)
[![Build Status](https://travis-ci.org/agilarity/jbehave-stories.svg?branch=master)](https://travis-ci.org/agilarity/jbehave-stories)

This project provides a useful base class for running [JBehave](http://jbehave.org/reference/stable/) test scenarios.

### Usage:
1 - Add dependency.
```xml
<dependency>
    <groupId>com.agilarity</groupId>
    <artifactId>jbehave-stories</artifactId>
    <version>1.0.5</version>
</dependency>
```
2 - Specify the steps in your test class.
```java
public class SmokeTest extends JBehaveStories {

    @Override
    protected List<?> createSteps() {
        return Arrays.asList(new SmokeTestSteps());
    }
}
```
3 - Put your story files under <tt>src/test/resources</tt>, at or below the same package as your test class.

4 - Run your test class as a normal [JUnit](http://junit.org/) test.
