package com.letskodeit.pageclasses;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.letskodeit.base.BasePage;
import com.letskodeit.utilities.Util;

import dev.failsafe.internal.util.Durations;

public class NavigationPage  extends BasePage{

	public WebDriver driver; //
	private String LOGIN_LINK="//a[@href='/login']";//xpath=>
	private String ALL_COURSES_LINK = "//a[normalize-space()='ALL COURSES']";//xpath=>
	private final String URL="https://courses.letskodeit.com/courses";//
	private String MY_COURSES_LINK = "xpath=>//a[normalize-space()='MY COURSES']";
	private String ACCOUNT_ICON="class=>zl-navbar-rhs-img";
	private String LOGOUT_LINK="xpath=>//a[normalize-space()='Logout']";

	public NavigationPage(WebDriver driver) {
		super(driver);//pass the driver to basePage constructor
		this.driver = driver;
		
	}
	public LoginPage login() {
		driver.findElement(By.xpath(LOGIN_LINK)).click();
		return new LoginPage(driver);
	}
	
	public boolean verifyHeader() {
		WebElement link=driver.findElement(By.xpath(ALL_COURSES_LINK));
		String text=link.getText();
		return Util.verifyTextContains(text, "All Courses");// Use Our util class
	}
	public void allCourses() {
		elementClick(ALL_COURSES_LINK, "All courses link");
		//driver.findElement(By.xpath(ALL_COURSES_LINK)).click();
	}
	
	public void myCourses() {
		driver.findElement(By.xpath(MY_COURSES_LINK)).click();
	}
	public boolean isOpen() {
		return URL.equalsIgnoreCase(driver.getCurrentUrl());
	}
	
	public boolean isUserLoggedIn() {
		
		try {
			WebElement accountImage = driver.findElement(By.className(ACCOUNT_ICON));
			return true;
			}
			catch(Exception e) {
				e.printStackTrace();
				return false;
			}
		
	}
	public void logout() {
		driver.findElement(By.className(ACCOUNT_ICON)).click();
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(3));
		WebElement logoutLink=wait.until(ExpectedConditions.elementToBeClickable(By.xpath(LOGOUT_LINK)));
		logoutLink.click();
	}
	
}
