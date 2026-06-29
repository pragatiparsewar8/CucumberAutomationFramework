package stepDefinitions;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;

import cucumber.TestContext;
import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class Hooks {

	TestContext testContext;
	

	public Hooks(TestContext context) {
		testContext = context;
	}
	

	@Before
	public void BeforeSteps() {
		/*What all you can perform here
			Starting a webdriver
			Setting up DB connections
			Setting up test data
			Setting up browser cookies
			Navigating to certain page
			or anything before the test
		*/
	}

	@After
	public void AfterSteps() {
		testContext.getWebDriverManager().closeDriver();
	}
	
	@AfterStep
	public void addScreenshot(Scenario scenario) {
	    WebDriver driver = testContext.getWebDriverManager().getDriver();

	    // Capture screenshot
	    String base64Screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BASE64);

	    // ✅ Attach to Cucumber report
	    scenario.attach(base64Screenshot.getBytes(), "image/png", "Step Screenshot");

	    // ✅ Attach to Extent Spark report
	    ExtentTest test = ExtentTestManager.getTest(); // current Extent test
	    if (scenario.isFailed()) {
	        test.fail("Step failed: " + scenario.getName())
	            .addScreenCaptureFromBase64String(base64Screenshot, "Failed Step Screenshot");
	    } else {
	        test.info("Step passed")
	            .addScreenCaptureFromBase64String(base64Screenshot, "Step Screenshot");
	    }
	}

}