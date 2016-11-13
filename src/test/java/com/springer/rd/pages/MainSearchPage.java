package com.springer.rd.pages;

import static org.testng.AssertJUnit.assertTrue;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import java.awt.AWTException;
import java.awt.Robot;
import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;



public class MainSearchPage extends PageObject {

    //input for search-string
	@FindBy(id = "query")
	private WebElement searchLine;
	
	//start new search and clean all settings
	@FindBy(id = "global-search-new")
	private WebElement newSearch;
	
	//input for search-string
	@FindBy(id = "results-only-access-checkbox")
	private WebElement checkbox;
	
	//search-button
	@FindBy(id = "search")
	private WebElement searchButton;
	
	//advanced settings button
	@FindBy(id = "search-options") 
	private WebElement advancedSearch;
	
	//advanced search link
	@FindBy(id = "advanced-search-link") 
	private WebElement searchLink;
	
	
	//first element in the list
	@FindBy(className = "no-access has-cover") 
	private WebElement firstFoundElement;
	
	//first element in the list
	@FindBy(className = "title") 
	private WebElement titleOfFirstFoundElement;
	
	//first element in the list
	@FindBy(xpath = ".//a[@class='next']") 
	private WebElement buttonNext;
	
	//how many results we have
	@FindBy(xpath = ".//*[@class='number-of-search-results-and-search-terms']/strong[1]") 
	private WebElement numberOfSearchResults;
	
	 //input for search-string
     @FindBy(id = "results-list")
	 private WebElement resultsList;
	
	public void isResultBlockEmpty() {
		//PageFactory.initElements(driver, this);
		System.out.println("Inside result list " + resultsList.getAttribute("value"));
		Assert.assertNull(resultsList.getAttribute("value"));
	}
	
	public MainSearchPage fillSearchQuery(String query){
		   searchLine.sendKeys(query);
		    return this;
		}
	
	public MainSearchPage newSearch(){
		   newSearch.click();;
		    return this;
		}
	
	public MainSearchPage isNoSearchResults(){
		   PageFactory.initElements(driver, this);
		   Assert.assertEquals(numberOfSearchResults.getText(), "0");
		    return this;
		}
	
	public MainSearchPage pressSearchButton(){
		   searchButton.click();
		    return this;
		}
	
	public MainSearchPage waitForResults(){
		   PageFactory.initElements(driver, this);
		   Assert.assertEquals(true, searchResultExistsByClass("no-access"));
		   return this;
		}
	
	
	
	public FoundItemPage openResult(){
		titleOfFirstFoundElement.click();
		return new FoundItemPage(driver);
	}
	
	private boolean existsElement(String className) {
	    try {
	        driver.findElement(By.className(className));
	    } catch (NoSuchElementException e) {
	        return false;
	    }
	    return true;
	}
	
	
	public MainSearchPage(WebDriver driver){
		super(driver);
		PageFactory.initElements(driver, this);
	}

	public AdvancedSearchPage switchToAdvanced() {
		advancedSearch.click();
		PageFactory.initElements(driver, this);
		searchLink.click();
		return new AdvancedSearchPage(driver);
	}	
	
	public MainSearchPage checkResults(String searchString)
	{ 
		List<WebElement> resultPage = driver.findElements(By.className("title"));
		int amount = resultPage.size();
		int counter = 0;
		while (resultPage.size() != 0)
		{
				for(WebElement result:resultPage)
				{
					counter++;
					if(!result.getText().toLowerCase().contains(searchString)){ 				
						System.out.println("Wrong title position " + counter);
					}
					Assert.assertEquals(result.getText().toLowerCase().contains(searchString), true);
				}
				if(resultPage.size() == 20){
					buttonNext.click();
					resultPage = driver.findElements(By.className("title"));
				}
				else break;
		}
		return this;
	}
}
