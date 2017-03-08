/**
 * Creating a Bagepage.java to return FirefoxDriver as Base whenever the driver is called
 */

package com.SparkCentral.Test.Search.com;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BasePage {

	public WebDriver driver;

	public BasePage(WebDriver driver) {
		if (driver == null) {
			driver = new FirefoxDriver();
		}
		this.driver = driver;
	}

	public BasePage getPage(String url){
		driver.get(url);
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		return new BasePage(driver);
	}

	public void closeSession(){
		driver.quit();
	}

}
