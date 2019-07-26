package pl.TS.PageObjects;

import org.openqa.selenium.WebDriver;

public class AbstractPage {
	final String loginPage = new String("http://automationpractice.com/index.php");

	protected WebDriver driver;

	public AbstractPage(WebDriver driver) {

		this.driver = driver;
	}

	public LandingPage navigateToLogInPage() {

		driver.get(loginPage);
		return new LandingPage(driver);
	}

	public void closeDriver() {

		driver.close();

	}

}
