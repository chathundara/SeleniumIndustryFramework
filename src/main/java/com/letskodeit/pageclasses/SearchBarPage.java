package com.letskodeit.pageclasses;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.letskodeit.base.BasePage;

public class SearchBarPage  extends BasePage{
	public WebDriver driver;
	private String SEARCH_COURSE_FIELD = "//input[@id='search']";
	private String SEARCH_COURSE_BUTTON = "//button[@type='submit']";
	
	public SearchBarPage(WebDriver driver) {
		super(driver);//pass the driver to basePage constructor
		this.driver = driver;
	}
	
	public ResultsPage course(String courseName) {
		WebElement searchField=driver.findElement(By.xpath(SEARCH_COURSE_FIELD));
		System.out.println("before clear");
		searchField.clear();
		System.out.println("after clear");
		searchField.sendKeys(courseName);
		
		WebElement searchButton= driver.findElement(By.xpath(SEARCH_COURSE_BUTTON));
		searchButton.click();
		
		return new ResultsPage(driver);
		
		
	}
	
	
}
