package com.qa;

import static org.junit.Assert.assertEquals;

import org.junit.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class TaskOne 
{
	public WebDriver driver = null;
	public Constants constant = new Constants();
	static ExtentReports extent = new ExtentReports("C:\\Users\\Admin\\Desktop\\Test Reports\\LoginTest.html",true);
	ExtentTest test;
	
	
	@Before
	public void setup()
	{
		
		test = extent.startTest("Automation of creation of a user");
		System.setProperty(constant.webdriverdirectory, constant.ChromeDriverFilePath);
		driver = new ChromeDriver();
		
	}
	@After
	public void teardown()
	{
		extent.endTest(test);
		extent.flush();
	    driver.quit();
	}
	
	// for test if the element is not found it fails the test and so no assert equals is needed
	@Test
	public void navigationToAddAUserPage()
	{
		//setting up variable
		JenkinsWebElements JWE = PageFactory.initElements(driver, JenkinsWebElements.class);
		
		test.log(LogStatus.INFO, "Navigating to webpage");
		driver.get(constant.URL1);
		
		//Initial Login Page
		test.log(LogStatus.INFO, "Finding login username Input");
		WebElement username1 = JWE.getFirstPageUsername(driver);
		username1.click();
		test.log(LogStatus.INFO, "Entering Username");
		username1.sendKeys("Username");
		
		test.log(LogStatus.INFO, "Finding login password Input");
		WebElement password = JWE.getFirstPagePassword(driver);
		password.click();
		test.log(LogStatus.INFO, "Entering password");
		password.sendKeys("password");
		
		test.log(LogStatus.INFO, "Finding login password Input");
		WebElement Submitfirst = JWE.getFirstPageSubmit(driver);
		Submitfirst.click();
		
		
		// Finding create a user page
		test.log(LogStatus.INFO, "Finding Manage jenkins");
		WebElement ManageJenkins = JWE.getManageJenkins(driver);
		test.log(LogStatus.INFO, "Navigating to Manage jenkins");
		ManageJenkins.click();
		
		
		test.log(LogStatus.INFO, "Finding Manage Users Button");
		WebElement ManageUsers = JWE.getManageUsers(driver);
		test.log(LogStatus.INFO, "Navigating to Manage Users Page");
		ManageUsers.click();
		
		test.log(LogStatus.INFO, "Finding Create users Button");
		WebElement CreateUsers = JWE.getCreateUsers1(driver);
		test.log(LogStatus.INFO, "Navigating to Create Users Page");
		CreateUsers.click();
		
		
		// add a user steps
		test.log(LogStatus.INFO, "Finding Create username Input");
		WebElement username = JWE.getUsername(driver);
		username.click();
		test.log(LogStatus.INFO, "Entering Username");
		username.sendKeys("testusername");
		
		test.log(LogStatus.INFO, "Finding password Input");
		WebElement password1 = JWE.getPassword1(driver);
		password1.click();
		test.log(LogStatus.INFO, "Entering password");
		password1.sendKeys("testpassword");
		
		test.log(LogStatus.INFO, "Finding Check password Input");
		WebElement password2 = JWE.getPassword2(driver);
		password2.click();
		test.log(LogStatus.INFO, "Entering check password");
		password2.sendKeys("testpassword");
		
		test.log(LogStatus.INFO, "Finding Full Name Input");
		WebElement FullName = JWE.getFullName(driver);
		FullName.click();
		test.log(LogStatus.INFO, "Entering Full Name");
		FullName.sendKeys("test name");
		
		test.log(LogStatus.INFO, "Finding Email Input");
		WebElement Email = JWE.getEmail(driver);
		Email.click();
		test.log(LogStatus.INFO, "Entering Email");
		Email.sendKeys("Roottest@Root.com");
		
		test.log(LogStatus.INFO, "Finding Submit button");
		WebElement SubmitUser = JWE.getSubmit(driver);
		test.log(LogStatus.INFO, "Clicking Submit");
		SubmitUser.click();
		
		test.log(LogStatus.INFO, "Checking a user has been entered");
		if(constant.URL2.equals(driver.getCurrentUrl())) {test.log(LogStatus.PASS, "A user has been entered");}
		else {test.log(LogStatus.FAIL, "A user has not been Entered");}
		assertEquals(constant.URL2,driver.getCurrentUrl());
		
		
	}
}
