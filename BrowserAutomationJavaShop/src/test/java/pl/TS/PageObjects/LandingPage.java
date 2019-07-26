package pl.TS.PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;


public class LandingPage extends AbstractPage {
		
	final String womanCategory = new String("//a[@title='Women']");
	protected By byWomanCategory = By.xpath(womanCategory);
	final String blouseCategory = new String("//a[@title='Blouses']");
	protected By byBlouseCategory = By.xpath(blouseCategory);
	final String blouseItem = new String("//img[@title='Blouse']");
	protected By byBlouseItem = By.xpath(blouseItem);
	final String clickMoreButton = new String("//a[@title='View']");
	protected By byClickMoreButton = By.xpath(clickMoreButton);
	final String logButton = new String("//a[@title='Log in to your customer account']");
	protected By byLogButton = By.xpath(logButton);
	
	public LandingPage(WebDriver driver) {
		super(driver);
	}

	public LogInPage navigateToLogInButton() {
			driver.findElement(byLogButton).click();	
		return new LogInPage(driver);
	}

		public CategoryPage pickCategory() throws InterruptedException {

		Thread.sleep(1000);
		Actions a = new Actions(driver);
		a.moveToElement(driver.findElement(byWomanCategory)).build().perform();
		Thread.sleep(1000);
		driver.findElement(byBlouseCategory).click();
		Thread.sleep(1000);

		Actions b = new Actions(driver);		
		b.moveToElement(driver.findElement(byBlouseItem)).build().perform();

		Thread.sleep(1000);
		driver.findElement(byClickMoreButton).click();
		Thread.sleep(1000);
		
		return new CategoryPage(driver);
	}
	
}