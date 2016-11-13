package com.springer.rd.pages;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.springer.rd.framework.BrowserManager;

public abstract class PageObject {
	protected BrowserManager manager;
	protected static   WebDriver driver;
	public  String baseUrl;
	static boolean acceptNextAlert = true;

	public PageObject (BrowserManager manager, WebDriver driver)
	{
		this.manager = manager;
		this.driver = driver;
	}
	
	public PageObject(WebDriver driver) {
		this.driver = driver;
	    WebDriverWait wait = new WebDriverWait(driver, 15); 
	    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	    PageFactory.initElements(driver, this);
		System.out.println("Factory should be launched here");
	}
	
	protected boolean isElementPresent(By by) {
	    try {
	      driver.findElement(by);
	      return true;
	    } catch (NoSuchElementException e) {
	      return false;
	    }
	  }

	private boolean isAlertPresent() {
	    try {
	      driver.switchTo().alert();
	      return true;
	    } catch (NoAlertPresentException e) {
	      return false;
	    }
	  }
	
	 public void getScreenshot()
     {
		 String fileName = new SimpleDateFormat("yyyyMMddhhmm'.txt'").format(new Date());
		 File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		 try {
			FileUtils.copyFile(scrFile, new File("/Users/Anna/Documents/SeleniumScreens/"+fileName + "." + "png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
     }

	private String closeAlertAndGetItsText() {
	    try {
	      Alert alert = driver.switchTo().alert();
	      String alertText = alert.getText();
	      if (acceptNextAlert) {
	        alert.accept();
	      } else {
	        alert.dismiss();
	      }
	      return alertText;
	    } finally {
	    	acceptNextAlert = true;
	    }
	  }

	public boolean searchResultExistsByClass(String className) {
		
		Boolean isPresent = driver.findElements(By.className(className)).size() > 0;
		return isPresent;
		
	}

}
