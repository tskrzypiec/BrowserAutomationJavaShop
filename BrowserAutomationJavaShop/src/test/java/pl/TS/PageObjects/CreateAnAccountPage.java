package pl.TS.PageObjects;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

import cucumber.api.DataTable;

public class CreateAnAccountPage extends AbstractPage{
	
	
	final String gender = new String("//*[@id='id_gender1']");
	protected By byGender = By.xpath(gender);
	final String firstName = new String("//input[@id='customer_firstname']");
	protected By byFirstName = By.xpath(firstName);
	final String lastName = new String("//input[@id='customer_lastname']");
	protected By byLastName = By.xpath(lastName);
	final String password = new String ("//input[@id='passwd']");
	protected By byPassword = By.xpath(password);
	final String days = new String("//select[@id='days']");
	protected By byDays = By.xpath(days);
	final String months = new String("//select[@id='months']");
	protected By byMonth = By.xpath(months);
	final String year = new String("//select[@id='years']");
	protected By byYear = By.xpath(year);
	final String company = new String("//input[@id='company']");
	protected By byCompany = By.xpath(company);
	final String address = new String("//input[@id='address1']");
	protected By byAddress = By.xpath(address);
	final String city = new String("//input[@id='city']");
	protected By byCity = By.xpath(city);
	final String state = new String("//select[@id='id_state']");
	protected By byState = By.xpath(state);
	final String postCode = new String("//input[@id='postcode']");
	protected By byPostCode = By.xpath(postCode);
	final String country = new String("//select[@id='id_country']");
	protected By byCountry = By.xpath(country);
	final String phone = new String("//input[@id='phone']");
	protected By byPhone = By.xpath(phone);
	final String mobile = new String("//input[@id='phone_mobile']");
	protected By byMobile = By.xpath(mobile);
	final String alias = new String("//input[@id='alias']");
	protected By byAlias = By.xpath(alias);
	final String submitAccount = new String("//button[@id='submitAccount']");
	protected By bySubmitAccount = By.xpath(submitAccount);
	
	public CreateAnAccountPage(WebDriver driver) {
		super(driver);
	}
	
	public CreateAnAccountPage fillInCreateAccountForm(DataTable accountData) {
		
		List<List<String>> data = accountData.raw();

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(byGender).click();
		driver.findElement(byFirstName).sendKeys(data.get(1).get(1));
		driver.findElement(byLastName).sendKeys(data.get(2).get(1));
		driver.findElement(byPassword).sendKeys(data.get(3).get(1));
		Select days = new Select(driver.findElement(byDays));
		days.selectByValue(data.get(4).get(1));
		Select month = new Select(driver.findElement(byMonth));
		month.selectByValue(data.get(5).get(1));
		Select years = new Select(driver.findElement(byYear));
		years.selectByValue(data.get(6).get(1));
		driver.findElement(byCompany).sendKeys(data.get(7).get(1));
		driver.findElement(byAddress).sendKeys(data.get(8).get(1));
		driver.findElement(byCity).sendKeys(data.get(9).get(1));
		Select state = new Select(driver.findElement(byState));
		state.selectByValue(data.get(10).get(1));
		driver.findElement(byPostCode).sendKeys(data.get(11).get(1));
		Select country = new Select(driver.findElement(byCountry));
		country.selectByValue(data.get(12).get(1));
		driver.findElement(byPhone).sendKeys(data.get(13).get(1));
		driver.findElement(byMobile).sendKeys(data.get(14).get(1));
		
		return new CreateAnAccountPage(driver);
	}
	
	public CreateAnAccountPage setAlias(DataTable aliasData) throws InterruptedException {
		
		List<List<String>> dataAlias = aliasData.raw();

		Thread.sleep(1000);
		driver.findElement(byAlias).clear();
		driver.findElement(byAlias).sendKeys(dataAlias.get(1).get(1));
		Thread.sleep(1000);

		return new CreateAnAccountPage(driver);
	}
	
	public ConfirmAccountPage submitNewAccount() {
		
		driver.findElement(bySubmitAccount).click();
		
		return new ConfirmAccountPage(driver);
	}	
	
}
