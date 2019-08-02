package pl.TS.PageObjects;

import java.math.BigDecimal;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProductPage extends AbstractPage {
	
	final String expectedResult = new String("56.00");//zmienilem na format 56.00 zrob dodawanie total ptoducts + total shipmetn
	final String totalShipping = new String("2"); //dodalem , dodaj locator 
	//final String totalProducts = new String ()
	//final String quantity = new String zrob cala logike liczenia product razy ilosc + shipping
	final static BigDecimal EXPECTEDRESULT = new BigDecimal(0);
	
	
	
	//= totalshipping + total products;
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
