package runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
    features = "src/test/resources/functionalTests",   // ✅ correct path
    glue = {"stepDefinitions"},                        // ✅ matches your package
    plugin = {"pretty", "html:target/cucumber-reports.html",
              "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"},
    monochrome = true
)
public class TestRunner extends AbstractTestNGCucumberTests {
}
