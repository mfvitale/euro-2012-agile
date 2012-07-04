package com.uefa;

import org.junit.runner.RunWith;
import cucumber.junit.Cucumber;

@RunWith(Cucumber.class)
//features=
@Cucumber.Options(format={"pretty", "html:target/cucumber-html-report"})
public class RunTests {
}
