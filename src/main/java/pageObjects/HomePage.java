package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import com.framework.base.BasePage;

public class HomePage extends BasePage{
	WebDriver driver;
	
	public HomePage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void perform_Search(String search) {
		logger.info("Navigating to Home Page");
		driver.navigate().to("https://shop.demoqa.com/?s=" + search + "&post_type=product");
	}
	
	public void navigateTo_HomePage() {
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
	}

}