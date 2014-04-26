/*
 * The MIT License (MIT)
 *
 * Copyright (c) 2014 Joseph A. Cruz
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */

package com.agilarity.jbehave;

import static org.jbehave.core.reporters.Format.CONSOLE;

import java.util.List;

import org.jbehave.core.configuration.Configuration;
import org.jbehave.core.configuration.MostUsefulConfiguration;
import org.jbehave.core.failures.FailingUponPendingStep;
import org.jbehave.core.junit.JUnitStories;
import org.jbehave.core.steps.InjectableStepsFactory;
import org.jbehave.core.steps.InstanceStepsFactory;
import org.junit.runner.RunWith;

import de.codecentric.jbehave.junit.monitoring.JUnitReportingRunner;

@RunWith(JUnitReportingRunner.class)
public abstract class JBehaveStories extends JUnitStories {

    private final StoryPathFinder storyPathFinder;
    private final InjectableStepsFactory injectableStepsFactory;

    public JBehaveStories() {
        super();
        storyPathFinder = new LocalStoryFinder(this.getClass());
        injectableStepsFactory = new InstanceStepsFactory(configuration(),
                createSteps());
    }

    protected abstract List<?> createSteps();

    @Override
    public List<String> storyPaths() {
        return storyPathFinder.findStoryPaths();
    }

    @Override
    public InjectableStepsFactory stepsFactory() {
        return injectableStepsFactory;
    }

    @Override
    public Configuration configuration() {
        final MostUsefulConfiguration config = (MostUsefulConfiguration) super
                .configuration();

        config.usePendingStepStrategy(new FailingUponPendingStep());
        config.storyReporterBuilder().withFormats(CONSOLE);

        return config;
    }
}