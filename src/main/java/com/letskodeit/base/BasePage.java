package com.letskodeit.base;

import org.openqa.selenium.WebDriver;
// All the common codes to page classes goes here
public class BasePage extends CustomDriver {
	WebDriver driver;

	public BasePage(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}

	public boolean verifytitle(String expectedTitle) {
		return driver.getTitle().equalsIgnoreCase(expectedTitle);
	}

}
