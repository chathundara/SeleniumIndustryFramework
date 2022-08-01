package com.letskodeit.pageclasses;

import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.letskodeit.base.BasePage;

public class ResultsPage  extends BasePage{
	public WebDriver driver;
	private String URL = "courses";
	//private String COURSES_LIST = "//div[@id='course-list']";
	private String COURSES_LIST = "zen-course-list"; // Issue with count

	public ResultsPage(WebDriver driver){
		super(driver);//pass the driver to basePage constructor
		this.driver=driver;
	}
	public boolean isOpen() {
		return driver.getCurrentUrl().contains(URL);
	}

	public int coursesCount() {
		List<WebElement> courseslist = driver.findElements(By.className(COURSES_LIST));
		System.out.println("course count is "+courseslist.size());
		return courseslist.size();

	}

	public boolean verifySearchResult() {
		boolean result = false;
		if (coursesCount() > 0) {
			result = true;
		}
		result=isOpen()&&result;
		//System.out.println("verify");
		
		return result;
	}
	public boolean verifyFilterCourseCount(int expectedCount) {
		return coursesCount()==expectedCount;
	}

}
