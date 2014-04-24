package com.agilarity.jbehave;

import static java.lang.System.clearProperty;
import static java.lang.System.setProperty;
import static java.util.Arrays.asList;
import static org.fest.assertions.Assertions.assertThat;

import java.util.Arrays;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.agilarity.jbehave.test.JBehaveTest;

public class LocalStoryFinderTest {
    private StoryPathFinder storyFinder;

    @Before
    public void given() {
        storyFinder = new LocalStoryFinder(JBehaveTest.class);
        clearProperty("story-name.filter");
    }

    @Test
    public void shouldFindStoryPaths() {
        // GIVEN
        final List<String> expected = Arrays.asList(
                "com/agilarity/jbehave/test/first.story",
                "com/agilarity/jbehave/test/subfolder/second.story");

        // WHEN
        final List<String> actual = storyFinder.findStoryPaths();

        // THEN
        assertThat(actual).isEqualTo(expected);
    }

    @Test
    public void shouldFilterStoryFiles() {
        // GIVEN
        setProperty("story-name.filter", "second");

        final List<String> expected = asList("com/agilarity/jbehave/test/subfolder/second.story");

        // WHEN
        final List<String> actual = storyFinder.findStoryPaths();

        // THEN
        assertThat(actual).isEqualTo(expected);
    }

    @Test
    public void shouldFindFeatureFiles() {
        // GIVEN
        storyFinder = new LocalStoryFinder(JBehaveTest.class, "feature");
        final List<String> expected = Arrays.asList(
                "com/agilarity/jbehave/test/first.feature",
                "com/agilarity/jbehave/test/subfolder/second.feature");

        // WHEN
        final List<String> actual = storyFinder.findStoryPaths();

        // THEN
        assertThat(actual).isEqualTo(expected);
    }
}
