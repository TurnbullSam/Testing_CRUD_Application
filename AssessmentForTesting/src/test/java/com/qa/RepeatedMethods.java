package com.qa;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import com.relevantcodes.extentreports.LogStatus;

public class RepeatedMethods 
{
	
	public void initalpage(WebDriver driver)
	{
		//Initial Login Page
		JenkinsWebElements JWE = PageFactory.initElements(driver, JenkinsWebElements.class);
		// User name
		WebElement username1 = JWE.getFirstPageUsername(driver);
		username1.click();
		username1.sendKeys("Username");
		
		//Password
		WebElement password = JWE.getFirstPagePassword(driver);
		password.click();
		password.sendKeys("password");
		
		//Submit
		WebElement Submitfirst = JWE.getFirstPageSubmit(driver);
		Submitfirst.click();
	}
	public void FindCreateUser(WebDriver driver)
	{
	// Finding create a user page
		
	JenkinsWebElements JWE = PageFactory.initElements(driver, JenkinsWebElements.class);
	WebElement ManageJenkins = JWE.getManageJenkins(driver);
	ManageJenkins.click();
	

	WebElement ManageUsers = JWE.getManageUsers(driver);
	ManageUsers.click();
	
	}
}
