package stepDefinition;

import java.util.concurrent.TimeUnit;

import org.junit.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import cucumber.api.DataTable;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import pl.TS.PageObjects.CategoryPage;
import pl.TS.PageObjects.ConfirmAccountPage;
import pl.TS.PageObjects.CreateAnAccountPage;
import pl.TS.PageObjects.LandingPage;
import pl.TS.PageObjects.LogInPage;
import pl.TS.PageObjects.ProductPage;

public class Steps {

	LandingPage landingPage;
	LogInPage logInPage;
	ConfirmAccountPage confirmAccountPage;
	CreateAnAccountPage createAnAccountPage;
	CategoryPage categoryPage;
	ProductPage productPage;
	
	 private static WebDriver driver;   

	@BeforeClass
	 public static void setupClass() {
	        
	    WebDriverManager.chromedriver().setup();
			
	 }

	@Before
	 public void setupTest() {
		
		String isHeadless = "false";
		System.out.println("headlessMode: " + isHeadless);
		
		if (isHeadless.equals("true")) {
			ChromeOptions options = new ChromeOptions();
			options.setHeadless(true);
			driver = new ChromeDriver(options);
		} else {
			driver = new ChromeDriver();
			driver.manage().window().maximize();
		}
		
	 }
		
	@After
	public void afterMethodTestSetUp() {

		driver.quit();
	}
	
	@Given("^I am on the main page$")
	public void shouldNavigateToMainPage() throws Throwable {

		landingPage = new LandingPage(driver);
		landingPage.navigateToLogInPage();
	}

	@And("^I click on the log in button$")
	public void shouldClickOnSighInButton() throws Throwable {

		logInPage = landingPage.navigateToLogInButton();
	}

	@When("^I use random email$")
	public void shouldFillEmailAddress() throws Throwable {
	
		logInPage.setEmail();  
	}

	@And("^I click create an account button")
	public void shouldClickOnCreateAnAccountButton() throws Throwable {

		createAnAccountPage = logInPage.clickOnCreateButton();
	}

	@And("^I submit the form with valid data$")
	public void shouldSubmitTheFormWithValidData(DataTable accountData) throws Throwable {

		createAnAccountPage.fillInCreateAccountForm(accountData);
	}

	@And("^I set alias")
	public void shouldSetAlias(DataTable aliasData) throws Throwable {

		createAnAccountPage.setAlias(aliasData);
	}

	@And("^I submit new account")
	public void shouldPressRegisterButton() throws Throwable {

		confirmAccountPage = createAnAccountPage.submitNewAccount();
	}

	@When("^I put email and password")
	public void shouldFillInEmailAddress(DataTable emailPasswordData) throws Throwable {

		logInPage.setEmailAndPassword(emailPasswordData);
	}

	@And("^I click signIn button")
	public void shouldClickSignInButton() throws InterruptedException {
		

		confirmAccountPage = logInPage.clickSignInButton();
	}

	@Then("^I should be on my account page")
	public void shouldBeOnMyAccountPage() throws Throwable {

		confirmAccountPage.checkIfIamOnMyAccountPage();

	}

	@When("^I pick blouse category and pick the item")
	public void shouldClickOnBlouseCategoryAndChooseAnItem() throws Throwable {

		categoryPage = landingPage.pickCategory();

	}

	@And("^I choose quantity and size of the item")
	public void shouldAddQuantityAndPickASize() throws Throwable {

		categoryPage.chooseQuantityAndSize();
	}

	@And("^I add the item to cart")
	public void shouldAddAnItemToCart() throws Throwable {

		productPage = categoryPage.addAnItemToCart();

	}

	@Then("^I check if Total price with shipping is correct")
	public void shouldCheckIfTheTotalPriceIsCorrect() throws Throwable {

		productPage.checkIfTheTotalPriceIsCorrect();

	}

}
