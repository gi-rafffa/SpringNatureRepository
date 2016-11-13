package com.springer.rd.tests;

import org.testng.annotations.Test;

public class NegativeSearchTest extends TestBase {
		 
	    @Test
		 public void negativeSimpleSearch() throws Exception{
	     browser.mainSearchPage.fillSearchQuery("aaaaaaaaabbbbbbb");
	     browser.mainSearchPage.pressSearchButton();
	     browser.mainSearchPage.isNoSearchResults();
	     browser.mainSearchPage.isResultBlockEmpty();
		}
		
}
