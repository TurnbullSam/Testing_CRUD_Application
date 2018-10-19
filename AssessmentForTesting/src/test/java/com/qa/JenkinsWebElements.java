package com.qa;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class JenkinsWebElements 
{
	public WebElement element = null;

	//initial login page
	public WebElement getFirstPageUsername(WebDriver driver)
	{
		 element =  driver.findElement(By.id("j_username"));
		 return element;
	}
	public WebElement getFirstPagePassword(WebDriver driver)
	{
		 element =  driver.findElement(By.xpath("/html/body/div/div/form/div[2]/input"));
		 return element;
	}
	public WebElement getFirstPageSubmit(WebDriver driver)
	{
		 element =  driver.findElement(By.name("Submit"));
		 return element;
	}
	
	// Add User element steps
	public WebElement getManageJenkins(WebDriver driver)
	{
		 element =  driver.findElement(By.xpath("//*[@id=\"tasks\"]/div[4]/a[2]"));
		 return element;
	}
	public WebElement getManageUsers(WebDriver driver)
	{
		 element =  driver.findElement(By.xpath("//*[@id=\"main-panel\"]/div[17]/a/dl/dt"));
		 return element;
	}
	
	public WebElement getCreateUsers1(WebDriver driver)
	{
		 element =  driver.findElement(By.xpath("//*[@id=\"tasks\"]/div[3]/a[2]"));
		 return element;
	}
	
	public WebElement getCreateUsers2(WebDriver driver)
	{
		 element =  driver.findElement(By.className("task-link"));
		 return element;
	}
	
	// Adding userdetails
	public WebElement getUsername(WebDriver driver)
	{
		 element =  driver.findElement(By.id("username"));
		 return element;
	}
	
	public WebElement getPassword1(WebDriver driver)
	{
		 element =  driver.findElement(By.name("password1"));
		 return element;
	}
	public WebElement getPassword2(WebDriver driver)
	{
		 element =  driver.findElement(By.name("password2"));
		 return element;
	}
	public WebElement getFullName(WebDriver driver)
	{
		 element =  driver.findElement(By.name("fullname"));
		 return element;
	}
	public WebElement getEmail(WebDriver driver)
	{
		 element =  driver.findElement(By.name("email"));
		 return element;
	}
	
	public WebElement getSubmit(WebDriver driver)
	{
		 element =  driver.findElement(By.id("yui-gen1-button"));
		 return element;
	}
	
	// find username element 
	
	public WebElement getUsernameElement(WebDriver driver, String arg1)
	{
		 element = driver.findElement(By.linkText(arg1));
		 return element;
	}
	
	// find jenkins id element
	public WebElement getJenkinsElement(WebDriver driver)
	{
		 element =  driver.findElement(By.xpath("//*[@id=\"main-panel\"]/div[2]"));
		 return element;
	}
}
