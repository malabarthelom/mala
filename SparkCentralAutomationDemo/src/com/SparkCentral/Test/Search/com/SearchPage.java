/**
 * Creating  SearchPage.java to search a search given search string in the web page
 */
package com.SparkCentral.Test.Search.com;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
public class SearchPage extends BasePage{

	public SearchPage(WebDriver driver){
		super(driver);
	}
	//Create a method to find a search element and send the search key
	public SearchPage doSendkey(String searchString) {
		WebElement  searchElement = driver.findElement(By.xpath("//input[@id='sb_form_q']"));
		searchElement.sendKeys();
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
		return new SearchPage(driver);
	}
	//Create a method to click  search element
	public SearchPage doSearchWith() {

		WebElement  searchElement1=driver.findElement(By.xpath("//input[@id='sb_form_go']"));
		searchElement1.click();
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
		return new SearchPage(driver);
	}


}


