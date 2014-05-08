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

package com.agilarity.examples.smoke;

import static org.fest.assertions.Assertions.assertThat;

import org.jbehave.core.annotations.BeforeScenario;
import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Named;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;

import com.agilarity.examples.smoke.domain.SafetyStatus;
import com.agilarity.examples.smoke.domain.SmokeDetector;

public class SmokeTestSteps {
    private int level;
    private SafetyStatus actual;
    private SmokeDetector detector;

    @BeforeScenario
    public void beforeScenario() {
        detector = new SmokeDetector();
    }

    @Given("the smoke level is <level>")
    public void givenTheSmokeLevelIslevel(@Named("level") final int level) {
        this.level = level;
    }

    @When("the smoke level is assessed")
    public void whenTheSmokeLevelIsAssessed() {
        actual = detector.detect(level);
    }

    @Then("the safety status will be <status>")
    public void thenTheSafetyStatusWillBestatus(
            @Named("status") final SafetyStatus expected) {
        assertThat(actual).isEqualTo(expected);
    }
}
