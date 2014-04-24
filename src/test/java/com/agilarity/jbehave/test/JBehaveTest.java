package com.agilarity.jbehave.test;

import static java.util.Arrays.asList;

import java.util.List;

import com.agilarity.jbehave.JBehaveStories;

public class JBehaveTest extends JBehaveStories {

    @Override
    protected List<?> createSteps() {
        return asList(new JBehaveTestStep());
    }
}