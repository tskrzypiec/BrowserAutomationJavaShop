package pl.TS.PageObjects;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;


public class CategoryPage extends AbstractPage {
	
final String setQuantityXpatch = new String("//input[@id='quantity_wanted']");
protected By bySetQuantity = By.xpath(setQuantityXpatch);	
final String quantityValue = new String ("2");
final String selectSizeXpatch = new String("//select[@id='group_1']");
protected By bySetSize = By.xpath(selectSizeXpatch);
final String sizeValue = new String("3");
final String addItem   = new String("//button[@name='Submit']");
protected By byAddItem = By.xpath(addItem);

	public CategoryPage(WebDriver driver) {
		super(driver);
	}

	public ProductPage chooseQuantityAndSize() throws InterruptedException {
		
		 	Thread.sleep(1000);
			
			driver.findElement(bySetQuantity).clear();

			Thread.sleep(1000);
			
			driver.findElement(bySetQuantity).sendKeys(quantityValue);

			Thread.sleep(1000);
			
			Select sizePick = new Select(driver.findElement(bySetSize));

			Thread.sleep(1000);
			
			sizePick.selectByValue(sizeValue);
		
		return new ProductPage(driver);
	}
	
	public ProductPage addAnItemToCart() throws InterruptedException {
	
	 		Thread.sleep(1000);
	 		
	 		driver.findElement(byAddItem).click();

	 		Thread.sleep(1000);

	 	return new ProductPage(driver);
	}
}

