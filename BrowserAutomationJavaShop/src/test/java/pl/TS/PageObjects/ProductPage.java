package pl.TS.PageObjects;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProductPage extends AbstractPage {
	
	final String expectedResult = new String("56");
	final String cartTotal = new String("//span[@class='ajax_block_cart_total']");
	protected By byCartTotal = By.xpath(cartTotal);
	
		public ProductPage(WebDriver driver) {
		super(driver);
		
	}

public ProductPage checkIfTheTotalPriceIsCorrect() throws InterruptedException {
	
	Assert.assertTrue("Sum of the product price + shipping is not correct.", driver.findElement(byCartTotal).getText().contains(expectedResult));
	
	Thread.sleep(1000);

	return new ProductPage(driver);
	
	}
				
}
