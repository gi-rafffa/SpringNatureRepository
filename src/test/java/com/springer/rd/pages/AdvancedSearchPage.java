package com.springer.rd.pages;

import org.eclipse.jetty.util.log.Log;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AdvancedSearchPage extends PageObject {
	 	
		//input field for book title
       @FindBy(className = "title-is") 
	   private WebElement titleField;
       
     	//button Search
       @FindBy(id = "submit-advanced-search") 
	   private WebElement buttonSearch;
       
       public AdvancedSearchPage fillSearchQueryTitle(String query){
    	   titleField.sendKeys(query);
		    return this;
		}

       public MainSearchPage confirmSearch(){
    	    buttonSearch.click();
		    return new MainSearchPage(driver);
		}
       public AdvancedSearchPage(WebDriver driver){
    	   super(driver);
    	   PageFactory.initElements(driver, this);
       	}	
	
}
