package pl.TS.PageObjects;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import cucumber.api.DataTable;

public class LogInPage extends AbstractPage{
	
	final String setEmail = new String("//input[@id='email']");
	protected By bySetEmail = By.xpath(setEmail);
	final String setPassword = new String("//input[@id='passwd']");
	protected By bySetPassword = By.xpath(setPassword);
	final String emailCreate = new String("email_create");
	protected By byEmailCreate = By.id(emailCreate);
	final String submitLogin = new String("//button[@id='SubmitLogin']");
	protected By bySubmitLogin = By.xpath(submitLogin);	
	final String authenticationInfo = new String("//*[@id='center_column']/div[1]/ol/li");
	protected By byAuthenticationInfo = By.xpath(authenticationInfo);
	final String expectedResult = new String("Authentication");
	
	public LogInPage(WebDriver driver) {
		super(driver);
	}

	public LogInPage setEmailAndPassword(DataTable EmailPasswordData) 
	{
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		List<List<String>> dataLog = EmailPasswordData.raw();
	
		driver.findElement(bySetEmail).sendKeys(dataLog.get(1).get(1));
		driver.findElement(bySetPassword).sendKeys(dataLog.get(2).get(1));
		return new LogInPage(driver);
	}
	
	public LogInPage setEmail(DataTable emailData){
		
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		List<List<String>> dataEmail = emailData.raw();
		driver.findElement(byEmailCreate).sendKeys(dataEmail.get(1).get(1));
		return new LogInPage(driver);
	} 
	
	public CreateAnAccountPage clickOnCreateButton(){
		
		driver.findElement(byEmailCreate).sendKeys(Keys.ENTER);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		return new CreateAnAccountPage(driver);
	}
	
	public ConfirmAccountPage clickSignInButton() throws InterruptedException{
		
		driver.findElement(bySubmitLogin).click();
		
		Thread.sleep(1000);
	
		Assert.assertFalse("Log in failure! Email or password failed!", driver.findElement(byAuthenticationInfo).getText().contains(expectedResult));

		Thread.sleep(2000);

		return new ConfirmAccountPage(driver);
	}
		
}
