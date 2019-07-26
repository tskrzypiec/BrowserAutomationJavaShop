package pl.TS.PageObjects;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ConfirmAccountPage extends AbstractPage {
	
	final String infoAccount = new String("//p[@class='info-account']");
	protected By byInfoAccount = By.xpath(infoAccount);
	final String getInfo = new String("Welcome to your account");

	public ConfirmAccountPage(WebDriver driver) {
		super(driver);
	}
	
	public ConfirmAccountPage checkIfIamOnMyAccountPage() throws InterruptedException {
		
		Assert.assertTrue("Error! You are not on my account page!", driver.findElement(byInfoAccount).getText().contains(getInfo));	
		
		Thread.sleep(1000);
		
		return new ConfirmAccountPage(driver);
	}
	
}
