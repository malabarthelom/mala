/**
 * Creating  BingSearchPage.java to access all the search String Links/Urls
 * 
 */
package com.SparkCentral.Test.Search.com;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class BingSearchPage extends BasePage{

	public BingSearchPage(WebDriver driver){
		super(driver);
	}

	public BingSearchPage accessPage() {		
		SearchPage SearchPage = new SearchPage(driver);
		//Get the search Url,Go to bing.com
		driver.get("http://www.bing.com");
		//Perform search 'sparkcentral' and return the search page results
		SearchPage searchPageResult= SearchPage.doSendkey("sparkcentral");
		//searchPageResult.doSearchWith();
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);	
		return new  BingSearchPage(driver);
	}
	
	//Find total links of the search page
	public int getTotalLinks() {
		int totalLinks = driver.findElements(By.tagName("a")).size();
		return totalLinks;
	}
	//Create a method to get first search result 'Sparkcentral - Official Site'
	public String getOfficialSite() {
		String officalSite=driver.findElements(By.tagName("a")).get(0).getText();
		return officalSite;
	}
	//Create a method to search results on first page contain 'Sparkcentral'

	public List<WebElement> getsparkCentralEachLink() {
		List<WebElement> sparkCentral=driver.findElements(By.tagName("a"));
		return sparkCentral;
	}
}
