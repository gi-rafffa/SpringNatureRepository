package com.springer.rd.tests;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import com.springer.rd.framework.BrowserManager;


public class TestBase {
	public static BrowserManager browser;

	 @BeforeTest(alwaysRun = true)
	public void setUp() throws Exception {
		browser = new BrowserManager();
		System.out.println("SETUP BEFORE TEST SESSION");
	  }
	
	 
	@AfterTest(alwaysRun = true)
	public void tearDown() throws Exception {
		browser.stop();	   
		System.out.println("TEARDOWN AFTER TEST SESSION");
	  }


}
