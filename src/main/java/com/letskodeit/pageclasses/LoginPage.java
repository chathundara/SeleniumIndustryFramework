package com.letskodeit.pageclasses;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.letskodeit.base.BasePage;

public class LoginPage  extends BasePage{
	
	public WebDriver driver;
	
	private String EMAIL_FIELD="email";
	private String PASSWORD_FIELD="password";
	private String SUBMIT_BUTTON="//input[@value='Login']";
	
	public LoginPage(WebDriver driver){
		super(driver);//pass the driver to basePage constructor
		this.driver=driver;
	}
	
	
	public NavigationPage signInWith(String email, String password) {
		WebElement emailField = driver.findElement(By.id(EMAIL_FIELD));
		emailField.clear();
		emailField.sendKeys(email);
		
		WebElement passwordField = driver.findElement(By.id(PASSWORD_FIELD));
		passwordField.clear();
		passwordField.sendKeys(password);
		
		WebElement loginButton=driver.findElement(By.xpath(SUBMIT_BUTTON));
		loginButton.click();
		
		return new NavigationPage(driver);
		
	}
}
