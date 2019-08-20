package pl.TS.PageObjects;

import java.math.BigDecimal;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProductPage extends AbstractPage {
	
	final String expectedResult = new String("56.00");
	
	/*final static BigDecimal COUNTEXPECTEDRESULT = new BigDecimal("0");
	final static BigDecimal COUNTTOTALSHIPPING = new BigDecimal("0");
	final static BigDecimal COUNTQUANTITY = new BigDecimal("0");
	final static BigDecimal COUNTTOTALPRODUCTS = new BigDecimal("0");  
	final static BigDecimal COUNTTOTAL = new BigDecimal("0");  
	BigDecimal CountTotalSum = COUNTTOTALPRODUCTS.add(TOTALSHIPPING);
	final String CountTotalProducts = new String ("//span[@class='ajax_block_products_total']");
	final String CountTotalShipping = new String ("//span[@class='ajax_cart_shipping_cost']");
	final String CountTotal = new String ("//span[@class='ajax_block_cart_total']"); */
	
	final String CountTotal = new String ("//span[@class='ajax_block_cart_total']"); 
	protected By byCountTotal = By.xpath(CountTotal);

	//BigDecimal bigDecimalCurrency=new BigDecimal(currency);
	
	
	final String cartTotal = new String("//span[@class='ajax_block_cart_total']");
	protected By byCartTotal = By.xpath(cartTotal);
	
	final  String TotalStrring = driver.findElement(byCountTotal).getText();
	final  BigDecimal COUNTTOTAL = new BigDecimal(TotalStrring);
	
	
	
	
		public ProductPage(WebDriver driver) {
		super(driver);
		
	}

public ProductPage checkIfTheTotalPriceIsCorrect() throws InterruptedException {
	
	Assert.assertTrue("Sum of the product price + shipping is not correct.", driver.findElement(byCartTotal).getText().contains(expectedResult));
	
	//System.out.println(driver.findElement(byCountTotal).getText().substring(0, CountTotal.length() -1));
	
	System.out.println(driver.findElement(byCountTotal).getText().substring(1, TotalStrring.length()));
	
	
	
	System.out.println("Total to " +COUNTTOTAL);
	
	//System.out.println(driver.findElement(byCountTotal).getText());

	/*
	 	public String getActualInstallmentRate() {
		String stringActualInstallmentRate = getTextField(byInstallmentRate);
		// TODO currency trim might be separate
		return getTextField(byInstallmentRate).substring(0, stringActualInstallmentRate.length() - 3);	
	}
	*/
	
	
	
	Thread.sleep(1000);

	return new ProductPage(driver);
	
	}
				
}
