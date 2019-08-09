package pl.TS.PageObjects;

import java.math.BigDecimal;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProductPage extends AbstractPage {
	
	final String expectedResult = new String("56.00");
	
/*	final static BigDecimal EXPECTEDRESULT = new BigDecimal("0");
	final static BigDecimal TOTALSHIPPING = new BigDecimal("0");
	final static BigDecimal QUANTITY = new BigDecimal("0");
	final static BigDecimal TOTALPRODUCTS = new BigDecimal("0");  
	final static BigDecimal TOTAL = new BigDecimal("0");  
	BigDecimal TotalSum = TOTALPRODUCTS.add(TOTALSHIPPING);
	final String TotalProducts = new String ("//span[@class='ajax_block_products_total']");
	final String TotalShipping = new String ("//span[@class='ajax_cart_shipping_cost']");
	final String Total = new String ("//span[@class='ajax_block_cart_total']");  */
	
	
	
	
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
