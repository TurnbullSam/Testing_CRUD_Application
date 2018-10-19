package com.qa;

import static org.junit.Assert.assertEquals;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class TaskOneCucumberStep 
{
	public WebDriver driver = null;
	public Constants constant = new Constants();
	static ExtentReports extent = new ExtentReports("C:\\Users\\Admin\\Desktop\\Test Reports\\CucumberParameterization.html",true);
	ExtentTest test;
	// variable for checking the number of runs so the first test doesn't run for every parameter
	public static int RunCounter = 0;
	public static int RowNum = 0;
	public static int ColNum = 0;
	
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
	
	@Given("^that you are on the create UserScreen$")
	public void that_you_are_on_the_create_UserScreen()  
	{
				//setting up variable
		JenkinsWebElements JWE = PageFactory.initElements(driver, JenkinsWebElements.class);
		RunCounter++;
				test.log(LogStatus.INFO, "Navigating to webpage");
				driver.get(constant.URL1);
				
				//Initial Login Page
				RepeatedMethods M = PageFactory.initElements(driver, RepeatedMethods.class);
				M.initalpage(driver);
				
				
				// Finding create a user page
				M.FindCreateUser(driver);
				WebElement CreateUsers = JWE.getCreateUsers1(driver);
	}

	@When("^the User details are entered on the Create UserScreen$")
	public void the_User_details_are_entered_on_the_Create_UserScreen()  
	{
		if(RunCounter == 1)
		{
		JenkinsWebElements JWE = PageFactory.initElements(driver, JenkinsWebElements.class);
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
		}
	  
	}

	@When("^the details are submitted on the Create UserScreen$")
	public void the_details_are_submitted_on_the_Create_UserScreen() 
	{
		if(RunCounter == 1)
		{
			JenkinsWebElements JWE = PageFactory.initElements(driver, JenkinsWebElements.class);
			test.log(LogStatus.INFO, "Finding Submit button");
			WebElement SubmitUser = JWE.getSubmit(driver);
			test.log(LogStatus.INFO, "Clicking Submit");
			SubmitUser.click();
		}
	    
	}

	@Then("^the Username should be visible on the UsersScreen$")
	public void the_Username_should_be_visible_on_the_UsersScreen() 
	{
		JenkinsWebElements JWE = PageFactory.initElements(driver, JenkinsWebElements.class);
		if(RunCounter == 1)
		{
		
			WebElement usernameElement = JWE.getUsernameElement(driver, "testusername");
		}
	 
	}

	@When("^the User details \"([^\"]*)\" username, \"([^\"]*)\" password, \"([^\"]*)\" confirm Password, and \"([^\"]*)\" Fullname are entered on the Create UserScreen$")
	public void the_User_details_username_password_confirm_Password_and_Fullname_are_entered_on_the_Create_UserScreen(String arg1, String arg2, String arg3, String arg4) 
	{
		JenkinsWebElements JWE = PageFactory.initElements(driver, JenkinsWebElements.class);
		// add a user steps
				test.log(LogStatus.INFO, "Finding Create username Input");
				WebElement username = JWE.getUsername(driver);
				username.click();
				test.log(LogStatus.INFO, "Entering Username");
				username.sendKeys(arg1);
				
				test.log(LogStatus.INFO, "Finding password Input");
				WebElement password1 = JWE.getPassword1(driver);
				password1.click();
				test.log(LogStatus.INFO, "Entering password");
				password1.sendKeys(arg2);
				
				test.log(LogStatus.INFO, "Finding Check password Input");
				WebElement password2 = JWE.getPassword2(driver);
				password2.click();
				test.log(LogStatus.INFO, "Entering check password");
				password2.sendKeys(arg2);
				
				test.log(LogStatus.INFO, "Finding Full Name Input");
				WebElement FullName = JWE.getFullName(driver);
				FullName.click();
				test.log(LogStatus.INFO, "Entering Full Name");
				FullName.sendKeys(arg3);
				
				test.log(LogStatus.INFO, "Finding Email Input");
				WebElement Email = JWE.getEmail(driver);
				Email.click();
				test.log(LogStatus.INFO, "Entering Email");
				Email.sendKeys(arg1 + "@Root.com");
				
				// clicking submit
				test.log(LogStatus.INFO, "Finding Submit button");
				WebElement SubmitUser = JWE.getSubmit(driver);
				test.log(LogStatus.INFO, "Clicking Submit");
				SubmitUser.click();
	}

	@Then("^the \"([^\"]*)\" username should be visible on the UsersScreen$")
	public void the_username_should_be_visible_on_the_UsersScreen(String arg1) 
	{
		ReadTestResultsToExcellDoc read = new ReadTestResultsToExcellDoc();
		
		JenkinsWebElements JWE = PageFactory.initElements(driver, JenkinsWebElements.class);
		
				test.log(LogStatus.INFO, "Checking a user has been entered");
				if(constant.URL2.equals(driver.getCurrentUrl())) 
				{
					test.log(LogStatus.PASS, "A user has been entered");
					read.setCellData("Test : "+ RowNum, RowNum, ColNum);
			    	read.setCellData("Test Passed", RowNum, ColNum + 1);
					
				}
				else 
				{
					test.log(LogStatus.FAIL, "A user has not been Entered");
					read.setCellData("Test : "+ RowNum, RowNum, ColNum);
			    	read.setCellData("Test Failed", RowNum, ColNum + 1);
					
				}
				WebElement usernameElement = JWE.getUsernameElement(driver, arg1);
				assertEquals(constant.URL2,driver.getCurrentUrl());
	  
	}
// ######################### second test unit #################################
	@Given("^the \"([^\"]*)\" username is visible on the UsersScreen$")
	public void the_username_is_visible_on_the_UsersScreen(String arg1) 
	{
		
		JenkinsWebElements JWE = PageFactory.initElements(driver, JenkinsWebElements.class);
		RunCounter++;

				test.log(LogStatus.INFO, "Navigating to webpage");
				driver.get(constant.URL1);
				
				RepeatedMethods M = PageFactory.initElements(driver, RepeatedMethods.class);
				M.initalpage(driver);
				
				test.log(LogStatus.INFO, "Navigating to Users page");
				// Finding create a user page
				M.FindCreateUser(driver);
				
				try
				{
					WebElement usernameElement = JWE.getUsernameElement(driver, arg1);
					test.log(LogStatus.PASS, "Username is on screen");
				}
				catch(NoSuchElementException e)
				{
					test.log(LogStatus.FAIL, "Username is not on screen");
				}
	    // Write code here that turns the phrase above into concrete actions
		
	
	}

	@When("^the \"([^\"]*)\" username is clicked on the UserScreen$")
	public void the_username_is_clicked_on_the_UserScreen(String arg1) 
	{
		test.log(LogStatus.INFO, "Following Username link");
		JenkinsWebElements JWE = PageFactory.initElements(driver, JenkinsWebElements.class);
	    WebElement usernameElement = JWE.getUsernameElement(driver, arg1);
	    
		usernameElement.click();
		
	  
	}

	@Then("^the User Profile should display the \"([^\"]*)\" username on the ProfileScreen$")
	public void the_User_Profile_should_display_the_username_on_the_ProfileScreen(String arg1) 
	{
	    // Write code here that turns the phrase above into concrete actions
		ReadTestResultsToExcellDoc read = new ReadTestResultsToExcellDoc();
		
		JenkinsWebElements JWE = PageFactory.initElements(driver, JenkinsWebElements.class);
		
	    WebElement JenkinsIdElement = JWE.getJenkinsElement(driver);
	    
	    if(("Jenkins User ID: " + arg1).equals(JenkinsIdElement.getAttribute("innerHTML")))
	    {
	    	test.log(LogStatus.PASS, "Username is on profile screen");
	    	read.setCellData("Test : "+ RowNum, RowNum, ColNum);
	    	read.setCellData("Test Passed", RowNum, ColNum + 1);
	    }
	    else
	    {
	    	test.log(LogStatus.FAIL, "Username is not on profile screen");
	    	read.setCellData("Test : "+ RowNum, RowNum, ColNum);
	    	read.setCellData("Test Failed", RowNum, ColNum + 1);
	    }
	    assertEquals("Jenkins User ID: " + arg1, JenkinsIdElement.getAttribute("innerHTML"));
	   
	}
// ########################################## Third Test ###############################################
	@Given("^the \"([^\"]*)\" Username's profile page has been loaded$")
	public void the_Username_s_profile_page_has_been_loaded(String arg1) 
	{
	    
		JenkinsWebElements JWE = PageFactory.initElements(driver, JenkinsWebElements.class);
		

				test.log(LogStatus.INFO, "Navigating to webpage");
				driver.get(constant.URL1);
				RepeatedMethods M = PageFactory.initElements(driver, RepeatedMethods.class);
				M.initalpage(driver);
				
				
				
				// Finding create a user page
				M.FindCreateUser(driver);
				
				WebElement usernameElement = JWE.getUsernameElement(driver, arg1);
				usernameElement.click();
				
			 WebElement JenkinsIdElement = JWE.getJenkinsElement(driver);
			 assertEquals("The Username's profile page has been loaded","Jenkins User ID: " + arg1, JenkinsIdElement.getAttribute("innerHTML"));
	}

	@Given("^the configure button has been clicked on the profile page$")
	public void the_configure_button_has_been_clicked_on_the_profile_page() 
	{
		test.log(LogStatus.INFO, "Finding Configure Button");
		JenkinsWebElementsForConfigure JWEC =  PageFactory.initElements(driver, JenkinsWebElementsForConfigure.class);
		WebElement configbutton = JWEC.getConfgure(driver); 
		test.log(LogStatus.INFO, "Clicking Configure Button");
		configbutton.click();
	   
	}

	@When("^I change the old FullName on the Configure Page to a new FullName \"([^\"]*)\"$")
	public void i_change_the_old_FullName_on_the_Configure_Page_to_a_new_FullName(String arg1) 
	{
		test.log(LogStatus.INFO, "Finding Full name text box");
		JenkinsWebElementsForConfigure JWEC =  PageFactory.initElements(driver, JenkinsWebElementsForConfigure.class);
		WebElement FullName = JWEC.getFullName(driver); 
		FullName.click();
		FullName.clear();
		test.log(LogStatus.INFO, "Entering Full name text box");
		FullName.sendKeys(arg1);
		
		
		
	}

	@When("^I save the changes to the Configure Page$")
	public void i_save_the_changes_to_the_Configure_Page() 
	{
		JenkinsWebElementsForConfigure JWEC =  PageFactory.initElements(driver, JenkinsWebElementsForConfigure.class);
		WebElement SaveButton = JWEC.getSave(driver);
		SaveButton.click();
	   
	    
	}

	@Then("^the Configure Page should show the NewFullName \"([^\"]*)\"$")
	public void the_Configure_Page_should_show_the_NewFullName(String arg1) 
	{
		ReadTestResultsToExcellDoc read = new ReadTestResultsToExcellDoc();
		JenkinsWebElementsForConfigure JWEC =  PageFactory.initElements(driver, JenkinsWebElementsForConfigure.class);
		WebElement FullNameBanner = JWEC.getFullNameBanner(driver);
		if((arg1).equals(FullNameBanner.getText()))
	    {
			test.log(LogStatus.PASS, "Full Name is on profile screen");
			read.setCellData("Test : "+ RowNum, RowNum, ColNum);
			read.setCellData("Test Passed", RowNum, ColNum + 1);
	    }
	    else
	    {
	    	test.log(LogStatus.FAIL, "Full Name is not on profile screen");
	    	read.setCellData("Test : "+ RowNum, RowNum, ColNum);
	    	read.setCellData("Test Failed", RowNum, ColNum + 1);
	    }
		
		assertEquals(arg1,FullNameBanner.getText());
		
		
	}

}
