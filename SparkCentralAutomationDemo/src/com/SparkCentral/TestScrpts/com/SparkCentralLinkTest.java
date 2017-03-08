
package com.SparkCentral.TestScrpts.com;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.SparkCentral.Test.Search.com.BingSearchPage;



public class SparkCentralLinkTest {
	private BingSearchPage searchPage = null;

	@Test
	public  void checkSparkCentralLinks() throws Exception {
		//Instantiate the BingSearchPage and access the method from the class
		searchPage = new BingSearchPage(new FirefoxDriver());
		searchPage.accessPage();

		String officalSite;
		int count=searchPage.getTotalLinks();

		//Verify that first search result 'Sparkcentral - Official Site'
		officalSite=searchPage.getOfficialSite();
		Assert.assertEquals("Official site not  found!","https://www.sparkcentral.com",officalSite);


		//Verify that all search results on first page contain 'Sparkcentral'

		for(int i=0;i<count;i++)
		{
			if(searchPage.getsparkCentralEachLink().get(i).getText().contains("sparkcentral")){
				Assert.assertTrue(searchPage.getsparkCentralEachLink().get(i).getText().contains("sparkcentral"));
			}//if
		}//for

		//Verify that 'Product' link in first search result is actually pointing to 'https://www.sparkcentral.com/product/'
		for(int i=0;i<count;i++)
		{
			if(searchPage.getsparkCentralEachLink().get(i).getText().contains("product")){
				searchPage.getsparkCentralEachLink().get(i).click();
				String ele	= ((WebDriver) searchPage.getsparkCentralEachLink().get(i)).getCurrentUrl();
				Assert.assertEquals("Puduct link not match!","//https://www.sparkcentral.com/product/",ele);
			}//if
		}//for"


	}
}

