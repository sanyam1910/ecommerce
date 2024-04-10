package Cucumber;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features="src//test//java//Cucumber//",glue="Stepdefinition", tags = "@tag2",
monochrome=true, plugin = {"html:target//Cucumber.html"})

public class TestNGTestRunner extends AbstractTestNGCucumberTests{

}
