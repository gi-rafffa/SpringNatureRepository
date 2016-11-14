package com.springer.rd.framework;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.springer.rd.pages.AdvancedSearchPage;
import com.springer.rd.pages.FoundItemPage;
import com.springer.rd.pages.MainSearchPage;
import com.springer.rd.pages.PageObject;



public class BrowserManager {
	public  static WebDriver driver;
	public  String baseUrl;
	private StringBuffer verificationErrors = new StringBuffer();
	public MainSearchPage mainSearchPage;
	public AdvancedSearchPage advancedSearchPage;
	public FoundItemPage foundItemPage;



	public BrowserManager() {
		FirefoxProfile profile = new FirefoxProfile();
		profile.setEnableNativeEvents(true);
		    driver = new FirefoxDriver(profile);
		    baseUrl = "http://link.springer.com";  
		    WebDriverWait wait = new WebDriverWait(driver, 15); 
		    driver.get(baseUrl);
		    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		    mainSearchPage = new MainSearchPage(driver); 
	}
	
	public void stop() {
		 driver.quit();
		    
	}}

