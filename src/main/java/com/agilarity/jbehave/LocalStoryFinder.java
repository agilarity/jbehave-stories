package com.agilarity.jbehave;

import static org.apache.commons.lang.StringUtils.EMPTY;

import java.util.List;

import org.jbehave.core.io.CodeLocations;
import org.jbehave.core.io.StoryFinder;
import org.jbehave.core.junit.JUnitStories;

public class LocalStoryFinder implements StoryPathFinder {
    private final Class<? extends JUnitStories> storiesClass;
    private final String storyFileExtension;

    public LocalStoryFinder(final Class<? extends JUnitStories> storiesClass) {
        super();
        this.storiesClass = storiesClass;
        this.storyFileExtension = "story";
    }

    public LocalStoryFinder(final Class<? extends JUnitStories> storiesClass,
            final String storyFileExtension) {
        super();
        this.storiesClass = storiesClass;
        this.storyFileExtension = storyFileExtension;
    }

    public List<String> findStoryPaths() {
        return new StoryFinder().findPaths(getLocation(), getStoryPattern(),
                EMPTY);
    }

    private String getLocation() {
        return CodeLocations.codeLocationFromClass(storiesClass).getFile();
    }

    private String getStoryPattern() {
        return String.format("**/%s/**/%s.%s", getPackageAsPath(),
                getStoryNameFilter(), getStoryFileExtension());
    }

    private String getPackageAsPath() {
        return storiesClass.getPackage().getName().replace(".", "/");
    }

    private String getStoryNameFilter() {
        return System.getProperty("story-name.filter", "*");
    }

    private String getStoryFileExtension() {
        return storyFileExtension;
    }
}
