package runners;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
    features = "src/test/resources/functionalTests",   // ✅ correct path
    glue = {"stepDefinitions"},                        // ✅ matches your package
    plugin = {"pretty", "html:target/cucumber-reports.html",
              "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"},
    monochrome = true
)

@Listeners(com.framework.listeners.RetryListener.class)
public class TestRunner extends AbstractTestNGCucumberTests {
	@Override
    @DataProvider(parallel = true)   // ✅ enables parallel execution
    public Object[][] scenarios() {
        return super.scenarios();
    }
}
