package com.letskodeit.pageclasses;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.letskodeit.base.BasePage;

public class CategoryFilterPage extends BasePage{
	public WebDriver driver;
	private JavascriptExecutor js;
	private String CATEGORY_DROPDOWN = "//select[@name='categories']";
	// private String CATEGORY_OPTION=

	public CategoryFilterPage(WebDriver driver) {
		super(driver);//pass the driver to basePage constructor
		this.driver = driver;
		js = (JavascriptExecutor) driver;
	}

	public void clickCategoryDropdown() {
		// Find category dropdown
				WebElement categoryDropDown = driver.findElement(By.xpath(CATEGORY_DROPDOWN));
				categoryDropDown.click();
	}
	
	public WebElement findCategory(String categoryName) {
		
		// Wait for the element to be clickable
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
		WebElement categoryOption = wait.until(
				ExpectedConditions.elementToBeClickable(By.xpath(String.format(CATEGORY_DROPDOWN, categoryName))));
		return categoryOption;
	}

	public ResultsPage select(String categoryName) {

		WebElement element = findCategory(categoryName);

		// js click
		js.executeScript("arguments[0].click();", element);
		return new ResultsPage(driver);
	}

	public int findCoursesCount(String categoryName) {
		WebElement element = findCategory(categoryName);
		String categoryText = element.getText();
		// get the number. this is not in my web version
		String[] arrayTemp = categoryText.split(" ");
		String courseCountString = arrayTemp[1].split(" ")[0];
		System.out.println("courseCountString"+courseCountString);
		int courseCount = Integer.parseInt(courseCountString);
		// click the drop down again to close the menu
		clickCategoryDropdown();
		return courseCount;

	}

}
