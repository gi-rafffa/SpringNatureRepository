package com.springer.rd.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import junit.framework.Assert;

public class FoundItemPage extends PageObject {
	
	    //input for search-string
		@FindBy(id = "title")
		private WebElement titleResult;
		
		public FoundItemPage checkTitle(String title){
			Assert.assertEquals(true, titleResult.getText().contains(title));
            System.out.println(titleResult.getText());
			return this;
		}
		
	
	    public FoundItemPage(WebDriver driver){
	    	super(driver);
	    	PageFactory.initElements(driver, this);
	    }
}
