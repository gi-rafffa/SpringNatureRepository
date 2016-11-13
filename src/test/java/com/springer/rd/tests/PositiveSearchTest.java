package com.springer.rd.tests;
import org.testng.annotations.Test;

public class PositiveSearchTest extends TestBase {
	
	    //search very common word and check that first result really contains it in header	
	    @Test
		public void positiveSimpleSearch() throws Exception{
	     browser.mainSearchPage.newSearch();
	     browser.mainSearchPage.fillSearchQuery("Linguistic");
	     browser.mainSearchPage.pressSearchButton();
	     browser.mainSearchPage.waitForResults();
	     browser.foundItemPage = browser.mainSearchPage.openResult();
	     browser.foundItemPage.checkTitle("Linguistic");
		}		
	    
		//WILL PASS - search rare word only in title, go through all results and check is title contains query or not
		@Test
		public void positiveAdvancedSearch() throws Exception{
		browser.advancedSearchPage = browser.mainSearchPage.switchToAdvanced();
		browser.advancedSearchPage.fillSearchQueryTitle("ellen");
		browser.mainSearchPage = browser.advancedSearchPage.confirmSearch();
		browser.mainSearchPage.checkResults("ellen");
	    }
		
		//WILL FAIL - search rare word only in title, there is a BUG on 4th page, 80th element
		@Test
		public void positiveAdvancedSearchBug() throws Exception{
		browser.advancedSearchPage = browser.mainSearchPage.switchToAdvanced();
		browser.advancedSearchPage.fillSearchQueryTitle("cpp");
		browser.mainSearchPage = browser.advancedSearchPage.confirmSearch();
		browser.mainSearchPage.checkResults("cpp");
	    }


}
