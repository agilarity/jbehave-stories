package com.agilarity.jbehave;

import java.util.List;

import com.google.java.contract.Ensures;

public interface StoryPathFinder {

    @Ensures("!result.isEmpty()")
    List<String> findStoryPaths();
}